/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Tree.Types.Bool;

/**
 *
 * @author SergioJavier
 */
public class LitBool extends Literal {
    
    Boolean value;

    public LitBool(Boolean value) {
        this.value = value;
        this.setType(new Bool());
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
   
}
