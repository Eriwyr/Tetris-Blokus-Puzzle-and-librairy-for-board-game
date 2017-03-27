import Blokus.BlokusModel;
import Blokus.PieceViewBlokus;
import LibraryBoardGame.Model.Board.Grid;
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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.java2d.loops.GeneralRenderer;

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

    private GridPane gPane;
    private GridPane gPaneGridBlokus;
    private GridPane gPanePlayer1;
    private GridPane gPanePlayer2;
    private GridPane gPanePlayer3;
    private GridPane gPanePlayer4;

    private BorderPane borderP;
    private BorderPane borderPBlokus;
    private TetrisModel tetrisModel;
    private BlokusModel blokusModel;
    private List<PieceView> pieceViews;
    private List<PieceView> pieceViewsPlayer1;
    private List<PieceView> pieceViewsPlayer2;
    private List<PieceView> pieceViewsPlayer3;
    private List<PieceView> pieceViewsPlayer4;


    private HBox hbtext;
    private Boolean endgame;
    /*private String game;*/
    private Scene scene_menu;
   /* private Scene scene_tetris;*/
   private Scene scene_blokus;
    private Button button_tetris;
    private Button button_blokus;
    private Stage primaryStage;
    private Group tetris_group;
    private Group blokus_group;
    private Text text;
    private Text textLevel;
    PieceViewFactory factory;
    private Text gameOverText;
    private Text joueurText;

    @Override
    public void start(Stage primaryStage) throws Exception {
        factory = new PieceViewFactory();
        pieceViews = new ArrayList<PieceView>();


        // Setting up view for the menu
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Tetris and Blokus");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(766);
        primaryStage.setResizable(true);

        BorderPane root = new BorderPane();

        Scene scene_menu = new Scene(root, 1024, 766);
        scene_menu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        root.setId("menu");
        root.applyCss();

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

        root.setFocusTraversable(true);
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case ESCAPE: System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        });
        //primaryStage.setScene(new Scene(borderP, 1024, 768));

        primaryStage.setScene(scene_menu);

        // Setting up actions for the buttons on the menu
        button_tetris.setOnAction(new EventHandler<ActionEvent>() {
            // Clicking on this button launches Tetris game
            @Override public void handle(ActionEvent e) {
                startSimulation("Tetris");
            }
        });

        button_blokus.setOnAction(new EventHandler<ActionEvent>() {
            // Clicking on this button launches Blockus game
            @Override public void handle(ActionEvent e) {
                startSimulation("Blokus");
            }
        });

        // Showing the menu
        primaryStage.show();


    }


    public void initializeGridTetris(GridPane gPane){
        try{
            Node node = gPane.getChildren().get(0);
            gPane.getChildren().clear();
            gPane.getChildren().add(0,node);

        } catch(Exception e) {


        }

        // Initialing grid
        for (int a = 0; a < tetrisModel.getBoard().getGrid().getSizeY(); a++) {
            for (int b = 0; b <  tetrisModel.getBoard().getGrid().getSizeX(); b++) {
                Rectangle rectangle = new Rectangle(30, 30);
                rectangle.setId("gridTetris");
                rectangle.applyCss();
                gPane.add(rectangle, b, a);
            }
        }
    }


    public void initializeGridPlayers(GridPane gPane){
        try{
            Node node = gPane.getChildren().get(0);
            gPane.getChildren().clear();
            gPane.getChildren().add(0,node);

        } catch(Exception e) {


        }
        for (int a = 0; a <55 ; a++) {
            for (int b = 0; b < 41; b++) {
                Rectangle rectangle = new Rectangle(15, 15);
                rectangle.setId("player1_4");
                rectangle.applyCss();
                gPanePlayer1.add(rectangle, b, a);
            }
        }
    }

    public void initializeGridBlokus(GridPane gPane){
        try{
            Node node = gPaneGridBlokus.getChildren().get(0);
            gPaneGridBlokus.getChildren().clear();
            gPaneGridBlokus.getChildren().add(0,node);

        } catch(Exception e) {


        }

        for (int a = 0; a <54; a++) {
            for (int b = 0; b < 43; b++) {
                Rectangle rectangle = new Rectangle(15, 15);
                rectangle.setId("gridBlokus");
                rectangle.applyCss();
                gPaneGridBlokus.add(rectangle, b, a);
            }
        }
    }



    public Scene settingSceneTetris() {
        primaryStage.setWidth(1024);
        primaryStage.setHeight(750);
        borderP = new BorderPane();
        borderP.setId("tetris");
        // permet de placer les diffrents boutons dans une grille
        gPane = new GridPane();


        // gPane.setGridLinesVisible(true);
        /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        initializeGridTetris(gPane);

        VBox vboxText = new VBox(100);

        vboxText.setAlignment(Pos.CENTER);
        vboxText.setId("vBoxText");
        vboxText.applyCss();
        //ToolBar toolbar = new ToolBar();
        //HBox statusbar = new HBox();
        /* borderP.setTop(toolbar);
        borderP.setBottom(statusbar);*/
        text = new Text();
        text.setId("points");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setText("Start ! ");
        text.applyCss();


        textLevel = new Text();
        textLevel.setId("level");
        textLevel.setTextAlignment(TextAlignment.CENTER);
        textLevel.setText("Level : ");
        textLevel.applyCss();





        gameOverText = new Text();
        gameOverText.setId("gameOverMessage");
        gameOverText.setTextAlignment(TextAlignment.CENTER);
        gameOverText.setText("");
        gameOverText.applyCss();

        vboxText.getChildren().addAll(textLevel,text, gameOverText);

        borderP.setCenter(gPane);
        borderP.setRight(vboxText);

        tetris_group = new Group();
        tetris_group.getChildren().add(borderP);

        Scene scene_tetris = new Scene(tetris_group, 1024, 768);
        scene_tetris.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        return scene_tetris;

    }

    public Scene settingSceneBlokus() {
        primaryStage.setWidth(1358);
        primaryStage.setHeight(903);
        borderPBlokus = new BorderPane();
        borderPBlokus.setId("blokus");
        // permet de placer les diffrents boutons dans une grille
        gPaneGridBlokus = new GridPane();
        gPanePlayer1 = new GridPane();
        gPanePlayer2 = new GridPane();
        gPanePlayer3 = new GridPane();
        gPanePlayer4 = new GridPane();

        gPaneGridBlokus.setId("gPBlokus");
        gPanePlayer1.setId("gP1");


        gPaneGridBlokus.applyCss();
        gPanePlayer1.applyCss();
        borderPBlokus.setCenter(gPaneGridBlokus);
        //borderPBlokus.setLeft(gPanePlayer1);

        //borderP.setLeft(gPanePlayer1);
        //borderP.setLeft(gPanePlayer2);
        //borderP.setRight(gPanePlayer3);
        //borderP.setRight(gPanePlayer4);

        textLevel = new Text();
        textLevel.setId("TEST ");
        textLevel.setTextAlignment(TextAlignment.CENTER);
        textLevel.setText("TEST  : ");
        textLevel.applyCss();

        //gPanePlayer2.getChildren().add(textLevel);

        //working
        //pieceViews.clear(); (no need)
        System.out.println("nombre de pièce chez le joueure 1 : "+blokusModel.getPlayer1().size());
      /*  int offset  =0;
        for (Piece piece : blokusModel.getPlayer1()) {
            //factory.getPieceViewBlokus(piece);
            PieceView pieceView = factory.getPieceViewBlokus(piece);
            System.out.println("couleur Display  :"+piece.getShape().get(0).getIdCouleur());
            for(Rectangle rectangle : pieceView.getShapeView()) {
                rectangle.setX(rectangle.getX()+offset);
                rectangle.applyCss();
                System.out.println(rectangle.getId());

            }
            pieceViewsPlayers.add(pieceView);
            offset += 6;
        }*/

        refreshPlayers();
        VBox vBoxLeft = new VBox(50);
        vBoxLeft.getChildren().addAll(gPanePlayer1, gPanePlayer2);
        borderPBlokus.setLeft(vBoxLeft);
        //boop();



        // gPane.setGridLinesVisible(true);
        /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        initializeGridBlokus(gPaneGridBlokus);

        blokus_group = new Group();
        blokus_group.getChildren().add(borderPBlokus);

        scene_blokus = new Scene(blokus_group, 1366, 900);
        //scene_blokus.setOnKeyPressed(gPaneGridBlokus);
        scene_blokus.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        return scene_blokus;

    }

    public void backToMenu(){

        primaryStage.setScene(scene_menu);
    }

    public void startSimulation(String gameName) {
        switch (gameName) {
            case "Tetris":

                tetrisModel = new TetrisModel();

                Scene scene_tetris = settingSceneTetris();
                primaryStage.setScene(scene_tetris);

                endgame = false;



                // PieceFactory pieceFactory = new PieceFactory();
                // Piece piece = pieceFactory.getPiece("tetris");
                // Piece piece = new Piece()




                tetrisModel.addObserver(new Observer() {
                    @Override
                    public void update(Observable o, Object arg) {
                        System.out.println("new notifing ");


                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {

                                           if( tetrisModel.isGameOver()) {
                                               System.out.println("setting text to game over ");
                                               gameOverText.setText("Game Over ! ");

                                           }
                                    }
                                });
                            }
                        }).start();

                    }
                });

                tetrisModel.getBoard().addObserver(new Observer() {

                    @Override
                    public void update(Observable o, Object arg) {
                        switch (gameName) {
                            case "Tetris":


                                    text.setText(Integer.toString(tetrisModel.getPoints()) + "\n Score");
                                    textLevel.setText("Level : " + Integer.toString(tetrisModel.getLevel()));
                                  /*  for (int i = 0; i < tetrisModel.getPieces().size(); i++) {
                                        try {
                                            PieceView pieceViewTry = pieceViews.get(i);
                                        } catch (Exception e) {
                                            pieceViews.add(i, factory.getPieceViewTetris(tetrisModel.getPieces().get(i)));
                                        }*/

                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Platform.runLater(new Runnable() {
                                                    @Override
                                                    public void run() {

                                                    /*new version*/
                                                        initializeGridTetris(gPane);
                                                        pieceViews.clear();
                                                        for (Piece piece : tetrisModel.getPieces()) {
                                                            pieceViews.add(factory.getPieceViewTetris(piece));
                                                        }

                                                        boop();
                                                    /*
                                                    for (PieceView pieceView : pieceViews) {
                                                       for (Rectangle rectangle : pieceView.getShapeView()) {
                                                          // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                                                           gPane.add(rectangle, (int) rectangle.getX(), (int) rectangle.getY());
                                                       }
                                                   }*/
                                                    }
                                                });
                                            }
                                        }).start();
                                   // }

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
                        switch (event.getCode()) {

                            case LEFT:
                                tetrisModel.movePiece(Direction.Left);
                                break;
                            case RIGHT:
                                tetrisModel.movePiece(Direction.Right);
                                break;
                            case DOWN:
                                tetrisModel.movePiece(Direction.Down);
                                break;
                            case UP:
                                tetrisModel.rotatePiece(1);
                                break;
                            case ESCAPE: backToMenu();
                            default:
                                break;
                        }
                    }
                });
                ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();
                execute.scheduleAtFixedRate(new  ModelThread(tetrisModel, endgame, gameName, pieceViews), 0, 600, TimeUnit.MILLISECONDS);

                break;

            case "Blokus" :

                pieceViewsPlayer1 = new ArrayList<PieceView>();
                pieceViewsPlayer2 = new ArrayList<PieceView>();
                pieceViewsPlayer3 = new ArrayList<PieceView>();
                pieceViewsPlayer4 = new ArrayList<PieceView>();

                blokusModel = new BlokusModel();
                Scene scene_blokus = settingSceneBlokus();
                initializeGridBlokus(gPaneGridBlokus);
                primaryStage.setScene(scene_blokus);

                endgame = false;
                PieceViewFactory factoryBlokus = new PieceViewFactory();
                pieceViews = new ArrayList<PieceView>();

                blokusModel.addObserver(new Observer() {
                    @Override
                    public void update(Observable o, Object arg) {


                        new Thread(new Runnable() {
                            @Override public void run() {
                                Platform.runLater(new Runnable() {
                                    @Override public void run() {

                                        System.out.println("udaote");
                                       // initializeGridPlayers(gPanePlayer1);
                                       /* pieceViewsPlayers.clear();

                                        int count = 0;
                                        for (Piece piece : blokusModel.getPlayer1()) {
                                            if (count == blokusModel.getIndexSelectedPiece()) {
                                                System.out.println("truvé indice selevtionné");
                                                pieceViewsPlayers.add(factory.getPieceViewBlokus(piece, Color.GREEN));
                                            } else {


                                                pieceViewsPlayers.add(factory.getPieceViewBlokus(piece));
                                            }
                                            count++;
                                        }*/
                                        refreshPlayers();

                                    }
                                });
                            }
                        }).start();


                    }
                });

                blokusModel.getBoard().addObserver(new Observer() {

                    @Override
                    public void update(Observable o, Object arg) {
                        switch (gameName) {
                            case "Blokus":
                                gPaneGridBlokus.getChildren().remove(textLevel);
                                //text.setText(Integer.toString(tetrisModel.getPoints()) + "\n Score");
                                //extLevel.setText("Level : "+Integer.toString(tetrisModel.getLevel()));


                                    new Thread(new Runnable() {
                                        @Override public void run() {
                                            Platform.runLater(new Runnable() {
                                                @Override public void run() {

                                                    /*new version*/
                                                    initializeGridBlokus(gPaneGridBlokus);
                                                    pieceViews.clear();
                                                    for (Piece piece : blokusModel.getPieces()) {
                                                        pieceViews.add(factoryBlokus.getPieceViewBlokus(piece));
                                                    }

                                                    boopBlokus();
                                                    /*
                                                    for (PieceView pieceView : pieceViews) {
                                                       for (Rectangle rectangle : pieceView.getShapeView()) {
                                                          // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                                                           gPane.add(rectangle, (int) rectangle.getX(), (int) rectangle.getY());
                                                       }
                                                   }*/
                                                }
                                            });
                                        }
                                    }).start();
                                break;

                            default:
                                break;
                        }


                    }
                });




                borderPBlokus.setFocusTraversable(true);
                borderPBlokus.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {

                        switch (event.getCode()) {

                            case S:
                                blokusModel.selectNextPiece(Direction.Left);
                                break;
                            case D:
                                blokusModel.selectNextPiece(Direction.Right);
                                break;
                            case R:
                                blokusModel.rotatePiece();
                                break;

                            case LEFT:
                                blokusModel.movePiece(Direction.Left);
                                break;
                            case UP:
                                blokusModel.movePiece(Direction.Up);
                                break;
                            case DOWN:
                                blokusModel.movePiece(Direction.Down);
                                break;
                            case RIGHT:
                                blokusModel.movePiece(Direction.Right);

                                break;
                            case ENTER:


                                Executor executor = Executors.newSingleThreadExecutor();
                                executor.execute(new  ModelThread(blokusModel, endgame, gameName, pieceViews));
                                    break;
                            case ESCAPE: System.exit(0);
                                break;
                            default:
                                break;


                        }
                        //blokusModel.getBoard().getGrid().Display();
                        System.out.println();
                    }
                });

                /*gPaneGridBlokus.setFocusTraversable(true);
                gPaneGridBlokus.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        System.out.println("keyy pressed 1");
                        switch (event.getCode()) {

                            case RIGHT:

                                System.out.println("right pressed !!");
                                break;

                            case LEFT:

                                System.out.println("left pressed !!");
                                break;
                            case ESCAPE: System.exit(0);
                                break;
                            default:
                                break;
                        }
                    }
                });*/
                break;

            default:
                break;
        }


    }


    public synchronized void boop() {
        for (PieceView pieceView : pieceViews) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPane.add(rectangle, (int) rectangle.getX(), (int) rectangle.getY());
            }
        }
    }

    public synchronized void boopBlokus() {
        for (PieceView pieceView : pieceViews) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPaneGridBlokus.add(rectangle, (int) rectangle.getX(), (int) rectangle.getY());
            }
        }
    }

    public synchronized void refreshPlayers() {
        int space = 2;

        int padding_left = 1;
        initializeGridPlayers(gPanePlayer1);

        pieceViewsPlayer1.clear();
        pieceViewsPlayer2.clear();
        pieceViewsPlayer3.clear();
        pieceViewsPlayer4.clear();

        int count = 0;
        for (Piece piece : blokusModel.getPlayer1()) {
            if (count == blokusModel.getIndexSelectedPiece() && blokusModel.getRound()%4==0) {
                pieceViewsPlayer1.add(factory.getPieceViewBlokus(piece, Color.GREEN));
            } else {
                pieceViewsPlayer1.add(factory.getPieceViewBlokus(piece));
            }
            count++;
        }
        count=0;
        for (Piece piece : blokusModel.getPlayer2()) {
            if (count == blokusModel.getIndexSelectedPiece()&&blokusModel.getRound()%4==1) {
                pieceViewsPlayer2.add(factory.getPieceViewBlokus(piece, Color.GREEN));
            } else {
                pieceViewsPlayer2.add(factory.getPieceViewBlokus(piece));
            }
            count++;
        }
        count=0;
        for (Piece piece : blokusModel.getPlayer3()) {
            if (count == blokusModel.getIndexSelectedPiece()&&blokusModel.getRound()%4==2) {
                pieceViewsPlayer3.add(factory.getPieceViewBlokus(piece, Color.GREEN));
            } else {
                pieceViewsPlayer3.add(factory.getPieceViewBlokus(piece));
            }
            count++;
        }
        count=0;
        for (Piece piece : blokusModel.getPlayer4()) {
            if (count == blokusModel.getIndexSelectedPiece()&&blokusModel.getRound()%4==3) {
                pieceViewsPlayer4.add(factory.getPieceViewBlokus(piece, Color.GREEN));
            } else {
                pieceViewsPlayer4.add(factory.getPieceViewBlokus(piece));
            }
            count++;
        }



        //  gPanePlayer1.setHgap(10); //horizontal gap in pixels => that's what you are asking for
      //  gPanePlayer1.setVgap(10);

        //only one player for now
        int offset1 = 0;
        for (PieceView pieceView : pieceViewsPlayer1) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPanePlayer1.add(rectangle, (int) rectangle.getX()+(offset1%10)*4+padding_left, (int) rectangle.getY()+((offset1/10)*5)+space);
            }
            offset1 +=1;
        }
        offset1 =0;
        space+=13;
        for (PieceView pieceView : pieceViewsPlayer2) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPanePlayer1.add(rectangle, (int) rectangle.getX()+(offset1%10)*4+padding_left, (int) rectangle.getY()+((offset1/10)*5)+space);
            }
            offset1 +=1;
        }
        offset1 = 0;
        space +=13;
        for (PieceView pieceView : pieceViewsPlayer3) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPanePlayer1.add(rectangle, (int) rectangle.getX()+(offset1%10)*4+padding_left, (int) rectangle.getY()+((offset1/10)*5)+space);
            }
            offset1 +=1;
        }
        space +=13;
        offset1 = 0;
        for (PieceView pieceView : pieceViewsPlayer4) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                // System.out.println((int) rectangle.getX()+" "+ (int) rectangle.getY());
                gPanePlayer1.add(rectangle, (int) rectangle.getX()+(offset1%10)*4+padding_left, (int) rectangle.getY()+((offset1/10)*5)+space);
            }
            offset1 +=1;
        }
    }



}


