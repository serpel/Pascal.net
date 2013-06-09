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
public class Mul extends BinaryOp {

    public Mul(Expression left, Expression right) {
        super(left, right);
    } 
    
    @Override
    public void semantic() {
        left.semanticValidation();
        right.semanticValidation();
        
        if (this.left.getType().getClass() != this.right.getType().getClass()) {
            ErrorLog.getInstance().add("Error: Operador '*' tiene tipos distintos, " + this.left.getType().toStr() + " y " + this.right.getType().toStr());
        }
        
        super.setType(left.getType());
    } 
}
