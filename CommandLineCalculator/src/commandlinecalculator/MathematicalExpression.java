package commandlinecalculator;

import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {
    private String rawInput;
    private List<Integer> indexOfAllOpeningBrackets;
    private List<Integer> indexOfAllClosingBrackets;
    private boolean rawInputIsIllegal;
    
    public MathematicalExpression(String rawInput) {
        setRawInput(rawInput); 
        this.indexOfAllOpeningBrackets = indexOfAllOpeningBrackets();
        this.indexOfAllClosingBrackets = indexOfAllClosingBrackets();
    }
    
    
    private void setRawInput(String rawInput) {
        this.rawInput = rawInput;
    }
    
    
    private String getRawInput() {
        return rawInput;
    }
    
    private List<Integer> indexOfAllOpeningBrackets() {
        
        String rawInput = getRawInput();
        List<Integer> indexOfAllOpeningBrackets = new ArrayList<>();
        
        for (int i=0; i < rawInput.length(); i++) {
            
            if (rawInput.charAt(i) == '(')
                indexOfAllOpeningBrackets.add(i);
                
        }
        
        return indexOfAllOpeningBrackets;
    }
    
    
    private List<Integer> indexOfAllClosingBrackets() {
        
        String rawInput = getRawInput();
        List<Integer> indexOfAllClosingBrackets = new ArrayList<>();
        
        for (int i=0; i < rawInput.length(); i++) {
            
            if (rawInput.charAt(i) == ')')
                indexOfAllClosingBrackets.add(i);
                
        }
        
        return indexOfAllClosingBrackets;
    }
    
    private boolean rawInputIsIllegal() {
        boolean isIllegal = false;
        
        for (int i=0; i < this.rawInput.length(); i++) {
            if (!(isDigit(this.rawInput.charAt(i))
                    || this.rawInput.charAt(i) == '.'
                    || this.rawInput.charAt(i) == '('
                    || this.rawInput.charAt(i) == ')'
                    || this.rawInput.charAt(i) == '*'
                    || this.rawInput.charAt(i) == '/'
                    || this.rawInput.charAt(i) == '+'
                    || this.rawInput.charAt(i) == '-')) {
                isIllegal = true;
                break;
            }
        }
        
        return isIllegal;
    }
    
}
