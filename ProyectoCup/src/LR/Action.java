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
    private Type actionType;
    private State st;

    public Action(State st, Type t) {
        this.st = st;
        this.actionType = t;
    }
    
    public void setType(Type t)
    {
        this.actionType = t;
    }

    public Type getActionType() {
        return actionType;
    } 

    public State getSt() {
        return st;
    }

    public void setSt(State st) {
        this.st = st;
    }
}
