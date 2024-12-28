package passwordgenerator;

class GeneratePassword {

    private int passwordLength;
    private int totalNumbers;
    private int totalCharacters;
    private int totalLetters;
    private String password;

    public GeneratePassword(int passwordLength, int totalNumbers,
            int totalCharacters, int totalLetters) {
        this.passwordLength = passwordLength;
        this.totalNumbers = totalNumbers;
        this.totalCharacters = totalCharacters;
        this.totalLetters = totalLetters;
        this.password = makePassword();
    }


    private String makePassword() {
        char[] passwordArray = new char[passwordLength];
        RandomCharacterPicker alphabetPicker = new AlphabetPicker();
        RandomCharacterPicker characterPicker = new CharacterPicker();
        RandomCharacterPicker numberPicker = new NumberPicker();
        byte alphabetCounter = 0;
        byte characterCounter = 0;
        byte numberCounter = 0;
        byte currentPasswordSlot = 0;
        int randomSelector;

        while (true) {
            randomSelector = (int) (Math.random() * 3) + 1;
            if (currentPasswordSlot == passwordLength) {
                break;
            }

            if (randomSelector == 1) {
                if (!(alphabetCounter >= totalLetters)) {
                    passwordArray[currentPasswordSlot] = alphabetPicker.getRandomCharacter();
                    currentPasswordSlot++;
                    alphabetCounter++;
                } else {
                    continue;
                }
            } else if (randomSelector == 2) {
                if (!(characterCounter >= totalCharacters)) {
                    passwordArray[currentPasswordSlot] = characterPicker.getRandomCharacter();
                    currentPasswordSlot++;
                    characterCounter++;
                } else {
                    continue;
                }
            } else if (randomSelector == 3) {
                if (!(numberCounter >= totalNumbers)) {
                    passwordArray[currentPasswordSlot] = numberPicker.getRandomCharacter();
                    currentPasswordSlot++;
                    numberCounter++;
                } else {
                    continue;
                }
            }
        }

        return new String(passwordArray);
    }


    @Override
    public String toString() {
        return password;
    }


}
