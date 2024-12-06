package commandlinecalculator;

import java.util.ArrayList;
import java.util.List;

public class MathematicalExpression {
    private String rawInput;
    
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
    
}
