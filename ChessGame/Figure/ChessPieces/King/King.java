package ChessGame.Figure.ChessPieces.King;
import ChessGame.ChessBoard.ChessBoard;
import ChessGame.Figure.ChessPieces.Queen.Queen;
import Inter.IntChessBoard.IntChessBoard;

/*
Author: Brandon Soto
Editor: Bungein Cheng
This method contructs a king using the superclass queen to take into account behavior of the queen 
Feb 11 at 9:00 pm
*/

/**
 * Represents a king figure in the chess game.
 */
public class King extends Queen{
    IntChessBoard chessboard = new ChessBoard();

    /**
     * Constructs a king figure with the specified name, color, position, and chessboard.
     *
     * @param name      the name of the king figure
     * @param color     the color of the king figure
     * @param LocationX the horizontal position of the king figure
     * @param LocationY the vertical position of the king figure
     * @param chessboard the chessboard on which the king figure is placed
     */
    public King(String name, String color, char LocationX, int LocationY, IntChessBoard chessboard){// constructor
        super(name, color, LocationX, LocationY, chessboard);
        this.chessboard = chessboard;
    }

    /**
     * Constructs a king figure with the specified name, color, position.
     *
     * @param name      the name of the king figure
     * @param color     the color of the king figure
     * @param LocationX the horizontal position of the king figure
     * @param LocationY the vertical position of the king figure
     */
    public King(String name, String color, char LocationX, int LocationY){// constructor
        super(name, color, LocationX, LocationY);
    }



    /**
     * Moves the king figure to the specified column and row if it's a valid move.
     *
     * @param n_column the new horizontal position of the king figure
     * @param n_row    the new vertical position of the king figure
     * @return {@code true} if the move is valid, {@code false} otherwise
     */
   @Override
   public boolean moveTo(char n_column, int n_row) { // verifies movement
    if (!chessboard.verifyCoordinate(n_column, n_row)){
        return false;
    }
    return super.moveTo(n_column, n_row) && Math.abs(getLocationX() - n_column) <= 1 && Math.abs(getLocationY() - n_row) <= 1;//calls super of the 
   }

    /**
     * Checks if moving the king figure to the specified column and row is a valid move.
     *
     * @param column the new horizontal position to check
     * @param row    the new vertical position to check
     * @return {@code true} if the move is valid, {@code false} otherwise
     */
   @Override
    public boolean isValid(char column, int row){// prints if the movement is valid.
        if(moveTo(column, row)&&super.samePosition(column, row)){
            return true;
        }
       return false;
   }
}
   