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
    public SymbolTable table;   
    private Env prev;
    
    private Env(Env prev) {
        this.prev = prev;
        this.table = new SymbolTable();
    }

    public static void setInstance(Env instance) {
        Env.instance = instance;
    }
    
    public Type getFunction(String name)
    {
        Type found = null;
        for(Env e=this; e!=null; e=e.prev)
        {
            found = e.table.getfunction(name);
            
            if(found != null)
            {
                return found;
            }
        } 
        return found;
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
    
    public static Env newEnvirontment()
    {
        return new Env(instance);
    }
    
    public static void restoreEnv()
    {
        instance = tmp;
    }
    
    public void put(String id, Type t)
    {
        this.table.addVariable(id, t);
    }
    
    public void putFunction(String id, Type t)
    {
        this.table.addFunction(id, t);
    }
    
    public void putRecord(String id, Type t)
    {
        this.table.addRecord(id, t);
    }
    
    public void putArg(String id, Type t)
    {
        this.table.addArgument(id, t);
    }
    
    public int getNumber(String name)
    {
        int found = -1;
        for(Env e=this; e!=null; e=e.prev)
        {   
            found = e.table.getNumber(name);           
            if( found != -1)
            {
                return found;
            }
        } 
        return found;
    }
    
    public int getArgNumber(String name)
    {
        int found = -1;
        for(Env e=this; e!=null; e=e.prev)
        {   
            found = e.table.getArgNumber(name);           
            if( found != -1)
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

    public SymbolTable getTable() {
        return table;
    }
}
