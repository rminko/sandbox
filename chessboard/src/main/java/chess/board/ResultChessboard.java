//
// Class to save results to the HashSet, so all we need is to implement
// equals and hashCode methods in it
//
package chess.board;

import java.util.Arrays;

import chess.State;

@Deprecated
public class ResultChessboard {
    private Integer height;
    private Integer width;
    private State[][] cells;

    public ResultChessboard(Integer x, Integer y) {
        height = x;
        width = y;
        cells = new State[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cells[i][j] = State.NONE;
            }
        }
    }

    public void setCellState(int x, int y, State state) {
        cells[x][y] = state;
    }

    public void print() {

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultChessboard)) {
            return false;
        }

        ResultChessboard that = (ResultChessboard) o;

        if (!height.equals(that.height)) {
            return false;
        }
        if (!width.equals(that.width)) {
            return false;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cells[i][j] != that.cells[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }
}
