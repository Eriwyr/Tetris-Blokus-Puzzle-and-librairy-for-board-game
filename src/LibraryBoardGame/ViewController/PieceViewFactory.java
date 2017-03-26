package LibraryBoardGame.ViewController;

import Blokus.PieceViewBlokus;
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

    public PieceView getPieceViewBlokus(Piece piece) {
        System.out.println(" COuleur factory :" + piece.getShape().get(0).getIdCouleur());
        return new PieceViewBlokus(piece);
    }



}
