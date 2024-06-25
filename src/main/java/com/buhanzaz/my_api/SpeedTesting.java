package com.buhanzaz.my_api;

import java.time.Duration;
import java.time.LocalDateTime;

//TODO Добавить point для возможности замерять сразу несколько методов
public final class SpeedTesting {
    private static LocalDateTime startTime;
    private static LocalDateTime endTime;

    public static void startTime() {
        zeroing();

        startTime = LocalDateTime.now();
    }

    public static void endTime() {
        endTime = LocalDateTime.now();
    }

    public static long performance() {
        Duration duration = Duration.between(startTime, endTime);

        zeroing();

        return duration.toNanos();
    }

    private static void zeroing() {
        startTime = endTime = null;
    }
}
