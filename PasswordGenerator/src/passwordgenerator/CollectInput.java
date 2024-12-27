package passwordgenerator;

public class CollectInput {

    private int passwordLenght;
    private int totalNumbers;
    private int totalCharacters;
    private int totalLetters;
    
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
}
