/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Tree.Types.Char;

/**
 *
 * @author SergioJavier
 */
public class LitChar extends Expression {
    
    char value;

    public LitChar(char value) {
        this.value = value;
        this.setType(new Char());
    }

    public char getValue() {
        return value;
    }

    public void setlValue(char value) {
        this.value = value;
    }

    @Override
    public void semanticValidation() {
        
    }
    
}
