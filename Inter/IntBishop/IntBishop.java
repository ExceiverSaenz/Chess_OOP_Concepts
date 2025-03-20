package Inter.IntBishop;

import ChessGame.ChessBoard.ChessBoard;
import Inter.IntChessBoard.IntChessBoard;

/*
 * Author: Brandon Soto
 * Editor: Exceiver Saenz
 * This interface mimics the behavior of the bishop in a chess game
*/
/**
 * Interface representing the behavior of a Bishop piece in a chess game.
 */
public interface IntBishop {

    /**
     * Represents the chessboard on which the bishop moves.
     */
    IntChessBoard chessboard = new ChessBoard(); // The chessboard on which the bishop moves

    /**
     * Moves the bishop to the specified new location.
     *
     * @param LocationX The current horizontal location of the bishop.
     * @param N_LocationX The new horizontal location of the bishop.
     * @param N_LocationY The new vertical location of the bishop.
     * @param LocationY The current vertical location of the bishop.
     * @return true if the bishop can move to the new location, false otherwise.
     */
    public default boolean moveToBishop(char LocationX, char N_LocationX, int N_LocationY, int LocationY) {
        // Check if the current position is within the chessboard
        if (!chessboard.verifyCoordinate(LocationX, LocationY)) {
            return false; // Return false if the position is outside the chessboard
        }
        // Return true if the new position is diagonally adjacent to the current position
        return (Math.abs(N_LocationX - LocationX) == Math.abs(N_LocationY - LocationY));
    }

    /**
     * Checks if moving the bishop to the specified new location is a valid move.
     *
     * @param N_LocationX The new horizontal location of the bishop.
     * @param N_LocationY The new vertical location of the bishop.
     * @return true if the move is valid, false otherwise.
     */
    boolean isValid(char N_LocationX, int N_LocationY);
}


