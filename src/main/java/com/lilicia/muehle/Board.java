package com.lilicia.muehle;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Line> lines;
    private List<Position> positions;

    public Board() {
        this.positions = new ArrayList<>();
        this.lines = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
//            this.positions.set(i, new Position());
            this.positions.add(new Position());
        }

        for (int i = 0; i < 16; i++) {
//            lines.set(i, new Line())
        }

        for (int i = 0; i < 24; i += 3) {
            List<Position> pos = new ArrayList<>();
            pos.add(this.positions.get(i));
            pos.add(this.positions.get(i + 1));
            pos.add(this.positions.get(i + 2));

            Line line = new Line(pos);

            lines.add(line);

            for (Position p : pos) {
                p.setLine(line);
            }
        }
        int[] arr = {0, 9, 21, 3, 10, 18, 6, 11, 15, 1, 4, 7, 16, 19, 22, 8, 12, 17, 5, 13, 20, 2, 14, 23};
        for (int i = 0; i < 24; i += 3) {
            List<Position> pos = new ArrayList<>();
            pos.add(this.positions.get(arr[i]));
            pos.add(this.positions.get(arr[i + 1]));
            pos.add(this.positions.get(arr[i + 2]));

            Line line = new Line(pos);

            lines.add(line);
            for (Position p : pos) {
                p.setLine(line);
            }
        }


        // 2nd loop
        // (1,10,22), (4,11,19), (7,12,16),
        // (2,5,8), (17,20,23), (9,13,18),
        // (6,14,21), (3,15,24)
    }
    public void removeStone(int position){
        this.positions.get(position).updateStatus(Stone.EMPTY);
    }

    public void print() {
        System.out.println(positions.get(0).getChar() + "___________" + positions.get(1).getChar() + "___________" + positions.get(2).getChar());
        System.out.println("|           |           |");
        System.out.println("|   " + positions.get(3).getChar() + "_______" + positions.get(4).getChar() + "_______" + positions.get(5).getChar() + "   |");
        System.out.println("|   |       |       |   |");
        System.out.println("|   |   " + positions.get(6).getChar() + "___" + positions.get(7).getChar() + "___" + positions.get(8).getChar() + "   |   |");
        System.out.println("|   |   |       |   |   |");
        System.out.println(positions.get(9).getChar() + "___" + positions.get(10).getChar() + "___" + positions.get(11).getChar() + "       " + positions.get(12).getChar() + "___" + positions.get(13).getChar() + "___" + positions.get(14).getChar());
        System.out.println("|   |   |       |   |   |");
        System.out.println("|   |   " + positions.get(15).getChar() + "___" + positions.get(16).getChar() + "___" + positions.get(17).getChar() + "   |   |");
        System.out.println("|   |       |       |   |");
        System.out.println("|   " + positions.get(18).getChar() + "_______" + positions.get(19).getChar() + "_______" + positions.get(20).getChar() + "   |");
        System.out.println("|           |           |");
        System.out.println(positions.get(21).getChar() + "___________" + positions.get(22).getChar() + "___________" + positions.get(23).getChar());
    }

    public boolean placeStone(Stone turn, int position) {
        return positions.get(position).updateStatus(turn);

    }
}
