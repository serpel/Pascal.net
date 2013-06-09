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
    
    public abstract void semanticValidation();   
    
    public void semantic()
    {
        this.semanticValidation();
        
        if(next!= null)
        {
            next.semantic();
        }
    }
            
           
}
