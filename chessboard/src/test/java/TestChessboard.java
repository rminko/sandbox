import java.util.ArrayList;
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


}
