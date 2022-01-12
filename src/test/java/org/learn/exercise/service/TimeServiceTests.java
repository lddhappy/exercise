package org.learn.exercise.service;

import org.junit.jupiter.api.Test;

public class TimeServiceTests {

    @Test
    public void parseTest() {
        String start = "03:12:05:45:34";
        String end = "10:12:08:03:12";
        TimeService timeService = new TimeService(start, end);
        System.out.println(timeService.getSecond());

        String start2 = "03:12:05:45:34";
        String end2 = "03:12:05:45:14";
        TimeService timeService2 = new TimeService(start2, end2);
        System.out.println(timeService2.getSecond());
    }
}
