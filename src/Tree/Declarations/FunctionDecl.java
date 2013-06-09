/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Statemens.Statement;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class FunctionDecl extends Declarations{
    Id name;
    Type t;
    Statement stms;

    public FunctionDecl(Id name, Type t, Statement stms) {
        this.name = name;
        this.t = t;
        this.stms = stms;
    }

    public Id getName() {
        return name;
    }

    public Type getT() {
        return t;
    }

    public Statement getStms() {
        return stms;
    }

    public void setName(Id name) {
        this.name = name;
    }

    public void setT(Type t) {
        this.t = t;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }

    @Override
    public void semanticValidation() {
        Env.getIntance().put(this.name.getIdentifier(), this.t);
        this.stms.semanticValidation();   
    }
    
}
