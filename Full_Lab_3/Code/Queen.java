/*
Author: Brandon Soto
Editors: Bungein Cheng

The `Queen` class is a subclass of `Bishop` that represents a queen in a chess game. 
This class has a constructor that accepts the name, color, column and row of the piece, 
  and calls the constructor of the `Bishop` superclass with these values.
The `Queen` class overrides two methods of the superclass: `verifyMove` and `isValid`. 
The `verifyMove` method takes a new column and row as parameters and checks if the queen's move to this new position is valid. 
First, it checks if the new position is inside the chessboard. If it is not, it returns `false`. Next, it checks if the move is
valid for a queen, that is, if it moves diagonally (like a bishop, using `super.verifyMove`) or in a straight line (like a rook). 
This is done by checking if the new column is equal to the current column or if the new row is equal to the current row.
The `isValid` method prints whether the move is valid. 
It calls the `verifyMove` method and the `samePosition` method of the superclass to check if the move is valid. 
If it is, it prints that the part can be moved to the new location. 
If it is not, it prints that the part cannot move to the new location.

Feb 11 at 8:27 pm
*/
class Queen extends Bishop {
    boolean temp = false;

    Queen(String name, String color, char column, int row){// constructor
        super(name, color, column, row);
    }
    @Override
    public boolean verifyMove(char n_column, int n_row) {// verify the movement
        if(! chessboard.withinChessboard(n_column, n_row)){
            return false;
        }
        return (super.verifyMove(n_column, n_row) || n_column == super.getColumn() || n_row == super.getRow());// call super verify movement and rook behavior for the queen
    }
    
    @Override
    public void isValid(char column, int row){// // prints if the movement is valid.
        if(verifyMove(column, row)&&super.samePosition(column, row)){
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can move to location "+column+""+row+"\n");
        }
        else{
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can not move to location "+column+""+row+"\n");
        }
    }

}