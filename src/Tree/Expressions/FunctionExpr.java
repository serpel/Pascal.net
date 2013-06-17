/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.Env;
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
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String codeGeneration() {   
        
        String tmp = "";
        Type t = Env.getIntance().getType(this.name.getIdentifier());
        
        tmp += this.elist.codeGeneration();
        tmp +="call "+t.toAssembly()+" "+this.name.getIdentifier()+"(";
        
        Expression e = this.elist;
        while(e!=null)
        {
            tmp += e.getType().toAssembly();
            tmp += ",";
            e = e.getNext();
        }
        
        tmp = tmp.substring(0,tmp.length()-1);
        tmp += ")\n"; 
        
        return tmp;
    }
}
