/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitBool extends Expression {
    
    Boolean lbool;

    public LitBool(Boolean lbool) {
        this.lbool = lbool;
    }

    public Boolean getLbool() {
        return lbool;
    }

    public void setLbool(Boolean lbool) {
        this.lbool = lbool;
    }
   
}
