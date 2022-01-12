package org.learn.exercise.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeService {
    private static final String YEAR = "2021:";
    private static final String TIME_FORMATTER = "yyyy:MM:dd:HH:mm:ss";

    private String timeStart;
    private String timeEnd;

    private long second;

    public TimeService(String timeStart, String timeEnd) {
        this.timeStart = YEAR + timeStart;
        this.timeEnd = YEAR + timeEnd;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMATTER);
        LocalDateTime startLocalDateTime = LocalDateTime.parse(this.timeStart, formatter);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(this.timeEnd, formatter);
        this.second = (Timestamp.valueOf(endLocalDateTime).getTime() - Timestamp.valueOf(startLocalDateTime).getTime()) / 1000L;
    }

    public long getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TimeService{" +
                "timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", second=" + second +
                '}';
    }
}
