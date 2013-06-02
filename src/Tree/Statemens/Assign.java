/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.ErrorLog;
import Tree.Expressions.Expression;

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
        
        if(this.left.getType() != this.right.getType())
        {
             ErrorLog.getInstance().add("Error: Tipos incompatibles, se encontro: "+this.right.getType().toString()+", "+this.right.getType().toString());
        }
    }
    
}
