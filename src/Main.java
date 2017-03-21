import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.ViewController.PieceView;
import Tetris.TetrisModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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


public class Main extends Application {

    private TetrisModel tetrisModel;
    private List<PieceView> pieceViews;
    private Boolean endgame;
    private String game;


    private Timeline colonyTimer = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if(!endgame) {

                try {
                    System.out.println("disply première piece ");
                    tetrisModel.getPieces().get(0).Display();
                } catch(Exception e) {
                    System.out.println("par de première peice à afficher");
                }

                try {
                    System.out.println("disply deuxième  piece ");
                    tetrisModel.getPieces().get(1).Display();;
                } catch (Exception e) {
                    System.out.println("par de deuxième peice à afficher");
                }

               tetrisModel.getBoard().getGrid().Display();
                switch (game) {
                    case "Tetris" :

                        if (tetrisModel.isPieceFalling()) {



                            //tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Down);
                            tetrisModel.fallingPiece();
                        }
                        else {

                            tetrisModel.addingNewFallingPiece();
                            tetrisModel.removeLine();

                            // tetrisModel.removeLine();



                        }

                        break;
                    default:
                        break;
                }

            }
            else
            {
                System.out.println("Simulation finished ");
            }
        }
    }));


    @Override
    public void start(Stage primaryStage) throws Exception {
        game = "Tetris";
        BorderPane borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();
        // gPane.setGridLinesVisible(true);
      /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        for (int a = 0; a < 10; a++) {
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

                borderP.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        //  model.addPiece(piece);

                        //tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Right);
                    }

                });

                primaryStage.setTitle("Library");
                colonyTimer.setCycleCount(Timeline.INDEFINITE);
                colonyTimer.play();

                primaryStage.setScene(new Scene(borderP, 1024, 768));
                primaryStage.show();


                break;
            default:
                break;
        }


        /*
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new ModelThread(tetrisModel, endgame, game));
        ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();
*/


    }




    public static void main(String[] args) {

       launch(args);

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
