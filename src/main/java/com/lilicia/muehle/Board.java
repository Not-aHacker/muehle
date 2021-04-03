package com.lilicia.muehle;

import java.util.List;

public class Board {
    private List<Line> lines;
    private List<Position> positions;
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
