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
    private int points;
    private int level;
    private boolean pieceFalling;
    private List<Piece> existingPieces;


    public TetrisModel() {
        this.level=1;
        this.points = 0;
        this.board = new ModelBoard(4, 15);
       /* this.pieces = new ArrayList<Piece>();*/
        this.points = 0;
        this.pieceFalling = false;

        existingPieces = new ArrayList<Piece>();

        List positions1 = new ArrayList<Position>();
        Position squareCenter = new Position(0, 0, 0);
        positions1.add(squareCenter);
        positions1.add(new Position(0, 1, 0));
        positions1.add(new Position(1, 0, 0));
        positions1.add(new Position(1, 1, 0));

        Piece square = new Piece(positions1);
        square.setCenter(squareCenter);
        existingPieces.add(square);

        List positions2 = new ArrayList<Position>();
        Position stickCenter = new Position(0, 1, 1);
        positions2.add(new Position(0, 0, 1));
        positions2.add(stickCenter);
        positions2.add(new Position(0, 2, 1));
        positions2.add(new Position(0, 3, 1));

        Piece stick = new Piece(positions2);
        stick.setCenter(stickCenter );
        existingPieces.add(stick);

        List positions3 = new ArrayList<Position>();
        Position rightLCenter = new Position(0, 1, 2);
        positions3.add(new Position(0, 0, 2));
        positions3.add(rightLCenter);
        positions3.add(new Position(0, 2, 2));
        positions3.add(new Position(1, 2, 2));

        Piece rightL = new Piece(positions3);
        rightL.setCenter(rightLCenter);
        existingPieces.add(rightL);

        List positions4 = new ArrayList<Position>();
        Position leftLCenter = new Position(1, 1, 3);

        positions4.add(new Position(1, 0, 3));
        positions4.add(leftLCenter);
        positions4.add(new Position(1, 2, 3));
        positions4.add(new Position(0, 2, 3));

        Piece leftL = new Piece(positions4);
        leftL.setCenter(leftLCenter);
      /*  System.out.println("leftLCenter : "+leftLCenter.getX() + leftLCenter.getY());
        System.out.println("Center : "+leftL.getCenter().getX());
        */existingPieces.add(leftL);

        List positions5 = new ArrayList<Position>();
        Position rightZCenter = new Position(1, 0, 4);
        positions5.add(new Position(0, 1, 4));
        positions5.add(new Position(1, 1, 4));
        positions5.add(rightZCenter);
        positions5.add(new Position(2, 0, 4));

        Piece rightZ = new Piece(positions5);
        rightZ.setCenter(rightZCenter);
        existingPieces.add(rightZ);

        List positions6 = new ArrayList<Position>();
        Position leftZCenter = new Position(1, 0, 5);
        positions6.add(new Position(0, 0, 5));
        positions6.add(leftZCenter);
        positions6.add(new Position(1, 1, 5));
        positions6.add(new Position(2, 1, 5));

        Piece leftZ = new Piece(positions6);
        leftZ.setCenter(leftZCenter);
        existingPieces.add(leftZ);

        List positions7 = new ArrayList<Position>();
        Position TCenter = new Position(1, 1, 6);
        positions7.add(new Position(0, 1, 6));
        positions7.add(new Position(1, 0, 6));
        positions7.add(TCenter);
        positions7.add(new Position(2, 1, 6));

        Piece T = new Piece(positions7);
        T.setCenter(TCenter);
        existingPieces.add(T);
    }

    public void addingNewFallingPiece() {

        System.out.print("On ajoute une nouevelle pièce qui tombe ");
       // System.out.println("size of piece "+pieces.size() );

        Random rand = new Random();
        int  n = rand.nextInt(7) ;
        System.out.println("n: "+n);
        /*remplace done*/
        Piece piece  = new Piece(existingPieces.get(2).getShape(), existingPieces.get(n).getCenter());
        //Piece piece  = new Piece(existingPieces.get(n).getShape());

      //  Piece piece  = new Piece(existingPieces.get(2).getShape());

        try {
           /*pieces.set(0, piece);*/

           board.getPieces().get(0).setShape(piece.getShape());
           System.out.println("en remplaçant celle qu'il y avait.");
       }catch (Exception e) {

           System.out.println("en en créant une nouvelle. ");
           piece.Display();
           board.getPieces().add(0, new Piece(piece.getShape(), piece.getCenter()));
       }
            /*remplace done*/




        board.AuthorizedAddPieceOnBoard(piece);
        setPieceFalling(true);
    }

     public void fallingPiece(){
         System.out.println("We are moving the first piece ");
        if (board.movePiece(board.getPieces().get(0), Direction.Down) == 1) {
            pieceFalling = false;
            if(board.getPieces().size() == 1) {
                System.out.println("adding a piece");
                board.getPieces().add(1, new Piece(board.getPieces().get(0).getShape(), board.getPieces().get(0).getCenter()));
                /*remplace*/
               // pieces.add(1, new Piece(pieces.get(0).getShape(), pieces.get(0).getCenter()));
                //pieces.add(1, new Piece(pieces.get(0).getShape()));
            } else {
                    for (Position position : board.getPieces().get(0).getShape()){
                        board.getPieces().get(1).getShape().add(new Position(position.getX(), position.getY(), position.getIdCouleur()));
                    }

            }


        }
    }

    public void rotatePiece(int rotation){
        board.rotatePiece(board.getPieces().get(1), rotation);
    }

    public void removeLine(){
        System.out.println("on verifie la disparition d'un d'une ligne ");

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
                points += level*40;
                indexLine = i;

                /* Creating list of position to remove a whole line*/
                List<Position> list = new ArrayList<Position>();

                for (int a = 0; a<sizeX; a ++) {
                    list.add(new Position(a, i));
                }
                System.out.println("On vide quelque cellules.");
                board.emptyMultipleCells(list, board.getPieces().get(1));
                System.out.println("On fait appel à gravity");
                gravity(indexLine);
            }
        }
    }

    public void gravity(int index) {
       // System.out.println("in gravity : number of pieces : "+board.getPieces().size());

        int c = 0;
        for (Position position : board.getPieces().get(1).getShape()) {
            if (position.getY()<index) {
                c++;
                board.moveOneCell(position, Direction.Down);

            }


        }
      //  System.out.println("bedor calling : "+board.getPieces().size());
        board.udateGrid();
        //System.out.println("counter :"+c);
        setChanged();
        notifyObservers();

    }

    public void newPiece(){

    }

    public List<Piece> getPieces() {
        return board.getPieces();
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

    public int getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }
}
