/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

/**
 *
 * @author SergioJavier
 */
public abstract class Declarations {
    
    Declarations next;

    public Declarations(Declarations next) {
        this.next = next;
    }

    public void setNext(Declarations next) {
        this.next = next;
    }

    public Declarations getNext() {
        return next;
    }
    
}
