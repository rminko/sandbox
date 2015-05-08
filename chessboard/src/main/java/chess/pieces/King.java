package chess.pieces;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public class King extends Chessman {

    @Override
    public State getType() {
        return State.KING;
    }

    @Override
    protected boolean fillBooked(Cell targetCell, Chessboard ch) {
        Cell[][] cells = ch.getCells();
        for (int i = targetCell.getX() - 1; i <= targetCell.getX() + 1; i++) {
            for (int j = targetCell.getY() - 1; j <= targetCell.getY() + 1; j++) {
                if (i >= 0 && j >= 0 && i < ch.getHeight() && j < ch.getWidth()) {
                    if (cells[i][j].isFree() ||  targetCell==cells[i][j]) {
                        booked.add(cells[i][j]);
                    } else {
                        booked.clear();
                        return false;
                    }
                }
            }
        }

        return super.fillBooked(targetCell, ch);

    }

}
