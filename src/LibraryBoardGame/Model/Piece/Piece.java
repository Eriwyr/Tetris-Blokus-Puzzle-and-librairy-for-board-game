package LibraryBoardGame.Model.Piece;
import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import javafx.geometry.Pos;
import sun.jvm.hotspot.runtime.posix.POSIXSignals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Piece {
    protected List<Position> shape;
    protected Position center;

    public Piece(List<Position> shape) {
        this.shape = shape;
        //this.center = center;
    }

    public Piece(List<Position> shape, Position center) {
        this.shape = shape;
        this.center = center;
    }

    public void addBox(Position p){
        //TODO add correct verification
        shape.add(p);
    }

    public Boolean removeBox(Position p){
        boolean ok;
        ok = false;
        if(shape.contains(p)){
            shape.remove(p);
            ok =true;
        }
        return ok;
    }

    public Position getCenter() {
        return center;
    }

    public List<Position> getShape() {
        return shape;
    }

    public void Display() {
        for (Position position : shape) {
            System.out.println(position.getX()+" "+position.getY());
        }
        System.out.println();
    }

    public List<Position> anticipationCalc(Direction direction){
        List<Position> anticipatePosition = new ArrayList<Position>();

        switch (direction) {
            case Left:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX() - 1, position.getY()));
                }


                break;

            case Right:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX() + 1, position.getY()));
                }

                break;

            case Up:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX(), position.getY() - 1));
                }

                break;

            case Down:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX(), position.getY() + 1));
                }

                break;
        }

        return anticipatePosition;
    }

    public void setShape(List<Position> shape) {
        this.shape = shape;
    }

}
