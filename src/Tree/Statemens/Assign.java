/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;

/**
 *
 * @author SergioJavier
 */
public class Assign extends Statement{

    Expression left,right;
    
    public Assign(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }  

    @Override
    public void semanticValidation() {
        
        left.semantic();
        right.semantic();
        
        if(this.left instanceof Id)
        {
             if(this.left.getType().getClass() != this.right.getType().getClass())
             {
                ErrorLog.getInstance().add("Error: Asignacion con tipos incompatibles, "+this.left.getType().toStr()+" y "+this.right.getType().toStr());
             }
        }//else if(this.left instanceof Array)
        
       
    }
    
}
