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
        Piece piece = existingPieces.get(1);
       try {
           pieces.set(0, piece);
       }catch (Exception e) {
           pieces.add(piece);
       }
        board.addPiece(piece);
        board.addPieceOnBoard(piece);
        setPieceFalling(true);
    }

    public void fallingPiece(){
        if (board.movePiece(pieces.get(0), Direction.Down) == 1) {
            pieceFalling = false;
            if(pieces.size() == 1) {
                System.out.println("adding a piece");
                pieces.add(1, pieces.get(0));
            } else {
                /*try {*/
                    for (Position position : pieces.get(0).getShape()){
                        pieces.get(1).getShape().add(position);
                    }
               /* } catch {

                }*/

            }

        }
    }

    public void rotatePiece(int rotation){
        board.rotatePiece(pieces.get(1), rotation);
    }

    public void removeLine(){
        boolean fullLine;
        int sizeX = board.getGrid().getSizeX();
        int count;
        for (int i = 0; i<board.getGrid().getSizeY(); i++) {
            fullLine = false;
            count=0;
            for (int j = 0; j<sizeX; j++) {
                count++;
            }
            if (count == sizeX) {
                for (int a = 0; a<sizeX; a ++) {
                    try {
                        board.emptyCell(new Position(a, i), pieces.get(1));
                    } catch (Exception e) {

                    }

                }
            }
            else if (count == 0)
            break;
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
