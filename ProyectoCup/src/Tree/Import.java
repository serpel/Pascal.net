/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author aB
 */
public class Import {
    private String statement;

    public Import(String statement) {
        this.statement = statement;
    }

    /**
     * @return the statement
     */
    public String getSentencia() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setSentencia(String statement) {
        this.statement = statement;
    }
}
