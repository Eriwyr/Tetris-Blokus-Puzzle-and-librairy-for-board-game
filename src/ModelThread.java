import Blokus.BlokusModel;
import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.ViewController.PieceView;
import Tetris.TetrisModel;

import java.util.List;
import java.util.Observable;

/**
 * Created by maxencebernier on 18/03/2017.
 */
public class ModelThread extends Observable implements Runnable {
    private TetrisModel tetrisModel;
    private BlokusModel blokusModel;
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

    public ModelThread(BlokusModel blokusModel, Boolean endgame, String game, List<PieceView> pieceViews) {
        super();
        this.blokusModel = blokusModel;
        this.endgame = endgame;
        this.game = game;
        this.pieceViews = pieceViews;
    }

    @Override
    public void run(){
        if(!endgame) {
            switch (game) {
                case "Tetris" :

                    if (!tetrisModel.isGameOver()) {


                        /* Uncomment the following to display grid every turn*/
                       // tetrisModel.getBoard().getGrid().Display();
                        if (tetrisModel.isPieceFalling()) {
                            tetrisModel.fallingPiece();
                        } else {
                            tetrisModel.addingNewFallingPiece();

                            tetrisModel.removeLine();
                        }
                    }
                    break;

                case "Blokus" :
                    System.out.println("dans thread");
                   // if (blokusModel.lookForWinner() != -1) {
                        if (blokusModel.isAuthorizePlacing(blokusModel.getPieces().get(0), blokusModel.getPieces().get(0).getCenter().getIdCouleur())){
                            blokusModel.removeOption();


                            blokusModel.nextRound();
                        } else {
                            System.out.println("pas autorisé ");
                        }

                    //}


                default:
                    break;
            }
        }
    }


}

