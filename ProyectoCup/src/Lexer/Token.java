/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexer;

/**
 *
 * @author aB
 */

public class Token {
    private String Lexema = "";
    private TokenType Tipo;
    private int row = 0;
    private int column = 0;
    
    public Token(String Lexema, TokenType Tipo, int row, int column){
        this.Lexema = Lexema;
        this.Tipo = Tipo;
        this.row = row;
        this.column = column;
    }

    /**
     * @return the Lexema
     */
    public String getLexema() {
        return Lexema;
    }

    /**
     * @param Lexema the Lexema to set
     */
    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    /**
     * @return the Tipo
     */
    public TokenType getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(TokenType Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }    
    
    public enum TokenType{
        Asterisk,
        Import,
        Parser,
        Code,
        JavaCodeStart,
        JavaCodeEnd,
        Colon,
        Semicolon,
        Terminal,
        Non,
        Or,
        Assign,
        Comma,
        Dot,
        Identifier,
        JavaCode,
        Less,
        Great,
        EOF
    };
    
}
