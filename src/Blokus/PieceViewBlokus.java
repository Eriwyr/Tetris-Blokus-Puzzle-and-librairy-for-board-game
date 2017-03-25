package Blokus;

import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import LibraryBoardGame.ViewController.PieceView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eriwyr on 25/03/2017.
 */
public class PieceViewBlokus extends PieceView {


    public PieceViewBlokus(Piece piece) {
        shapeView = new ArrayList<Rectangle>();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30);
            switch (position.getIdCouleur()) {
                case 0:
                    rectangle.setId("rectPlayer1");

                    break;
                case 1:
                    rectangle.setId("rectPlayer2");

                    break;
                case 2:
                    rectangle.setId("rectPLayer3");

                    break;
                case 3:
                    rectangle.setId("rectPlayer4");

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
}
