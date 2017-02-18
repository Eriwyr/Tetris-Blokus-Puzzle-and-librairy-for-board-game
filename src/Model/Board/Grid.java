package Model.Board;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Grid {
    private Cell[][] tabCell;

    public Grid(Cell[][] grid) {
        this.tabCell = grid;
    }

    public Grid(int x, int y){
        this.tabCell = new Cell[x][y];
    }
}
