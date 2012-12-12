/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LR;

import Tree.Definitions;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class State {
    
    private int num;
    private ArrayList<Definitions> defs;
    private ArrayList<Transition> transitions;

    public State(int num, ArrayList<Definitions> defs) {
        this.num = num;
        this.defs = defs;
        this.transitions = new ArrayList<Transition>();
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public ArrayList<Definitions> getDefs() {
        return defs;
    }    
 
    public String getStateID()
    {
        return "S"+num;
    }
    
    public void addTransicion(String symbol, State to_st)
    {  
        this.transitions.add( new Transition(symbol,to_st) );        
    }
    
    public String printState()
    {        
        String msj = "("+getStateID()+" -> \n";//+refs.get(0)+")\n";
        
        for (Definitions definitions : defs) {
            
            msj += definitions.toStr();  
        }
        
        return msj;
    }
}
