package LibraryBoardGame.Model.Board;

import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Iterator;
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

    public ModelBoard() {
        grid = new Grid(6, 12);
        pieces = new ArrayList<Piece>();
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

    public int movePiece(Piece piece, Direction direction) {
        int returnValue =0;
        removePiece(piece);

       /* removePiece(piece);*/
        boolean available = true;
        List<Position> anticipatePos;

        anticipatePos = piece.anticipationCalc(direction);

        for (Position position: anticipatePos){
            try {
                if(!grid.getCellXY(position).isEmpty()){
                    available = false;
                    returnValue = 1;
                    break;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Catch in ModelBoard movepiece");
                available = false;
                returnValue = 1;
            }
        }

        if(available){
            piece.setShape(anticipatePos);
        }

        setChanged();
      /*  System.out.println("Piece outing move : ");
        piece.Display();
        System.out.println("notifying from move piece");
        */notifyObservers();
        addPieceOnBoard(piece);

        return returnValue;

    }



    public void removePiece(Piece piece){
        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(true);
        }

}

    public List<Piece> getPieces(){
        return pieces;
    }

    public void addPiece(Piece piece){
        pieces.add(piece);


    }

    public void addPieceOnBoard(Piece piece) {
        for (Position position :piece.getShape()) {
            grid.setCellXY(position, false);
        }
        addPiece(piece);
        setChanged();
        notifyObservers();

    }


    public void AuthorizedAddPieceOnBoard(Piece piece) {
        for (Position position : piece.getShape()) {
            if (grid.getCellXY(position).isEmpty()) return ;
        }

        for (Position position :piece.getShape()) {

            grid.setCellXY(position, false);
        }
        addPiece(piece);
        setChanged();
        notifyObservers();

    }


    public void emptyMultipleCells(List<Position> list, Piece piece) {

        for (Position position : list) {
            grid.getCellXY(position).setEmpty(true);

            for (Iterator<Position> iterator = piece.getShape().iterator(); iterator.hasNext();) {
                Position cell = iterator.next();
                if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                    System.out.println("removing Position : "+position.getX()+" "+position.getY());
                    // Remove the current element from the iterator and the list.
                    iterator.remove();
                }
            }
        }



        System.out.println("notifying from emptyMultipleCells");
        setChanged();
        notifyObservers();

    }
    public void emptyCell(Position position, Piece piece) {
        System.out.println("position to remove : "+position.getX()+" " +position.getY());

        for (Iterator<Position> iterator = piece.getShape().iterator(); iterator.hasNext();) {
            Position cell = iterator.next();
            if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                System.out.println("removing Position : "+position.getX()+" "+position.getY());
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }

        System.out.println("notifying from empty");
        setChanged();
        notifyObservers();

    }




    public void rotatePiece(Piece piece, int rotation) { // rotation = 1 for clockwise rotation, -1 for anticlockwise
    /*    removePiece(piece);
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
*/
    }


}
