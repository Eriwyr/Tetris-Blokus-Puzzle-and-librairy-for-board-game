import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.ViewController.PieceView;
import Tetris.TetrisModel;

import java.util.List;

/**
 * Created by maxencebernier on 18/03/2017.
 */
public class ModelThread implements Runnable {
    private TetrisModel tetrisModel;
    private Boolean endgame;
    private String game;
    private List<PieceView> pieceViews; /*Debug*/


    public ModelThread(TetrisModel tetrisModel, Boolean endgame, String game, List<PieceView> pieceViews) {
        super();
        this.tetrisModel = tetrisModel;
        this.endgame = endgame;
        this.game = game;
        this.pieceViews = pieceViews;
    }

    @Override
    public void run(){
        if(!endgame) {
            tetrisModel.getBoard().getGrid().Display();
              try {
                  int i =0;
                  System.out.println("On a actuellement "+tetrisModel.getPieces().size() + " pièces dans le model. (Soit "+tetrisModel.getBoard().getPieces().size()+" pièces sur le plateau)");
                    for (Piece piece : tetrisModel.getPieces()) {
                        try {
                            System.out.println("Pièce numéro "+i);
                            piece.Display();

                        } catch (Exception e) {

                        }
                        i++;
                    }
              } catch (Exception e) {

              }
            switch (game) {
                case "Tetris" :
                    /* Uncomment the following to display grid every turn*/
                    //tetrisModel.getBoard().getGrid().Display();
                    if (tetrisModel.isPieceFalling()) {
                        System.out.println("We have a piece falling at this turn.");
                        tetrisModel.fallingPiece();
                    }
                    else {
                        System.out.println("No piece is falling at this trun.");
                        tetrisModel.addingNewFallingPiece();

                        tetrisModel.removeLine();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

