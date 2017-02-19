package LibraryBoardGame.ViewController;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.PieceFactory;
import LibraryBoardGame.Model.Piece.Position;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    ModelBoard model;
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane borderP = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();


        model = new ModelBoard(10,10);

        PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece("tetris");
        model.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                for (Piece piece: model.getPieces()){
                    for (Position position: piece.getShape()) {
                        System.out.println("oIQSHD");
                        Rectangle r = new Rectangle();
                        r.setX(position.getX()*30);
                        r.setY(position.getY()*30);
                        r.setWidth(30);
                        r.setHeight(30);
                        r.setFill(Color.RED);
                        borderP.getChildren().add(r);

                    }

                }
            }
        });
        borderP.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                model.addPiece(piece);
                model.movePiece(piece, ModelBoard.Direction.Right);
            }

        });
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(borderP, 1024, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {

        // launch(args);
        ModelBoard model = new ModelBoard(10,10);
        System.out.println("avant");
        model.getGrid().Display();
        PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece("tetris");

        model.addPieceOnBoard(piece);
        System.out.println("après ");
        model.getGrid().Display();

        System.out.println();
        model.movePiece(piece, ModelBoard.Direction.Down);
        model.getGrid().Display();

    }
}
