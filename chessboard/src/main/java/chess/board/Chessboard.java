package chess.board;
import java.util.HashSet;
import java.util.Set;

import chess.State;

public class Chessboard {
    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    private Integer height;
    private Integer width;

    private Cell[][] cells;
    private Set<Cell> free = new HashSet<Cell>();

    public Chessboard(Integer x, Integer y) {
        height = x;
        width = y;
        cells = new Cell[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cells[i][j] = new Cell(State.NONE, i, j);
                free.add(cells[i][j]);
            }
        }
    }

    public void print() {
        return;
    }

    public void setCell(Integer x, Integer y, State state) {
        cells[x][y].setState(state);
        if (cells[x][y].isFree()) {
            free.add(cells[x][y]);
        } else {
            free.remove(cells[x][y]);
        }
    }

    public Boolean checkCellIsFree(Integer x, Integer y) {
        return cells[x][y].isFree();
    }

    public Set<Cell> getFree() {
        return free;
    }

    public Cell[][] getCells() {
        return cells;
    }

}
