package Blokus;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;

import java.util.ArrayList;

import java.util.List;
import java.util.Observable;

/**
 * Created by Eriwyr on 25/03/2017.
 */
public class BlokusModel extends Observable{
    private ModelBoard board;
    private List<Piece> existingPieces;
    private List<Piece> player1;
    private List<Piece> player2;
    private List<Piece> player3;
    private List<Piece> player4;
    /*private Piece currentPiece;*/
    private int indexSelectedPiece;
    private boolean pieceSelected;
    private int round;

        public BlokusModel(){
            /*currentPiece = new Piece();*/
            indexSelectedPiece= 0;
            pieceSelected = true;

            this.board = new ModelBoard(12, 20);

            player1 = new ArrayList<Piece>();
            player2 = new ArrayList<Piece>();
            player3 = new ArrayList<Piece>();
            player4 = new ArrayList<Piece>();

            existingPieces = new ArrayList<Piece>();

            List positions0 = new ArrayList<Position>();
            Position cellCenter = new Position(0, 0, 0);
            positions0.add(cellCenter);

            Piece cell = new Piece(positions0);
            cell.setCenter(cellCenter);
            existingPieces.add(cell);

            List positions1 = new ArrayList<Position>();
            Position squareCenter = new Position(0, 0, 0);
            positions1.add(squareCenter);
            positions1.add(new Position(0, 1, 0));
            positions1.add(new Position(1, 0, 0));
            positions1.add(new Position(1, 1, 0));

            Piece square = new Piece(positions1);
            square.setCenter(squareCenter);
            existingPieces.add(square);

            List positions2 = new ArrayList<Position>();
            Position stickCenter = new Position(0, 2, 1);
            positions2.add(new Position(0, 0, 1));
            positions2.add(new Position(0,1,1));
            positions2.add(stickCenter);
            positions2.add(new Position(0, 3, 1));
            positions2.add(new Position(0, 4, 1));

            Piece stick = new Piece(positions2);
            stick.setCenter(stickCenter );
            existingPieces.add(stick);


            List positions3 = new ArrayList<Position>();
            Position rightLCenter = new Position(0, 2, 2);
            positions3.add(new Position(0, 0, 2));
            positions3.add(new Position(0, 1, 2));
            positions3.add(rightLCenter);
            positions3.add(new Position(1, 2, 2));
            positions3.add(new Position(1, 3, 2));

            Piece rightL = new Piece(positions3);
            rightL.setCenter(rightLCenter);
            existingPieces.add(rightL);



            List positions4 = new ArrayList<Position>();
            Position cell2Center = new Position(0, 0, 0);
            positions4.add(cell2Center);
            positions4.add(new Position(0, 1, 0));


            Piece cell2 = new Piece(positions4);
            cell2.setCenter(cell2Center);
            existingPieces.add(cell2);



            List positions5 = new ArrayList<Position>();
            Position leftRCenter = new Position(0, 1, 2);
            System.out.println("left cnter : "+leftRCenter.getX()+" "+leftRCenter.getY());
            positions5.add(new Position(0, 0, 2));

            positions5.add(leftRCenter);
            positions5.add(new Position(1, 1, 2));
            Piece leftR = new Piece(positions5);
            leftR.setCenter(leftRCenter);

            System.out.println("left cnter : "+rightL.getCenter().getX()+" "+rightL.getCenter().getY());
            existingPieces.add(leftR);
            System.out.println("left cnter : "+existingPieces.get(5).getCenter().getX()+" "+existingPieces.get(5).getCenter().getY());


            List positions6 = new ArrayList<Position>();
            Position cell3Center = new Position(0, 1, 0);
            positions6.add(new Position(0, 0, 0));
            positions6.add(cell3Center);
            positions6.add(new Position(0, 2, 0));


            Piece cell3 = new Piece(positions6);
            cell3.setCenter(cell3Center);
            existingPieces.add(cell3);


            List positions7 = new ArrayList<Position>();
            Position TCenter = new Position(1, 1, 6);
            positions7.add(new Position(0, 1, 6));
            positions7.add(new Position(1, 0, 6));
            positions7.add(TCenter);
            positions7.add(new Position(2, 1, 6));

            Piece T = new Piece(positions7);
            T.setCenter(TCenter);
            existingPieces.add(T);

            List positions8 = new ArrayList<Position>();
            Position cell4Center = new Position(0, 1, 0);
            positions8.add(new Position(0, 0, 0));
            positions8.add(cell4Center);
            positions8.add(new Position(0, 2, 0));
            positions8.add(new Position(0, 3, 0));



            Piece cell4 = new Piece(positions8);
            cell4.setCenter(cell4Center);
            existingPieces.add(cell4);


            List positions9 = new ArrayList<Position>();
            Position sleepLCenter = new Position(0, 1, 0);
            positions9.add(new Position(0, 0, 0));
            positions9.add(sleepLCenter);
            positions9.add(new Position(0, 2, 0));
            positions9.add(new Position(1, 2, 0));


            Piece sleepL = new Piece(positions9);
            sleepL.setCenter(sleepLCenter);
            existingPieces.add(sleepL);

            List positions10 = new ArrayList<Position>();
            Position rightZCenter = new Position(1, 0, 4);
            positions10.add(new Position(0, 1, 4));
            positions10.add(new Position(1, 1, 4));
            positions10.add(rightZCenter);
            positions10.add(new Position(2, 0, 4));

            Piece rightZ = new Piece(positions10);
            rightZ.setCenter(rightZCenter);
            existingPieces.add(rightZ);

            List positions11 = new ArrayList<Position>();
            Position sleepLReverseCenter = new Position(1, 1, 0);
            positions11.add(new Position(0, 0, 0));
            positions11.add(new Position(1, 0, 0));
            positions11.add(sleepLReverseCenter);
            positions11.add(new Position(1, 2, 0));
            positions11.add(new Position(1, 3, 0));



            Piece sleepLReverse = new Piece(positions11);
            sleepLReverse.setCenter(sleepLReverseCenter);
            existingPieces.add(sleepLReverse);


            List positions12 = new ArrayList<Position>();
            Position bigTCenter = new Position(1, 1, 0);
            positions12.add(new Position(1, 0, 0));
            positions12.add(bigTCenter);
            positions12.add(new Position(1, 2, 0));
            positions12.add(new Position(0, 2, 0));
            positions12.add(new Position(2, 2, 0));


            Piece bigT = new Piece(positions12);
            bigT.setCenter(bigTCenter);
            existingPieces.add(bigT);


            List positions13 = new ArrayList<Position>();
            Position bigRightZCenter = new Position(1, 0, 4);
            positions13.add(new Position(0, 1, 4));
            positions13.add(new Position(1, 1, 4));
            positions13.add(bigRightZCenter);
            positions13.add(new Position(2, 0, 4));
            positions13.add(new Position(3, 0, 4));


            Piece bigRightZ = new Piece(positions13);
            bigRightZ.setCenter(bigRightZCenter);


            List positions14 = new ArrayList<Position>();
            Position standLeftCenter = new Position(1, 1, 4);
            positions14.add(new Position(0, 2, 4));
            positions14.add(new Position(0, 1, 4));
            positions14.add(standLeftCenter);
            positions14.add(new Position(2, 1, 4));
            positions14.add(new Position(2, 0, 4));


            Piece standLeft = new Piece(positions14);
            standLeft.setCenter(standLeftCenter);
            existingPieces.add(standLeft);

            List positions15 = new ArrayList<Position>();
            Position grenadeCenter = new Position(0, 1, 4);
            positions15.add(new Position(0, 0, 4));
            positions15.add(grenadeCenter);
            positions15.add(new Position(0, 2, 4));
            positions15.add(new Position(1, 2, 4));
            positions15.add(new Position(1, 1, 4));


            Piece grenade = new Piece(positions15);
            grenade.setCenter(grenadeCenter);
            existingPieces.add(grenade);

            List positions16 = new ArrayList<Position>();
            Position birdCenter = new Position(1, 1, 4);
            positions16.add(new Position(0, 2, 4));
            positions16.add(new Position(0, 1, 4));
            positions16.add(birdCenter);
            positions16.add(new Position(1, 0, 4));
            positions16.add(new Position(2, 0, 4));


            Piece bird = new Piece(positions16);
            bird.setCenter(birdCenter);
            existingPieces.add(bird);



            List positions17 = new ArrayList<Position>();
            Position eCenter = new Position(0, 1, 4);
            positions17.add(new Position(0, 0, 4));
            positions17.add(new Position(1, 0, 4));
            positions17.add(eCenter);
            positions17.add(new Position(0, 2, 4));
            positions17.add(new Position(1, 2, 4));


            Piece e = new Piece(positions17);
            e.setCenter(eCenter);
            existingPieces.add(e);


            List positions18 = new ArrayList<Position>();
            Position weirdCenter = new Position(1, 1, 4);
            positions18.add(new Position(1, 0, 4));
            positions18.add(new Position(2,0 , 4));
            positions18.add(weirdCenter);
            positions18.add(new Position(0, 1, 4));
            positions18.add(new Position(1, 2, 4));


            Piece weird = new Piece(positions18);
            weird.setCenter(weirdCenter);
            existingPieces.add(weird);


            List positions19 = new ArrayList<Position>();
            Position crossCenter = new Position(1, 1, 4);
            positions19.add(new Position(1, 0, 4));
            positions19.add(crossCenter);
            positions19.add(new Position(0,1 , 4));
            positions19.add(new Position(2, 1, 4));
            positions19.add(new Position(1, 2, 4));


            Piece cross = new Piece(positions19);
            cross.setCenter(crossCenter);
            existingPieces.add(cross);


            List positions20 = new ArrayList<Position>();
            Position lastCenter = new Position(1, 1, 4);
            positions20.add(new Position(0, 1, 4));
            positions20.add(lastCenter);
            positions20.add(new Position(1,0 , 4));
            positions20.add(new Position(2, 1, 4));
            positions20.add(new Position(3, 1, 4));


            Piece last = new Piece(positions20);
            last.setCenter(lastCenter);
            existingPieces.add(last);
            int c = 1;

            System.out.println("Piece numbre 4");
            System.out.println(existingPieces.get(4).getCenter().getX()+" "+existingPieces.get(4).getCenter().getY());
            System.out.println("Piece numbre 5");

            System.out.println(existingPieces.get(5).getCenter().getX()+" "+existingPieces.get(5).getCenter().getY());
            System.out.println("Piece numbre 6");

            System.out.println(existingPieces.get(6).getCenter().getX()+" "+existingPieces.get(6).getCenter().getY());
             for (Piece piece: existingPieces) {
                System.out.println("pice number : "+c);
                player1.add(new Piece(piece.getShape(),piece.getCenter(), 0));
                System.out.println(piece.getShape().get(0).getIdCouleur());
                player2.add(new Piece(piece.getShape(),piece.getCenter(), 1));
                player3.add(new Piece(piece.getShape(),piece.getCenter(), 2));
                player4.add(new Piece(piece.getShape(),piece.getCenter(), 3));
                c++;
            }


        }

