/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantic;

import Tree.Expressions.Expression;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class Environment {
    private SymbolTable table;   
    protected Environment prev;

    public Environment(Environment prev) {
        this.prev = prev;
        this.table = new SymbolTable();
    }
    
    public void put(String id, Type t)
    {
        this.table.addVariable(id, t);
    }
    
    public Expression get(String name)
    {
        Expression found = null;
        for(Environment e=this; e!=null; e=e.prev)
        {
            found = e.table.getValue(name);
            
            if(found != null)
            {
                return found;
            }
        } 
        return found;
    }

}
