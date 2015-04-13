package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chess.board.Chessboard;
import chess.pieces.*;

public class Demo {
    public static void main(String args[]) {
        int count = 0;
        int x = 0;
        int y = 0;

        Player player = new Player();
        Chessboard chessboard;
        List<Chessman> pocket = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("PLAYER: I am choosing a board now. Please set its height:");
        System.out.print("YOU:");
        x = s.nextInt();
        System.out.println("PLAYER: I am choosing a board now. Please set its weight: ");
        System.out.print("YOU:");
        y = s.nextInt();
        System.out.println();

        chessboard = new Chessboard(x, y);
        player.setChessboard(chessboard);

        int flag = -1;

        while (flag != 0) {

            System.out.println("PLAYER:  Now I have " + count + " chess pieces in a pocket. Should I take one more?");
            System.out.println();
            System.out.println(" 1 - take Queen");
            System.out.println(" 2 - take Rook");
            System.out.println(" 3 - take Bishop");
            System.out.println(" 4 - take King");
            System.out.println(" 5 - take Knight");
            System.out.println(" 0 - thank you, that is enough");
            System.out.println();
            System.out.print("YOU:");
            flag = s.nextInt();

            switch (flag) {
                case 1:
                    pocket.add(new Queen()); count++;
                    break;
                case 2:
                    pocket.add(new Rook()); count++;
                    break;
                case 3:
                    pocket.add(new Bishop()); count++;
                    break;
                case 4:
                    pocket.add(new King()); count++;
                    break;
                case 5:
                    pocket.add(new Knight()); count++;
                    break;
            }
        }

        flag = -1;
        while (flag != 1 && flag != 2) {
            System.out.println("PLAYER: should I print every result?");
            System.out.println();
            System.out.println(" 1 - yes, please print chess board for every result");
            System.out.println(" 2 - no, just give me summary");
            System.out.println();
            System.out.print("YOU:");
            flag = s.nextInt();
            if (flag == 1) {
                player.setPrintResults(true);
            }
            if (flag == 2) {
                player.setPrintResults(false);
            }
        }


        System.out.println("PLAYER: ok, I start calculation right now");
        long start = System.currentTimeMillis();
        player.setPieces(pocket);
        player.findResults();
        player.printResult();
        long end = System.currentTimeMillis();
        System.out.println("It took " + ((end - start)) / 1000d + " seconds to find results");
        System.out.println();

    }

}
