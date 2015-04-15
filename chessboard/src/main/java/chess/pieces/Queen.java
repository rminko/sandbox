package chess.pieces;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public class Queen extends Rook {

    @Override
    public State getType() {
        return State.QUEEN;
    }

    @Override
    protected boolean fillBooked(Cell targetCell, Chessboard ch) {
        Cell[][] cells = ch.getCells();
        for (int i = 0; i < ch.getHeight(); i++) {
            for (int j = 0; j < ch.getWidth(); j++) {
                if (i + j == targetCell.getX() + targetCell.getY() || i - j == targetCell.getX() - targetCell.getY()) {
                    if (cells[i][j].isFree()) {
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
