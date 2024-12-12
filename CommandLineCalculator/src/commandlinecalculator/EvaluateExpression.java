package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {

    private String mathExpression;
    private List<String> tokens;
    private String solution;

    public EvaluateExpression(String mathExpression) {
        this.mathExpression = mathExpression.replace("**", "^");
        this.tokens = getTokens();
        this.solution = shuntingYard();
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
                tokens.add(Character.toString(character));
            }
        }

        return tokens;
    }


    private String shuntingYard() {
        Stack<String> operators = new Stack<>();
        List<String> output = new ArrayList<>();
        boolean isExpressionInvalid = false;

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

        List<String> watch = output;

        return "";
    }


    private int precedence(String operator) {
        int precedence = -1;
        if (operator == "+" || operator == "-") {
            precedence = 1;
        }
        if (operator == "*" || operator == "/") {
            precedence = 2;
        }
        if (operator == "^") {
            precedence = 3;
        }
        return precedence;
    }


    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    @Override
    public String toString() {
        return this.solution;
    }


}
