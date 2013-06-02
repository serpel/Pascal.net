/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitInteger extends Expression {
    
    int value;

    public LitInteger(int value) {
        this.value = value;
        this.setType(new Tree.Types.Integer());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void semanticValidation() {
        
    }   
    
}
