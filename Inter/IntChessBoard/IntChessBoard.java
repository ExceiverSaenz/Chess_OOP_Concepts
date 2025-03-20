package Inter.IntChessBoard;

/*
 * Author: Brandon Soto
 * Editor: Cheng Bungein
 * This interface mimics the behavior of the chess board in a chess game
*/

/**
 * An interface representing a chessboard for managing positions and validity checks.
 */
public interface IntChessBoard{

    /**
     * Method to verify the validity of the Y-coordinate of a piece.
     * @param LocationY The Y-coordinate to be verified
     * @return true if the Y-coordinate is valid, false otherwise
     */
    boolean verifyCoordinate(int LocationY);

    /**
     * Method to verify the validity of the X and Y coordinates of a piece.
     * @param LocationX The X-coordinate to be verified
     * @param LocationY The Y-coordinate to be verified
     * @return true if both X and Y coordinates are valid, false otherwise
     */
    boolean verifyCoordinate(char LocationX, int LocationY);

    /**
     * Method to verify the validity of a piece's position represented by a string input.
     * @param input The input string representing the position to be verified
     * @return true if the position is valid, false otherwise
     */
    boolean validPosition(String input);
}