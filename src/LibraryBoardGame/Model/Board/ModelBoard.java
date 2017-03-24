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
        System.out.println("On est dans move : "+direction);
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
                available = false;
                returnValue = 1;
            }
        }

        if(available){
            piece.setShape(anticipatePos);
        }

        setChanged();
        notifyObservers();
        addPieceOnBoardInOrder(piece, 0);

        return returnValue;

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
        for (Position position :piece.getShape()) {
            grid.setCellXY(position, false);
        }
        addPiece(piece, index);
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
        removePiece(piece);
        List<Position> positions = new ArrayList<Position>();
        int centerX = 0;
        int centerY=0;
        int pieceX=0;
        int pieceY=0;
        int newX=0;
        int newY=0;
        if (rotation == 1) {
            for (Position position : piece.getShape()) {
                System.out.println("entering !  ! !!!!!!! ! !! ");

                pieceX = position.getX();
                pieceY = position.getY();


                centerX = piece.getCenter().getX();
                centerY = piece.getCenter().getY();

                newX = centerX + (pieceY-centerY);
                newY = centerY - (pieceX-centerX);

                position.setX(newX);
                position.setY(newY);

                positions.add(position);
            }

        } else {

        }

        piece.setShape(positions);
        addPieceOnBoard(piece);

    }


}
