package com.whiteboard.interview.service;

import com.whiteboard.interview.data.BowlingFrame;
import com.whiteboard.interview.data.BowlingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingServiceTest {
    private BowlingGame game;
    private BowlingService bowlingService = new BowlingService();

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    @Test
    void testAllZero() {
        for(int i=0; i<10; i++) {
            game.addBowlingFrame(generateFrame(0, 0));
        }
        assertEquals(0, bowlingService.scoreBowlingGame(game));
    }

    @Test
    void testAllNines() {
        for(int i=0; i<10; i++) {
            game.addBowlingFrame(generateFrame(4, 5));
        }
        assertEquals(90, bowlingService.scoreBowlingGame(game));
    }

    @Test
    void testAllSpares() {
        for(int i=0; i<9; i++) {
            game.addBowlingFrame(generateFrame(5, 5));
        }
        BowlingFrame frame = generateFrame(5, 5);
        frame.addThrow(5);
        game.addBowlingFrame(frame);
        assertEquals(150, bowlingService.scoreBowlingGame(game));
    }

    @Test
    void testAllStrikes() {
        for(int i=0; i<9; i++) {
            game.addBowlingFrame(generateStrike());
        }
        BowlingFrame frame = generateFrame(10, 10);
        frame.addThrow(10);
        game.addBowlingFrame(frame);
        assertEquals(300, bowlingService.scoreBowlingGame(game));
    }

    @Test
    void testHalfStrikeHalfSpare() {
        for(int i=0; i<9; i++) {
            if(i%2 == 0) {
                game.addBowlingFrame(generateStrike());
            } else {
                game.addBowlingFrame(generateFrame(5, 5));
            }
        }
        BowlingFrame frame = generateFrame(10, 10);
        frame.addThrow(10);
        game.addBowlingFrame(frame);
        assertEquals(220, bowlingService.scoreBowlingGame(game));
    }

    BowlingFrame generateStrike() {
        BowlingFrame frame = new BowlingFrame();
        frame.addThrow(10);
        return frame;
    }

    BowlingFrame generateFrame(int firstThrow, int secondThrow) {
        BowlingFrame frame = new BowlingFrame();
        frame.addThrow(firstThrow);
        frame.addThrow(secondThrow);
        return frame;
    }
}