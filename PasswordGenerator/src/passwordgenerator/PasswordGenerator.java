package passwordgenerator;

import java.util.Scanner;

public class PasswordGenerator {

    static int passwordLenght;
    static int totalNumbers;
    static int totalCharacters;
    static int totalLetters;

    public static void main(String[] args) {
        // TODO code application logic here
    }


    static void collectUserInput() {
        Scanner scanner = new Scanner(System.in);

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

        passwordLenght = totalLetters + totalCharacters + totalNumbers;
    }


}
