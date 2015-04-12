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
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3) {
                    int pi = targetCell.getX() + i;
                    int pj = targetCell.getY() + j;
                    if (pi >= 0 && pi < ch.getHeight() && pj >= 0 && pj < ch.getWidth()) {
                        if (cells[pi][pj].isFree()) {
                            booked.add(cells[pi][pj]);
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
