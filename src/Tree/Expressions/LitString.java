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
    
    String lString;

    public LitString(String lString) {
        this.lString = lString;
    }

    public String getlString() {
        return lString;
    }

    public void setlString(String lString) {
        this.lString = lString;
    }
       
}
