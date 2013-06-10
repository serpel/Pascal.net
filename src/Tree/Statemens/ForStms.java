/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.Environment;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;
import Tree.Types.Bool;
import Tree.Types.Type;
import com.sun.corba.se.spi.ior.Identifiable;

/**
 *
 * @author SergioJavier
 */
public class ForStms extends Statement{
    Expression expr;
    Assign ass;
    Statement stms;

    public ForStms(Assign ass, Expression expr, Statement stms) {
        this.expr = expr;
        this.ass = ass;
        this.stms = stms;
    }

    public Expression getExpr() {
        return expr;
    }

    public Assign getAss() {
        return ass;
    }

    public Statement getStms() {
        return stms;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public void setAss(Assign ass) {
        this.ass = ass;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }    

    @Override
    public void semanticValidation() {
        Env.newEnv();  
        
        Expression i = this.ass.left;
        Expression j = this.ass.right;
        if(i instanceof Id)
        {
            Env.getIntance().put(((Id)i).getIdentifier(), j.getType()); 
        }else
        {
             ErrorLog.getInstance().add("Error: For esperaba Id pero se encontro: "+i.getType().toStr());
        }       

        this.ass.semantic();
        this.expr.semantic();
        
        if(this.ass.getRight().getType().getClass() != this.expr.getType().getClass())
        {
             ErrorLog.getInstance().add("Error: El rango de la intruccion FOR debe poseer tipos iguales, se encontro: "+this.ass.right.getType().toStr()+" y "+this.expr.getType().toStr());
        }
        
        if(stms!=null)
        {
            stms.semantic();
        }
            
        Env.restoreEnv();
    }
    
}
