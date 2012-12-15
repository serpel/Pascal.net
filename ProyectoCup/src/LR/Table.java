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
public class Table {
    
    /* Tabla de acciones */
    private String LR_headers_terminales[]; 
    private String LR_headers_states[];
    private Action LR_table[][];
    
    private int Size_Column;
    private int Size_Row;
    
    /*Instancia de objetos LR*/
    private LR lr;

    /*Inicilice the Actions table and add your symbols and states*/
    public Table(LR lr_items) {
        
        this.lr = lr_items;
        ArrayList<String> symbols = lr.getSymbols();
        ArrayList<State> states = lr.getSts();
        
        /* Size of table actions */
        Size_Column = symbols.size();
        Size_Row = states.size();
                
        LR_table = new Action[Size_Row][Size_Column];
        LR_headers_terminales = new String[Size_Column];
        LR_headers_states = new String[Size_Row];
        
        
        //terminal + no terminals
        for (int i = 0; i < Size_Column; i++) {
           LR_headers_terminales[i] = symbols.get(i);
        }
        
        //inicialice Actions table 
        for (int i = 0; i < Size_Row; i++) {
            
            //States 
            LR_headers_states[i] = String.valueOf(states.get(i).getNum());
            
            for (int j = 0; j < Size_Column; j++) {
                LR_table[i][j] = new Action(new State(-1, new ArrayList<Definitions>()), Action.Type.Error);
            }
        }
        
        
        /*this part create the transitions table*/
        int index = 0;
        for (State state : states) {
            
            ArrayList<Transition> trs = state.getTransitions();
            
            for (int i = 0; i < Size_Column; i++) {
                String term = LR_headers_terminales[i];

                for (Transition transition : trs) {

                    if (transition.getSymbol().equals(term)) {
                        //int to_st = transition.getTo_st().getNum();                       
                        LR_table[index][i] = new Action(transition.getTo_st(), Action.Type.Shift);    
                    }
                }
            }        
            index++;
        }
    }

    public Action[][] getLR_table() {
        return LR_table;
    }
    

    public Table(Action[][] LR_table, LR lr) {
        this.LR_table = LR_table;
        this.lr = lr;
    }
   
  
    // Print transicion Table (GOTO)
    public void printTransicionTable()
    {
        String msj = "\t\t\tGOTO\t\t\n"; 
        
        //terminal + no terminals
        msj += "|_____|";
        
        for (int i = 0; i < Size_Column; i++) {
            msj += setSpace(LR_headers_terminales[i]);
            if (Size_Column > i) {
                msj += "|";
            }
        }
        
        msj+="\n";
        for (int i = 0; i < Size_Row; i++) {      
            msj += "|" + setSpace(LR_headers_states[i]) + "|";
            
            for (int j = 0; j < Size_Column; j++) {
                
                State st = LR_table[i][j].getSt(); 

                if (st.getNum() >= 0) {
                    msj += setSpace(String.valueOf(st.getNum()));
                } else {
                    msj += setSpace("_____");
                }

                if (Size_Column > j) {
                    msj += "|";
                }

            }
            msj += "\n";
        }
        System.out.println(msj);
    }
    
    private String setSpace(String s)
    {
        if(s.length() > 5)
        {
            s = s.subSequence(0, 5).toString();
            
        }else if (s.length() == 4)
        {
            s = "_"+s;
        }
        else if(s.length() == 3)
        {
            s = "_"+s+"_";
        }else if(s.length() ==  1)
        {
            s = "__"+s+"__";
        }
        
        return s;
    }
}
