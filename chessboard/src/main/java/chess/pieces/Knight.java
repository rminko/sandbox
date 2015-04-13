package chess.pieces;

import chess.State;
import chess.board.Cell;
import chess.board.Chessboard;

public class Knight extends Chessman {
    @Override
    public State getType() {
        return State.KNIGHT;
    }

    @Override
    protected boolean fillBooked(Cell targetCell, Chessboard ch) {

        Cell[][] cells = ch.getCells();

        booked.add(ch.getCells()[targetCell.getX()][targetCell.getY()]);
        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                if (Math.abs(x) + Math.abs(y) == 3) {
                    int i = targetCell.getX() + x;
                    int j = targetCell.getY() + y;
                    if (i >= 0 && i < ch.getHeight() && j >= 0 && j < ch.getWidth()) {
                        if (cells[i][j].isFree()) {
                            booked.add(cells[i][j]);
                        } else {
                            booked.clear();
                            return false;
                        }
                    }
                }
            }
        }
        return super.fillBooked(targetCell, ch);
    }

}
