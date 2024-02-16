/* 
Author Class: Bungein Cheng
The `Chessboard` class represents a chessboard. This class has two constants, `max_row` and `min_row`, 
  which define the maximum and minimum number of rows on the chessboard, respectively.
The `Chessboard` class has three public methods: `withinChessboard` and `validPosition`.
The `withinChessboard` method checks if a position is inside the chessboard. 
It has two overloads: one that takes a column and a row as parameters, and one that takes only a row. 
The first overload checks if both the column and the row are within the valid range. 
If both are within the range, it returns `true`; otherwise, it returns `false`. 
The second overload only checks if the row is within the valid range.
The `validPosition` method checks if an entry is valid and if the position is valid. First, 
  it removes commas and whitespace from the entry. 
Then, it checks if the length of the entry is 2. If it is not, it returns `false`. Next, 
  it extracts the column and row from the input and checks if the column is a letter and the row is a digit. 
If both conditions are met, it returns `true`; otherwise, it returns `false`.

Feb 8 at 7:00 pm

*/
public class Chessboard { // Define a class
    //Excevier
    private static final int max_row = 8; // Defines a constant for the maximum number of rows in the checkerboard.
    private static final int min_row = 1; // Defines a constant for the minimum number of rows in the chessboard.
    
    public boolean withinChessboard(char column, int row) { // Public method that checks if a position is inside the chessboard.
    
        if ((column >= 'a' && column <= 'h') == true && (row >= min_row && row <= max_row) == false) { // If the column is within the valid range and the row is not within the valid range....
            return false; // Returns false because the position is not completely inside the board.
        }else if ((column >= 'a' && column <= 'h') == false && (row >= min_row && row <= max_row) == true) { // If the column is not within the valid range and the row is within the valid range.
            return false; // Returns false because the position is not completely inside the board.
        }else if ((column >= 'a' && column <= 'h') == false && (row >= min_row && row <= max_row) == false) { // If neither the column nor the row is within the valid range....
            return false; // Returns false because the position is not inside the board.
        }else{ // If both column and row are within the valid range
            return true; // Returns true because the position is inside the board.
        }
    }
    public boolean withinChessboard(int row){
        if(row>=1 && row<=8){
            return true;
        }
        return false;
    }


    //Author Brandon Soto, Editor Exceiver
    public boolean validPosition(String input){ // method to make sure the position is valid and the input is valid.
        input=input.replace(",","").trim();
        if (input.length() != 2) {
            return false;
        }
        char column = input.charAt(0);
        char row = input.charAt(1);
        if(Character.isLetter(column) && Character.isDigit(row)){

            return true;
        }

        return false;
    }

}