/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LR;

/**
 *
 * @author SergioJavier
 */
public class Action {
    
    public enum Type { Shift, Reduce, Error } 
    private State st;

    public Action(State st, Type t) {
        this.st = st;
    }

    public State getSt() {
        return st;
    }

    public void setSt(State st) {
        this.st = st;
    }
}
