import java.util.Scanner;

import com.lilicia.muehle.Board;
import com.lilicia.muehle.Stone;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Stone turn;
        int pos;
        for (int i = 0; i < 18; i++) {
            board.print();

            turn = i % 2 == 0 ? Stone.WHITE : Stone.BLACK;
            System.out.print("Enter your position (1-24 for " + turn.name() + "): ");
            pos = scanner.nextInt();


            // Muehle
            if (board.placeStone(turn, pos - 1)) {
                board.print();
                System.out.print("Remove position (1-24): ");
                pos = scanner.nextInt();
                board.removeStone(pos - 1);
            }
        }

        turn = Stone.WHITE;
        while (board.getBlackStones() > 3 && board.getWhiteStones() > 3) {
            board.print();
            System.out.print("Choose position (1-24): ");
            pos = scanner.nextInt();
            System.out.print("Choose direction (L,R,U,D): ");
            char direction = scanner.next().charAt(0);
            if (!board.moveStone(pos -1, direction)) {
                continue;
            }
            turn = turn == Stone.WHITE ? Stone.BLACK : Stone.WHITE;
        }


        System.out.println("End");
    }
}
