/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

/**
 *
 * @author SergioJavier
 */
public class IfStms extends Statement{
    Statement ifst,elsest;

    public IfStms(Statement ifst, Statement elsest, Statement next) {
        super(next);
        this.ifst = ifst;
        this.elsest = elsest;
    }

    public Statement getIfst() {
        return ifst;
    }

    public Statement getElsest() {
        return elsest;
    }

    public void setIfst(Statement ifst) {
        this.ifst = ifst;
    }

    public void setElsest(Statement elsest) {
        this.elsest = elsest;
    }
    
}
