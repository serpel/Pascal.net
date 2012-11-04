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
    private int countError;

    public Parser(Lexer lex) throws Exception {
        this.lex = lex;

        countError = 0;
        cToken = lex.getNextToken();
        S();

        if (cToken.getTipo() == Token.TokenType.EOF) {
            cToken = lex.getNextToken();
            if (countError == 0) {
                System.out.print("BUILD SUCCESSFUL\n");
            }
        } else {
            Error();
        }
    }

    public Lexer getLex() {
        return lex;
    }

    private void Error() throws Exception {
        countError++;
        throw new Exception("Parser.java:" + cToken.getRow() + ":" + cToken.getColumn() + " Error: Simbolo inesperado '" + cToken.getLexema() + "'.\n");
    }

    private void Error(String mjs) throws Exception {
        countError++;
        throw new Exception("Parser.java:" + cToken.getRow() + ":" + cToken.getColumn() + " Error: " + mjs + ".\n");
    }

    /*
     * S ::= import java_code terminal non_terminal definitions
     */
    private void S() throws Exception {
        Import();
        JavaCode();
        Terminal();
        NonTerminal();
        definitions();
    }

    /* 
     * import ::= ( IMPORT JAVACODE SEMICOLON )*
     */
    private void Import() throws Exception {

        while (cToken.getTipo() == Token.TokenType.Import) {
            cToken = lex.getNextToken();

            //JAVACODE SECTION
            while (cToken.getTipo() != Token.TokenType.Semicolon) {
                cToken = lex.getNextToken();
            }

            if (cToken.getTipo() == Token.TokenType.Semicolon) {
                cToken = lex.getNextToken();
            } else {
                Error();
            }
        }
    }
    /*
     * parser_code = PARSER CODE JAVACODESTART JAVACODE JAVACODEEND SEMICOLON
     */

    private void JavaCode() throws Exception {
        if (cToken.getTipo() == Token.TokenType.Parser) {
            cToken = lex.getNextToken();
            
            if (cToken.getTipo() == Token.TokenType.Code) {
                cToken = lex.getNextToken();
                
                if (cToken.getTipo() == Token.TokenType.JavaCodeStart) {
                    cToken = lex.getNextToken();
                    
                    if (cToken.getTipo() == Token.TokenType.JavaCode) {
                        cToken = lex.getNextToken();
                        
                        if (cToken.getTipo() == Token.TokenType.JavaCodeEnd) {
                            cToken = lex.getNextToken();
                            
                            if (cToken.getTipo() == Token.TokenType.Semicolon) {
                                cToken = lex.getNextToken();

                            } else {
                                Error("Se esperaba simbolo ';'");
                            }
                        } else {
                            Error("Se esperaba simbolo ':}'");
                        }
                    } else {
                        Error();
                    }
                } else {
                    Error("Se esperaba simbolo '{:'");
                }
            } else {
                Error("Se esperaba palabra reservada 'Code'");
            }
        } else {
            Error("Se esperaba token 'Parser'");
        }
    }

    /*
     * terminal ::= ( TERMINAL ID ['<ID>']? id_list SEMICOLON )*
     */
    private void Terminal() throws Exception {

        while (cToken.getTipo() == Token.TokenType.Terminal) {
            cToken = lex.getNextToken();

            if (cToken.getTipo() == Token.TokenType.Identifier) {
                cToken = lex.getNextToken();
                
                if (cToken.getTipo() == Token.TokenType.Less) {
                    cToken = lex.getNextToken();

                    if (cToken.getTipo() == Token.TokenType.Identifier) {
                        cToken = lex.getNextToken();

                        if (cToken.getTipo() == Token.TokenType.Great) {
                            cToken = lex.getNextToken();
                        } else {
                            Error("Se esperaba token '>'");
                        }
                    } else {
                        Error("Se esperaba ID");
                    }
                }

                IdList();

                if (cToken.getTipo() == Token.TokenType.Semicolon) {
                    cToken = lex.getNextToken();
                } else {
                    Error("Se esperaba simbolo ';'");
                }
            }
        }
    }

    /* 
     * id_list  ::= ID ( COMA ID )*
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
                Error("Se esperaba ID");
            }
        }
    }

    /*
     *  non_terminal ::= ( NON TERMINAL [ID<ID>?] id_list SEMICOLON )*
     */
    private void NonTerminal() throws Exception {
        while (cToken.getTipo() == Token.TokenType.Non) {
            cToken = lex.getNextToken();

            if (cToken.getTipo() == Token.TokenType.Terminal) {
                cToken = lex.getNextToken();

                if (cToken.getTipo() == Token.TokenType.Identifier) {
                    cToken = lex.getNextToken();

                    if (cToken.getTipo() == Token.TokenType.Less) {
                        cToken = lex.getNextToken();

                        if (cToken.getTipo() == Token.TokenType.Identifier) {
                            cToken = lex.getNextToken();

                            if (cToken.getTipo() == Token.TokenType.Great) {
                                cToken = lex.getNextToken();
                            } else {
                                Error();
                            }
                        }
                    }
                }

                IdList();

                if (cToken.getTipo() == Token.TokenType.Semicolon) {
                    cToken = lex.getNextToken();
                } else {
                    Error("Se esperaba simbolo ';'");
                }
            } else {
                Error();
            }
        }
    }

    /* 
     * definitions ::= ( definition )*
     * definition ::= ID ASSIGN productions SEMICOLON
     */
    private void definitions() throws Exception {

        while (cToken.getTipo() == Token.TokenType.Identifier) {
            cToken = lex.getNextToken();

            if (cToken.getTipo() == Token.TokenType.Assign) {
                cToken = lex.getNextToken();
                productions();

                if (cToken.getTipo() == Token.TokenType.Semicolon) {
                    cToken = lex.getNextToken();
                } else {
                    Error("Se esperaba simbolo ';'");
                }
            } else {
                Error();
            }
        }
    }

    /*
     * productions ::= production ( [OR production]? )* 
     * production ::= ( ID [:ID]? [{: JAVACODE :}]? )*
     */
    private void productions() throws Exception {
        production();
        if (cToken.getTipo() == Token.TokenType.Or) {
            cToken = lex.getNextToken();
            productions();
        }
    }

    private void production() throws Exception {
        while (cToken.getTipo() == Token.TokenType.Identifier) {
            cToken = lex.getNextToken();

            if (cToken.getTipo() == Token.TokenType.Colon) {
                cToken = lex.getNextToken();

                if (cToken.getTipo() == Token.TokenType.Identifier) {
                    cToken = lex.getNextToken();
                } else {
                    Error("Se esperaba ID");
                }
            }
            if (cToken.getTipo() == Token.TokenType.JavaCodeStart) {
                cToken = lex.getNextToken();
                if (cToken.getTipo() == Token.TokenType.JavaCode) {
                    cToken = lex.getNextToken();
                }

                if (cToken.getTipo() == Token.TokenType.JavaCodeEnd) {
                    cToken = lex.getNextToken();
                } else {
                    Error("Se esperaba simbolo ':}'");
                }
            }
        }
    }
}
