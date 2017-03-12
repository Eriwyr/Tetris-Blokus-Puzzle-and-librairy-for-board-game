package LibraryBoardGame.Model.Board;

import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class ModelBoard extends Observable{
    private Grid grid;
    private List<Piece> pieces;

    public ModelBoard(Grid grid, List<Piece> pieces) {
        this.grid = grid;
        this.pieces = pieces;
    }

    public Grid getGrid() {
        return grid;
    }

    public ModelBoard(int x, int y){
        this.grid = new Grid(x,y);
        pieces = new ArrayList<Piece>();

        List<Position> shape2 = new ArrayList<Position>();
        Piece piece2 = new Piece(shape2);

        shape2.add(new Position(5, 5));
        shape2.add(new Position(5, 6));
        shape2.add(new Position(5, 7));

        pieces.add(piece2);

    }

    public void movePiece(Piece piece, Direction direction) {
        removePiece(piece);
        boolean available = true;
        List<Position> anticipatePos;

        anticipatePos = piece.anticipationCalc(direction);

        for (Position position: anticipatePos){
            try {
                if(!grid.getCellXY(position).isEmpty()){
                    available = false;
                    System.out.println(position.getX()+" "+position.getY()+" is not empty");
                    break;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(position.getX()+" "+position.getY()+" is out of bound");
                available = false;
            }
        }

        if(available){
            piece.setShape(anticipatePos);
            System.out.println("all good");
        }

        setChanged();
        notifyObservers();

        addPieceOnBoard(piece);

    }



    public void removePiece(Piece piece){
        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(true);
        }
       /* setChanged();
        notifyObservers();*/
}

    public List<Piece> getPieces(){
        return pieces;
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
        setChanged();
        notifyObservers();

    }

    public void addPieceOnBoard(Piece piece) {
        for (Position position :piece.getShape()) {
            grid.setCellXY(position, false);
        }
        /*
        setChanged();
        notifyObservers();
        */
    }
/*
    public void rotatePiece(Piece piece, int rotation) { // rotation = 1 for clockwise rotation, -1 for anticlockwise
        removePiece(piece);
        int temp =0;
        int removeCenterX;
        int removeCenterY;
        if (rotation == 1) {
            for (Position position : piece.getShape()) {
                System.out.println("old position :"+ position.getX()+ " "+ position.getY());


              //  removeCenterX = position.getX() - piece.getCenter().getX();
             //   removeCenterY = position.getY() - piece.getCenter().getY();

                // extchange

                //temp = removeCenterY;
                temp =  position.getY() - piece.getCenter().getY();
                removeCenterY = position.getX() - piece.getCenter().getX();;
                removeCenterX = temp;

                System.out.println("extchange : "+removeCenterX + " "+ removeCenterY );
                //add centers
                removeCenterX = removeCenterX+piece.getCenter().getX();

                removeCenterY = removeCenterY+piece.getCenter().getY();
                System.out.println("added center  : "+removeCenterX + " "+ removeCenterY );



                position.setX(removeCenterX);
                position.setY(removeCenterY);
                System.out.println("new position :"+ position.getX()+ " "+ position.getY());

            }

        } else {

        }




        addPieceOnBoard(piece);

    }
    */
}
