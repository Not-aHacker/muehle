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
            if (board.placeStone(turn, pos -1)) {
                System.out.print("Remove position (1-24): ");
                pos = scanner.nextInt();
                // board.removeStone(pos - 1)
            }
        }

        System.out.println("End");
    }
}
