package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Player;
import chess.board.*;
import org.junit.*;


public class TestChessboard {

    @Test
    public void testKingsAndRook() {
        System.out.println("-------------------------------------");
        System.out.println("Test two Kings and Rook on 3x3 board");
        Player player = new Player();
        Chessboard board = new Chessboard(3,3);
        List<Chessman> pieces = new ArrayList<Chessman>(8);
        pieces.add(new King());
        pieces.add(new King());
        pieces.add(new Rook());
        player.setChessboard(board);
        player.setPieces(pieces);
        long start = System.currentTimeMillis();
        player.findResults(false);
        long end = System.currentTimeMillis();
        System.out.println("It took "+ ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(true);
    }
        @Test
        public void test() {
        System.out.println("-------------------------------------");
        long start = System.currentTimeMillis();
        Chessboard board = new Chessboard(6,6);
        Player player = new Player();
        List<Chessman> pieces = new ArrayList<Chessman>(8);
        pieces.add(new Queen());
        pieces.add(new Queen());
        pieces.add(new King());
        pieces.add(new King());
        pieces.add(new Bishop());
        pieces.add(new Bishop());
        pieces.add(new Knight());
        player.setChessboard(board);
        player.setPieces(pieces);
        player.findResults(false);
        long end = System.currentTimeMillis();
            System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
            player.printResult();
            System.out.println("-------------------------------------");

    }

}
