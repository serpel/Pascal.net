/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Tree.Declarations.Declarations;
import Tree.Expressions.Expression;

/**
 *
 * @author SergioJavier
 */
public class Function extends Type{

    Declarations exprs;

    public Function(Declarations exprs) {
        this.exprs = exprs;
    }

    public Declarations getExprs() {
        return exprs;
    }

    public void setExprs(Declarations exprs) {
        this.exprs = exprs;
    }
    
    public int count()
    {
        Declarations e = this.exprs;
        
        int cont = 0;
        while(e!=null)
        {
            cont++;
            e = e.getNext();
        }
        
        return cont;
    }
    
    @Override
    public java.lang.String toAssably() {
        return "Function";
    }
    
    @Override
    public java.lang.String toStr() {
        return "Funtion";
    }
    
}
