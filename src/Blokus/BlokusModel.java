package Blokus;

import LibraryBoardGame.Model.Board.ModelBoard;
import LibraryBoardGame.Model.Direction;
import LibraryBoardGame.Model.Piece.Piece;
import LibraryBoardGame.Model.Piece.Position;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

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

            this.board = new ModelBoard(43, 54);

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
            positions5.add(new Position(0, 0, 2));
            positions5.add(leftRCenter);
            positions5.add(new Position(1, 1, 2));
            Piece leftR = new Piece(positions5);
            leftR.setCenter(leftRCenter);
            existingPieces.add(leftR);


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
            existingPieces.add(bigRightZ);


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



             for (Piece piece: existingPieces) {
                player1.add(new Piece(piece.getShape(),piece.getCenter(), 0));
                player2.add(new Piece(piece.getShape(),piece.getCenter(), 1));
                player3.add(new Piece(piece.getShape(),piece.getCenter(), 2));
                player4.add(new Piece(piece.getShape(),piece.getCenter(), 3));
                c++;
            }

            board.addPieceOnBoardInOrder(player1.get(0), 0);


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
        System.out.println("observing this picec ");
        piece.Display();
        if(round <4) {
            for (Position position : piece.getShape()) {
               // for(Piece pieceBoard : board.getPieces()) {
                for( int k = 1 ; k <board.getPieces().size(); k++) {
                    Piece pieceBoard = board.getPieces().get(k);
                    for (Position positionBoard : pieceBoard.getShape()) {
                        if(positionBoard.getX() == position.getX() && positionBoard.getY() == position.getY()) {
                            return false;
                        }
                    }
                }

                if (position.getX() == 0 && position.getY() == 0) return true;

                else if (position.getX() == 0 && position.getY() == board.getGrid().getSizeY()-1) return true;

                else if (position.getX() == board.getGrid().getSizeX()-1 && position.getY() == 0) return true;

                else if (position.getX() == board.getGrid().getSizeX()-1 && position.getY() == board.getGrid().getSizeY()-1) return true;

            }
            return false;
        }
        int nbPiecesDiagonales = 0;
        for(Position position : piece.getShape()) {
        //    for (Piece piece1 : board.getPieces()) {
             //   piece1.Display();
          //  }
            //position.Display();
            // Si cette case est "au-dessus" d'une pièce déjà présente, on ne peut pas la mettre.
            // On boucle sur toutes les pièces et on regarde si l'une d'entre elles se trouvent à la place
            // de position. Dans ce cas, on return false

            for (int interationPiecesOnBoard = 1; interationPiecesOnBoard < board.getPieces().size(); interationPiecesOnBoard++) {
                //for (Piece p : board.getPieces()) {
                Piece p = board.getPieces().get(interationPiecesOnBoard);
                for (Position pPosition : p.getShape()) {
                    if (pPosition.getX() == position.getX() && pPosition.getY() == position.getY()) {
                        return false;
                    }
                }
            }
            // On regarde aux 4 coins + 4 diagonales de la cellule actuelle
            for (int i = -1; i < 2; i++) {
                for (int y = -1; y < 2; y++) {
                    int posToCheckX = position.getX() + i;
                    int posToCheckY = position.getY() + y;
                    // la position à vérifier doit être tq 0 < pos < tailleGrille - pour des raisons évidentes de sécurité
                    // aussi: on ne veut pas check le cas où i = y = 0, car cela reviendrait à regarder la case actuelle,
                    // vu que position.getX() + 0 = position.getX() et position.getY() + 0 = position.getY()
                    if (posToCheckX > 0 && posToCheckY > 0
                            && posToCheckX < board.getGrid().getSizeX() && posToCheckY < board.getGrid().getSizeY()
                            && (i != 0 || y != 0)) {
                        // Si on est dans les diagolanes => si abs(i) = 1 et abs(y) = 1
                        if (Math.abs(i) == 1 && Math.abs(y) == 1) {
                            // On regarde s'il existe une pièce dans cette diagonale
                            int c = 0;
                            for (int b = 1; b < board.getPieces().size(); b++) {
                                Piece pBoard = board.getPieces().get(b);
                                c++;

                                for (Position pBoardPostion : pBoard.getShape()) {
                                    if (pBoardPostion.getX() == posToCheckX && pBoardPostion.getY() == posToCheckY) {
                                        // il y a une pièce dans cette diagonale. Est-ce que c'est une des notres ?
                                        if (pBoardPostion.getIdCouleur() == idColorPlayer) {
                                            nbPiecesDiagonales++;
                                        }
                                    }
                                }
                            }
                        } else { // On est pas dans les colones = on est dans les lignes
                            // On cherche s'il y a une pièce à la position [posToCheckX][posToCheckY]
                            for (int a = 1; a < board.getPieces().size(); a++) {
                                Piece pBoard = board.getPieces().get(a);

                                for (Position pBoardPostion : pBoard.getShape()) {
                                    if (pBoardPostion.getX() == posToCheckX && pBoardPostion.getY() == posToCheckY) {
                                        // Il y en a une.
                                        if (pBoardPostion.getIdCouleur() == idColorPlayer) {
                                            return false;
                                        }
                                    }
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
        System.out.println("liste des pièces sur le plateau ");
        for (Piece piece : board.getPieces()) {
            piece.Display();
        }
        pieceSelected = true;
        List<Piece> studyList = new ArrayList<>();
        System.out.println("rond :"+round);
        if (round == 0 ){
            studyList = new ArrayList<Piece>(player1);
        } else {


            switch (round % 4) {
                case 0:
                    studyList = new ArrayList<Piece>(player1);
                    break;
                case 1:
                    studyList = new ArrayList<Piece>(player2);
                    break;
                case 2:
                    studyList = new ArrayList<Piece>(player3);
                    break;
                case 3:
                    studyList = new ArrayList<Piece>(player4);
                    break;

            }
        }

        if (direction == Direction.Right && indexSelectedPiece < studyList.size()-1) {
            try{
                board.removePiece(board.getPieces().get(0));
            }catch (Exception e) {
            }

            board.addPieceOnBoardInOrder(new Piece(studyList.get(indexSelectedPiece+1)), 0);
            indexSelectedPiece++;
            for (Piece piece : board.getPieces()) {
                piece.Display();
            }


        } else if (direction == Direction.Left && indexSelectedPiece>0) {
            try{
                board.removePiece(board.getPieces().get(0));
            }catch (Exception e) {
            }


            board.addPieceOnBoardInOrder(new Piece(studyList.get(indexSelectedPiece-1)), 0);
            indexSelectedPiece--;
            System.out.println("left");
            System.out.println("OUVELLE liste des pièces sur le plateau ");
            for (Piece piece : board.getPieces()) {
                piece.Display();
            }


        }
         setChanged();
        notifyObservers();

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
       switch (round % 4) {
            case 0:
                player1.remove(indexSelectedPiece);
                break;
            case 1:
                player2.remove(indexSelectedPiece);
                break;
            case 2:
                player3.remove(indexSelectedPiece);
                break;
            case 3:
                player4.remove(indexSelectedPiece);
                break;
            default:
                System.out.println("hum ... ");
                break;

        }
        setChanged();
        notifyObservers();
    }


    public void rotatePiece() {
        board.rotatePiece(board.getPieces().get(0), 1);
    }
}
