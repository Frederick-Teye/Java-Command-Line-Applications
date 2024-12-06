package commandlinecalculator;

public class MathematicalExpression {
    private String rawInput;
    
    public MathematicalExpression(String rawInput) {
        setRawInput(rawInput); 
    }
    
    
    private void setRawInput(String rawInput) {
        this.rawInput = rawInput;
    }
    
}
