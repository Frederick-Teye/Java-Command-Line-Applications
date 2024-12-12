package commandlinecalculator;

import java.util.Scanner;

public class CommandLineCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mathematical expression: ");
        String userInput = scanner.nextLine().trim();

        String mathExpressionWithoutWhiteSpace = userInput.replace(" ", "");
        System.out.println(mathExpressionWithoutWhiteSpace);

        MathematicalExpression mathExpression = new MathematicalExpression(mathExpressionWithoutWhiteSpace);
        // I don't need the MathematicalExpression class again, except its 
        // isRawInputIllegal() method. 

        if (mathExpression.isRawInputIllegal() == true) {
            System.out.println("Invalid input, enter only numbers and math operators");
        } else {
//            String input = mathExpression.toString();

            EvaluateExpression solution;
            solution = new EvaluateExpression(mathExpressionWithoutWhiteSpace);
            System.out.println("solution of " + mathExpression + " = " + solution);
        }

    }


}
