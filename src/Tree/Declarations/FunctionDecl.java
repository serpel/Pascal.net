/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Statemens.Statement;
import Tree.Types.Field;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class FunctionDecl extends Declarations{
    Id name;
    Type t;
    Declarations vars;
    Statement stms;

    public FunctionDecl(Id name, Type t, Declarations vars, Statement stms) {
        this.name = name;
        this.t = t;
        this.vars = vars;
        this.stms = stms;
    }

    public Id getName() {
        return name;
    }

    public void setName(Id name) {
        this.name = name;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    public Declarations getVars() {
        return vars;
    }

    public void setVars(Declarations vars) {
        this.vars = vars;
    }

    public Statement getStms() {
        return stms;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }

    @Override
    public void semanticValidation() {
       
        
        Env.getIntance().put(this.name.getIdentifier(), this.t);
        
        //variables locales
        if(this.vars != null)
        {
            this.vars.semantic();
        }
       
        if (this.stms != null) {
            this.stms.semantic();
        }
    }
    
}
