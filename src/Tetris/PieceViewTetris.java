package Tetris;

import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import LibraryBoardGame.ViewController.PieceView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by maxencebernier on 12/03/2017.
 */


public class PieceViewTetris extends PieceView{
    private Text points;


    public PieceViewTetris(Piece piece) {
        //super(piece);
        System.out.println("piece we are trying to view : ");
        piece.Display();


        shapeView = new ArrayList<Rectangle>();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30) ;
            switch (position.getIdCouleur()) {
                case 0 :
                    rectangle.setFill(Color.DARKRED);
                    break;
                case 1 :
                    rectangle.setFill(Color.DEEPPINK);
                    break;
                case 2 :
                    rectangle.setFill(Color.BLUE);
                    break;
                case 3 :
                    rectangle.setFill(Color.CADETBLUE);
                    break;
                case 4 :
                    rectangle.setFill(Color.ROSYBROWN);
                    break;
                case 5 :
                    rectangle.setFill(Color.GREENYELLOW);
                    break;
                case 6 :
                    rectangle.setFill(Color.PEACHPUFF);
                    break;
                case 100 :
                    rectangle.setFill(Color.TRANSPARENT);
                    break;
                default:
                    rectangle.setFill(Color.BLACK);
                    break;
            }

            shapeView.add(rectangle);


        }
        // affichage.setText(m.getValue() + "");

    }

    public void Display() {
        System.out.println("right display ! ");
    }
}
