/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Tree.Expressions.Expression;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class Array extends Type{
    Expression exprs;
    Type t;

    public Array(Expression exprs, Type t) {
        this.exprs = exprs;
        this.t = t;
    }

    public Expression getExprs() {
        return exprs;
    }

    public Type getT() {
        return t;
    }

    public void setExprs(Expression exprs) {
        this.exprs = exprs;
    }

    public void setT(Type t) {
        this.t = t;
    }

    @Override
    public java.lang.String toAssably() {
        return "Array";
    }

    @Override
    public java.lang.String toStr() {
        return "Array";
    }

}
