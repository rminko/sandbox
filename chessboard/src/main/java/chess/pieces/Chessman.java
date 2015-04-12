package chess.pieces;

import java.util.HashSet;
import java.util.Set;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public class Chessman {

    protected Set<Cell> booked = new HashSet<>();
    protected Cell place = null;

    public boolean sit(Chessboard board) {
        return false;
    }

    public State getType() {
        return State.BOOKED;
    }

    public void rid(Chessboard ch) {
    }

}
