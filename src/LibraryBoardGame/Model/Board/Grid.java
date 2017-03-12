package LibraryBoardGame.Model.Board;

import LibraryBoardGame.Model.Piece.Position;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Grid {
    private Cell[][] tabCell;
    private int sizeX;
    private int sizeY;


    public Grid(Cell[][] grid) {
        this.tabCell = grid;
    }

    public Grid(int x, int y){
        sizeX=x;
        sizeY=y;
       // System.out.println("contructor ");
        this.tabCell = new Cell[x][y];
        //System.out.println("type : "+ this.tabCell[0][0].getClass());

        for( int i = 0; i <x; i++) {
            for (int j = 0; j<y; j++) {
                tabCell[i][j] = new Cell(true);
                //tabCell[i][j].setEmpty(true);
                //System.out.println("type : "+ this.tabCell[i][j].getClass());
            }
        }
    }

    public void setCellXY(Position position, Boolean bool) {
        tabCell[position.getX()][position.getY()].setEmpty(bool);
    }

    public Cell getCellXY(Position position){
        return tabCell[position.getX()][position.getY()];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void Display() {
        for( int i = 0; i <10; i++) {
            for (int j = 0; j<10; j++) {
                if (tabCell[i][j].isEmpty()) System.out.print(". ");
                else System.out.print("x ");
            }
            System.out.println();
        }
    }
}
