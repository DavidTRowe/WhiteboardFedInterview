package com.whiteboard.interview;

import com.whiteboard.interview.service.BowlingService;

public class Main {
    private static BowlingService bowlingService = new BowlingService();

    public static void main(String[] args) {
        System.out.println(scoreBowlingString("X-X-X-X-X-X-X-X-X-XXX"));
        System.out.println(scoreBowlingString("45-54-36-27-09-63-81-18-90-72"));
        System.out.println(scoreBowlingString("5/-5/-5/-5/-5/-5/-5/-5/-5/-5/5"));
    }

    private static int scoreBowlingString(String bowlingString) {
        return bowlingService.scoreBowlingGame(bowlingService.parseBowlingGame(bowlingString));
    }
}
