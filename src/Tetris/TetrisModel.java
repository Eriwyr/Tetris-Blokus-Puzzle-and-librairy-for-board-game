package Tetris;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * Created by maxencebernier on 12/03/2017.
 */
public class TetrisModel extends Observable {
    private ModelBoard board;
    private List<Piece> pieces;
    private int points;
    private boolean pieceFalling;
    private List<Piece> existingPieces;


    public TetrisModel() {
        this.board = new ModelBoard();
        this.pieces = new ArrayList<Piece>();
        this.points = 0;
        this.pieceFalling = false;

        existingPieces = new ArrayList<Piece>();

        List positions1 = new ArrayList<Position>();
        positions1.add(new Position(0, 0, 0));
        positions1.add(new Position(0, 1, 0));
        positions1.add(new Position(1, 0, 0));
        positions1.add(new Position(1, 1, 0));

        Piece square = new Piece(positions1);
        existingPieces.add(square);

        List positions2 = new ArrayList<Position>();
        positions2.add(new Position(0, 0, 1));
        positions2.add(new Position(0, 1, 1));
        positions2.add(new Position(0, 2, 1));
        positions2.add(new Position(0, 3, 1));

        Piece stick = new Piece(positions2);
        existingPieces.add(stick);

        List positions3 = new ArrayList<Position>();
        positions3.add(new Position(0, 0, 2));
        positions3.add(new Position(0, 1, 2));
        positions3.add(new Position(0, 2, 2));
        positions3.add(new Position(1, 2, 2));

        Piece rightL = new Piece(positions3);
        existingPieces.add(rightL);

        List positions4 = new ArrayList<Position>();
        positions4.add(new Position(1, 0, 3));
        positions4.add(new Position(1, 1, 3));
        positions4.add(new Position(1, 2, 3));
        positions4.add(new Position(0, 2, 3));

        Piece leftL = new Piece(positions4);
        existingPieces.add(leftL);

        List positions5 = new ArrayList<Position>();
        positions5.add(new Position(0, 1, 4));
        positions5.add(new Position(1, 1, 4));
        positions5.add(new Position(1, 2, 4));
        positions5.add(new Position(2, 0, 4));

        Piece rightZ = new Piece(positions5);
        existingPieces.add(rightZ);

        List positions6 = new ArrayList<Position>();
        positions6.add(new Position(0, 0, 5));
        positions6.add(new Position(1, 0, 5));
        positions6.add(new Position(1, 1, 5));
        positions6.add(new Position(2, 1, 5));

        Piece leftZ = new Piece(positions6);
        existingPieces.add(leftZ);

        List positions7 = new ArrayList<Position>();
        positions7.add(new Position(0, 1, 6));
        positions7.add(new Position(1, 0, 6));
        positions7.add(new Position(1, 1, 6));
        positions7.add(new Position(2, 1, 6));

        Piece T = new Piece(positions7);
        existingPieces.add(T);
    }

    public void addingNewFallingPiece() {
        System.out.println("every ossible piece (size) : "+existingPieces.size());

        Random rand = new Random();

        int  n = rand.nextInt(6) + 1;
        System.out.println("n: "+n);

        Piece piece  = new Piece(existingPieces.get(n).getShape());

        System.out.println("Piece choisie : ");
        piece.Display();

       try {
           /*pieces.set(0, piece);*/
           System.out.println("try to set following shape :");
           piece.Display();

           pieces.get(0).setShape(piece.getShape());

       }catch (Exception e) {

           System.out.println("catch : piece added :");
           piece.Display();
           pieces.add(0, new Piece(piece.getShape()));
       }

        board.AuthorizedAddPieceOnBoard(piece);
        setPieceFalling(true);
    }

     public void fallingPiece(){
        if (board.movePiece(pieces.get(0), Direction.Down) == 1) {
            pieceFalling = false;
            if(pieces.size() == 1) {
                System.out.println("adding a piece");
                pieces.add(1, new Piece(pieces.get(0).getShape()));
            } else {
                    for (Position position : pieces.get(0).getShape()){
                        pieces.get(1).getShape().add(new Position(position.getX(), position.getY(), position.getIdCouleur()));
                    }

            }


        }
    }

    public void rotatePiece(int rotation){
        board.rotatePiece(pieces.get(1), rotation);
    }

    public void removeLine(){
        int sizeX = board.getGrid().getSizeX();
        int sizeY = board.getGrid().getSizeY();
        int count;
        int indexLine;

        for (int i = 0; i<sizeY; i++) {
            count=0;
            for (int j = 0; j<sizeX; j++) {
                if(!board.getGrid().getCellXY(new Position(j,i)).isEmpty()){

                    count++;
                }

            }
            if (count == sizeX) {
                indexLine = i;
                System.out.println("line found");

                System.out.println("Will remove "+sizeX+"positions");

                /* Creating list of position to remove a whole line*/
                List<Position> list = new ArrayList<Position>();


                for (int a = 0; a<sizeX; a ++) {
                    list.add(new Position(a, i)); //TODO : add default color
                }


                board.emptyMultipleCells(list, pieces.get(1));

            }
        }

    }

    public void newPiece(){

    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public ModelBoard getBoard() {
        return board;
    }

    public boolean isPieceFalling() {
        return pieceFalling;
    }

    public void setPieceFalling(boolean pieceFalling) {
        this.pieceFalling = pieceFalling;
    }
}
