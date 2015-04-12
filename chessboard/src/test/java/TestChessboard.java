import java.util.ArrayList;
import java.util.List;

import chess.Player;
import chess.board.Chessboard;
import chess.pieces.Chessman;
import chess.pieces.King;
import chess.pieces.Rook;
import org.junit.Assert;
import org.junit.Test;


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
        player.findResults();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        player.printResult();
        System.out.println("-------------------------------------");
        Assert.assertTrue(player.getOptionsCount() == 8);
    }

}
