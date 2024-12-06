package commandlinecalculator;
import java.util.Scanner;

public class CommandLineCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter mathematical expression: ");
        String userInput = scanner.nextLine().trim();
        
        String mathExpressionWithoutWhiteSpace = userInput.replace(" ", "");
        System.out.println(mathExpressionWithoutWhiteSpace);
        
        
    }
    
}
