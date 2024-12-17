package numberguessinggame;

import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome!!! A random number between -1 and 100 is \n"
                + "generated in memory, guess what number it is: ");
        
        int userInput = scanner.nextInt();
        int generatedRandomNumber = (int) (Math.random() * 100);
        byte numberOfTrial = 0;
        
        do {            
            if (userInput < generatedRandomNumber) {
                System.out.println("Your input is too low!\n");
                numberOfTrial++;
                System.out.print("Enter a new number: ");
                userInput = scanner.nextInt();
            } else if (userInput > generatedRandomNumber) {
                System.out.println("Your input is too high!\n");
                numberOfTrial++;
                System.out.print("Enter a new number: ");
                userInput = scanner.nextInt();
            } else {
                System.out.print("You've won!!!");
                System.out.println("You've attempted " + numberOfTrial + " times!");
                break;
            }
        } while (true);
    }
    
    
}
