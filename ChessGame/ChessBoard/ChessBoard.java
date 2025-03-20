package ChessGame.ChessBoard;

import Inter.IntChessBoard.IntChessBoard;
/* 
Author Class: Bungein Cheng
The chessboard class manages if the input is within the chessboard and if the input is valid for the other method to run
3/6 at 7:00 pm
*/

/**
 * Represents a chessboard for managing piece positions and performing validity checks.
 * The chessboard has a maximum row limit of 8 and a minimum row limit of 1.
 */
public class ChessBoard implements IntChessBoard { // Define a class
    private final int MAX_ROW = 8;  // Constants are made private and final
    private final int MIN_ROW = 1;

    /**
     * Method to verify if the position is valid.
     *
     * @param Location_X the X coordinate of the position
     * @param Location_Y the Y coordinate of the position
     * @return boolean indicating if the position is valid
     */
    public boolean verifyCoordinate(char Location_X, int Location_Y) { // Public method that checks if a position is inside the chessboard.
        boolean isXValid = Location_X >= 'a' && Location_X <= 'h';
        boolean isYValid = Location_Y >= MIN_ROW && Location_Y <= MAX_ROW;
        return isXValid && isYValid;
    }

    /**
     * Method to verify if the Y coordinate of the position is valid.
     *
     * @param Location_Y the Y coordinate of the position
     * @return boolean indicating if the Y coordinate is valid
     */
    public boolean verifyCoordinate(int Location_Y){
        if(Location_Y>=1 && Location_Y<=8){
            return true;
        }
        return false;
    }


    /**
     * Method to verify if the position is valid.
     *
     * @param input the input string representing the position
     * @return boolean indicating if the position is valid
     */
    public boolean validPosition(String input){ // method to make sure the position is valid and the input is valid.
        if (input.length() != 2) {
            return false;
        }
        char Location_X = input.charAt(0);
        char Location_Y = input.charAt(1);
        if(Character.isLetter(Location_X) && Character.isDigit(Location_Y)){
            return true;
        }
        return false;
    }

}