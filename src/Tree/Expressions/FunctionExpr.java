/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class FunctionExpr extends Expression {

    Id name;
    Expression elist;

    public FunctionExpr(Id name, Expression elist) {
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

    @Override
    public void semanticValidation() {
        
        Type t = Env.getIntance().getFunction(name.getIdentifier());
        if( t == null)
        {
            ErrorLog.getInstance().add("Error: funcion " +this.name.getIdentifier()+ " no existe.\n");
        }
        
        this.elist.semantic();
        
        super.setType(t);
        //falta comprobar parametros
    }
    
    @Override
    public String codeGeneration() {

        String tmp = "", arg = "";
        Type t = Env.getIntance().getFunction(this.name.getIdentifier());

        tmp += this.elist.code();
        tmp += "call " + t.toAssembly() + " " + this.name.getIdentifier() + "(";

        Expression e = this.elist;
        while (e != null) {
            arg += e.getType().toAssembly();
            arg += ",";
            e = e.getNext();
        }

        if (arg.length() > 0) {
            arg = arg.substring(0, arg.length() - 1);
            tmp += arg;
        }
        tmp += ")\n";

        return tmp;
    }
}
