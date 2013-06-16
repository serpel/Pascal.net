/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import AssemblyInfo.Assambly;
import Semantic.ErrorLog;
import Tree.Types.Bool;

/**
 *
 * @author SergioJavier
 */
public class And extends BinaryOp{

    public And(Expression left, Expression right) {
        super(left, right);
    }
    
    @Override
    public void semantic() {
        left.semanticValidation();
        right.semanticValidation();
        
        if (this.left.getType().getClass() != this.right.getType().getClass()) {
            ErrorLog.getInstance().add("Error: Operador 'and' tiene tipos distintos, " + this.left.getType().toStr() + " y " + this.right.getType().toStr());
        }
        
        super.setType(new Bool());
    }

    @Override
    public String codeGeneration() {
        //return left.codeGeneration()+right.codeGeneration()+"and\n";
        
        String lbl1=Assambly.getInstance().getLabel("And");
        String lbl2=Assambly.getInstance().getLabel("And");
        
        StringBuilder ret=new StringBuilder(left.codeGeneration());
        ret.append("brfalse ").append(lbl1).append("\n");
        ret.append(right.codeGeneration());
        ret.append("br ").append(lbl2).append("\n");
        ret.append(lbl1).append(":\n");
        ret.append("ldc.i4 0\n");
        ret.append(lbl2).append(":\n");
        
        return ret.toString();
    }
    
}
