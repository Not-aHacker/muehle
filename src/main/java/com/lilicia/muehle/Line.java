package com.lilicia.muehle;

import java.util.List;

public class Line {
    private List<Position> positions;

    public Line(List<Position> positions) {
        this.positions = positions;
    }

    public boolean isMuehle() {
        if (this.positions.get(0).getStatus() == Stone.BLACK) {
            return this.positions.get(1).getStatus() == Stone.BLACK && this.positions.get(2).getStatus() == Stone.BLACK;
        }
        if (this.positions.get(0).getStatus() == Stone.WHITE) {
            return this.positions.get(1).getStatus() == Stone.WHITE && this.positions.get(2).getStatus() == Stone.WHITE;
        }
        return false;
    }

}
