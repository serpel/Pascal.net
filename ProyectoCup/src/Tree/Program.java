/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;

/**
 *
 * @author aB
 */
public class Program {
    private ArrayList<Import> importStatements;
    private ParserCode globalParserCode;
    private ArrayList<Terminals> terminals = new ArrayList<Terminals>();
    private ArrayList<Terminals> nonTerminals = new ArrayList<Terminals>();
    private ArrayList<Definitions> definitions;

    /**
     * @return the importStatements
     */
    public ArrayList<Import> getImportStatements() {
        return importStatements;
    }

    /**
     * @param importStatements the importStatements to set
     */
    public void setImportStatements(ArrayList<Import> importStatements) {
        this.importStatements = importStatements;
    }

    /**
     * @return the globalParserCode
     */
    public ParserCode getGlobalParserCode() {
        return globalParserCode;
    }

    /**
     * @param globalParserCode the globalParserCode to set
     */
    public void setGlobalParserCode(ParserCode globalParserCode) {
        this.globalParserCode = globalParserCode;
    }
    
    /**
     * @return the definitions
     */
    public ArrayList<Definitions> getDefinitions() {
        return definitions;
    }

    /**
     * @param definitions the definitions to set
     */
    public void setDefinitions(ArrayList<Definitions> definitions) {
        this.definitions = definitions;
    }
    
    public void AddTerminal(Terminals terminal){
        terminals.add(terminal);
    }
    
    public void AddNonTerminal(Terminals nonTerminal){
        nonTerminals.add(nonTerminal);
    }

    /**
     * @return the terminals
     */
    public ArrayList<Terminals> getTerminals() {
        return terminals;
    }

    /**
     * @return the nonTerminals
     */
    public ArrayList<Terminals> getNonTerminals() {
        return nonTerminals;
    }
    
    
}
