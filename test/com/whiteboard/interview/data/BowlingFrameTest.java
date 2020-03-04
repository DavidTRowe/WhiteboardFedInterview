package com.whiteboard.interview.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingFrameTest {
    BowlingFrame frame;

    @BeforeEach
    void setUp() {
        frame = new BowlingFrame();
    }

    @Test
    void isSpare() {
        frame.addThrow(6);
        frame.addThrow(4);
        assertTrue(frame.isSpare());
    }

    @Test
    void isStrike() {
        frame.addThrow(10);
        assertTrue(frame.isStrike());
    }

    @Test
    void testStrikeIsNotSpare() {
        frame.addThrow(10);
        assertFalse(frame.isSpare());
    }

    @Test
    void testSpareIsNotStrike() {
        frame.addThrow(5);
        frame.addThrow(5);
        assertFalse(frame.isStrike());
    }

    @Test
    void testNotStrike() {
        frame.addThrow(1);
        frame.addThrow(1);
        assertFalse(frame.isStrike());
    }

    @Test
    void testNotSpare() {
        frame.addThrow(1);
        frame.addThrow(1);
        assertFalse(frame.isSpare());
    }
}