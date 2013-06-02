/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitFloat extends Expression{
    
    float value;

    public LitFloat(float value) {
        this.value = value;
        this.setType(new Tree.Types.Float());
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public void semanticValidation() {
     
    }
    
}
