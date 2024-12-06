package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {
    private String rawInput;
    private List<Integer> indexOfAllOpeningBrackets;
    private List<Integer> indexOfAllClosingBrackets;
    private boolean rawInputIsIllegal;
    
    public MathematicalExpression(String rawInput) {
        setRawInput(rawInput); 
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
    
}
