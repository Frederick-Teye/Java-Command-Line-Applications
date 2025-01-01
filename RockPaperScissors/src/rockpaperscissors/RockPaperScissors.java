package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors Game");

    }


    private static boolean isNumeric(String arg) {
        if (arg == null) {
            return false;
        }

        try {
            Double.parseDouble(arg);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    private static int getUserInput() {
        String userInput;
        while (true) {
            System.out.print("Enter   1 to select Rock, "
                    + "\n\t2 to select Paper, "
                    + "\n\t3 to select Scissors: ");
            userInput = scanner.nextLine();
            System.out.println("");
            if (!isNumeric(userInput)) {
                System.out.println("Enter only numbers!!!");
            } else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }


}
