/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;

/**
 *
 * @author SergioJavier
 */
public abstract class Statement { 
    Statement next=null;
    
    public abstract void semanticValidation(); 
    
    public void semantic()
    {
        this.semanticValidation();
        
        if(next!=null)
        {
            next.semantic();
        }
    }

    public void setNext(Statement next) {
        this.next = next;
    }

    public Statement getNext() {
        return next;
    }
    
    public abstract java.lang.String codeGenerationStament();
    
    public java.lang.String codeGeneration()
    {
        String valor = this.codeGenerationStament();
        if(next!= null)
        {
            valor+=next.codeGeneration();
        }
        return valor;
    }
    
}
