package passwordgenerator;

public class NumberPicker implements RandomCharacterPicker {

    private final char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    @Override
    public Character getRandomCharacter() {
        int randomIndex = (int) (Math.random() * numbers.length);
        return numbers[randomIndex];
    }


}