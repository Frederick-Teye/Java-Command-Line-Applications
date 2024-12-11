package commandlinecalculator;

import java.util.List;

public class EvaluateExpression {

    private String mathExpression;
    private List<Integer> tokens;
    private String solution;

    public EvaluateExpression(String mathExpression) {
        this.mathExpression = mathExpression;
        this.tokens = getTokens();
        this.solution = overseeEvaluation();
    }


    @Override
    public String toString() {
        return this.solution;
    }


}
