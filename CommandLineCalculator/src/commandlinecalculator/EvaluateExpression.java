package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {

    private String mathExpression;

    public EvaluateExpression(String mathExpression) {
        this.mathExpression = mathExpression;
    }


    private List<Integer> getBracketsInMathExpression() {
        List<Integer> indexOfAllBracketsInMathExpression = new ArrayList<>();

        for (int i = 0; i < this.mathExpression.length(); i++) {

            if (this.mathExpression.charAt(i) == '('
                    || this.mathExpression.charAt(i) == ')') {
                indexOfAllBracketsInMathExpression.add(i);
            }

        }
        return indexOfAllBracketsInMathExpression;
    }


    private int getItemAtIndexBeforeCurrentItemInList(int value, List<Integer> indexOfAllBracketsList) {
        int currentIndexValue = value;
        List<Integer> indexOfBrackets = indexOfAllBracketsList;
        int temporalIndex = 0;

        for (int i = 0; i < indexOfBrackets.size(); i++) {
            if (indexOfBrackets.get(i) != currentIndexValue) {
                temporalIndex = i;
            } else if (indexOfBrackets.get(i) == currentIndexValue) {
                break;
            }
        }

        return indexOfBrackets.get(temporalIndex);
    }


}
