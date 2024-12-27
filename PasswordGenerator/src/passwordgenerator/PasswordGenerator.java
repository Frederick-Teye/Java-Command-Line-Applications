package passwordgenerator;

public class PasswordGenerator {

    static int passwordLenght;
    static int totalNumbers;
    static int totalCharacters;
    static int totalLetters;

    public static void main(String[] args) {
        CollectInput userInput = new CollectInput();
        passwordLenght = userInput.getPasswordLength();
        totalNumbers = userInput.getTotalNumbers();
        totalCharacters = userInput.getTotalCharacters();
        totalLetters = userInput.getTotalLetters();

        GeneratePassword password = new GeneratePassword
        (passwordLenght, totalNumbers, totalCharacters, totalLetters);
        
        System.out.println("Your password is " + password.toString());
    }


}
