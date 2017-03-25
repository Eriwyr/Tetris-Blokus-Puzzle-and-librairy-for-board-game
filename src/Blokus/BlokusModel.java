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

        public BlokusModel(){
            existingPieces = new ArrayList<Piece>();

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
        }




}
