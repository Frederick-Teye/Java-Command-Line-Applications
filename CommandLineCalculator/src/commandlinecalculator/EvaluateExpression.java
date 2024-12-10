package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {

    private String mathExpression;
    private List<Integer> indexOfAllBracketsInMathExpression;
    private String solution;

    public EvaluateExpression(String mathExpression) {
        this.mathExpression = mathExpression;
        this.indexOfAllBracketsInMathExpression = getBracketsInMathExpression();
        this.solution = overseeEvaluation();
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


    private int numberOfMathOperatorsInString(String stringArgument) {
        int counter = 0;
        for (int i = 0; i < stringArgument.length(); i++) {

            if (stringArgument.charAt(i) == '*'
                    || stringArgument.charAt(i) == '/'
                    || stringArgument.charAt(i) == '+'
                    || stringArgument.charAt(i) == '-') {
                counter++;
            }

        }
        return counter;
    }


    private int indexOfEndOfOperandToTheRight(int indexToStartSearchFrom, String mathExpression) {
        int endOfOperandOnRight = 0;
        for (int i = indexToStartSearchFrom; i < mathExpression.length(); i++) {
            if (mathExpression.charAt(i) == '*'
                    || mathExpression.charAt(i) == '/'
                    || mathExpression.charAt(i) == '+'
                    || mathExpression.charAt(i) == '-'
                    || i == mathExpression.length() - 1) {
                endOfOperandOnRight = i;
                break;
            }
        }
        return ++endOfOperandOnRight;
    }


    private int indexOfEndOfOperandToTheLeft(int indexToStartSearchFrom, String string) {
        int endOfOperandOnTheLeft = 0;

        for (int i = indexToStartSearchFrom; i > -1; i--) {
            if (string.charAt(i) == '*'
                    || string.charAt(i) == '/'
                    || string.charAt(i) == '+'
                    || string.charAt(i) == '-'
                    || i == 0) {
                endOfOperandOnTheLeft = i;
                break;
            }
        }
        return endOfOperandOnTheLeft;
    }


    private String overseeEvaluation() {
        String temporalMathExpression = this.mathExpression;
        List<Integer> temporalIndexOfBrackets = new ArrayList<>(this.indexOfAllBracketsInMathExpression);

        while (!(temporalIndexOfBrackets.isEmpty() && numberOfMathOperatorsInString(temporalMathExpression) == 0)) {

            if (temporalIndexOfBrackets.isEmpty()) {
                if (numberOfMathOperatorsInString(temporalMathExpression) > 0) {
                    if (temporalMathExpression.contains("**")) {
                        temporalMathExpression
                                = extractLeftAndRightOperandsAndSolveExponentialExpression(temporalMathExpression);
                    } else if (temporalMathExpression.contains("*")) {
                        temporalMathExpression
                                = extractLeftAndRightOperandsAndSolveMultiplicationExpression(temporalMathExpression);
                    } else if (temporalMathExpression.contains("/")) {
                        temporalMathExpression
                                = extractLeftAndRightOperandsAndSolveDivisionExpression(temporalMathExpression);
                    }
                }
            }
            temporalMathExpression = temporalMathExpression;

        }

        return temporalMathExpression;
    }


    private String extractLeftAndRightOperandsAndSolveExponentialExpression(String temporalMathExpression) {
        int indexOfPowerOperator = temporalMathExpression.indexOf("**");
        int indexOfEndOfOperandOnTheRight
                = indexOfEndOfOperandToTheRight(indexOfPowerOperator + 2, temporalMathExpression);
        int indexOfEndOfOperandOnTheLeft
                = indexOfEndOfOperandToTheLeft(indexOfPowerOperator - 1, temporalMathExpression);
        String leftOperand
                = temporalMathExpression.substring(indexOfEndOfOperandOnTheLeft, indexOfPowerOperator);
        String rightOperand
                = temporalMathExpression.substring(indexOfPowerOperator + 2, indexOfEndOfOperandOnTheRight);
        temporalMathExpression = solveExponentialExpression(leftOperand, rightOperand);
        return temporalMathExpression;
    }


    private String solveExponentialExpression(String leftOperand, String rightOperand) {
        double base = Double.parseDouble(leftOperand);
        double exponent = Double.parseDouble(rightOperand);
        double result = Math.pow(base, exponent);
        return Double.toString(result);
    }


    private String extractLeftAndRightOperandsAndSolveMultiplicationExpression(String temporalMathExpression) {
        int indexOfMultiplicationOperator = temporalMathExpression.indexOf("*");
        int indexOfEndOfOperandOnTheRight
                = indexOfEndOfOperandToTheRight(++indexOfMultiplicationOperator, temporalMathExpression);
        int indexOfEndOfOperandOnTheLeft
                = indexOfEndOfOperandToTheLeft(indexOfMultiplicationOperator - 2, temporalMathExpression);
        String leftOperand
                = temporalMathExpression.substring(indexOfEndOfOperandOnTheLeft, --indexOfMultiplicationOperator);
        String rightOperand
                = temporalMathExpression.substring(++indexOfMultiplicationOperator, indexOfEndOfOperandOnTheRight);
        temporalMathExpression = solveMultiplicationExpression(leftOperand, rightOperand);
        return temporalMathExpression;
    }


    private String solveMultiplicationExpression(String leftOperand, String rightOperand) {
        double leftOperandCasted = Double.parseDouble(leftOperand);
        double rightOperandCasted = Double.parseDouble(rightOperand);
        double result = leftOperandCasted * rightOperandCasted;
        return Double.toString(result);
    }


    private String extractLeftAndRightOperandsAndSolveDivisionExpression(String temporalMathExpression) {
        int indexOfDivisionOperator = temporalMathExpression.indexOf("/");
        int indexOfEndOfOperandOnTheRight
                = indexOfEndOfOperandToTheRight(++indexOfDivisionOperator, temporalMathExpression);
        int indexOfEndOfOperandOnTheLeft
                = indexOfEndOfOperandToTheLeft(indexOfDivisionOperator - 2, temporalMathExpression);
        String leftOperand
                = temporalMathExpression.substring(indexOfEndOfOperandOnTheLeft, --indexOfDivisionOperator);
        String rightOperand
                = temporalMathExpression.substring(++indexOfDivisionOperator, indexOfEndOfOperandOnTheRight);
        temporalMathExpression = solveDivisionExpression(leftOperand, rightOperand);
        return temporalMathExpression;
    }


    private String solveDivisionExpression(String leftOperand, String rightOperand) {
        double leftOperandCasted = Double.parseDouble(leftOperand);
        double rightOperandCasted = Double.parseDouble(rightOperand);
        double result = leftOperandCasted / rightOperandCasted;
        return Double.toString(result);
    }


    @Override
    public String toString() {
        return this.solution;
    }


}
