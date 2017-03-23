package LibraryBoardGame.ViewController;

import LibraryBoardGame.Model.Piece.Piece;
import Tetris.PieceViewTetris;

/**
 * Created by maxencebernier on 23/03/2017.
 */
public class PieceViewFactory {

    public PieceViewFactory() {
    }

    public PieceView getPieceViewTetris(Piece piece) {
        return new PieceViewTetris(piece);
    }

}
