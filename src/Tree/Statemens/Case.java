/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Tree.Expressions.Expression;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class Case extends Statement {
    
    ArrayList<Expression> exprs;
    Statement stms;

    public Case(ArrayList<Expression> exprs, Statement next) {
        super(next);
        this.exprs = exprs;
    }

    public ArrayList<Expression> getExprs() {
        return exprs;
    }

    public Statement getStms() {
        return stms;
    }

    public void setExprs(ArrayList<Expression> exprs) {
        this.exprs = exprs;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }

    
}
