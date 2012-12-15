/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocup;

import LR.Action;
import LR.LR;
import LR.State;
import LR.Table;
import Lexer.Lexer;
import Parser.Parser;
import Tree.Program;
import ParserGenerator.ParserGenerator;
import java.util.ArrayList;
/**
 *
 * @author serpel
 */
public class ProyectoCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        try {
            Lexer lex = new Lexer("src/text2.txt");
            Parser p = new Parser(lex);
            Program program = p.Parse();
            
            //program.ValidateSemantics();
            //ParserGenerator generator = new ParserGenerator(program);
            //generator.Generate();
            
            LR lr = new LR(program);   
            lr.toStr();
            
            // iniciliza la tabla con estados nullos y el tipo en error
            Table t = new Table(lr);        
            t.getLR_table();           
            t.printTransicionTable();
            
            
            
            int i = 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        /*
         Token t;
        do
        {
            t = lex.getNextToken();
            String output = String.format("(%d,%d)Lexema = [%s] ; Tipo = [%s]", t.getRow(), t.getColumn(), t.getLexema(), t.getTipo());
            System.out.println(output);
        } while(Token.TokenType.EOF != t.getTipo());
        */     
    }
}
