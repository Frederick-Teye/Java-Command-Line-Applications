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
}
