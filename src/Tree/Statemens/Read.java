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
public class Read extends Statement{
    Expression param;

    public Read(Expression param) {
        this.param = param;
    }

    public void setParam(Expression param) {
        this.param = param;
    }

    public Expression getParam() {
        return param;
    }

    @Override
    public void semanticValidation() {
          
//        if(this.param instanceof Id)
//        {
//            String id = ((Id)param).getIdentifier();
//            if(Env.getIntance().get(id) == null)
//            {
//                ErrorLog.getInstance().add("Error: variable '"+id+"' no existe.");
//            }
//        }
        param.semanticValidation();
    }
    
}
