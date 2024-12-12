package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    private String mathExpression;
    private List<String> tokens;
    private String solution;
    private List<String> infixOutput;
    private boolean isExpressionInvalid = false;

    public EvaluateExpression(String mathExpression) {
        this.mathExpression = mathExpression;
        this.tokens = getTokens();
        this.infixOutput = shuntingYard();
        this.solution = evaluateRPN();
    }


    private List<String> getTokens() {
    List<String> tokens = new ArrayList<>();
    String currentToken = "";
    char[] mathExpression = this.mathExpression.toCharArray();

    for (int i = 0; i < mathExpression.length; i++) {
        char character = mathExpression[i];

        if ('-' == character && (i == 0 
                || "+-*/^()".contains(Character.toString(mathExpression[i - 1])))) {
            currentToken += character; 
        } else if ("0123456789.".contains(Character.toString(character))) {
            currentToken += character; 
        } else {
            if (!currentToken.isEmpty()) {
                tokens.add(currentToken); 
                currentToken = "";
            }
            if ("+-*/^()".contains(Character.toString(character))) {
                tokens.add(Character.toString(character)); 
            }
        }
    }

    // Add the last token if it exists
    if (!currentToken.isEmpty()) {
        tokens.add(currentToken);
    }

    return tokens;
}


    private List<String> shuntingYard() {
        Stack<String> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            if (isNumeric(token)) {
                output.add(token);
            } else if ("(".equals(token)) {
                operators.add(token);
            } else if (")".equals(token)) {
                while (!operators.isEmpty() && !"(".equals(operators.peek())) {
                    output.add(operators.pop());
                }
                if (operators.isEmpty()) {
                    isExpressionInvalid = true; // Mismatched parentheses
                } else {
                    operators.pop(); // Pop the '('
                }
            } else { // Operator
                while (!operators.isEmpty()
                        && precedence(operators.peek())
                        >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.add(token);
            }
        }

        while (!operators.isEmpty()) {
            if ("(".equals(operators.peek())) {
                isExpressionInvalid = true;
            }

            output.add(operators.pop());
        }

        return output;
    }


    private int precedence(String operator) {
        if ("+".equals(operator) || "-".equals(operator)) {
            return 1;
        }
        if ("*".equals(operator) || "/".equals(operator)) {
            return 2;
        }
        if ("^".equals(operator)) {
            return 3;
        }
        return -1;
    }


    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private String evaluateRPN() {
        if (infixOutput.isEmpty()) {
            return "0";
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < infixOutput.size(); i++) {
            String get = infixOutput.get(i);

            if (get.equals("+")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.add(b + a);
            } else if (get.equals("*")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(b * a);
            } else if (get.equals("-")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a - b);
            } else if (get.equals("/")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(a / b);
            } else if (get.equals("^")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(Math.pow(a, b));
            } else {
                stack.push(Double.parseDouble(get));
            }
        }
        return Double.toString(stack.pop());
    }


    @Override
    public String toString() {
        return this.solution;
    }


}
