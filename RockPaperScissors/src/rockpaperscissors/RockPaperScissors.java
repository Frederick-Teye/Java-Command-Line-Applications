package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors Game");
        byte machinePoints = 0;
        byte userPoints = 0;

        String[] gameValues = {"rock", "paper", "scissors"};

        do {
            int userInput = getUserInput();
            String userSelection = gameValues[--userInput];
            String randomSelection = gameValues[(int) (Math.random() * gameValues.length)];

            if (userSelection.equals("rock") && randomSelection.equals("scissors")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                userPoints++;
                System.out.println("You win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            } else if (userSelection.equals("scissors") && randomSelection.equals("rock")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                machinePoints++;
                System.out.println("Machine win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            } else if (userSelection.equals("scissors") && randomSelection.equals("paper")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                userPoints++;
                System.out.println("You win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            } else if (userSelection.equals("paper") && randomSelection.equals("scissors")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                machinePoints++;
                System.out.println("Machine win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            } else if (userSelection.equals("paper") && randomSelection.equals("rock")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                userInput++;
                System.out.println("You win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            } else if (userSelection.equals("rock") && randomSelection.equals("paper")) {
                System.out.println("Your input: " + userSelection);
                System.out.println("Machine selection: " + randomSelection);
                machinePoints++;
                System.out.println("Machine win!!!\n");
                if (quitGame()) {
                    System.out.println("Your score is: " + userPoints);
                    System.out.println("Machine score is " + machinePoints);
                    break;
                } else {
                    System.out.println("");
                }
            }
        } while (true);

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
                System.out.println("Enter only numbers!!!\n");
            } else if ((Integer.parseInt(userInput) > 3)
                    || (Integer.parseInt(userInput) < 1)) {
                System.out.println("Enter only numbers from 1 to 3\n");
            } else {
                break;
            }
        }
        return Integer.parseInt(userInput);
    }


    private static boolean quitGame() {
        System.out.print("Will you like to QUIT game?(Y/N): ");
        String userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("y") || userInput.equals("yes")) {
            return true;
        }
        return false;
    }


}
