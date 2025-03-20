package ChessGame.Figure.ChessPieces.Pawn;

import ChessGame.ChessBoard.ChessBoard;
import ChessGame.Figure.Figure;
import Inter.IntChessBoard.IntChessBoard;


/*
Author: Exceiver
Editors: Brandon Soto & Cheng Bungein
The Pawn class is a subclass of the ChessPieces(now called figures) superclass, representing a pawn piece in a game of chess.
It inherits all attributes and methods from ChessPieces, and also defines its own behavior.
The class includes several constructors for creating a pawn with different attributes.
The verifyMove method checks if a proposed move is valid for a pawn, considering the unique movement rules of a pawn in chess. 
The isValid method uses verifyMove to check if a move is valid and then prints a message indicating whether the pawn can move to the specified 
location. 
This class provides a specific implementation for a pawn, while still utilizing the general structure and functionality provided by the 
ChessPieces superclass.
3/6  at 9am
*/
/**
 * Represents a pawn figure in the chess game.
 */
public class Pawn extends Figure{

    /**
     * Constructs a pawn figure with the specified name, color, position.
     *
     * @param name      the name of the pawn figure
     * @param color     the color of the pawn figure
     * @param LocationX the horizontal position of the pawn figure
     * @param LocationY the vertical position of the pawn figure
     */
    public Pawn(String name, String color, char LocationX, int LocationY){
         super(name, color, LocationX, LocationY);
    }

    IntChessBoard chessboard = new ChessBoard();

    /**
     * Moves the pawn figure to the specified column and row if it's a valid move.
     *
     * @param n_column the new horizontal position of the pawn figure
     * @param n_row    the new vertical position of the pawn figure
     * @return {@code true} if the move is valid, {@code false} otherwise
     */
    @Override
    public boolean moveTo(char n_column, int n_row){
      // AGREGAR EN EL MAIN
         if(!chessboard.verifyCoordinate(n_column, n_row)){
             return false;
         }        
 
         int color=-1;
         if(getColor().trim().equalsIgnoreCase("white")){
              color=1;
         }
 
         return n_column == getLocationX() && n_row == getLocationY() + color;
     }

    /**
     * Checks if moving the pawn figure to the specified column and row is a valid move.
     *
     * @param column the new horizontal position to check
     * @param row    the new vertical position to check
     * @return {@code true} if the move is valid, {@code false} otherwise
     */
     @Override
     public boolean isValid(char column, int row){
          if(moveTo(column, row)&&super.samePosition(column, row)){
              return true;
          }
         return false;
     }

    /**
     * Returns a string representation of the pawn figure including its name, color, locationX, and locationY.
     *
     * @return a string representation of the pawn figure
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nColor: " + getColor() + "\nLocationX: " + getLocationX()+ "\nLocationY: " + getLocationY();
    }
}