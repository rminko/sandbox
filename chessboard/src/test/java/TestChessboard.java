import java.util.ArrayList;
import java.util.List;

import chess.Player;
import chess.State;
import chess.board.Chessboard;
import chess.board.ResultChessboard;
import chess.pieces.Chessman;
import chess.pieces.King;
import chess.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;


public class TestChessboard {

    @Test
    public void testResultBoards () {
        ResultChessboard board3x3v1 = new ResultChessboard(3,3);
        ResultChessboard board3x3v2 = new ResultChessboard(3,3);
        ResultChessboard board3x3v3 = new ResultChessboard(3,3);
        ResultChessboard board4x3 = new ResultChessboard(4,3);
        board3x3v3.setCellState(0,0, State.BOOKED);

        Assert.assertTrue(board3x3v1.equals(board3x3v2));
        Assert.assertTrue(board3x3v1.hashCode()== board3x3v2.hashCode());

        Assert.assertFalse(board3x3v1.equals(board3x3v3));
        Assert.assertFalse(board3x3v1.hashCode()== board3x3v3.hashCode());

        Assert.assertFalse(board3x3v1.equals(board4x3));


    }

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
        player.findResults();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(player.getOptionsCount() == 8);
        Assert.assertTrue(player.getResultsCount() == 4);
    }

}
