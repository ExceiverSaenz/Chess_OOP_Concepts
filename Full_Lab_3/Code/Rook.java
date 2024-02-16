/*
Author: Exceiver
Editors: Brandon Soto & Cheng Bungein

The Rook class is a subclass of ChessPieces that represents a rook in a chess game. 
This class has a constructor that accepts the name, color, column and row of the piece, 
  and calls the constructor of the superclass with these values.
The Rook class overrides two methods of the superclass: verifyMove and isValid.
The verifyMove method verifies whether a move is valid for the rook. 
It returns true if the new column is the same as the current column or if the new row is
  the same as the current row. 
This is the behavior of the tower, which can move in a straight line horizontally or vertically.
The isValid method prints whether a move is valid. 
If the move is valid and the new position is not the same as the current position, it 
  prints that the part can move to the new location. 
Otherwise, it prints that the part cannot move to the new location. 
This method uses the verifyMove method to verify the validity of the move. 

Feb 10 at 3:00 pm
*/
class Rook extends ChessPieces {
    

    Rook(String name, String color, char column, int row){
        super(name, color,column, row);
    }

    @Override
    public boolean verifyMove(char n_column, int n_row) { // Public method that verifies if a move is valid for the part.

        return n_column == super.getColumn() || n_row == super.getRow(); // behavior of the rook
    }

    @Override
    public void isValid(char column, int row){// prints if the position is valid 
        if(verifyMove(column, row)&&super.samePosition(column, row)){ // verifies if the movement is valid
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can move to location "+column+""+row+"\n");
        }
        else{
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can not move to location "+column+""+row+"\n");
        }
    }




       

}
