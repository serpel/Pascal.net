/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Tree.Expressions.Expression;

/**
 *
 * @author SergioJavier
 */
public class Function extends Type{

    Expression exprs;

    public Function(Expression exprs) {
        this.exprs = exprs;
    }

    public Expression getExprs() {
        return exprs;
    }

    public void setExprs(Expression exprs) {
        this.exprs = exprs;
    }
    
    public int count()
    {
        Expression e = this.exprs;
        
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
        return "function";
    }
    
}
