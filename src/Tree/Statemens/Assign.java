/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;

/**
 *
 * @author SergioJavier
 */
public class Assign extends Statement{

    Id i;
    Expression right;

    public Assign(Id i, Expression right) {
        this.i = i;
        this.right = right;
    }

    public Id getI() {
        return i;
    }

    public void setI(Id i) {
        this.i = i;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
    
   
    @Override
    public void semanticValidation() {
        
        right.semantic();
        this.i.semantic();

        if (this.i.getType().getClass() != this.right.getType().getClass()) {
            ErrorLog.getInstance().add("Error: Asignacion con tipos incompatibles, " + this.i.getType().toStr() + " y " + this.right.getType().toStr());
        }
        
    }

    @Override
    public String codeGenerationStament() {
        return this.right.codeGeneration()+"stloc."+Env.getIntance().getNumber(i.getIdentifier())+"\n";
    }
    
}
