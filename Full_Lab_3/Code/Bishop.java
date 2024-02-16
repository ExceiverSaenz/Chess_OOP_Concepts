/*
Author: Exceiver
Editors: Brandon Soto & Cheng Bungein
The `Bishop` class is a subclass of `ChessPieces` that represents a bishop in a chess game. 
This class has a constructor that accepts the name, color, column and row of the piece, 
  and calls the constructor of the `ChessPieces` superclass with these values.
The `Bishop` class overrides two methods of the superclass: `verifyMove` and `isValid`. 
The `verifyMove` method takes a new column and row as parameters and checks if the move of 
  the bishop to this new position is valid. 
First, it checks if the new position is inside the chessboard. 
If it is not, it returns `false`. Then, it checks if the move is valid for a bishop, that is, if it moves diagonally. 
This is done by checking if the absolute difference between the new column and the current 
  column is equal to the absolute difference between the new row and the current row.
The `isValid` method prints whether the move is valid. 
It calls the `verifyMove` method and the `samePosition` method of the superclass to check if the move is valid. 
If it is, it prints that the part can be moved to the new location. 
If it is not, it prints that the part cannot move to the new location.

Feb 11 at 7:00 pm
*/
class Bishop extends ChessPieces {
    Bishop(String name, String color, char column, int row){// constructor of bishop
        super(name, color, column, row);
    }

    @Override
    public boolean verifyMove(char n_column, int n_row) { // Public method that checks if a move is valid for the bishop.
        if (!chessboard.withinChessboard(n_column, n_row)) {
            return false; // Return false if the position is outside the chessboard
        }
        return (Math.abs(n_column - super.getColumn()) == Math.abs(n_row - super.getRow()));// behavior of bishop
    } 

    @Override
    public void isValid(char column, int row){ // is a method to print if the movement is valid
        if(verifyMove(column, row)&&super.samePosition(column, row)){// call the verify move and the super method sameposition
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can move to location "+column+""+row+"\n");
        }
        else{
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can not move to location "+column+""+row+"\n");
        }
    }

}