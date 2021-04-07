package com.lilicia.muehle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Position {
    private Stone status;
    private List<Line> listOfLines;

    public Position() {
        status = Stone.EMPTY;
        listOfLines = new ArrayList<>();
    }

    public Stone getStatus() {
        return this.status;
    }

    public char getChar() {
        switch (status) {
            case BLACK:
                return 'X';
            case WHITE:
                return 'O';
            case EMPTY:
                return '*';
        }
        return '.';
    }

    public boolean updateStatus(Stone newStatus) {
        switch (newStatus) {
            case BLACK:
                status = Stone.BLACK;
                break;
            case WHITE:
                status = Stone.WHITE;
                break;
            case EMPTY:
                status = Stone.EMPTY;
        }
        return listOfLines.get(0).isMuehle() || listOfLines.get(1).isMuehle();
    }

    public void setLine(Line line) {
        listOfLines.add(line);
    }

    public boolean movePossible(char direction) {
        if (direction == 'L' || direction == 'R') {
            return listOfLines.get(0).movePossible(this, direction);
        }
        if (direction == 'U' || direction == 'D') {
            return listOfLines.get(1).movePossible(this, direction);
        }
        return false;
    }

    public Line getHorLine() {
        return this.listOfLines.get(0);
    }

    public Line getVerLine() {
        return this.listOfLines.get(1);
    }
}
