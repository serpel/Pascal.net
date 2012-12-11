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
    
    private void MergeDefinitions(){
        for(int i = 0; i < definitions.size(); i++){
            String id = definitions.get(i).getId();
            for(int x = i+1; x < definitions.size(); x++){
                String id2 = definitions.get(x).getId();
                if(id.equals(id2)){
                    ArrayList<Productions> productions = definitions.get(x).getProductions();
                    definitions.get(i).getProductions().addAll(productions);
                    definitions.remove(x);
                    x--;
                }
            }
        }
    }
    
    public void ValidateSemantics() throws Exception{
        MergeDefinitions();
        
        //Terminal no puede producir
        int i;
        for(i = 0; i < definitions.size(); i ++){
            String definitionId = definitions.get(i).getId();
            for(int x = 0 ; x < terminals.size(); x++){
                Terminals t = terminals.get(x);
                ArrayList<String> listaIds = t.getId();
                for(int y = 0; y < listaIds.size(); y++){
                    if( definitionId.equals(listaIds.get(y)) ){
                        String format = "Error: Un terminal no puede producir! (TerminalID: %s)";
                        throw new Exception(String.format(format, definitionId));
                    }
                }
            }
        }
        //No se puede accesar un No terminal o terminal no declarado
        for(i = 0; i < definitions.size(); i ++){
            String definitionId = definitions.get(i).getId();
            String format = "Error: No se ha declarado \"%s\"!";
            if( !(TerminalExists(definitionId) || NonTerminalExists(definitionId)) ){
                throw new Exception(String.format(format, definitionId));
            }
            
            ArrayList<Productions> productions = definitions.get(i).getProductions();
            
            for(int x = 0; x < productions.size(); x++){
                ArrayList<Item> items = productions.get(x).items;
                for(int y = 0; y < items.size(); y++){
                    String item = items.get(y).id;
                    if( !( TerminalExists(item) || NonTerminalExists(item)  ) ){
                        throw new Exception(String.format(format, item));                        
                    }
                }
            }            
        }
        //Todo no terminal definido tiene que tener producciones definidas
        for(i = 0 ; i < nonTerminals.size(); i++){
            Terminals t = nonTerminals.get(i);
            ArrayList<String> listaIds = t.getId();
            for(int x = 0; x < listaIds.size(); x++){
                if(!DeclarationExists(listaIds.get(x))){
                    String format = "Error: No Terminal(%s) debe de tener al menos una producción!";
                    throw new Exception(String.format(format, listaIds.get(x)));
                }
            }
        } 
        //Todo Terminal y No Terminal debe de ser referenciado al menos una vez.
        for(i = 0 ; i < terminals.size(); i++){
            Terminals t = terminals.get(i);
            ArrayList<String> listaIds = t.getId();
            for(int x = 0; x < listaIds.size(); x++){
                if( !ProductionExists( listaIds.get(x) ) ){
                    String format = "Error: Terminal \"%s\" no fue referenciado en la gramatica!";
                    throw new Exception( String.format(format, listaIds.get(x)) );
                }
            }
        }
        
        for(i = 0 ; i < nonTerminals.size(); i++){
            Terminals t = nonTerminals.get(i);
            ArrayList<String> listaIds = t.getId();
            for(int x = 0; x < listaIds.size(); x++){
                if( !ProductionExists( listaIds.get(x) ) ){
                    String format = "Error: No-Terminal \"%s\" no fue referenciado en la gramatica!";
                    throw new Exception( String.format(format, listaIds.get(x)) );
                }
            }
        }
        //No se pueden definir 2 veces las producciones
        for(i = 0; i < definitions.size(); i ++){            
            ArrayList<Productions> productions = definitions.get(i).getProductions();
            
            for(int x = 0; x < productions.size(); x++){
                ArrayList<Item> items = productions.get(x).items;
                int y = 0;
                int z = y + 1;
                //for(int y = 0; y < items.size(); y++){
                //    String item = items.get(y).id;
                //    for(int z = y+1; z < items.size(); z++){
                        
                //    }
                //}
            }            
        }
    }
    
    private boolean TerminalExists(String terminalId){
        for(int i = 0 ; i < terminals.size(); i++){
            Terminals t = terminals.get(i);
            ArrayList<String> listaIds = t.getId();
            for(int x = 0; x < listaIds.size(); x++){
                if( terminalId.equals(listaIds.get(x)) ){
                    return true;
                }
            }
        }        
        return false;
    }
    
    private boolean NonTerminalExists(String nonTerminalId){
       for(int i = 0 ; i < nonTerminals.size(); i++){
            Terminals t = nonTerminals.get(i);
            ArrayList<String> listaIds = t.getId();
            for(int x = 0; x < listaIds.size(); x++){
                if( nonTerminalId.equals(listaIds.get(x)) ){
                    return true;
                }
            }
        }        
        return false;
    }
    
    private boolean DeclarationExists(String declaration){
        for(int i = 0; i < definitions.size(); i ++){
            String definitionId = definitions.get(i).getId();
            if( declaration.equals(definitionId) ){
                return true;
            }
        }
        return false;
    }
    
    private boolean ProductionExists(String terminal){
        for(int i = 0; i < definitions.size(); i ++){            
            ArrayList<Productions> productions = definitions.get(i).getProductions();
            
            for(int x = 0; x < productions.size(); x++){
                ArrayList<Item> items = productions.get(x).items;
                for(int y = 0; y < items.size(); y++){
                    String item = items.get(y).id;
                    if( terminal.equals(item) ){
                        return true;
                    }
                }
            }            
        }
        return false;
    }
}
