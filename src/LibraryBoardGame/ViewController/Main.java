package LibraryBoardGame.ViewController;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.PieceFactory;
import LibraryBoardGame.Model.Piece.Position;
import Tetris.TetrisModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    //ModelBoard model;
    TetrisModel tetrisModel;
    List<PieceView> pieceViews;
    Boolean endgame;
    private String game;


    private Timeline colonyTimer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if(!endgame) {
                switch (game) {
                    case "Tetris" :
                        if (tetrisModel.isPieceFalling()) {
                            // Add a falling piece
                            tetrisModel.getBoard().movePiece(tetrisModel.getPieces().get(0), Direction.Down);
                        }
                        else {
                            tetrisModel.removeLine();
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
    public void start(Stage primaryStage) throws Exception{
        game = "Tetris";
        BorderPane borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();
       // gPane.setGridLinesVisible(true);
      /*  gPane.setHgap(6);
        gPane.setVgap(6);*/

        for (int a = 0; a<10; a++) {
            for (int b= 0; b<10; b++) {
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
            case "Tetris" :
                tetrisModel = new TetrisModel();
                endgame = false;

                pieceViews = new ArrayList<PieceView>();

                // PieceFactory pieceFactory = new PieceFactory();
                //Piece piece = pieceFactory.getPiece("tetris");
                //  Piece piece = new Piece()
                tetrisModel.addObserver(new Observer() {

                    @Override
                    public void update(Observable o, Object arg) {
                        switch (game) {
                            case "Tetris":


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

    }


    public static void main(String[] args) {

        launch(args);
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
