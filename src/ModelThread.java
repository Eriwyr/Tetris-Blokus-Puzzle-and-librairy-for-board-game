import LibraryBoardGame.Model.Board.ModelBoard;
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
            switch (game) {
                case "Tetris" :
                    /* Uncomment the following to display grid every turn*/
                    //tetrisModel.getBoard().getGrid().Display();
                    if (tetrisModel.isPieceFalling()) {
                        System.out.println("sizes : "+tetrisModel.getPieces().size()+ " "+pieceViews.size());
                        tetrisModel.fallingPiece();
                    }
                    else {
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

