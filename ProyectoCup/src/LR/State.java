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
    private String id;
    private String to_reduce;
    private ArrayList<Definitions> defs;
    private ArrayList<Transition> transitions;

    public State(int num, ArrayList<Definitions> defs) {
        this.num = num;
        this.defs = defs;
        this.transitions = new ArrayList<Transition>();
        this.id = "S";
    }

    public State(int num, String to_reduce, ArrayList<Definitions> defs) {
        this.num = num;
        this.to_reduce = to_reduce;
        this.defs = defs;
        this.transitions = new ArrayList<Transition>();
        this.id = "S";
    }
    
    public String getTo_reduce() {
        return to_reduce;
    }

    public void setTo_reduce(String to_reduce) {
        this.to_reduce = to_reduce;
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
        return id+num;
    }
    
    public void addTransicion(String symbol, State to_st)
    {  
        this.transitions.add( new Transition(symbol,to_st) );        
    }
    
    public String printState()
    {        
        String msj = "("+getStateID()+" -> "+ this.to_reduce +")\n";
        
        for (Definitions definitions : defs) {
            
            msj += definitions.toStr();  
        }
        
        return msj;
    }
}
