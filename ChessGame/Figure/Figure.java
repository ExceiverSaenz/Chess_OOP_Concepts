package ChessGame.Figure;

import ChessGame.ChessBoard.ChessBoard;
import Inter.IntChessBoard.IntChessBoard;
import Inter.IntFigure.IntFigure;


/*
 * Author: Brandon Soto
 * Editor: Cheng Bungein
 * This class mimics the behavior of the figure in a chess game
*/

/**
 * Represents a chess figure with a name, color, and position on the board.
 */
public class Figure implements IntFigure {
    private String name;
    private String color;
    private char LocationX;
    private int LocationY;

    /**
     * The chessboard on which the figure is placed.
     */
    protected IntChessBoard chessboard;

    /**
     * Default constructor for the Figure class.
     * Initializes name, color, LocationX, LocationY, and chessboard to default values.
     */
    public Figure(){ 
        name = ""; 
        color = ""; 
        LocationX = '\u0000'; 
        LocationY = 0;
        chessboard = new ChessBoard();
    }

    /**
     * Constructor for Figure with name.
     *
     * @param name The name of the figure.
     */
    public Figure(String name){
        this.name = name;
        color = ""; 
        LocationX = '\u0000'; 
        LocationY = 0;
        chessboard = new ChessBoard();
    }

    /**
     * Constructor for Figure with name and color.
     *
     * @param name  The name of the figure.
     * @param color The color of the figure.
     */
    public Figure(String name, String color) {
        this.name = name;
        this.color = color; 
        LocationX = '\u0000'; 
        LocationY = 0;
        chessboard = new ChessBoard();
    }

    /**
     * Constructor for Figure with name, color, and LocationX.
     *
     * @param name      The name of the figure.
     * @param color     The color of the figure.
     * @param LocationX The X-coordinate location of the figure.
     */
    public Figure(String name, String color, char LocationX) {
        this.name = name;
        this.color = color; 
        this.LocationX = LocationX;
        LocationY = 0;
        chessboard = new ChessBoard();
    }

    /**
     * Constructor for Figure with name, color, LocationX, and LocationY.
     *
     * @param name      The name of the figure.
     * @param color     The color of the figure.
     * @param LocationX The X-coordinate location of the figure.
     * @param LocationY The Y-coordinate location of the figure.
     */
    public Figure(String name, String color, char LocationX, int LocationY) {
        this.name = name;
        this.color = color; 
        this.LocationX = LocationX;
        this.LocationY = LocationY;
        chessboard = new ChessBoard();
    }

    /**
     * Get the name of the figure.
     *
     * @return The name of the figure.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the color of the figure
     *
     * @return String
     */
    public String getColor() {
        return this.color; 
    }

    /**
     * Get the locationX of the figure
     *
     * @return char
     */
    public char getLocationX() {
        return this.LocationX; 
    }

    /**
     * Get the locationY of the figure
     *
     * @return int
     */
    public int getLocationY() { 
        return this.LocationY; 
    }

    /**
     * Get the chessboard of the figure
     *
     * @return IntChessBoard
     */
    public IntChessBoard getChessBoard(){
        return chessboard;
    }

    /**
     * Set the locationX of the figure
     *
     * @param LocationX The new X-coordinate location of the figure.
     */
    public void setLocationX(char LocationX) { 
        this.LocationX = LocationX; 
    }

    /**
     * Set the locationY of the figure
     *
     * @param LocationY The new Y-coordinate location of the figure.
     */
    public void setLocationY(int LocationY) { 
        this.LocationY = LocationY; 
    }

    /**
     * Set the chessboard of the figure
     * @param LocationX the new horizontal position of the figure
     * @param LocationY the new vertical position of the figure
     * @return boolean {@code true} if the move is valid, {@code false} otherwise
     */
    public boolean moveTo(char LocationX, int LocationY){
        return false;
    }

    /**
     * Checks if a move to the specified position is valid.
     *
     * @param N_LocationX the new horizontal position to move to
     * @param N_LocationY the new vertical position to move to
     * @return {@code true} if the move is valid, {@code false} otherwise
     */
    public boolean isValid(char N_LocationX, int N_LocationY){
        if((Math.abs(N_LocationX - LocationX) == Math.abs(N_LocationY - LocationY))&& samePosition(N_LocationX, N_LocationY)){// call the verify move and the super method sameposition
            return true;
        }
        return false;
    }

    /**
     * Checks if the figure is at the specified position.
     *
     * @param LocationX the horizontal position to check
     * @param LocationY the vertical position to check
     * @return {@code true} if the figure is at the specified position, {@code false} otherwise
     */
    public boolean samePosition(char LocationX, int LocationY){
        if(getLocationX()==LocationX && getLocationY()== LocationY){
            return false;
        }
        return true;
    }

    /**
     * Provides a string representation of the figure.
     *
     * @return a string containing the figure's name, color, and position
     */
    public String toString() {
        return "Name: " + this.name + "\nColor: " + this.color + "\nLocationX: " + this.LocationX + "\nLocationY: " + this.LocationY;
    }

}