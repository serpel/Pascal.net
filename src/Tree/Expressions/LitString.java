/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitString extends Expression {
    
    String value;

    public LitString(String value) {
        this.value = value;
        this.setType(new Tree.Types.String());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void semanticValidation() {
        
    }
       
}
