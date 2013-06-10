/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Semantic.Env;
import Tree.Statemens.Statement;
import Tree.Declarations.Declarations;
import Tree.Declarations.TypeDecl;
import Tree.Declarations.VarDecl;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SergioJavier
 */
public class Record extends Type{
    
    Hashtable<java.lang.String, Type> table;

    public Record(Hashtable<java.lang.String, Type> table) {
        this.table = table;
    }

    public Hashtable<java.lang.String, Type> getTable() {
        return table;
    }

    public void setTable(Hashtable<java.lang.String, Type> table) {
        this.table = table;
    }
        
    @Override
    public java.lang.String toAssably() {
        return "";
    }
    
    @Override
    public java.lang.String toStr() {
        return "Record";
    }
    
}
