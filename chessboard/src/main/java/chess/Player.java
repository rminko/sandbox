package chess;

import java.util.ArrayList;
import java.util.List;

import chess.board.Chessboard;
import chess.pieces.Chessman;

public class Player {

    private Chessboard chessboard;
    private List<Chessman> pieces = new ArrayList<>();
    private int optionsCount = 0;

    public int getOptionsCount() {
        return optionsCount;
    }

    public void setChessboard(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void setPieces(List<Chessman> pieces) {
        this.pieces = pieces;
    }

    public void process(Integer level) {
        //TODO: recursive search potions operation
    }

    public void findResults() {
        optionsCount = 0;
        int startLevel = 0;
        process(startLevel);
    }

    public void printResult() {
        System.out.println();
        System.out.println("Finally found all results: " + optionsCount + " results");

    }
}
