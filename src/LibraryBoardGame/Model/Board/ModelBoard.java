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
        grid = new Grid(4, 10);
        pieces = new ArrayList<Piece>();
    }

    public Grid getGrid() {
        return grid;
    }

    public ModelBoard(int x, int y){
        this.grid = new Grid(x,y);
        pieces = new ArrayList<Piece>();
    }



   public int movePiece(Piece piece, Direction direction) {

       int returnValue = 0;
       Piece anticipatedPiece = new Piece();
       removePiece(piece);
       anticipatedPiece.anticipationCalc(piece, direction);

       if (pieceIsAuthorized(anticipatedPiece)) {
           piece = anticipatedPiece;
           returnValue = 0;
       } else {
           returnValue =1;
       }

       addPieceOnBoardInOrder(piece, 0);
       return returnValue;
   }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void udateGrid(){
        System.out.println("after calling size piece : "+pieces.size());
        for(int i =0; i<grid.getSizeY(); i++) {
            for (int j=0; j<grid.getSizeX(); j++ ) {
                grid.setCellXY(new Position(j, i ), true);
            }
        }


        for (Piece piece : pieces){
            System.out.println("size positions "+piece.getShape().size());
            for (Position position : piece.getShape()) {
                System.out.println("setting to false "+position.getX()+" "+position.getY());
                grid.setCellXY(position, false);
            }
            System.out.println("in udate grid");
            grid.Display();
        }

    }


    public void moveOneCell(Position position, Direction direction) {

        Position anticipatedPosition = position.anticipatePosition(direction);
        position.setX(anticipatedPosition.getX());
        position.setY(anticipatedPosition.getY());


   /*     Position positionAbove = position.anticipatePosition(Direction.Up);
        System.out.println("For the position  "+position.getX()+" "+position.getY()+", the above is :"+positionAbove.getX()+" "+positionAbove.getY()+", and bellow is "+anticipatedPosition.getX()+" "+anticipatedPosition.getY());
     //   if(grid.getCellXY(anticipatedPosition).isEmpty()) {

        if (getGrid().getCellXY(positionAbove).isEmpty()) {
            System.out.println("the position "+positionAbove.getX()+" "+positionAbove.getY()+" is empty " );
            System.out.println("firt set "+position.getX()+" "+ position.getY()+ " to true");
            grid.setCellXY(position, true);
        } else {
            System.out.println("first set "+position.getX()+" "+ position.getY()+ " to false");
            grid.setCellXY(position, false);
        }

        position.setX(anticipatedPosition.getX());
        position.setY(anticipatedPosition.getY());
            System.out.println("second set "+position.getX()+" "+ position.getY()+ " to false");
            grid.setCellXY(position, false);
      //  }*/

        setChanged();
        notifyObservers();
    }


    public void removePiece(Piece piece){

        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(true);
        }
        pieces.remove(piece);
}

    public List<Piece> getPieces(){
        return pieces;
    }

    public void addPiece(Piece piece){
        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(false);
        }
        pieces.add(piece);


    }

    public void addPiece(Piece piece, int index){
        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(false);
        }
        pieces.add(index, piece);

    }

    public void addPieceOnBoard(Piece piece) {
        for (Position position :piece.getShape()) {
            grid.setCellXY(position, false);
        }
        addPiece(piece);
        setChanged();
        notifyObservers();

    }

    public  void addPieceOnBoardInOrder(Piece piece, int index) {
        System.out.println("piece we are troyning de add ");
        piece.Display();
        int c =1;
        for (Position position :piece.getShape()) {
            System.out.println("setting pisition "+c);
            grid.setCellXY(position, false);
            c++;
        }
        System.out.println("done with for ");
        addPiece(piece, index);
        System.out.println("added");
        setChanged();
        notifyObservers();
        System.out.println("notifyined ");
    }


    public boolean AuthorizedAddPieceOnBoard(Piece piece) {
        for (Position position : piece.getShape()) {
            if (grid.getCellXY(position).isEmpty()) return true ;
        }

        for (Position position :piece.getShape()) {

            grid.setCellXY(position, false);
        }
        addPiece(piece);
        setChanged();
        notifyObservers();
        return false;

    }

    public boolean AuthorizedAddPieceOnBoard(Piece piece, int index) {
        System.out.println("On verifie l'autorasation ");
        for (Position position : piece.getShape()) {
            System.out.println("pour cette position :"+position.getX()+" "+position.getY());
            if (!grid.getCellXY(position).isEmpty()){
                System.out.println("la position est accupée, on s'arrête et on revoit false");
                return false ;
            }
        }
        System.out.println("Tout ets Ok ");

        for (Position position :piece.getShape()) {

            grid.setCellXY(position, false);
        }
        System.out.println("on ajoute la pièce au plateau ");
        addPiece(piece, index);
        setChanged();
        notifyObservers();
        return true;

    }


    public void emptyMultipleCells(List<Position> list, Piece piece) {

        for (Position position : list) {
            grid.getCellXY(position).setEmpty(true);

            for (Iterator<Position> iterator = piece.getShape().iterator(); iterator.hasNext();) {
                Position cell = iterator.next();
                if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                    // Remove the current element from the iterator and the list.
                    iterator.remove();
                }
            }
        }

        setChanged();
        notifyObservers();

    }
    public void emptyCell(Position position, Piece piece) {

        for (Iterator<Position> iterator = piece.getShape().iterator(); iterator.hasNext();) {
            Position cell = iterator.next();
            if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                //System.out.println("removing Position : "+position.getX()+" "+position.getY());
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }

        setChanged();
        notifyObservers();

    }


    public int rotatePiece(Piece piece, int rotation) { // rotation = 1 for clockwise rotation, -1 for anticlockwise

        removePiece(piece);
        int returnValue = 0;

        Piece anticipatedPiece = new Piece();
        anticipatedPiece.anticipationCalc(piece, rotation);

        if (pieceIsAuthorized(anticipatedPiece)) {
            piece = anticipatedPiece;
            returnValue = 0;
        } else {
            returnValue = 1;
        }
        addPieceOnBoardInOrder(piece, 0);
        return returnValue;
    }

    public boolean pieceIsAuthorized(Piece piece) {
        for (Position position : piece.getShape()) {
            try {
                if (!grid.getCellXY(position).isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public void replacePieceOnBoard(Piece newPiece, int index) {
        //On enlève l'ancienne
        for (Position position: pieces.get(index).getShape()){
            grid.getCellXY(position).setEmpty(true);
        }

        for (Position position :newPiece.getShape()) {
            grid.setCellXY(position, false);
        }
        //addPiece(piece, index);
        pieces.set(index, newPiece);
        setChanged();
        notifyObservers();


    }


}