    public ModelBoard getBoard() {
        return board;
    }

    public List<Piece> getExistingPieces() {
        return existingPieces;
    }

    public List<Piece> getPlayer1() {
        return player1;
    }

    public List<Piece> getPlayer2() {
        return player2;
    }

    public List<Piece> getPlayer3() {
        return player3;
    }

    public List<Piece> getPlayer4() {
        return player4;
    }


    public Boolean isAuthorizePlacing(Piece piece, int idColorPlayer) {
        if(round == 0) {
            for (Position position : piece.getShape()) {

                if (position.getX() == 0 && position.getY() == 0) {
                    System.out.println("Ok on est au coin 0 0");
                    return true;
                }
                else if (position.getX() == 0 && position.getY() == board.getGrid().getSizeY()-1) {

                    System.out.println("Ok on est au coin 0 Y");
                    return true;
                }
                else if (position.getX() == board.getGrid().getSizeX()-1 && position.getY() == 0){

                    System.out.println("Ok on est au coin X 0");
                    return true;
                }
                else if (position.getX() == board.getGrid().getSizeX()-1 && position.getY() == board.getGrid().getSizeY()-1){
                            System.out.println("Ok on est au coin X Y");
                    return true;
                }

            }

            System.out.println("on est pas dans un coin ! ");
            return false;
        }

        int nbPiecesDiagonales = 0;

        for(Position position : piece.getShape()) {
            // Si cette case est "au-dessus" d'une pièce déjà présente, on ne peut pas la mettre.
            // On boucle sur toutes les pièces et on regarde si l'une d'entre elles se trouvent à la place
            // de position. Dans ce cas, on return false

            for(int interationPiecesOnBoard = 1; interationPiecesOnBoard< board.getPieces().size(); interationPiecesOnBoard++){


            //for (Piece p : board.getPieces()) {
                Piece p  = board.getPieces().get(interationPiecesOnBoard);
                for (Position pPosition : p.getShape()) {
                    if (pPosition.getX() == position.getX() && pPosition.getY() == position.getY())
                        return false;

                    // On regarde aux 4 coins + 4 diagonales de la cellule actuelle
                    for (int i = -1; i < 1; i++) {
                        for (int y = -1; y < 1; y++) {
                            int posToCheckX = position.getX() + i;
                            int posToCheckY = position.getY() + y;

                            // la position à vérifier doit être tq 0 < pos < tailleGrille - pour des raisons évidentes de sécurité
                            // aussi: on ne veut pas check le cas où i = y = 0, car cela reviendrait à regarder la case actuelle,
                            // vu que position.getX() + 0 = position.getX() et position.getY() + 0 = position.getY()
                            if (posToCheckX > 0 && posToCheckY > 0
                                    && posToCheckX < board.getGrid().getSizeX() && posToCheckY < board.getGrid().getSizeY()
                                    && i != 0 && y != 0) {
                                // Si on est dans les diagolanes => si abs(i) = 1 et abs(y) = 1
                                if (Math.abs(i) == 1 && Math.abs(y) == 1) {
                                    // On regarde s'il existe une pièce dans cette diagonale
                                    for (Piece pBoard : board.getPieces())
                                        for (Position pBoardPostion : p.getShape())
                                            if (pBoardPostion.getX() == posToCheckX && pBoardPostion.getY() == posToCheckY)
                                                // il y a une pièce dans cette diagonale. Est-ce que c'est une des notres ?
                                                if (pBoardPostion.getIdCouleur() == idColorPlayer)
                                                    System.out.println("Elle est à nous. On incrémente");
                                                    nbPiecesDiagonales++;
                                } else { // On est pas dans les colones = on est dans les lignes
                                    // On cherche s'il y a une pièce à la position [posToCheckX][posToCheckY]
                                    for (Piece pBoard : board.getPieces())
                                        for (Position pBoardPostion : p.getShape())
                                            if (pBoardPostion.getX() == posToCheckX && pBoardPostion.getY() == posToCheckY)
                                                // Il y en a une.
                                                if (pBoardPostion.getIdCouleur() == idColorPlayer)
                                                    System.out.println("On a une face à nous à coté");
                                                    return false;
                                }

                            }
                        }
                    }
                }

            }
        }


        return nbPiecesDiagonales != 0;
    }
    public void nextRound(){
        round = round+1;
        board.addPieceOnBoardInOrder(board.getPieces().get(0), 1);
        pieceSelected = false;
        indexSelectedPiece =-1;

    }

