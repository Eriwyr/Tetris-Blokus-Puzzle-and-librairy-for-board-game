package LibraryBoardGame.Model.Piece;
import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Iterator;
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


    public List<Position> getShape() {
        return shape;
    }

    public void Display() {
        for (Position position : shape) {
            System.out.println(position.getX()+" "+position.getY()+" (color : "+position.getIdCouleur()+")");
        }
        System.out.println();
    }

    public List<Position> anticipationCalc(Direction direction){
        List<Position> anticipatePosition = new ArrayList<Position>();

        switch (direction) {
            case Left:
                System.out.println("LLLLEEEEFFFFTTTTT");
                for (Position position : shape) {
                    anticipatePosition.add(new Position(position.getX() - 1, position.getY(), position.getIdCouleur()));
                }


                break;

            case Right:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX() + 1, position.getY(), position.getIdCouleur()));
                }

                break;

            case Up:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX(), position.getY() - 1, position.getIdCouleur()));
                }

                break;

            case Down:
                for (Position position : shape) {

                    anticipatePosition.add(new Position(position.getX(), position.getY() + 1, position.getIdCouleur()));
                }

                break;
        }

        return anticipatePosition;
    }

    public void setShape(List<Position> shape) {
        this.shape = shape;
    }

    public void removePosition(Position position) {


        List<String> list = new ArrayList<>();


        for (Iterator<Position> iterator = shape.iterator(); iterator.hasNext();) {
            Position cell = iterator.next();
            if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                System.out.println("removing Position : "+position.getX()+" "+position.getY());
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }

        System.out.println("end of removePosition ");
    }

    public Position getCenter() {
        return this.center;
    }

    public  void setCenter(Position center) {
        this.center = center;
    }
}
