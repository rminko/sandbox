package chess.pieces;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public class Rook extends Chessman {
    @Override
    public State getType() {
        return State.ROOK;
    }

    @Override
    protected boolean fillBooked(Cell targetCell, Chessboard ch) {

        Cell[][] cells = ch.getCells();

        for (int i = 0; i < ch.getHeight(); i++) {
            if (cells[i][targetCell.getY()].isFree() ||  targetCell==cells[i][targetCell.getY()]) {
                booked.add(cells[i][targetCell.getY()]);
            } else {
                booked.clear();
                return false;
            }
        }
        for (int j = 0; j < ch.getWidth(); j++) {
            if (cells[targetCell.getX()][j].isFree() ||  targetCell==cells[targetCell.getX()][j]) {
                booked.add(cells[targetCell.getX()][j]);
            } else {
                booked.clear();
                return false;
            }
        }

        return super.fillBooked(targetCell, ch);

    }

}
