package LibraryBoardGame.Model.Piece;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Position {
    private int x;
    private int y;
    private int idCouleur;

    public Position(int x, int y) {
        this.idCouleur = 0;
        this.x = x;
        this.y = y;
    }


    public Position(int x, int y, int idColor) {
        this.x = x;
        this.y = y;
        this.idCouleur = idColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getIdCouleur() {
        return idCouleur;
    }
}
