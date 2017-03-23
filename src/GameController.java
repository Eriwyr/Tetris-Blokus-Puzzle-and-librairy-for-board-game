import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
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
import javafx.scene.Node;
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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by maxencebernier on 22/03/2017.
 */
public class GameController extends Application {

    private GridPane gPane;
    private BorderPane borderP;
    private TetrisModel tetrisModel;
    static List<PieceView> pieceViews;
    private Boolean endgame;
    /*private String game;*/
    private Scene scene_menu;
    private Button button_tetris;
    private Button button_blokus;
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        //game = "null";

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


        VBox vbox = new VBox(100);

        //vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setAlignment(Pos.CENTER);
        this.button_tetris = new Button("Tetris");
        this.button_tetris.setId("tetrisBtn");
        this.button_tetris.applyCss();


        this.button_blokus = new Button("Blokus");
        this.button_blokus.setId("blokusBtn");
        this.button_blokus.applyCss();
        vbox.getChildren().addAll(button_tetris, button_blokus);

        root.setCenter(vbox);


        primaryStage.setScene(scene_menu);
        //primaryStage.setScene(new Scene(borderP, 1024, 768));
         borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
         gPane = new GridPane();
        // gPane.setGridLinesVisible(true);
        /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        initializeGrid(gPane);

        //ToolBar toolbar = new ToolBar();
        //HBox statusbar = new HBox();
        /* borderP.setTop(toolbar);
        borderP.setBottom(statusbar);*/


        borderP.setCenter(gPane);


        button_tetris.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {


                startSimulation("Tetris");
                ///////SET LEVEL OF ANTS
                /*game = "Tetris";*/

                System.out.println("button clicked");
            }
        });
        primaryStage.show();


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

    public void startSimulation(String gameName) {
        switch (gameName) {
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
                        System.out.println("updating");
                        switch (gameName) {
                            case "Tetris":


                                for (int i = 0; i < tetrisModel.getPieces().size(); i++) {
                                    try {
                                        PieceView pieceViewTry = pieceViews.get(i);
                                    } catch (Exception e) {
                                        System.out.println("cache in GameController update");
                                        pieceViews.add(i, new PieceView(tetrisModel.getPieces().get(i)));
                                    }

                                    PieceView pieceView = pieceViews.get(i);
                                    Piece piece = tetrisModel.getPieces().get(i);

                                    new Thread(new Runnable() {
                                        @Override public void run() {
                                            Platform.runLater(new Runnable() {
                                                @Override public void run() {
                                                    /*new version*/
                                                    initializeGrid(gPane);
                                                    pieceViews.clear();
                                                    for (Piece piece : tetrisModel.getPieces()) {
                                                        pieceViews.add(new PieceView(piece));
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





                break;
            default:
                break;
        }

        ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();
        //Execute MonRunnable toutes les secondes
        execute.scheduleAtFixedRate(new  ModelThread(tetrisModel, endgame, gameName, pieceViews), 0, 600, TimeUnit.MILLISECONDS);
    }
}


