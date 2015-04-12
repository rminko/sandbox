package chess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chess.board.Chessboard;
import chess.board.ResultChessboard;
import chess.pieces.Chessman;

public class Player {

    private Chessboard chessboard;
    private List<Chessman> pieces = new ArrayList<>();
    private int optionsCount = 0;
    private Set<ResultChessboard> results = new HashSet<>();


    public int getOptionsCount() {
        return optionsCount;
    }

    public int getResultsCount() {
        return results.size();
    }

    public void setChessboard(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void setPieces(List<Chessman> pieces) {
        this.pieces = pieces;
    }

    public void process(Integer level) {
        Chessman piece = pieces.get(level);
        while (piece.sit(chessboard)) {
            if (pieces.size() == level + 1) {
                optionsCount++;
                results.add(generateBoardResult());

            } else {
                process(level + 1);
            }
        }
        piece.rid(chessboard);
    }

    public void findResults() {
        optionsCount = 0;
        int startLevel = 0;
        process(startLevel);
    }

    public ResultChessboard generateBoardResult() {
        ResultChessboard result = new ResultChessboard(chessboard.getHeight(), chessboard.getWidth());
        for (Chessman piece : pieces) {
            result.setCellState(piece.getPlace().getX(), piece.getPlace().getY(), piece.getType());
        }
        return result;
    }

    public void printResult() {
        System.out.println();
        System.out.println("Finally found all results: " + optionsCount + " results");
        System.out.println("Finally found distinct     : " + results.size() + " results");

    }
}
