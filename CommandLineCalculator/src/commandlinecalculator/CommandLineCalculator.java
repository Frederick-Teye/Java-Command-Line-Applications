package commandlinecalculator;

import java.util.Scanner;

public class CommandLineCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter mathematical expression: ");
        String userInput = scanner.nextLine().trim();
        
        String mathExpressionWithoutWhiteSpace = userInput.replace(" ", "");
        System.out.println(mathExpressionWithoutWhiteSpace);
        
        MathematicalExpression mathExpression = new 
        MathematicalExpression(mathExpressionWithoutWhiteSpace);
        
        String input = mathExpression.toString();
        
        EvaluateExpression solution;
        solution = new EvaluateExpression(input);
        System.out.println("soution of " + mathExpression + " = " + solution);
    }
    
}
