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

    public ModelBoard() {
        grid = new Grid(10, 10);
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
        removePiece(piece);
        System.out.println("Piece entering move : ");
        piece.Display();
       /* removePiece(piece);*/
        boolean available = true;
        List<Position> anticipatePos;

        anticipatePos = piece.anticipationCalc(direction);
        System.out.println("anticipated position : ");

        for (Position position : anticipatePos) {
            System.out.println(position.getX()+" "+position.getY());
        }
        for (Position position: anticipatePos){
            try {
                if(!grid.getCellXY(position).isEmpty()){
                    System.out.println("available = flase fropm is empy");
                    available = false;
                    break;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("available = flase from catch");
                available = false;
                return 1;
            }
        }

        if(available){
            System.out.println("setting");
            piece.setShape(anticipatePos);
        }

      /*  setChanged();
        System.out.println("Piece outing move : ");
        piece.Display();
        System.out.println("notifying from move piece");
        notifyObservers();*/
        addPieceOnBoard(piece);
        return 0;

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
        System.out.println("notifying from addPiece");
        setChanged();
        notifyObservers();

    }

    public void emptyCell(Position position, Piece piece) {
        grid.setCellXY(position, false);
        for (Position cell : piece.getShape()) {
            if (position.getX() == cell.getX() && position.getY() == cell.getY()) {
                piece.getShape().remove(position);
            }
        }
        setChanged();
        System.out.println("notifying from empty");
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
