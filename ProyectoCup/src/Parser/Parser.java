/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Lexer.Lexer;
import Lexer.Token;

/**
 *
 * @author SergioJavier
 */
public class Parser {
    
    private Token cToken;
    private Lexer lex;

    public Parser(Lexer lex) throws Exception {
        this.lex = lex;
        
        S();
    }

    public Lexer getLex() {
        return lex;
    }   
    
    public void Error(String mjs) throws Exception{       
        throw new Exception("Error: " + mjs + ".\n");
    }
    
    public void Error(Token t) throws Exception{
        throw new Exception("Error: Simbolo inesperado '" + t.getLexema() + "'.\n");
    }
    
    private void S() throws Exception
    {
        cToken = lex.getNextToken();        
        Import();
        JavaCode();
        Terminal();
        NonTerminal();  
        definitions();
    }
    
    /* 
     import ::= IMPORT JAVACODE import 
     */
    private void Import() throws Exception{
        
        if(cToken.getTipo() == Token.TokenType.Import)
        {
            cToken = lex.getNextToken(); 
            
            while(cToken.getTipo() != Token.TokenType.Semicolon)
            {
                cToken = lex.getNextToken();
            }
        }else
        {
            Error("Se esperaba palabra reservada 'import'");
        }
    }
    
    private void JavaCode() throws Exception
    {
        cToken = lex.getNextToken();
        
        if(cToken.getTipo() == Token.TokenType.Parser)
        {
            cToken = lex.getNextToken();
            if(cToken.getTipo() ==  Token.TokenType.Code)
            {
                cToken = lex.getNextToken();  
                if(cToken.getTipo() ==  Token.TokenType.JavaCodeStart)
                {
                    cToken = lex.getNextToken();               
                    if(cToken.getTipo() ==  Token.TokenType.JavaCode)
                    {
                         cToken = lex.getNextToken();
                         if(cToken.getTipo() ==  Token.TokenType.JavaCodeEnd)
                         {
                            cToken = lex.getNextToken();
                         }else
                         {
                             Error("Se esperaba simbolo ':}'");
                         }
                    }else
                    {
                        Error(cToken);
                    }                   
                }else{
                    Error(cToken);
                }
            }else{
                Error(cToken);
            }
        }else
        {
            Error(cToken);
        }
    }
    
    /*
     terminal ::= TERMINAL [ID<ID>?] id_list SEMICOLON terminal
          | 3
     */
    
    private void Terminal() throws Exception
    {   
        cToken = lex.getNextToken();  
        while(cToken.getTipo() == Token.TokenType.Terminal)
        {
            cToken = lex.getNextToken();
            
            if(cToken.getTipo() == Token.TokenType.Identifier)
            {
                cToken = lex.getNextToken();
                if(cToken.getTipo() == Token.TokenType.Less)
                {
                    cToken = lex.getNextToken();
                    
                    if(cToken.getTipo() == Token.TokenType.Identifier)
                    {
                        cToken = lex.getNextToken();
                    }
                }
            }
            IdList();
            
            if(cToken.getTipo() == Token.TokenType.Semicolon)
            {
                cToken = lex.getNextToken();
            }else{
                Error(cToken);
            }    
        }
    }
    
    /* 
     id_list  ::= ID COMA id_list
           | 3
     */
    private void IdList() throws Exception {

        if (cToken.getTipo() == Token.TokenType.Identifier) {
            cToken = lex.getNextToken();
        }

        while (cToken.getTipo() == Token.TokenType.Comma) {
            cToken = lex.getNextToken();
            if (cToken.getTipo() == Token.TokenType.Identifier) {
                cToken = lex.getNextToken();
            } else {
                Error(cToken);
            }
        }
    }
    
    /*
     non_terminal ::= NON TERMINAL [ID<ID>?] id_list SEMICOLON non_terminal
              | 3
     */
    private void NonTerminal() throws Exception
    {    
        //cToken = lex.getNextToken();  
        while(cToken.getTipo() == Token.TokenType.Non)
        {
            cToken = lex.getNextToken();
            
            if(cToken.getTipo() == Token.TokenType.Terminal)
            {
                cToken = lex.getNextToken();
                
                if (cToken.getTipo() == Token.TokenType.Identifier) {
                    cToken = lex.getNextToken();
                    if (cToken.getTipo() == Token.TokenType.Less) {
                        cToken = lex.getNextToken();

                        if (cToken.getTipo() == Token.TokenType.Identifier) {
                            cToken = lex.getNextToken();
                        }
                    }
                }
                IdList();
                
                if(cToken.getTipo() == Token.TokenType.Semicolon)
                {
                   cToken = lex.getNextToken();
                }else
                {
                    Error(cToken);
                }
            }else
            {
                 Error(cToken);
            }
        }
    }
    
    /* definitions ::= definition definitions 
                    | 3    
       definition ::= ID ASSIGN productions SEMICOLON      
     */
    private void definitions() throws Exception
    {
        cToken = lex.getNextToken();  
        while(cToken.getTipo() == Token.TokenType.Identifier)
        {
            cToken = lex.getNextToken(); 
            if(cToken.getTipo() == Token.TokenType.Assign)
            {
                cToken = lex.getNextToken(); 
                productions();
                
                if(cToken.getTipo() == Token.TokenType.Semicolon)
                {
                    cToken = lex.getNextToken(); 
                }else
                {
                    Error(cToken);
                }
            }else
            {
                Error(cToken);
            }
        }
    }    
    
    /* productions ::= production OR productions */
    private void productions() throws Exception
    {
        production(); 
        if(cToken.getTipo() == Token.TokenType.Or)
        {
            cToken = lex.getNextToken();
            productions(); 
        }
    }
    
    /* production ::= ID[:ID | {: JAVACODE :}]? production */
    private void production() throws Exception
    {
        cToken = lex.getNextToken();
        while (cToken.getTipo() == Token.TokenType.Identifier) {
            cToken = lex.getNextToken();
                  
            if (cToken.getTipo() == Token.TokenType.Colon) {
                cToken = lex.getNextToken();
                
                if (cToken.getTipo() == Token.TokenType.Identifier) {
                    cToken = lex.getNextToken();
                }else
                {
                    Error(cToken);
                }
            }else if(cToken.getTipo() == Token.TokenType.JavaCodeStart)
            {
                cToken = lex.getNextToken();               
                if (cToken.getTipo() == Token.TokenType.JavaCode) {
                    cToken = lex.getNextToken();    
                }
                
                if(cToken.getTipo() == Token.TokenType.JavaCodeEnd){
                    cToken = lex.getNextToken();    
                }else
                {
                    Error(cToken);
                }
            }
        }
    }
}
