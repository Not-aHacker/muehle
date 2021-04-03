package com.lilicia.muehle;

public class Position {
    private Stone status;

    public Position() {
        status = Stone.EMPTY;
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
    public void updateStatus(Stone newStatus) {
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
    }
}
