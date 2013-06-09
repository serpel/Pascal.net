/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.ErrorLog;
import Tree.Types.Bool;

/**
 *
 * @author SergioJavier
 */
public class Equal extends BinaryOp{

    public Equal(Expression left, Expression right) {
        super(left, right);
    }
    
    @Override
    public void semantic() {
        left.semanticValidation();
        right.semanticValidation();
        
        if (this.left.getType().getClass() != this.right.getType().getClass()) {
            ErrorLog.getInstance().add("Error: Operador '==' tiene tipos distintos, " + this.left.getType().toStr() + " y " + this.right.getType().toStr());
        }
        
        super.setType(new Bool());
    }
    
}
