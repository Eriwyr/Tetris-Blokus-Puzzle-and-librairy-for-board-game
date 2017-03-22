import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.ViewController.PieceView;
import Tetris.TetrisModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by maxencebernier on 22/03/2017.
 */
public class GameController extends Application {

    private TetrisModel tetrisModel;
    static List<PieceView> pieceViews;
    private Boolean endgame;
    private String game;
    private Scene scene_menu;
    private Button button_tetris;
    private Button button_blokus;
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        game = "Tetris";

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Tetris and Blokus");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setResizable(false);

        BorderPane root = new BorderPane();

        Scene scene_menu = new Scene(root, 1024, 768);
        scene_menu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        root.setId("menu");
        root.applyCss();
       // primaryStage.setBackground(new Background(myBI));


        HBox hbox = new HBox();

        //hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setAlignment(Pos.CENTER);
        this.button_tetris = new Button("Tetris");
        this.button_tetris.setId("tetrisBtn");
        this.button_tetris.applyCss();
        hbox.getChildren().add(button_tetris);
        //root.getChildren().add(hbox);
        root.setCenter(hbox);


        primaryStage.setScene(scene_menu);
        //primaryStage.setScene(new Scene(borderP, 1024, 768));
        BorderPane borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();
        // gPane.setGridLinesVisible(true);
        /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        for (int a = 0; a < 12; a++) {
            for (int b = 0; b < 10; b++) {
                Rectangle rectangle = new Rectangle(a, b, 30, 30);
                rectangle.setFill(Color.YELLOW);

                gPane.add(rectangle, a, b);

            }
        }

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
                                /*
                                System.out.println("pieceView size " + pieceViews.size());
                                System.out.println("pieces in model : " + tetrisModel.getPieces().size());
*/
                                for (int i = 0; i < tetrisModel.getPieces().size(); i++) {
                                    try {
                                        PieceView pieceViewTry = pieceViews.get(i);
                                    } catch (Exception e) {
                                        pieceViews.add(i, new PieceView(tetrisModel.getPieces().get(i)));
                                    }
                                    PieceView pieceView = pieceViews.get(i);

                                    Piece piece = tetrisModel.getPieces().get(i);

                                    new Thread(new Runnable() {
                                        @Override public void run() {
                                            Platform.runLater(new Runnable() {
                                                @Override public void run() {

                                                    /* Old version for debug*/
                                                    /*
                                                    for (int y = 0; y < pieceView.getShapeView().size(); y++) {


                                                        gPane.getChildren().remove(pieceView.getShapeView().get(y));

                                                        pieceView.getShapeView().get(y).setX(piece.getShape().get(y).getX());
                                                        pieceView.getShapeView().get(y).setY(piece.getShape().get(y).getY());

                                                        gPane.add(pieceView.getShapeView().get(y), (int) pieceView.getShapeView().get(y).getX(), (int) pieceView.getShapeView().get(y).getY());


                                                    }*/


                                                    for (int y = 0; y < piece.getShape().size(); y++) {

                                                        // System.out.println("square "+y+" : "+pieceView.getShapeView().get(y).getX()+" " + pieceView.getShapeView().get(y).getY());
                                                        try {
                                                            gPane.getChildren().remove(pieceView.getShapeView().get(y));

                                                            pieceView.getShapeView().get(y).setX(piece.getShape().get(y).getX());
                                                            pieceView.getShapeView().get(y).setY(piece.getShape().get(y).getY());


                                                        } catch (Exception e) {

                                                            pieceView.addCellToPieceView(piece.getShape().get(y).getX(), piece.getShape().get(y).getY());
                                                        }

                                                        gPane.add(pieceView.getShapeView().get(y), (int) pieceView.getShapeView().get(y).getX(), (int) pieceView.getShapeView().get(y).getY());
                                                    }
                                                }
                                            });
                                        }
                                    }).start();
                                }

                                /*


                                for(int h = 0; h<pieceViews.size(); h++) {

                                    PieceView pieceView = pieceViews.get(h);
                                    Piece piece = tetrisModel.getPieces().get(h);

                                    for (int y = 0; y<pieceView.getShapeView().size(); y++) {

                                        // System.out.println("square "+y+" : "+pieceView.getShapeView().get(y).getX()+" " + pieceView.getShapeView().get(y).getY());
                                        gPane.getChildren().remove(pieceView.getShapeView().get(y));

                                        pieceView.getShapeView().get(y).setX( piece.getShape().get(y).getX());
                                        pieceView.getShapeView().get(y).setY( piece.getShape().get(y).getY());

                                        gPane.add(pieceView.getShapeView().get(y), (int)pieceView.getShapeView().get(y).getX(), (int)pieceView.getShapeView().get(y).getY());


                                    }
                                }
*/
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
        execute.scheduleAtFixedRate(new  ModelThread(tetrisModel, endgame, game, pieceViews), 0, 300, TimeUnit.MILLISECONDS);
    }

}


