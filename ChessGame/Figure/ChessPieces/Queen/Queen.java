package ChessGame.Figure.ChessPieces.Queen;

import ChessGame.ChessBoard.ChessBoard;
import ChessGame.Figure.ChessPieces.Rook.Rook;
import Inter.IntChessBoard.*;
import Inter.IntBishop.IntBishop;

/*
Author: Brandon Soto
Editor: Bungein Cheng
This class inheritance from rook class, getting the attributes and including methods to
verify the movement of the piece and set the movements of that piece can do also implements intbishop to recieve bishop movement
3/4 at 8:27 pm
*/

/**
 * Represents a Queen piece in a chess game, inheriting behavior from Rook and implementing behavior from IntBishop.
 */
public class Queen extends Rook implements IntBishop{
    IntChessBoard chessboard = new ChessBoard();
    /**
     * Constructor to create a new Queen with the specified attributes and chessboard.
     *
     * @param name The name of the queen.
     * @param color The color of the queen.
     * @param LocationX The horizontal location of the queen.
     * @param LocationY The vertical location of the queen.
     * @param chessboard The chessboard on which the queen moves.
     */
    public Queen(String name, String color, char LocationX, int LocationY, IntChessBoard chessboard){// constructor
        super(name, color, LocationX, LocationY, chessboard);
        this.chessboard = chessboard;
    }

    /**
     * Constructor to create a new Queen with the specified attributes.
     *
     * @param name The name of the queen.
     * @param color The color of the queen.
     * @param LocationX The horizontal location of the queen.
     * @param LocationY The vertical location of the queen.
     */
    public Queen(String name, String color, char LocationX, int LocationY){// constructor
        super(name, color, LocationX, LocationY);

    }

    /**
     * Checks if moving the queen to the specified new location is a valid move.
     *
             * @param n_column The new horizontal location of the queen.
     * @param n_row The new vertical location of the queen.
     * @return true if the move is valid, false otherwise.
     */
    public boolean moveTo(char n_column, int n_row) {// verify the movement
        if(! chessboard.verifyCoordinate(n_column, n_row)){
            return false;
        }
        return super.moveTo(n_column, n_row) || moveToBishop(getLocationX(), n_column, getLocationY(), n_row);// call super verify movement and rook behavior for the queen

    }

    /**
     * Checks if the specified move for the queen is valid.
     *
     * @param column The horizontal location of the queen's destination.
     * @param row The vertical location of the queen's destination.
     * @return true if the move is valid, false otherwise.
     */
    @Override
    public boolean isValid(char column, int row){// // prints if the movement is valid.
        if(chessboard.verifyCoordinate(column, row)&&super.samePosition(column, row)&& moveTo(column,row)){
            return true;
        }
        return false;
    }


}
