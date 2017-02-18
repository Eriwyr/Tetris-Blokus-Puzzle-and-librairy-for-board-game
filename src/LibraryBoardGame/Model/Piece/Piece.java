package LibraryBoardGame.Model.Piece;
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
}
