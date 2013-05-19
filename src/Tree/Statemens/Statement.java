/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

/**
 *
 * @author SergioJavier
 */
public abstract class Statement {
    
    Statement next;

    public Statement(Statement next) {
        this.next = next;
    }

    public void setNext(Statement next) {
        this.next = next;
    }

    public Statement getNext() {
        return next;
    }
    
}