    public void selectNextPiece(Direction direction) {
        pieceSelected = true;

        try{
            System.out.println("removing current piece");
            board.removePiece(board.getPieces().get(0));
        }catch (Exception e) {
            System.out.println("il n'y en avait pas ");
        }
        System.out.println("index avant if = "+indexSelectedPiece);
        if (direction == Direction.Right && indexSelectedPiece < player1.size()-1) {
            System.out.println("Nouevlle referene à current dans selct next piece if ");
           /* try{
                board.getPieces().set(0, player1.get(indexSelectedPiece+1));
            }catch (Exception e) {
                board.getPieces().add(0, player1.get(indexSelectedPiece+1));
            }*/
            board.addPieceOnBoardInOrder(new Piece(player1.get(indexSelectedPiece+1)), 0);

            indexSelectedPiece++;


        } else if (direction == Direction.Left && indexSelectedPiece>0) {
            System.out.println("Nouevlle referene à current dans selct next piece else ");

            /*try{
                board.getPieces().set(0, player1.get(indexSelectedPiece-1));
            }catch (Exception e) {
                board.getPieces().add(0, player1.get(indexSelectedPiece-1));
            }*/
            board.addPieceOnBoardInOrder(new Piece(player1.get(indexSelectedPiece-1)), 0);
                indexSelectedPiece--;


        }
         setChanged();
        notifyObservers();

      /*  board.addPieceOnBoard(board.getPieces().get(0));*/

    }

