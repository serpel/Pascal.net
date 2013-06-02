/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.Id;
import Tree.Statemens.Statement;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class FunctionDecl extends Declarations{
    Id name;
    Declarations params;
    Type t;
    Statement stms;

    public FunctionDecl(Id name, Declarations params, Type t, Statement stms) {
        this.name = name;
        this.params = params;
        this.t = t;
        this.stms = stms;
    }

    public Id getName() {
        return name;
    }

    public Declarations getParams() {
        return params;
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

    public void setParams(Declarations params) {
        this.params = params;
    }

    public void setT(Type t) {
        this.t = t;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }
    
}
