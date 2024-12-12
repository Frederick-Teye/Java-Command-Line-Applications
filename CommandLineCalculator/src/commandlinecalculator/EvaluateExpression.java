package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;

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
        return "";
    }


    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '^') {
            return 3;
        }
        return 0;
    }


    @Override
    public String toString() {
        return this.solution;
    }


}
