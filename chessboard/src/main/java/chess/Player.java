package chess;

import java.util.*;

import chess.board.Chessboard;
import chess.board.ResultChessboard;
import chess.pieces.Chessman;

public class Player {

    private Chessboard chessboard;
    private List<Chessman> pieces = new ArrayList<>();
    private int optionsCount = 0;

    private boolean printResults = false;

    // not used for updated algorithm
    private Set<ResultChessboard> results = new HashSet<>();

    public void setPrintResults(boolean printResults) {
        this.printResults = printResults;
    }

    public int getOptionsCount() {
        return optionsCount;
    }

    @Deprecated
    public int getResultsCount() {
        return results.size();
    }

    public void setChessboard(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void setPieces(List<Chessman> pieces) {
        this.pieces = pieces;
        Collections.sort(pieces);
    }

    public void process(Integer level) {
        Chessman piece = pieces.get(level);
        while (piece.sit(chessboard)) {
            if (pieces.size() == level + 1) {
                optionsCount++;
                if (printResults) {
                    chessboard.print();
                }
            } else {
                if (piece.getType() == pieces.get(level + 1).getType()) {
                    pieces.get(level + 1).getLocalPlaces().addAll(piece.getLocalPlaces());
                }
                process(level + 1);
            }
        }
        piece.rid(chessboard);
    }

    public void findResults() {
        optionsCount = 0;
        int startLevel = 0;
        if (pieces.size() > 0) {
            process(startLevel);
        }
    }

    @Deprecated
    public ResultChessboard generateBoardResult() {
        ResultChessboard result = new ResultChessboard(chessboard.getHeight(), chessboard.getWidth());
        for (Chessman piece : pieces) {
            result.setCellState(piece.getPlace().getX(), piece.getPlace().getY(), piece.getType());
        }
        return result;
    }

    public void printResult() {
        System.out.println();
        System.out.println("Finally found: " + optionsCount + " results");
    }
}
