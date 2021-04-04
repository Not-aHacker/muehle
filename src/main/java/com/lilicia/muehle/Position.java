package com.lilicia.muehle;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private Stone status;
    private List<Line> listOfLines;

    public Position() {
        status = Stone.EMPTY;
        listOfLines = new ArrayList<>();
    }
    public Stone getStatus(){
        return this.status;
    }

    public char getChar() {
        switch (status){
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

    public void setLine(Line line){
        listOfLines.add(line);

    }
}
