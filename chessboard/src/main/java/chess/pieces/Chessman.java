package chess.pieces;

import java.util.HashSet;
import java.util.Set;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public abstract class Chessman implements Comparable<Chessman>{

    protected Set<Cell> booked = new HashSet<>();
    protected Cell place = null;

    public Set<Cell> getLocalPlaces() {
        return localPlaces;
    }

    // Set off cells which were already taken by this piece
    // should be cleared when chess piece is leaving the board
    protected Set<Cell> localPlaces = new HashSet<>();

    public boolean sit(Chessboard board) {
        while (true) {
            if (place != null) {
                place.setState(State.NONE);
                board.getFree().addAll(booked);
                booked.clear();
            }

            place = chooseCell(board);
            if (place == null) {
                return false;
            }

            if (fillBooked(place, board)) {
                place.setState(getType());
                board.getFree().removeAll(booked);
                return true;
            }
        }
    }

    public Cell chooseCell(Chessboard chessboard) {
        for (Cell targetCell : chessboard.getFree()) {
            if (!localPlaces.contains(targetCell)) {
                localPlaces.add(targetCell);
                return targetCell;
            }
        }
        return null;
    }

    protected boolean fillBooked(Cell targetCell, Chessboard chessboard) {
        booked.retainAll(chessboard.getFree());

        return true;
    }


    public State getType() {
        return State.NONE;
    }

    public Cell getPlace() {
        return place;
    }

    public void rid(Chessboard ch) {
        ch.getFree().addAll(booked);
        localPlaces.clear();
        booked.clear();
        if (place != null) {
            place.setState(State.NONE);
            place = null;
        }
    }

    public int compareTo(Chessman another) {
        return getType().compareTo(another.getType());
    }
}
