package Blokus;

import LibraryBoardGame.Model.Board.ModelBoard;
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

        public BlokusModel(){

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
            rightL.setCenter(leftRCenter);
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

            for (Piece piece: existingPieces) {
                player1.add(new Piece(piece.getShape(),piece.getCenter()));
                player2.add(new Piece(piece.getShape(),piece.getCenter()));
                player3.add(new Piece(piece.getShape(),piece.getCenter()));
                player4.add(new Piece(piece.getShape(),piece.getCenter()));
            }


        }




}
