/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitChar extends Expression {
    
    char lChar;

    public LitChar(char lChar) {
        this.lChar = lChar;
    }

    public char getlChar() {
        return lChar;
    }

    public void setlChar(char lChar) {
        this.lChar = lChar;
    }
    
}
