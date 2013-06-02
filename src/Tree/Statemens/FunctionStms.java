/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;
import Tree.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class FunctionStms extends Statement{
   
    Id name;
    Expression elist;

    public FunctionStms(Id name, Expression elist) {
        this.name = name;
        this.elist = elist;
    }

    public Id getName() {
        return name;
    }

    public Expression getElist() {
        return elist;
    }

    public void setName(Id name) {
        this.name = name;
    }

    public void setElist(Expression elist) {
        this.elist = elist;
    }
    
    private int count()
    {
        Expression e = this.elist;
        
        int cont = 0;
        while(e!=null)
        {
            cont++;
            e = e.getNext();
        }
        
        return cont;
    }

    @Override
    public void semanticValidation() {
        
        Type t = Env.getIntance().getType(this.name.getIdentifier());
        
        if(!(t instanceof Tree.Types.Function))
        {
            ErrorLog.getInstance().add("Error: La variable '"+this.name.getIdentifier()+"' no es de tipo Function");
        }else
        {
            int paramSize = ((Tree.Types.Function)t).count();
            
            if(paramSize != count())
            {
                ErrorLog.getInstance().add("Error: La function '"+this.name.getIdentifier()+"' esperaba "+paramSize+" parametros.");
            } 
        }
    }
    
}
