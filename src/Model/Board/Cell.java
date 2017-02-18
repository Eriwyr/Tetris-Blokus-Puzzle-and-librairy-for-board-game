package Model.Board;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Cell {
    private Boolean empty;


    public Cell(Boolean empty) {
        this.empty = empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public Boolean isEmpty() {
        return empty;
    }

}
