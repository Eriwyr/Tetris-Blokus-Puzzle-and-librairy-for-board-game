package LibraryBoardGame.ViewController;

import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;

import java.util.ArrayList;
import java.util.List;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by maxencebernier on 28/02/2017.
 */
public class PieceView {
    //private Piece piece;
    // private Position center;

    protected List<Rectangle> shapeView;

    public PieceView() {
        shapeView = new ArrayList<Rectangle>();

    }

    public PieceView(Piece piece) {
        shapeView = new ArrayList<Rectangle>();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30) ;
            rectangle.setFill(Color.RED);

            shapeView.add(rectangle);

         }

    }

    public List<Rectangle> getShapeView() {
        return shapeView;
    }

    public void Display() {
        for (Rectangle rectangle: shapeView) {
            System.out.println(rectangle.getX()+" "+rectangle.getY());
        }
    }
    /*
    public void updateShapeView(Piece piece) {
        shapeView.clear();
        for (Position position : piece.getShape()) {
            Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 30, 30) ;
            rectangle.setFill(Color.RED);

            shapeView.add(rectangle);

        }
        */

        public void addCellToPieceView (int x, int y ) {
            Rectangle rectangle = new Rectangle(x, y, 30, 30) ;
            rectangle.setFill(Color.RED);

            shapeView.add(rectangle);
        }
    }



