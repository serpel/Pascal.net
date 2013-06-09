/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.ErrorLog;

/**
 *
 * @author SergioJavier
 */
public abstract class BinaryOp extends Expression{
    
    Expression left, right;

    public BinaryOp(Expression left, Expression right) {
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
    
    public abstract void semantic();

    @Override
    public void semanticValidation() {
        this.semantic();      
    }  
    
}
