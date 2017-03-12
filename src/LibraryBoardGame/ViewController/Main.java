package LibraryBoardGame.ViewController;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.PieceFactory;
import LibraryBoardGame.Model.Piece.Position;
import javafx.application.Application;
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

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    ModelBoard model;
    List<PieceView> pieceViews;

    @Override
    public void start(Stage primaryStage) throws Exception{
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


        model = new ModelBoard(10,10);
        int i= 0;
        for (Piece piece : model.getPieces()) {

            piece.Display();
        }


        pieceViews = new ArrayList<PieceView>();

        int j = 0;
        for (Piece piece: model.getPieces()){

            for (Position position: piece.getShape()) {
                try {
                    pieceViews.set(i, new PieceView(piece));
                } catch (IndexOutOfBoundsException e) {
                    pieceViews.add(new PieceView(piece));
                }






                       /* Rectangle r = new Rectangle();
                        r.setX(position.getX()*30);
                        r.setY(position.getY()*30);
                        r.setWidth(30);
                        r.setHeight(30);
                        r.setFill(Color.RED);
                        */

                //borderP.getChildren().add(r);
            }
            j ++;
        }

        for (PieceView pieceView : pieceViews) {
            for (Rectangle rectangle : pieceView.getShapeView()) {
                //gPane.clearConstraints(rectangle);

                gPane.add(rectangle, (int)rectangle.getX(), (int)rectangle.getY());
            }
        }

       // PieceFactory pieceFactory = new PieceFactory();
        //Piece piece = pieceFactory.getPiece("tetris");
      //  Piece piece = new Piece()
        model.addObserver(new Observer() {



            @Override
            public void update(Observable o, Object arg) {



                       /* Rectangle r = new Rectangle();
                        r.setX(position.getX()*30);
                        r.setY(position.getY()*30);
                        r.setWidth(30);
                        r.setHeight(30);
                        r.setFill(Color.RED);
                        */

                        //borderP.getChildren().add(r);





                // Removing old rectangle and adding new one


                for(int h = 0; h<pieceViews.size(); h++) {

                    PieceView pieceView = pieceViews.get(h);
                    Piece piece = model.getPieces().get(h);

                    for (int y = 0; y<pieceView.getShapeView().size(); y++) {


                        // System.out.println("square "+y+" : "+pieceView.getShapeView().get(y).getX()+" " + pieceView.getShapeView().get(y).getY());
                        gPane.getChildren().remove(pieceView.getShapeView().get(y));

                        pieceView.getShapeView().get(y).setX( piece.getShape().get(y).getX());
                        pieceView.getShapeView().get(y).setY( piece.getShape().get(y).getY());

                        gPane.add(pieceView.getShapeView().get(y), (int)pieceView.getShapeView().get(y).getX(), (int)pieceView.getShapeView().get(y).getY());


                    }
                }






/*
                List<Node> rectangleChildren = new ArrayList<Node>();
                rectangleChildren = gPane.getChildren();

                System.out.println("Children : ");
                for(Node node : rectangleChildren) {

                    System.out.println("X : "+node.getLayoutX()+ " Y : "+ node.getLayoutY());
                }
*/

                /*
                List<Node> rectangleChildren = new ArrayList<Node>();
                rectangleChildren = gPane.getChildren();
*/

            }
        });

     /*   // on efface affichage lors du clic
        affichage.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                affichage.setText("");
            }

        });*/

        borderP.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
              //  model.addPiece(piece);
                model.movePiece(model.getPieces().get(0), Direction.Right);
            }

        });

        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(borderP, 1024, 768));
        primaryStage.show();
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
