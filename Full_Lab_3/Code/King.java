/*
Author: Brandon Soto
Editor: Bungein Cheng

The `King` class is a subclass of `Queen` that represents a king in a chess game. 
This class has a constructor that accepts the name, color, column and row of the piece, 
  and calls the constructor of the `Queen` superclass with these values.
The `King` class overrides two methods of the superclass: `verifyMove` and `isValid`. 
The `verifyMove` method takes a new column and row as parameters and checks if the move of the king to this new position is valid. 
First, it checks if the new position is inside the chessboard. If it is not, it returns `false`. 
Then, it checks if the move is valid for a king, that is, if it moves to an adjacent square. 
This is done by checking if the absolute difference between the new column and the current column 
  and between the new row and the current row is less than or equal to 1. In addition, it also checks 
  if the move is valid for a queen, using `super.verifyMove`.
The `isValid` method prints whether the move is valid. It calls the `verifyMove` method and the `samePosition` 
  method of the superclass to check if the move is valid. 
If it is, it prints that the part can be moved to the new location. 
If it is not, it prints that the part cannot move to the new location.

Feb 11 at 9:00 pm
*/
public class King extends Queen{
    King(String name, String color, char column, int row){// constructor.
        super(name, color, column, row); // 
    }
    
@Override
public boolean verifyMove(char n_column, int n_row) { // verifies movement
    if (!chessboard.withinChessboard(n_column, n_row)){
        return false;
    }
    return super.verifyMove(n_column, n_row) && Math.abs(getRow() - n_row) <= 1 && Math.abs(getColumn() - n_column) <= 1;//calls super of the queen and makes sure it is within 1 square
}

@Override
public void isValid(char column, int row){// prints if the movement is valid.
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
