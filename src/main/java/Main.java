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

            while((!isValidPosition(pos)) || board.getPosStatus(pos - 1) != Stone.EMPTY ){
                board.print();
                System.out.println("Is not possible please try again.");
                System.out.print("Enter your position (1-24 for " + turn.name() + "): ");
                pos = scanner.nextInt();
            }

            // Muehle
            if (board.placeStone(turn, pos - 1)) {
                board.print();
                System.out.print("Remove position (1-24): ");
                pos = scanner.nextInt();
                while ((!isValidPosition(pos)) || (board.removeStone(turn,pos - 1) == false)){
                    board.print();
                    System.out.println("Is not possible please try again.");
                    System.out.print("Remove position (1-24): ");
                    pos = scanner.nextInt();
                }
            }

        }

        turn = Stone.WHITE;
        while (board.getBlackStones() > 2 && board.getWhiteStones() > 2) {
            if (turn==Stone.WHITE && board.getWhiteStones()>3) {
                board.print();
                System.out.print("Choose position (1-24): ");
                for (pos = scanner.nextInt();(!isValidPosition(pos) || board.getPosStatus(pos) != turn);){
                    board.print();
                    System.out.print("Choose position (1-24): ");
                    pos = scanner.nextInt();
                }

                System.out.print("Choose direction (L,R,U,D): ");
                char direction = scanner.next().charAt(0);
                if (!board.moveStone(pos - 1, direction,turn)) {
                    continue;
                }
            }
            else if (turn==Stone.WHITE && board.getWhiteStones()==3) {
                    board.print();
                    System.out.print("Choose position (1-24): ");
                    pos = scanner.nextInt();
                    System.out.print("Choose new position (1-24): ");
                    int newpos = scanner.nextInt();
                    if (!board.jumpStone(pos - 1, newpos - 1,Stone.WHITE)) {
                        continue;
                    }
                }
            else if (turn==Stone.BLACK && board.getBlackStones()>3) {
                    board.print();
                    System.out.print("Choose position (1-24): ");
                    pos = scanner.nextInt();
                    System.out.print("Choose direction (L,R,U,D): ");
                    char direction = scanner.next().charAt(0);
                    if (!board.moveStone(pos - 1, direction, Stone.BLACK)) {
                        continue;
                    }
                }
            else if (turn==Stone.BLACK && board.getBlackStones()==3) {
                    board.print();
                    System.out.print("Choose position (1-24): ");
                    pos = scanner.nextInt();
                    System.out.print("Choose new position (1-24): ");
                    int newpos = scanner.nextInt();
                    if (!board.jumpStone(pos - 1, newpos - 1, Stone.BLACK)) {
                        continue;
                    }
                }

            turn = turn == Stone.WHITE ? Stone.BLACK : Stone.WHITE;
        }


        System.out.println("End");
    }
    private static boolean isValidPosition (int position) {
        return (0<position && position<25);
    }
}
