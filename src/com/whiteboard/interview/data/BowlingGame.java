package com.whiteboard.interview.data;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    List<BowlingFrame> bowlingFrames = new ArrayList<>();

    public void addBowlingFrame(BowlingFrame bowlingFrame) {
        bowlingFrames.add(bowlingFrame);
    }

    public List<BowlingFrame> getBowlingFrames() {
        return new ArrayList<>(bowlingFrames);
    }
}
