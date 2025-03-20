package Inter.IntFigure;

/*
 * Author: Brandon Soto
 * Editor: Cheng Bungein
 * This interface mimics the behavior of the figure in a chess game
 */

/**
 * The IntFigure interface represents a figure that can move to a new position on a grid.
 */
public interface IntFigure {

    /**
     * Moves the figure to a new position on the grid.
     *
     * @param column the new column of the figure's position
     * @param row the new row of the figure's position
     * @return true if the move is valid and the figure successfully moved, false otherwise
     */
    boolean moveTo(char column, int row);
}
