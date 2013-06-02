/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.*;

/**
 *
 * @author SergioJavier
 */
public class ConstDecl extends Declarations{
    
    Id name;
    Expression expr;

    public ConstDecl(Id name, Expression expr) {
        this.name = name;
        this.expr = expr;
    } 
}
