package LibraryBoardGame.Model.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class PieceFactory {

    public PieceFactory() {
    }

    public Piece getPiece(String type) {
        List<Position> shape = new ArrayList<Position>();

        switch (type) {
            case "tetris" :
                shape.add(new Position(0,0));
                shape.add(new Position(1,0));
                return new Piece(shape);

            case "blokus" :
                shape.add(new Position(0,0));
                shape.add(new Position(1,0));
                return new Piece(shape);
            case "puzzle" :
                shape.add(new Position(0,0));
                shape.add(new Position(1,0));
                return new Piece(shape);
            default:
                return null;
        }

    }
}
