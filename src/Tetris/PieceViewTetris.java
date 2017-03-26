package Tetris;

import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import LibraryBoardGame.ViewController.PieceView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;


/**
 * Created by maxencebernier on 12/03/2017.
 */


public class PieceViewTetris extends PieceView{
    private Text points;


    public PieceViewTetris(Piece piece) {


        shapeView = new ArrayList<Rectangle>();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30) ;
            switch (position.getIdCouleur()) {
                case 0 :
                    rectangle.setId("rect1");

                    break;
                case 1 :
                    rectangle.setId("rect2");

                    break;
                case 2 :
                    rectangle.setId("rect3");

                    break;
                case 3 :
                    rectangle.setId("rect4");

                    break;
                case 4 :
                    rectangle.setId("rect5");

                    break;
                case 5 :
                    rectangle.setId("rect6");

                    break;
                case 6 :
                    rectangle.setId("rect7");

                    break;
                case 100 :
                    rectangle.setId("rect8");
                    rectangle.setFill(Color.TRANSPARENT);
                    break;
                default:
                    rectangle.setId("rect9");
                    rectangle.setFill(Color.BLACK);
                    break;
            }
            rectangle.setStroke(Color.BLACK);
            shapeView.add(rectangle);
        }
    }

    public PieceViewTetris(Piece piece, Color color) {


        shapeView = new ArrayList<Rectangle>();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30) ;
            switch (position.getIdCouleur()) {
                case 0 :
                    rectangle.setId("rect1");

                    break;
                case 1 :
                    rectangle.setId("rect2");

                    break;
                case 2 :
                    rectangle.setId("rect3");

                    break;
                case 3 :
                    rectangle.setId("rect4");

                    break;
                case 4 :
                    rectangle.setId("rect5");

                    break;
                case 5 :
                    rectangle.setId("rect6");

                    break;
                case 6 :
                    rectangle.setId("rect7");

                    break;
                case 100 :
                    rectangle.setId("rect8");
                    rectangle.setFill(Color.TRANSPARENT);
                    break;
                default:
                    rectangle.setId("rect9");
                    rectangle.setFill(Color.BLACK);
                    break;
            }
            rectangle.setStroke(color);
            shapeView.add(rectangle);
        }
    }
    public void Display() {
        System.out.println("right display ! ");
    }
}
