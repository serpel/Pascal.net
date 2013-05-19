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
    
    int lInteger;

    public LitInteger(int lInteger) {
        this.lInteger = lInteger;
    }

    public int getlInteger() {
        return lInteger;
    }

    public void setlInteger(int lInteger) {
        this.lInteger = lInteger;
    }
    
    
}
