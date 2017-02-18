package LibraryBoardGame.Model.Board;

import LibraryBoardGame.Model.Piece.Position;

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

    public Cell getCellXY(Position position){
        return tabCell[position.getX()][position.getY()];
    }
}
