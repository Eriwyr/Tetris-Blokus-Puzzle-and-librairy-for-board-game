import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.ViewController.PieceView;
import Tetris.TetrisModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {


    public static void main(String[] args) {

       /*launch(args);*/
        javafx.application.Application.launch(GameController.class);


       /* javafx.application.Application.launch(GameController.class);*/
        /*ModelBoard model = new ModelBoard(10,10);
        System.out.println("avant");
        model.getGrid().Display();*/

      /*  PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece("tetris");

        model.addPieceOnBoard(piece);
        System.out.println("après ");
        model.getGrid().Display();

        System.out.println();
        model.rotatePiece(piece, 1);
        model.getGrid().Display();

        System.out.println();
        model.rotatePiece(piece, 1);
        model.getGrid().Display(); */

    }
}
