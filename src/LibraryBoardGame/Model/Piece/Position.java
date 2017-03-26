package LibraryBoardGame.Model.Piece;

import LibraryBoardGame.Model.Direction;

/**
 * Created by Eriwyr on 18/02/2017.
 */
public class Position {
    private int x;
    private int y;
    private int idCouleur;

    public Position(int x, int y) {
        this.idCouleur = 10;
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

    public Position anticipatePosition(Direction direction) {
        switch (direction) {
            case Left :
                return new Position(x-1, y, idCouleur);

            case Right :
                return new Position(x+1, y, idCouleur);

            case Up :
                return new Position(x, y-1, idCouleur);

            case Down :
                return new Position(x, y+1, idCouleur);

            default :
                return this;

        }
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }
    public void Display() {
        System.out.println(x+" "+y);
    }
}
