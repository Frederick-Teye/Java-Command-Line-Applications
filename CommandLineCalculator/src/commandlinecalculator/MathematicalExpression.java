package commandlinecalculator;

import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {

    private String rawInput;
    private List<Integer> indexOfAllOpeningBrackets;
    private List<Integer> indexOfAllClosingBrackets;
    private boolean rawInputIsIllegal;
    private String firstMutatedRawInput;
    private String lastMutatedRawInput;

    public MathematicalExpression(String rawInput) {
        setRawInput(rawInput);
        this.indexOfAllOpeningBrackets = indexOfAllOpeningBrackets();
        this.firstMutatedRawInput = putMultiplicationSignBetweenNumbersAndOpenBrackets();
        this.indexOfAllClosingBrackets = indexOfAllClosingBrackets();
        this.rawInputIsIllegal = rawInputIsIllegal();
        this.lastMutatedRawInput = putMultiplicationSignBetweenClosedBracketsAndNumbers();
    }

    private void setRawInput(String rawInput) {
        this.rawInput = rawInput;
    }

    private String getRawInput() {
        return rawInput;
    }

    /**
     * Finds the indices of all opening parentheses in the raw input string.
     *
     * This method retrieves the raw input string and iterates through it to
     * collect the indices of all opening parentheses ('('). The method excludes
     * the first character of the string from being added to the list of
     * indices. The indices are stored in a list, which is then returned.
     *
     * @return List<Integer> - A list of integers representing the indices of
     * all opening parentheses found in the raw input string. If no opening
     * parentheses are found, an empty list is returned.
     */
    private List<Integer> indexOfAllOpeningBrackets() {

        String rawInput = getRawInput();
        List<Integer> indexOfAllOpeningBrackets = new ArrayList<>();

        for (int i = 0; i < rawInput.length(); i++) {

            if (rawInput.charAt(i) == '(') {
                if (i != 0) {
                    indexOfAllOpeningBrackets.add(i);
                }
            }

        }

        return indexOfAllOpeningBrackets;
    }

    /**
     * Finds the indices of all closing parentheses in the first muted raw input
     * string.
     *
     * This method iterates through the `firstMutatedRawInput` string and
     * collects the indices of all closing parentheses (')') that are not the
     * last character in the string. The indices are stored in a list, which is
     * then returned.
     *
     * @return List<Integer> - A list of integers representing the indices of
     * all closing parentheses found in the `firstMutatedRawInput` string. If no
     * closing parentheses are found, an empty list is returned.
     */
    private List<Integer> indexOfAllClosingBrackets() {

        String firstMutatedRawInput = this.firstMutatedRawInput;
        List<Integer> indexOfAllClosingBrackets = new ArrayList<>();

        for (int i = 0; i < firstMutatedRawInput.length(); i++) {

            if (firstMutatedRawInput.charAt(i) == ')') {
                if (!(i == firstMutatedRawInput.length() - 1)) {
                    indexOfAllClosingBrackets.add(i);
                }
            }

        }

        return indexOfAllClosingBrackets;
    }

    /**
     * Checks if the raw input string contains any illegal characters.
     *
     * This method iterates through each character of the `rawInput` string and
     * verifies whether it consists solely of valid characters. The valid
     * characters are: - Digits (0-9) - Decimal point (.) - Parentheses (()) -
     * Arithmetic operators (+, -, *, /)
     *
     * If any character in the `rawInput` string is found to be outside of these
     * valid characters, the method will return true, indicating that the input
     * is illegal. Otherwise, it returns false, indicating that the input is
     * legal.
     *
     * @return boolean - Returns true if the raw input contains illegal
     * characters, false if the input is legal.
     */
    private boolean rawInputIsIllegal() {
        boolean isIllegal = false;

        for (int i = 0; i < this.rawInput.length(); i++) {
            if (!(isDigit(this.rawInput.charAt(i))
                    || this.rawInput.charAt(i) == '.'
                    || this.rawInput.charAt(i) == '('
                    || this.rawInput.charAt(i) == ')'
                    || this.rawInput.charAt(i) == '*'
                    || this.rawInput.charAt(i) == '/'
                    || this.rawInput.charAt(i) == '+'
                    || this.rawInput.charAt(i) == '-')) {
                isIllegal = true;
                break;
            }
        }

        return isIllegal;
    }

    /**
     * Inserts multiplication signs between numbers and opening brackets in the
     * raw input string.
     *
     * This method iterates through the indices of all opening brackets and
     * checks if there is a number immediately preceding an opening bracket. If
     * there is no arithmetic operator (such as '*', '/', '+', or '-') between
     * the number and the opening bracket, a multiplication sign ('*') is
     * inserted. The method ensures that multiple multiplication signs are not
     * added consecutively.
     *
     * @return String - The modified raw input string with multiplication signs
     * inserted where necessary. If no modifications are needed, the original
     * string is returned.
     */
    private String putMultiplicationSignBetweenNumbersAndOpenBrackets() {
        byte counter = 0;
        String mutatedRawInput = this.rawInput;

        for (int i = 0; i < indexOfAllOpeningBrackets.size(); i++) {

            int getIndex = indexOfAllOpeningBrackets.get(i) + counter;
            String substring = mutatedRawInput.substring(0, getIndex);

            if (!(substring.endsWith("*")
                    || substring.endsWith("**")
                    || substring.endsWith("/")
                    || substring.endsWith("+")
                    || substring.endsWith("-"))) {

                mutatedRawInput = substring + "*" + mutatedRawInput.substring(getIndex);
                counter++;
            }
        }

        return mutatedRawInput;
    }

    /**
     * Inserts multiplication signs between closed brackets and numbers in the
     * mutated raw input string.
     *
     * This method iterates through the indices of all opening brackets and
     * checks if there is a number immediately following a closing bracket. If
     * there is no arithmetic operator (such as '*', '/', '+', or '-') between
     * the closing bracket and the number, a multiplication sign ('*') is
     * inserted. The method ensures that multiple multiplication signs are not
     * added consecutively.
     *
     * @return String - The modified mutated raw input string with
     * multiplication signs inserted where necessary. If no modifications are
     * needed, the original string is returned.
     */
    private String putMultiplicationSignBetweenClosedBracketsAndNumbers() {
        byte counter = 0;
        String mutatedRawInput = this.firstMutatedRawInput;

        for (int i = 0; i < indexOfAllOpeningBrackets.size(); i++) {

            int getIndex = indexOfAllOpeningBrackets.get(i) + counter;
            String substring = mutatedRawInput.substring(0, getIndex + 2);

            if (!(substring.endsWith("*")
                    || substring.endsWith("**")
                    || substring.endsWith("/")
                    || substring.endsWith("+")
                    || substring.endsWith("-"))) {

                mutatedRawInput = mutatedRawInput.substring(0, ++getIndex)
                        + "*" + mutatedRawInput.substring(++getIndex);
                counter++;
            }
        }

        return mutatedRawInput;
    }

    @Override
    public String toString() {
        return "Refined Mathematical Expression: " + lastMutatedRawInput;
    }

}
