package com.whiteboard.interview.data;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {
    private final List<Integer> bowlingThrows = new ArrayList<>();

    public void addThrow(int bowlingThrow) {
        bowlingThrows.add(bowlingThrow);
    }

    public List<Integer> getThrows() {
        return bowlingThrows;
    }

    public boolean isSpare() {
         if(bowlingThrows.size() == 2) {
             return bowlingThrows.get(0) + bowlingThrows.get(1) == 10;
         }
         return false;
    }

    public boolean isStrike() {
        return bowlingThrows.size() == 1 && bowlingThrows.get(0) == 10;
    }
}
