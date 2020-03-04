package com.whiteboard.interview.service;

import com.whiteboard.interview.data.BowlingFrame;
import com.whiteboard.interview.data.BowlingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BowlingService {
    Logger logger = Logger.getLogger(this.getClass().getName());

    public int scoreBowlingGame(BowlingGame bowlingGame) {
        List<Integer> bowlingThrows = new ArrayList<>();
        for(BowlingFrame frame : bowlingGame.getBowlingFrames()) {
            bowlingThrows.addAll(frame.getThrows());
        }

        int score = 0;
        int throwIndex = 0;
        for(BowlingFrame frame : bowlingGame.getBowlingFrames()) {
            for(int throwScore : frame.getThrows()) {
                score += throwScore;
                throwIndex++;
            }

            if(frame.isStrike()) {
                score += bowlingThrows.get(throwIndex) +
                         bowlingThrows.get(throwIndex + 1);
            } else if(frame.isSpare()) {
                score += bowlingThrows.get(throwIndex);
            }
        }
        return score;
    }

    public BowlingGame parseBowlingGame(String bowlingString) {
        BowlingGame bowlingGame = new BowlingGame();
        String[] frames = bowlingString.split("-");

        for(String frameString : frames) {
            frameString = frameString.trim();
            BowlingFrame frame = new BowlingFrame();
            int previousThrow = 0;
            for(char c : frameString.toLowerCase().toCharArray()) {
                if(c == 'x') {
                    frame.addThrow(10);
                    previousThrow = 10;
                } else if(c == '/') {
                    frame.addThrow(10 - previousThrow);
                } else if(Character.isDigit(c)) {
                    frame.addThrow(Character.getNumericValue(c));
                    previousThrow = Character.getNumericValue(c);
                } else {
                    logger.log(Level.WARNING, "Skipping invalid throw: {0} in frame: {1}", new Object[]{c, frameString});
                }
            }
            bowlingGame.addBowlingFrame(frame);
        }

        return bowlingGame;
    }
}
