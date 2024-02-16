/*
Author: Exceiver Saenz
Editor: Brandon Soto
Description: The ChessPieces class is a superclass that represents a chess piece.
This class contains all the attributes of all chess pieces, such as the name, color, column and row where the piece is located on the chessboard.
The ChessPieces class also provides several constructors to create a chess piece with different combinations of attributes, allowing great flexibility when creating instances of chess pieces.
In addition, the ChessPieces class provides methods to obtain and set the values of these attributes.
It also includes methods to check if a move or a position is valid, and if a piece is in the same position.
Finally, the ChessPieces class has a printDescription() method that prints a description of the chess piece, including its name, color, column and row.

Feb. 10 at 8:00 am
 */
public class ChessPieces {
    private String name = ""; // Name of the piece
    private String color = ""; // Color of the piece
    private char column = '\u0000'; // Column where the piece is located   
    private int row = 0; // Row where the piece is located
    Chessboard chessboard = new Chessboard(); // Chessboard

    public ChessPieces(){ // Default constructor
        name = ""; 
        color = ""; 
        column = '\u0000'; 
        row = 0;
    }
    
    public ChessPieces(String name){ // Constructor with the name of the piece
        this.name = name;
        color = ""; 
        column = '\u0000'; 
        row = 0;
    }
    
    public ChessPieces(String name, String color) { // Constructor with the name and color of the piece
        this.name = name;
        this.color = color; 
        column = '\u0000'; 
        row = 0;
    }

    public ChessPieces(String name, String color, char column) { // Constructor with the name, color, and column of the piece
        this.name = name;
        this.color = color; 
        this.column = column;
        row = 0;
    }

    public ChessPieces(String name, String color, char column, int row) { // Constructor with the name, color, column, and row of the piece
        this.name = name;
        this.color = color; 
        this.column = column;
        this.row = row;
    }

    public String getName() { // Method to get the name of the piece
        return this.name;
    }

    public String getColor() { // Method to get the color of the piece
        return this.color; 
    }

    public char getColumn() { // Method to get the column of the piece
        return this.column; 
    }

    public int getRow() { // Method to get the row of the piece
        return this.row; 
    }

    public void setColumn(char column) { // Method to set the column of the piece
        this.column = column; 
    }

    public void setRow(int row) { // Method to set the row of the piece
        this.row = row; 
    }

    public boolean verifyMove(char column, int row){ // Method to verify if the move is valid
        return false;
    }

    public void isValid(char column, int row){ // Method to verify if the position is valid
        
    }

    public boolean samePosition(char column, int row){ // Method to verify if the piece is in the same position
        if(getColumn()==column && getRow()==row){
            return false;
        }
        return true;
    }

    public void printDescription() { // Method to print the description of the piece
        System.out.println("Name: " + this.name + "\nColor: " + this.color + "\nColumn: " + this.column + "\nRow: " + this.row);
    }
}
