/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.*;
import Tree.Expressions.Expression;
import Tree.Types.*;

/**
 *
 * @author SergioJavier
 */
public class WhileStms extends Statement{
    Expression param;
    Statement stms;

    public WhileStms(Expression param, Statement stms) {
        this.param = param;
        this.stms = stms;
    }

    public Expression getParam() {
        return param;
    }

    public Statement getStms() {
        return stms;
    }

    public void setParam(Expression param) {
        this.param = param;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }

    @Override
    public void semanticValidation() {
        
        Env.newEnv();     
        
        if(!(this.param.getType() instanceof Bool) || !(this.param.getType() instanceof Tree.Types.Integer))
        {
            ErrorLog.getInstance().add("Error: Instruccion While no soporta tipo "+this.param.getType().toString());
        }    
        
        stms.semanticValidation();
            
        Env.restoreEnv();
    }
    
}
