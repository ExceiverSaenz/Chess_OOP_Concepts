package ChessGame.Figure.ChessPieces.Knight;

import ChessGame.ChessBoard.ChessBoard;
import ChessGame.Figure.Figure;
import Inter.IntChessBoard.IntChessBoard;

/*
Author: Exceiver
Editors: Cheng Bungein & Brandon Soto
This method mimis the behavior of the knigth and uses methods from the super class figures
3/6 11 at 5:00 pm
*/

/**
 * Represents a knight chess piece with a name, color, and position on the board.
 */
public class Knight extends Figure{

    /**
     * Default constructor for the Knight class.
     *
     * @param name      The name of the knight.
     * @param color     The color of the knight.
     * @param LocationX The X-coordinate location of the knight.
     * @param LocationY The Y-coordinate location of the knight.
     */
    public Knight(String name, String color, char LocationX, int LocationY){
        super(name, color, LocationX, LocationY);
    }

    IntChessBoard chessboard = new ChessBoard();

    /**
     * Moves the knight to a new position if it is a valid move.
     *
     * @param n_column The new column position.
     * @param n_row    The new row position.
     * @return boolean Returns true if the move is valid, otherwise false.
     */
    @Override
    public boolean moveTo(char n_column, int n_row) { // Public method that checks if a transaction is valid for the part.
        //AGREGAR EN EL MAIN
         if (!chessboard.verifyCoordinate(n_column, n_row)) { 
             return false; // Return false if the position is outside the chessboard
         }
        return (Math.abs(getLocationY() - n_row) == 1 && Math.abs(getLocationX() - n_column) == 2) ||
           (Math.abs(getLocationY() - n_row) == 2 && Math.abs(getLocationX() - n_column) == 1);
    }

    /**
     * Checks if the move to a new position is valid for the knight.
     *
     * @param column The column of the new position.
     * @param row    The row of the new position.
     * @return boolean Returns true if the move is valid, otherwise false.
     */
    @Override
    public boolean isValid(char column, int row){
        if(moveTo(column, row)&&super.samePosition(column, row)){
            return true;
        }
        return false;
    }

    /**
     * Provides a string representation of the knight, including its name, color, and position.
     *
     * @return String A string representation of the knight.
     */
    @Override
    public String toString() {
         return "Name: " + getName() + "\nColor: " + getColor() + "\nLocationX: " + getLocationX()+ "\nLocationY: " + getLocationY();
    }
}