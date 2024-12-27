package passwordgenerator;

public class CharacterPicker implements RandomCharacterPicker {

    public final char[] characters = {'.', ',', ';', ':', '<', '>', '/', ']', '|',
        '[', '{', '}', '"', '!', '@', '#', '$', '%', '^', '?',
        '&', '*', '(', ')', '-', '_', '=', '+', '`', '~'};

    @Override
    public Character getRandomCharacter() {
        int randomIndex = (int) (Math.random() * characters.length);
        return characters[randomIndex];
    }


}
