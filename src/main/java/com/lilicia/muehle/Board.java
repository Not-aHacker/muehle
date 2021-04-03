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

            lines.add(new Line(pos));
        }

        // 2nd loop
        // (1,10,22), (4,11,19), (7,12,16),
        // (2,5,8), (17,20,23), (9,13,18),
        // (6,14,21), (3,15,24)
    }

    public void print() {
        System.out.println("*__________*__________*");
        System.out.println("|          |          |");
        System.out.println("|   *______*______*   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   |   *__*__*   |   |");
        System.out.println("|   |   |  |  |   |   |");
        System.out.println("*___*___*     *___*___*");
        System.out.println("|   |   |  |  |   |   |");
        System.out.println("|   |   *__*__*   |   |");
        System.out.println("|   |      |      |   |");
        System.out.println("|   *______*______*   |");
        System.out.println("|          |          |");
        System.out.println("*__________*__________*");
    }

}
