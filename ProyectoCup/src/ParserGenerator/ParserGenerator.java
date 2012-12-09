/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ParserGenerator;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author aB
 */
import Tree.*;


public class ParserGenerator {
    private Program program;
    private FileWriter fstream;
    private BufferedWriter out;
    
    private int numTabs = 0;
    
    public ParserGenerator(Program program) throws Exception{
        this.program = program;
    }
    
    public void Generate() throws Exception{
        CreateSymDotJava();
        CreateParserDotJava();
    }
    
    private void NewLine() throws Exception{
        out.write("\n");
        for(int i = 0; i < numTabs ; i++){
            out.write("\t");
        }
    }
    
    private void AddTab(){
        numTabs++;
    }
    
    private void RemTab(){
        numTabs--;
    }
    
    private void CreateSymDotJava() throws Exception{
        fstream = new FileWriter("src/sym.java");
        out = new BufferedWriter(fstream);     
        NewLine();        
        
        out.write("/* Clase de Simbolos */");
        NewLine();
        out.write("public class sym{");
        
        WriteTerminals();
        
        
        RemTab();
        NewLine();
        out.write("}");
        
        out.close();   
    }
    
    private void WriteTerminals() throws Exception{
        int count = 2;
        
        AddTab();
        NewLine();
        out.write("//Terminales");
        NewLine();
        
        out.write("public static final int EOF = 0;");
        NewLine();
        out.write("public static final int error = 1;");
        
        ArrayList<Terminals> terminalsList = program.getTerminals();
        
        for(int i = 0; i < terminalsList.size(); i++){
            Terminals terminal = terminalsList.get(i);
            ArrayList<String> idList = terminal.getId();
            for(int x = 0; x < idList.size(); x++){
                NewLine();
                String format = "public static final int %s = %d;";
                out.write( String.format(format, idList.get(x), count++ ) );
            }
        }
    }
    
    private void CreateParserDotJava() throws Exception{
        fstream = new FileWriter("src/parser.java");
        out = new BufferedWriter(fstream);
        NewLine();
        out.write("/** Parser Class **/");
        NewLine();
        NewLine();
        
        out.write("public class parser{");
        AddTab();
        NewLine();
        out.write("/** Code **/");
        
        RemTab();
        NewLine();
        out.write("}");
        
        out.close();  
    }
}
