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


}
