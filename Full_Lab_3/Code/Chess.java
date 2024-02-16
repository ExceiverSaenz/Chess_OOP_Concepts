/*
Authors: ALL TEAM

The `Chess` class is an implementation of a chess game in Java. It was developed by a team composed by Brandon Soto, Exceiver Saenz and Bungein Cheng. 
This class uses enumerations to represent the types of chess pieces, the columns of the board and the colors of the pieces. 
The game is executed in the `main` method, where the user is prompted to select the pieces to place on the board. 
For each piece selected, its type, color, column and row are validated. Once all the pieces have been selected, the user is prompted to enter a target position to move the pieces. 
The movement rules are checked and it is ensured that the target position is inside the board. 
The `Chess` class encapsulates the main logic of the chess game, including the interaction with the user and the validation of the actions performed.
14 Feb 5:00pm - 9:00 pm
 */

import java.util.Scanner;
public class Chess {
    //Bungein Cheng
    enum ChessPieceType {PAWN,ROOK,KNIGHT,BISHOP,QUEEN,KING}//enum classes
    enum Column { A, B, C, D, E, F, G, H }
    enum Color { WHITE, BLACK }
    public static void main(String [] args){
        
        
        Scanner scanner = new Scanner(System.in);
        ChessPieces [] Piece = new ChessPieces[6];//Array for the classes 
        Chessboard board = new Chessboard();//new chessboard
        //check if we have selected the piece or not 
        boolean visitedPawn =  false, visitedRook=  false, visitedKnight =  false, visitedKing =  false, visitedQueen =  false, visitedBishop =  false;
        int position = 0;
        while(position<6){//until have selected all pieces a position
        System.out.println("You have " + position + " Chess pieces, you need " + (6 - position) + " more");
            ChessPieceType pieceSelected = null;
            Color colorSelect = null;
            Column columnSelected = null;
            char col = '\0';
            int row = 0;
            boolean validNumber = false;
            
        // Author: Exceiver Saenz Start
            while(pieceSelected == null){//until have an answer

                try{
                    System.out.println("Select a piece: PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING ");
                    //input does not matter upper or lower case and spaces
                    pieceSelected = ChessPieceType.valueOf(scanner.nextLine().toUpperCase().trim());
                }catch (IllegalArgumentException e){
                    System.out.println("piece not found try again");//in case the input is not correct
                }
            }    
            
            while(colorSelect==null){//until have an answer
                try{
                    System.out.println("Select a color between: White and Black ");
                    //input does not matter upper or lower case and spaces
                    colorSelect = Color.valueOf(scanner.nextLine().toUpperCase().trim());
                }catch(IllegalArgumentException e){//in case the input is not correct
                    System.out.println("color not found try again");
                }
            }            

            while(columnSelected == null){//until have an answer
                try{
                    System.out.println("Select the Column between A and H: ");
                    //input does not matter upper or lower case and spaces
                    columnSelected = Column.valueOf(scanner.nextLine().toUpperCase().trim());
                }catch(IllegalArgumentException e){//in case the input is not correct
                    System.out.println("Column not found try again");
                }
            }
            col = columnSelected.toString().toLowerCase().charAt(0);

            // Author: Exceiver Saenz  End

            while(!validNumber){//until have an answer
                System.out.println("Enter row between 1 to 8: ");
                row = scanner.nextInt();
                if(board.withinChessboard(row)){//set to the chessboard
                    validNumber=true;
                }
                else{//method from chessboaerd if position is not permited
                    System.out.println("initial position invalid try again.");
                }
                
            }  
            scanner.nextLine();

            //Bungein Cheng, Brandon Soto
            switch (pieceSelected) {//when user inputs one of the pieces
                case PAWN:
                    if(!visitedPawn){//if piece had not been visited
                        Piece[position] = new Pawn("Pawn", colorSelect.toString(), col, row);//get attributes 
                        visitedPawn = true;
                        position++;
                        
                    }
                    else {
                        System.out.println("Pawn cannot be chosen twice");
                    }
                    break;
                
                case ROOK:
                    if(!visitedRook){//if piece had not been visited
                        Piece[position] = new Rook("Rook", colorSelect.toString(), col, row);//get attributes
                        visitedRook = true;
                        position++;
                    }
                    else {
                        System.out.println("Rook cannot be chosen twice");
                    }
                    break;

                case KNIGHT:
                    if(!visitedKnight){//if piece had not been visited
                        Piece[position] = new Knight("Knight", colorSelect.toString(), col, row);//get attributes
                        visitedKnight = true;
                        position++;
                    }
                    else {
                        System.out.println("Knight cannot be chosen twice");
                    }
                    break;

                case KING:
                    if(!visitedKing){//if piece had not been visited
                        Piece[position] = new King("King", colorSelect.toString(), col, row);//get attributes
                        visitedKing = true;
                        position++;
                    }
                    else {
                        System.out.println("King cannot be chosen twice");
                    }
                    break;

                case QUEEN:
                    if(!visitedQueen){//if piece had not been visited
                        Piece[position] = new Queen("Queen", colorSelect.toString(), col, row);//get attributes
                        visitedQueen = true;
                        position++;
                    }
                    else {
                    System.out.println("Queen cannot be chosen twice");
                    }
                    break;

                case BISHOP:
                    if(!visitedBishop){//if piece had not been visited
                        Piece[position] = new Bishop("Bishop", colorSelect.toString(), col, row);//get attributes
                        visitedBishop = true;
                        position++;
                    }
                    else {
                        System.out.println("Bishop cannot be chosen twice");
                    }
                    break;
                default:
                    System.out.println("Invalid piece, try again!");
                
            }
    }
    // Author Start Brandon
    boolean targetValid = false;
    while(!targetValid){
        Scanner nextPostion = new Scanner(System.in);
        System.out.println("enter target position");
        String target = nextPostion.nextLine();
        //convert the letter into an Integer to set a position
        int new_row = Integer.parseInt(String.valueOf(target.charAt(1)));
        char new_column = target.toLowerCase().charAt(0);
        System.out.println(new_row + "\n" + new_column);
        
       if(board.validPosition(target) && board.withinChessboard( new_column, new_row)) {
            for(int i=0 ; i<Piece.length; i++) {
                Piece[i].isValid(new_column,new_row);
            }
            targetValid=true;
        }
        else{
            System.out.println("Target position not within chessboard try again");
        }
    }
    scanner.close();
    }
    // Author End Brandon
}
