/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class Id extends Expression {
    String Identifier;

    public Id(String Identifier) {
        this.Identifier = Identifier;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    @Override
    public void semanticValidation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
