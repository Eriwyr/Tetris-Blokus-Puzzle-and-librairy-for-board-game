package Tetris;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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

        List positions = new ArrayList<Position>();
        positions.add(new Position(0, 0));
        positions.add(new Position(0, 1));
        positions.add(new Position(1, 0));
        positions.add(new Position(1, 1));

        Piece square = new Piece(positions);
        existingPieces.add(square);


        positions.clear();
        positions.add(new Position(0, 0));
        positions.add(new Position(0, 1));
        positions.add(new Position(0, 2));
        positions.add(new Position(0, 3));

        Piece stick = new Piece(positions);
        existingPieces.add(stick);

        positions.clear();
        positions.add(new Position(0, 0));
        positions.add(new Position(0, 1));
        positions.add(new Position(0, 2));
        positions.add(new Position(1, 2));

        Piece rightL = new Piece(positions);
        existingPieces.add(rightL);

        positions.clear();
        positions.add(new Position(1, 0));
        positions.add(new Position(1, 1));
        positions.add(new Position(1, 2));
        positions.add(new Position(0, 2));

        Piece leftL = new Piece(positions);
        existingPieces.add(leftL);

        positions.clear();
        positions.add(new Position(0, 1));
        positions.add(new Position(1, 1));
        positions.add(new Position(1, 2));
        positions.add(new Position(2, 0));

        Piece rightZ = new Piece(positions);
        existingPieces.add(rightZ);

        positions.clear();
        positions.add(new Position(0, 0));
        positions.add(new Position(1, 0));
        positions.add(new Position(1, 1));
        positions.add(new Position(2, 1));

        Piece leftZ = new Piece(positions);
        existingPieces.add(leftZ);

        positions.clear();
        positions.add(new Position(0, 1));
        positions.add(new Position(1, 0));
        positions.add(new Position(1, 1));
        positions.add(new Position(2, 1));

        Piece T = new Piece(positions);
        existingPieces.add(T);







    }

    public void addingNewFallingPiece() {
        Piece piece  = new Piece(existingPieces.get(1).getShape());

       try {
           /*pieces.set(0, piece);*/

           pieces.get(0).setShape(piece.getShape());

       }catch (Exception e) {
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
                        pieces.get(1).getShape().add(new Position(position.getX(), position.getY()));
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
            System.out.println("ligne : "+i+" nb case :"+count);
            if (count == sizeX) {
                indexLine = i;
                System.out.println("line found");

                for (int a = 0; a<sizeX; a ++) {
                    try {
                        board.emptyCell(new Position(a, i), pieces.get(1));
                    } catch (Exception e) {

                    }

                }

                for (Position cell : pieces.get(1).getShape()) {
                    if(cell.getY()>indexLine) {
                        board.getGrid().setCellXY(new Position(cell.getX(), cell.getY()), true);
                        pieces.get(1).getShape().remove(cell);
                        cell.setY(cell.getY()+1);
                        board.getGrid().setCellXY(new Position(cell.getX(), cell.getY()), false);
                        pieces.get(1).getShape().add(cell);
                    }


                }
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
