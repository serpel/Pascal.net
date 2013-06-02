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
public class Env {
    
    private static Env instance=null;
    private static Env tmp=null;
    private SymbolTable table;   
    private Env prev;

    
    private Env(Env prev) {
        this.prev = prev;
        this.table = new SymbolTable();
    }

    public static Env getIntance() {
        
        if(instance==null)
        {
            instance = new Env(null);
        }
        return instance;
    }

    public Env getPrev() {
        return prev;
    }

    public static void newEnv() 
    {
        tmp = instance;
        instance = new Env(instance);
    }
    
    public static void restoreEnv()
    {
        instance = tmp;
    }
    
    public void put(String id, Type t)
    {
        this.table.addVariable(id, t);
    }
    
    public Expression get(String name)
    {
        Expression found = null;
        for(Env e=this; e!=null; e=e.prev)
        {
            found = e.table.getValue(name);
            
            if(found != null)
            {
                return found;
            }
        } 
        return found;
    }
    
    public Type getType(String name)
    {
        Type found = null;
        for(Env e=this; e!=null; e=e.prev)
        {
            found = e.table.getType(name);
            
            if(found != null)
            {
                return found;
            }
        } 
        return found;
    }
    
}
