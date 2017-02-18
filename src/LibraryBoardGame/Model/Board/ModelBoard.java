package LibraryBoardGame.Model.Board;

import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;

import java.util.List;
import java.util.Observable;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class ModelBoard extends Observable{
    private Grid grid;
    private List<Piece> pieces;

    public enum Direction{
        Left, Right, Up, Down;
    }
    public ModelBoard(Grid grid, List<Piece> pieces) {
        this.grid = grid;
        this.pieces = pieces;
    }

    public void movePiece(Piece piece, Direction direction) {
        switch (direction) {
            case Left:
                for (Position position : piece.getShape()) {
                    position.setX(position.getX() - 1);
                }
                break;

            case Right:
                for (Position position : piece.getShape()) {
                    position.setX(position.getX() + 1);
                }
                break;

            case Up:
                for (Position position : piece.getShape()) {
                    position.setY(position.getY() - 1);
                }
                break;

            case Down:
                for (Position position : piece.getShape()) {
                    position.setY(position.getY() + 1);
                }
                break;

        }
    }

    public void emptyCell(List<Position> positions){
        for (Position position:positions){
            grid.getCellXY(position).setEmpty(true);
        }

    }

    public void removePiece(Piece piece){
        for (Position position: piece.getShape()){
            grid.getCellXY(position).setEmpty(true);
        }
    }

}
