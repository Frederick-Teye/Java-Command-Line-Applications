package commandlinecalculator;

import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {

    private String rawInput;
    private List<Integer> indexOfAllOpeningBrackets;
    private List<Integer> indexOfAllClosingBrackets;
    private boolean rawInputIsIllegal;

    public MathematicalExpression(String rawInput) {
        setRawInput(rawInput);
        this.indexOfAllOpeningBrackets = indexOfAllOpeningBrackets();
        this.indexOfAllClosingBrackets = indexOfAllClosingBrackets();
        this.rawInputIsIllegal = rawInputIsIllegal();
    }

    private void setRawInput(String rawInput) {
        this.rawInput = rawInput;
    }

    private String getRawInput() {
        return rawInput;
    }

    private List<Integer> indexOfAllOpeningBrackets() {

        String rawInput = getRawInput();
        List<Integer> indexOfAllOpeningBrackets = new ArrayList<>();

        for (int i = 0; i < rawInput.length(); i++) {

            if (rawInput.charAt(i) == '(') {
                indexOfAllOpeningBrackets.add(i);
            }

        }

        return indexOfAllOpeningBrackets;
    }

    private List<Integer> indexOfAllClosingBrackets() {

        String rawInput = getRawInput();
        List<Integer> indexOfAllClosingBrackets = new ArrayList<>();

        for (int i = 0; i < rawInput.length(); i++) {

            if (rawInput.charAt(i) == ')') {
                indexOfAllClosingBrackets.add(i);
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

    private String putMultiplicationSignBetweenNumbersAndOpenBrackets() {
        byte counter = 0;
        String mutedRawInput = this.rawInput;

        for (int i = 0; i < indexOfAllOpeningBrackets.size(); i++) {

            int getIndex = indexOfAllOpeningBrackets.get(i) + counter;
            String substring = mutedRawInput.substring(0, getIndex);

            if (!(substring.endsWith("*")
                    || substring.endsWith("**")
                    || substring.endsWith("/")
                    || substring.endsWith("+")
                    || substring.endsWith("-"))) {

                mutedRawInput = substring + "*" + mutedRawInput.substring(getIndex);
                counter++;
            }
        }

        return mutedRawInput;
    }
}
