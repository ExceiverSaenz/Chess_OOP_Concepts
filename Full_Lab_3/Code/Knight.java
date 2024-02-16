/*
Author: Exceiver
Editors: Cheng Bungein & Brandon Soto
The Knight class is a subclass of ChessPieces that represents a knight in a chess game. 
This class has a constructor that accepts the name, color, column and row of the piece, 
  and calls the constructor of the superclass with these values.
The Knight class overrides two methods of the superclass: verifyMove and isValid.
The verifyMove method checks whether a move is valid for the knight. First, it checks if 
  the new position is inside the chessboard. 
If it is not, it returns false. Then, it checks if the move conforms to the behavior of 
  the knight, which may move in an 'L' shaped pattern. 
If the movement is valid, it returns true.The isValid method prints whether a movement is valid. 
If the move is valid and the new position is not the same as the current position, 
  it prints that the part can move to the new location. 
Otherwise, it prints that the part cannot move to the new location. This method uses the 
  verifyMove method to verify the validity of the move.

Feb 11 at 5:00 pm
*/
class Knight extends ChessPieces {
    

    Knight(String name, String color, char column, int row){
        super(name, color, column, row);
    }

    @Override
    public boolean verifyMove(char n_column, int n_row) { // Public method that checks if a transaction is valid for the part.
        if (!chessboard.withinChessboard(n_column, n_row)) {
            return false; // Return false if the position is outside the chessboard
        }
        return (Math.abs(getRow() - n_row) == 1 && Math.abs(getColumn() - n_column) == 2) || // behavior of the knight
           (Math.abs(getRow() - n_row) == 2 && Math.abs(getColumn() - n_column) == 1);
    }
    @Override
    public void isValid(char column, int row){// to print if it is valid
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




       


