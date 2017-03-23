import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import LibraryBoardGame.ViewController.PieceView;
import LibraryBoardGame.ViewController.PieceViewFactory;
import Tetris.PieceViewTetris;
import Tetris.TetrisModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by maxencebernier on 22/03/2017.
 */
public class GameController extends Application {

    private TetrisModel tetrisModel;
    private List<PieceView> pieceViews;
    private Boolean endgame;
    private String game;


    @Override
    public void start(Stage primaryStage) throws Exception {


        game = "Tetris";
        PieceViewFactory factory = new PieceViewFactory();
        BorderPane borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();
        // gPane.setGridLinesVisible(true);
        /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        initializeGrid(gPane);

        //ToolBar toolbar = new ToolBar();
        //HBox statusbar = new HBox();
        /* borderP.setTop(toolbar);
        borderP.setBottom(statusbar);*/


        borderP.setCenter(gPane);


        switch (game) {
            case "Tetris":
                tetrisModel = new TetrisModel();
                endgame = false;

                pieceViews = new ArrayList<PieceView>();

                // PieceFactory pieceFactory = new PieceFactory();
                //Piece piece = pieceFactory.getPiece("tetris");
                //  Piece piece = new Piece()


                tetrisModel.getBoard().addObserver(new Observer() {

                    @Override
                    public void update(Observable o, Object arg) {
                        switch (game) {
                            case "Tetris":


                                for (int i = 0; i < tetrisModel.getPieces().size(); i++) {
                                    try {
                                        PieceView pieceViewTry = pieceViews.get(i);
                                    } catch (Exception e) {
                                        pieceViews.add(i, factory.getPieceViewTetris(tetrisModel.getPieces().get(i)));
                                    }

                                    new Thread(new Runnable() {
                                        @Override public void run() {
                                            Platform.runLater(new Runnable() {
                                                @Override public void run() {

                                                    /*new version*/
                                                    initializeGrid(gPane);
                                                    pieceViews.clear();
                                                    for (Piece piece : tetrisModel.getPieces()) {
                                                        pieceViews.add(factory.getPieceViewTetris(piece));
                                                    }

                                                    for (PieceView pieceView : pieceViews) {
                                                       for (Rectangle rectangle : pieceView.getShapeView()) {
                                                           gPane.add(rectangle, (int) rectangle.getX(), (int) rectangle.getY());
                                                       }
                                                   }
                                                }
                                            });
                                        }
                                    }).start();
                                }

                                break;
                            default:
                                break;
                        }
                    }
                });

                gPane.setFocusTraversable(true);
                gPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        System.out.println("key press");
                        switch (event.getCode()) {
                            case LEFT: tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Left);
                            case RIGHT: tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Right);
                        }
                    }
                });
                borderP.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        //  model.addPiece(piece);
                        //tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Right);
                    }
                });

                primaryStage.setTitle("Library");
                primaryStage.setScene(new Scene(borderP, 1024, 768));
                primaryStage.show();


                break;
            default:
                break;
        }
        /*
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new ModelThread(tetrisModel, endgame, game, pieceViews));
        ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();
        */


        ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();
        //Execute MonRunnable toutes les secondes
        execute.scheduleAtFixedRate(new  ModelThread(tetrisModel, endgame, game, pieceViews), 0, 600, TimeUnit.MILLISECONDS);
    }


    public void initializeGrid(GridPane gPane){
        try{
            Node node = gPane.getChildren().get(0);
            gPane.getChildren().clear();
            gPane.getChildren().add(0,node);

        } catch(Exception e) {


        }
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 12; b++) {


                Rectangle rectangle = new Rectangle(a, b, 30, 30);
                rectangle.setFill(Color.YELLOW);

                gPane.add(rectangle, a, b);

            }
        }
    }
}


