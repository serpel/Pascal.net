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
    Declarations next=null;

    public void setNext(Declarations next) {
        this.next = next;
    }

    public Declarations getNext() {
        return next;
    }
    
}
