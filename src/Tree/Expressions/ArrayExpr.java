/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class ArrayExpr extends Expression{
    
    Expression indexs;

    public ArrayExpr(Expression indexs) {
        this.indexs = indexs;
    }

    public Expression getIndexs() {
        return indexs;
    }

    public void setIndexs(Expression indexs) {
        this.indexs = indexs;
    }  

    @Override
    public void semanticValidation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}