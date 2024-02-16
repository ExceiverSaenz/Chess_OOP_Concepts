/*
Author: Exceiver
Editors: Brandon Soto & Cheng Bungein

The Pawn class is a subclass of the ChessPieces superclass, 
  representing a pawn piece in a game of chess.
It inherits all attributes and methods from ChessPieces, 
  and also defines its own behavior.
The class includes several constructors for creating a pawn 
  with different attributes.
The verifyMove method checks if a proposed move is valid for a pawn, 
  considering the unique movement rules of a pawn in chess. 
The isValid method uses verifyMove to check if a move is valid and then 
  prints a message indicating whether the pawn can move to the specified location. 
This class provides a specific implementation for a pawn, while still 
  utilizing the general structure and functionality provided by the ChessPieces superclass.


Feb. 10 at 10:14 am
 */

class Pawn extends ChessPieces {


    Pawn(String name, String color, char column, int row){// contructor
        super(name, color, column, row);// super class
    }

    @Override
    public boolean verifyMove(char n_column, int n_row){ // verifies the movement of the pown
        if(!chessboard.withinChessboard(n_column, n_row)){// verifies initial position is within boundaries
            return false;
        }        

        int color=-1;
        if(getColor().trim().equalsIgnoreCase("white")){ // checks color
                color=1;
        }

        return n_column == getColumn() && n_row == getRow() + color; //return true if is correct
    }

    @Override
    public void isValid(char column, int row){ // prints if the position is valid 
        if(verifyMove(column, row)&&super.samePosition(column, row)){// verify if the movement 
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can move to location "+column+""+row+"\n");
        }
        else{
            System.out.print(getName()+" at location "+getColumn()+""+getRow()+" ");
            System.out.print("can not move to location "+column+""+row+"\n");
        }
    }

}
