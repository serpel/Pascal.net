/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public abstract class Expression {
    
    Expression next=null;
    Type t;

    public abstract void semanticValidation();  
    
    public void semantic()
    {
        semanticValidation();
        
        if(next!=null)
        {
            semantic();
        }
    }
    
    public Expression getNext() {
        return next;
    }

    public void setNext(Expression next) {
        this.next = next;
    } 
    
    public Type getType(){
        return this.t;
    }
    
    public void setType(Type t){
        this.t = t;
    }
}
