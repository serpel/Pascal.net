/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LR;

import Tree.Definitions;
import Tree.Productions;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author SergioJavier
 */
public class States {
    
    private int num;
    private ArrayList<Definitions> defs;
    private HashMap<Integer, String> refs;

    public States(int num, ArrayList<Definitions> defs) {
        this.num = num;
        this.defs = defs;
        refs = new HashMap<Integer, String>();
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Definitions> getDefs() {
        return defs;
    }

    public HashMap<Integer, String> getRefs() {
        return refs;
    }  
    
    public String getStateID()
    {
        return "S"+num;
    }
    
    public String printState()
    {
        
        String msj = "("+getStateID()+" -> "+refs.get(0)+")\n";
        
        for (Definitions definitions : defs) {
            
            msj += definitions.toStr();  
        }
        
        return msj;
    }
}
