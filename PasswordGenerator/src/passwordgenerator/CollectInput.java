package passwordgenerator;

import java.util.Scanner;

public class CollectInput {

    private int passwordLenght;
    private int totalNumbers;
    private int totalCharacters;
    private int totalLetters;
    private Scanner scanner = new Scanner(System.in);

    public CollectInput() {
        setNumberOfCharacters();
        setNumberOfLetters();
        setNumberOfNumbers();
        setPasswordLength();
    }


    private void setNumberOfCharacters() {
        do {
            System.out.print("How many characters should password contain: ");
            String totalCharactersString = scanner.nextLine().trim();
            if (isNumeric(totalCharactersString)) {
                totalCharacters = Integer.parseInt(totalCharactersString);
                System.out.println("");
                break;
            } else {
                System.out.println("Enter numbers only!!!\n");
            }
        } while (true);
    }


    private void setNumberOfLetters() {
        do {
            System.out.println("How many letters should password contain: ");
            String totalLettersString = scanner.nextLine().trim();

            if (isNumeric(totalLettersString)) {
                totalLetters = Integer.parseInt(totalLettersString);
                System.out.println("");
                break;
            } else {
                System.out.println("Enter numbers only!!!\n");
            }
        } while (true);
    }


    private void setNumberOfNumbers() {
        do {
            System.out.print("Password should contain how many numbers: ");
            String totalNumbersString = scanner.nextLine().trim();
            if (isNumeric(totalNumbersString)) {
                totalNumbers = Integer.parseInt(totalNumbersString);
                System.out.println("");
                break;
            } else {
                System.out.println("Enter numbers only!!!\n");
            }
        } while (true);
    }


    private void setPasswordLength() {
        passwordLenght = totalCharacters + totalNumbers + totalLetters;
    }


    private boolean isNumeric(String arg) {
        if (arg == null) {
            return false;
        }

        try {
            Double.parseDouble(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public int getPasswordLenght() {
        return passwordLenght;
    }


}
