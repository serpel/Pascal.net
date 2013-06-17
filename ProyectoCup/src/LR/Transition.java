/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LR;

/**
 *
 * @author SergioJavier
 */
public class Transition {
    
    private State to_st;
    private String symbol;

    public Transition(String symbol,State to_st) {
        this.to_st = to_st;
        this.symbol = symbol;
    }

    public State getTo_st() {
        return to_st;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setTo_st(State to_st) {
        this.to_st = to_st;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    } 
}
