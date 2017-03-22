package LibraryBoardGame.Model.Piece;
import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;

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
                System.out.println("LLLLEEEEFFFFTTTTT");
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

    public void removePosition(Position position) {


        List<String> list = new ArrayList<>();


// This is a clever way to create the iterator and call iterator.hasNext() like
// you would do in a while-loop. It would be the same as doing:
//     Iterator<String> iterator = list.iterator();
//     while (iterator.hasNext()) {
        for (Iterator<Position> iterator = shape.iterator(); iterator.hasNext();) {
            Position cell = iterator.next();
            if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                System.out.println("removing Position : "+position.getX()+" "+position.getY());
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }

        /*
        System.out.println("removing Position ");
        for (Position cell : shape ){
            if (cell.getY() == position.getY() && cell.getX() == position.getX()) {
                shape.remove(cell);
            }
        }
        */
        System.out.println("end of removePosition ");
    }

}
