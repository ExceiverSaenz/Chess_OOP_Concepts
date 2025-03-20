package ChessGame.Figure.ChessPieces.Rook;

import ChessGame.ChessBoard.ChessBoard;
import ChessGame.Figure.Figure;
import Inter.IntChessBoard.IntChessBoard;

/*
Author: Exceiver
Editors: Brandon Soto & Cheng Bungein
This method mimics the behavior of the rook 
3/6 at 3:00 pm
*/

/**
 * The Rook class represents a rook chess piece.
 */
public class Rook extends Figure {

    IntChessBoard chessboard = new ChessBoard();

    /**
     * Constructs a rook with the specified name, color, initial position, and chessboard.
     *
     * @param name      the name of the rook
     * @param color     the color of the rook
     * @param LocationX the initial column position of the rook
     * @param LocationY the initial row position of the rook
     * @param chessboard the chessboard on which the rook is placed
     */
    public Rook(String name, String color, char LocationX, int LocationY, IntChessBoard chessboard) {
        super(name, color, LocationX, LocationY);
        this.chessboard = chessboard;
    }

    /**
     * Constructs a rook with the specified name, color, and initial position.
     *
     * @param name      the name of the rook
     * @param color     the color of the rook
     * @param LocationX the initial column position of the rook
     * @param LocationY the initial row position of the rook
     */
    public Rook(String name, String color, char LocationX, int LocationY) {
        super(name, color, LocationX, LocationY);
    }

    /**
     * Checks if a move to the specified column and row is valid for the rook.
     *
     * @param column the column to move to
     * @param row    the row to move to
     * @return true if the move is valid for the rook, false otherwise
     */
    @Override
    public boolean isValid(char column, int row) {
        if (moveTo(column, row) && super.samePosition(column, row)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if moving the rook to the specified column and row is a valid move.
     *
     * @param n_column the column to move to
     * @param n_row    the row to move to
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean moveTo(char n_column, int n_row) {
        if (!chessboard.verifyCoordinate(n_column, n_row)) {
            return false;
        }
        return n_column == getLocationX() || n_row == getLocationY();
    }

    /**
     * Returns a string representation of the rook object.
     *
     * @return a string containing the name, color, and position of the rook
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\nColor: " + getColor() + "\nLocationX: " + getLocationX() + "\nLocationY: " + getLocationY();
    }
}


