package ChessGame.Figure.ChessPieces.Bishop;

import Inter.IntBishop.IntBishop;
import ChessGame.ChessBoard.ChessBoard;
import Inter.IntChessBoard.IntChessBoard;
import Inter.IntFigure.IntFigure;


/*
Author: Brandon Soto
Editor: Bungein Cheng
This class inheritance from Bishop class, getting the attributes and including methods to
verify the movement of the piece and set the movements of that piece can do, it implements intbishop
3/4 at 1 pm
*/


/**
 * Represents a Bishop piece in a chess game.
 */
public class Bishop implements IntFigure, IntBishop {

    private String name; // The name of the bishop
    private String color; // The color of the bishop
    private char LocationX; // The horizontal location of the bishop on the chessboard
    private int LocationY; // The vertical location of the bishop on the chessboard
    IntChessBoard chessboard = new ChessBoard(); // The chessboard on which the bishop moves

    /**
     * Constructor to create a new Bishop with the specified attributes.
     *
     * @param name The name of the bishop.
     * @param color The color of the bishop.
     * @param LocationX The horizontal location of the bishop.
     * @param LocationY The vertical location of the bishop.
     */
    public Bishop(String name, String color, char LocationX, int LocationY) {
        this.name = name;
        this.color = color;
        this.LocationX = LocationX;
        this.LocationY = LocationY;
    }

    /**
     * Default constructor.
     */
    public Bishop() {
        this.name = "name";
        this.color = "color";
        this.LocationX = '\u0000';
        this.LocationY = 0;
    }

    /**
     * Checks if the new location has the same position as the current location.
     *
     * @param N_LocationX The new horizontal location.
     * @param N_LocationY The new vertical location.
     * @return true if the new location is different from the current location, false otherwise.
     */
    public boolean samePosition(char N_LocationX, int N_LocationY) {
        return !(N_LocationX == LocationX && N_LocationY == LocationY);
    }

    /**
     * Checks if the new movement is valid with the specified new location.
     *
     * @param N_LocationX The new horizontal location.
     * @param N_LocationY The new vertical location.
     * @return true if the movement is valid, false otherwise.
     */
    @Override
    public boolean isValid(char N_LocationX, int N_LocationY) {
        return !(!chessboard.verifyCoordinate(LocationX, LocationY) && moveToBishop(LocationX, N_LocationX, LocationY, N_LocationY) && samePosition(N_LocationX, N_LocationY));
    }

    /**
     * Moves the piece to the specified new location.
     *
     * @param N_LocationX The new horizontal location.
     * @param N_LocationY The new vertical location.
     * @return true if the piece is successfully moved, false otherwise.
     */
    @Override
    public boolean moveTo(char N_LocationX, int N_LocationY) {
        // Implementation of moveTo method
        return false;
    }
}
