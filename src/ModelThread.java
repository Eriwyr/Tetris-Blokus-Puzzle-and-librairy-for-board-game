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
        System.out.println("running");
        System.out.println(" \" "+game+" \" ");
        if(!endgame) {
            System.out.println("not endgame");
            switch (game) {
                case "Tetris" :

                    if (tetrisModel.isPieceFalling()) {
                        System.out.println("sizes : "+tetrisModel.getPieces().size()+ " "+pieceViews.size());

                        tetrisModel.fallingPiece();
                    }
                    else {
                        System.out.println("no piece is falling");

                        tetrisModel.addingNewFallingPiece();

                        // tetrisModel.removeLine();

                    }

                    break;
                default:
                    break;
            }
        }
        System.out.println("Simulation finished ");
    }
}

