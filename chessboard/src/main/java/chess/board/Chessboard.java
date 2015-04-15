package chess.board;

import java.util.HashSet;
import java.util.Set;

import chess.State;

public class Chessboard {
    private Integer height;
    private Integer width;
    private Cell[][] cells;
    // Set with cells, which currently is not occupied or threatened by any chessman
    private Set<Cell> free = new HashSet<>();

    public Chessboard(Integer height, Integer width) {
        this.height = height;
        this.width = width;
        cells = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(State.NONE, i, j);
                free.add(cells[i][j]);
            }
        }
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Set<Cell> getFree() {
        return free;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void print() {

        for (int j = 0; j < width; j++) {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(cells[i][j].getState().getSymbol());
            }
            System.out.print("|");
            System.out.println();
        }

        for (int j = 0; j < width; j++) {
            System.out.print("--");
        }
        System.out.println();
    }
}
