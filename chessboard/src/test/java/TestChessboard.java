import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chess.Player;
import chess.State;
import chess.board.Chessboard;
import chess.board.ResultChessboard;
import chess.pieces.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class TestChessboard {

    @Ignore
    public void testResultBoards() {
        ResultChessboard board3x3v1 = new ResultChessboard(3, 3);
        ResultChessboard board3x3v2 = new ResultChessboard(3, 3);
        ResultChessboard board3x3v3 = new ResultChessboard(3, 3);
        ResultChessboard board4x3 = new ResultChessboard(4, 3);
        board3x3v3.setCellState(0, 0, State.NONE);

        Assert.assertTrue(board3x3v1.equals(board3x3v2));
        Assert.assertTrue(board3x3v1.hashCode() == board3x3v2.hashCode());

        Assert.assertFalse(board3x3v1.equals(board3x3v3));
        Assert.assertFalse(board3x3v1.hashCode() == board3x3v3.hashCode());

        Assert.assertFalse(board3x3v1.equals(board4x3));

    }

    @Test
    public void testKingsAndRook() {
        System.out.println("-------------------------------------");
        System.out.println("Test two Kings and Rook on 3x3 board");
        Player player = new Player();
        Chessboard board = new Chessboard(3, 3);
        List<Chessman> pieces = new ArrayList<>(3);
        pieces.add(new King());
        pieces.add(new King());
        pieces.add(new Rook());
        player.setChessboard(board);
        player.setPieces(pieces);
        long start = System.currentTimeMillis();
        player.findResults();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(player.getOptionsCount() == 4);
    }

    @Test
    public void testRooksAndKnights() {
        System.out.println("-------------------------------------");
        System.out.println("Test 4 Knights and 2 Rooks on 4x4 board");
        Player player = new Player();
        Chessboard board = new Chessboard(4, 4);
        List<Chessman> pieces = new ArrayList<>(6);
        pieces.add(new Rook());
        pieces.add(new Rook());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());
        pieces.add(new Knight());
        player.setChessboard(board);
        player.setPieces(pieces);
        long start = System.currentTimeMillis();
        player.findResults();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(player.getOptionsCount() == 8);
    }

    @Test
    public void targetTest() {
        System.out.println("-------------------------------------");
        System.out.println("Target test on 7x7 board");
        long start = System.currentTimeMillis();
        Chessboard board = new Chessboard(7, 7);
        Player player = new Player();
        List<Chessman> pieces = new ArrayList<>(7);
        pieces.add(new Queen());
        pieces.add(new Queen());
        pieces.add(new King());
        pieces.add(new King());
        pieces.add(new Bishop());
        pieces.add(new Bishop());
        pieces.add(new Knight());
        player.setChessboard(board);
        player.setPieces(pieces);
        player.findResults();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(player.getOptionsCount() == 3063828);

    }

    @Ignore
    public void validateResultsTest() throws IOException {

        System.out.println("-------------------------------------");
        System.out.println("We are going to validate file with target task results");
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String result;
        Chessboard board;
        List<Chessman> pieces;
        Chessman piece;
        char pieceChar;
        Integer resultsCount = 0;

        List<Chessman> testpieces = new ArrayList<>(7);
        testpieces.add(new Queen());
        testpieces.add(new Queen());
        testpieces.add(new King());
        testpieces.add(new King());
        testpieces.add(new Bishop());
        testpieces.add(new Bishop());
        testpieces.add(new Knight());
        Collections.sort(testpieces);

        while ((result = reader.readLine()) != null) {

            board = new Chessboard(7, 7);
            pieces = new ArrayList<>(7);


            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) != '-') {
                    pieceChar = result.charAt(i);
                    switch (pieceChar) {
                        case 'Q': {
                            board.getCells()[i % 7][i / 7].setState(State.QUEEN);
                            piece = new Queen();
                            piece.setPlace(board.getCells()[i % 7][i / 7]);
                            pieces.add(piece);
                            break;
                        }
                        case 'R':
                            board.getCells()[i % 7][i / 7].setState(State.ROOK);
                            piece = new Rook();
                            piece.setPlace(board.getCells()[i % 7][i / 7]);
                            pieces.add(piece);
                            break;
                        case 'B':
                            board.getCells()[i % 7][i / 7].setState(State.BISHOP);
                            piece = new Bishop();
                            piece.setPlace(board.getCells()[i % 7][i / 7]);
                            pieces.add(piece);
                            break;
                        case 'N':
                            board.getCells()[i % 7][i / 7].setState(State.KNIGHT);
                            piece = new Knight();
                            piece.setPlace(board.getCells()[i % 7][i / 7]);
                            pieces.add(piece);
                            break;
                        case 'K':
                            board.getCells()[i % 7][i / 7].setState(State.KING);
                            piece = new King();
                            piece.setPlace(board.getCells()[i % 7][i / 7]);
                            pieces.add(piece);
                            break;
                    }

                }
            }

// first check - whether the number of pieces correct
            Assert.assertTrue(pieces.size() == testpieces.size());

// second check - we have really right chess pieces types
            Collections.sort(pieces);
            for (int i = 0; i < testpieces.size(); i++) {
                Assert.assertTrue(testpieces.get(i).getType().equals(pieces.get(i).getType()));
            }
// final check - validate pieces positions
            for (Chessman p : pieces) {
                Assert.assertTrue(p.validatePosicion(board));
            }
            resultsCount++;
        }
        System.out.println("Finally validated: " + resultsCount);
        System.out.println("-------------------------------------");
    }
}
