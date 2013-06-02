/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantic;

import Tree.Expressions.Expression;
import Tree.Types.Null;
import Tree.Types.Type;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author SergioJavier
 */
public class SymbolTable {
    
    Hashtable<String,Integer> table = new Hashtable<>();
    Hashtable<String,Type> typeTable = new Hashtable<>();
    Hashtable<String,Expression> valueTable = new Hashtable<>();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> typelist = new ArrayList<String>();

    public SymbolTable() {
    }

    public void addVariable(String name, Type t)
    {
        if(!table.containsKey(name))
        {
            table.put(name, new Integer(table.size()));
            typeTable.put(name, t);
            list.add(name);
            typelist.add(t.toAssably());
        }
    }
    
    public Expression getValue(String name)
    {
        if(valueTable.containsKey(name))
        {
            return valueTable.get(name);
        }
        return null;
    }
    
    public int geNumber(String name)
    {
        if(table.containsKey(name))
        {
            return table.get(name).intValue();
        }
        return -1;
    }
    
    public Type getType(String name)
    {
        Type t;
        if(typeTable.contains(name))
        {
            t = typeTable.get(name);
        }else
        {
            t = new Null();
        }
        
        return t;
    }
    
     public String getLocals()
     {
         StringBuilder local = new StringBuilder();
         int offset = 0; 
         String tmp = "                          ";
         
         local.append(".locals init (");
         offset = local.length();
         
         for(int i=0;i<list.size();i++)
         {
             local.append("["); local.append(i); local.append("] ");
             local.append(typelist.get(i));local.append(" "); local.append(list.get(i));
             if(i<list.size()-1)
             {
                 local.append(",\n");
                 local.append(tmp,0, offset);
             }
         }
         local.append(")\n");
         return local.toString();
     }

}
