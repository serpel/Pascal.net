/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Environment;

/**
 *
 * @author SergioJavier
 */
public abstract class Statement { 
    Statement next=null;
    
    public abstract void semanticValidation();  

    public void setNext(Statement next) {
        this.next = next;
    }

    public Statement getNext() {
        return next;
    }
    
}