    public int lookForWinner() {
        if (player1.size() ==0) {
            return 1;
        } else if (player1.size() ==0) {
            return 2;
        } else if (player1.size() ==0) {
            return 3;
        } else if (player1.size() ==0) {
            return 4;
        } else {
            return -1;
        }
    }

    public int getIndexSelectedPiece() {
        return indexSelectedPiece;
    }

   /* public Piece getCurrentPiece() {
        return currentPiece;
    }*/

    public void movePiece(Direction direction) {
        if (pieceSelected) {
            board.movePieceWithoutChecking(board.getPieces().get(0), direction);
        }


      //  currentPiece = new Piece(board.anticipationCalc(currentPiece, Direction.Down));
    }

    public List<Piece> getPieces() {
        return board.getPieces();

    }

    public int getRound() {
        return round;
    }

    public boolean isPieceSelected() {
        return pieceSelected;
    }

    public void removeOption() {
     /*   switch (round % 4) {
            case 0:
                player1.Player1remove(blokusModel.getIndexSelectedPiece());
                break;
            case 1:
                blokusModel.getPlayer1().remove(blokusModel.getIndexSelectedPiece());
                break;
            case 2:
                blokusModel.getPlayer1().remove(blokusModel.getIndexSelectedPiece());
                break;
            case 3:
                blokusModel.getPlayer1().remove(blokusModel.getIndexSelectedPiece());
                break;


        }*/
    }
}
