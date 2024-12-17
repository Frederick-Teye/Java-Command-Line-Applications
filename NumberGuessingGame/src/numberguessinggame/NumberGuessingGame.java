package numberguessinggame;

import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome!!! A random number between 1 and 100 is \n"
                + "generated in memory, guess what number it is: ");
        
        int userInput = scanner.nextInt();
        int generatedRandomNumber = (int) (Math.random() * 100);
    }


}
