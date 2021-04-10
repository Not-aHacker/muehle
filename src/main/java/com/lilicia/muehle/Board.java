package com.lilicia.muehle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    Scanner scanner = new Scanner(System.in);
    private List<Line> lines;
    private List<Position> positions;
    private int blackStones;
    private int whiteStones;

    public Board() {
        this.blackStones = this.whiteStones = 0;
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

    public boolean removeStone(Stone turn,int position) { //removes stone and checks if the position that you want to remove is available to remove
        Position pos = this.positions.get(position);
        Stone color = pos.getStatus();
        if (color != turn && color != Stone.EMPTY && ((!pos.getHorLine().isMuehle() && !pos.getVerLine().isMuehle()) || checkIfAllStonesinMuehle(color))) {
            if (color == Stone.BLACK) {
                --this.blackStones;
            } else {
                --this.whiteStones;
            }
            pos.updateStatus(Stone.EMPTY);
            return true;
        }
        return false;
    }

    // BOARD
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

    public boolean placeStone(Stone turn, int position) { // places stone and checks if it is true or false
        if (turn == Stone.BLACK) {
            ++this.blackStones;
        } else {
            ++this.whiteStones;
        }
        return positions.get(position).updateStatus(turn);
    }

    public boolean moveStone (int position, char direction, Stone turn) { //move stone and returns if muehle
        Position pos = this.positions.get(position);

            Position newPos;
            switch (direction) {
                case 'L':
                    newPos = pos.getHorLine().getNextPos(pos, -1);
                    break;
                case 'R':
                    newPos = pos.getHorLine().getNextPos(pos, 1);
                    break;
                case 'U':
                    newPos = pos.getVerLine().getNextPos(pos, -1);
                    break;
                case 'D':
                    newPos = pos.getVerLine().getNextPos(pos, 1);
                    break;
                default:
                    return false;
            }
            Stone curr = pos.getStatus();
            pos.updateStatus(Stone.EMPTY);
            //if muehle is created
            return newPos.updateStatus(curr);
    }
    //moveStone returns, if move possible or not, and moves the stone, if possible
    /*public boolean moveStone(int position, char direction, Stone turn) {
        Position pos = this.positions.get(position);
            if (pos.movePossible(direction)) {
            Position newPos;
            switch (direction) {
                case 'L':
                    newPos = pos.getHorLine().getNextPos(pos, -1);
                    break;
                case 'R':
                    newPos = pos.getHorLine().getNextPos(pos, 1);
                    break;
                case 'U':
                    newPos = pos.getVerLine().getNextPos(pos, -1);
                    break;
                case 'D':
                    newPos = pos.getVerLine().getNextPos(pos, 1);
                    break;
                default:
                    return false;
            }

            if (pos.getStatus() != turn || newPos.getStatus() == Stone.EMPTY) {//checking if the new Position is Empty and if the oldPos is even in the right turn
                Stone curr = pos.getStatus();
                pos.updateStatus(Stone.EMPTY);
                if (newPos.updateStatus(curr)){ //if muehle is created

                }
                return true;
            }
        }
        return false;
    }
*/
    public int getBlackStones() {
        return blackStones;
    }

    public int getWhiteStones() {
        return whiteStones;
    }
    public Stone getPosStatus(int position){ //get the status of the position so main can use it
        Position pos = this.positions.get(position);
        return pos.getStatus();
    }
    public boolean checkIfAllStonesinMuehle(Stone turn){ // checks if all Stones of the OPPONENT is in a Muehle
        for (int i = 0; i < 24; i++){
            Position pos = positions.get(i);
            if (pos.getStatus() == turn){
                if (!pos.getHorLine().isMuehle() && !pos.getVerLine().isMuehle()) {
                    return false;
                }
            }
        }
        return true;
    }

    //jumpStone returns, if muehle or not, and moves the stone
    public boolean jumpStone(int posOld, int posNew, Stone turn) {
        Position oldPos = this.positions.get(posOld);
        Position newPos = this.positions.get(posNew);

        Stone curr = oldPos.getStatus();
        oldPos.updateStatus(Stone.EMPTY);
        return newPos.updateStatus(curr);
    }

    public Position getPosition(int pos) {
        return positions.get(pos);
    }
}
