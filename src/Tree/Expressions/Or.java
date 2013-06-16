/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import AssemblyInfo.Assambly;
import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Types.Bool;

/**
 *
 * @author SergioJavier
 */
public class Or extends BinaryOp  {

    public Or(Expression left, Expression right) {
        super(left, right);
    }
    
    @Override
    public void semantic() {
        left.semanticValidation();
        right.semanticValidation();
        
        if (this.left.getType().getClass() != this.right.getType().getClass()) {
            ErrorLog.getInstance().add("Error: Operador 'or' tiene tipos distintos, " + this.left.getType().toStr() + " y " + this.right.getType().toStr());
        }
        
        super.setType(new Bool());
    }
    
    @Override
    public String codeGeneration() {
        //return left.codeGeneration()+right.codeGeneration()+"or\n";
        
        String lbl1=Assambly.getInstance().getLabel("Or");
        String lbl2=Assambly.getInstance().getLabel("Or");
        
        StringBuilder ret = new StringBuilder(left.codeGeneration());
        ret.append("brtrue ").append(lbl1).append("\n");
        ret.append(right.codeGeneration());
        ret.append("br ").append(lbl2).append("\n");
        ret.append(lbl1).append(":\n");
        ret.append("ldc.i4 1\n");
        ret.append(lbl2).append(":\n");
        
        return ret.toString();
    }

}
