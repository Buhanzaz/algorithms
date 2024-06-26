package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SmartDate implements Comparable<SmartDate> {
    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //private static final int commonYears;

    private final int month;   // month (between 1 and 12)
    private final int day;     // day   (between 1 and DAYS[month]
    private final int year;    // year

    public SmartDate(int month, int day, int year) {
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public SmartDate(String date) {
        String[] fields;
        if (date.contains("/")) {
            fields = date.split("/");
        } else if (date.contains("-")) {
            fields = date.split("-");
        } else if (date.contains(":")) {
            fields = date.split(":");
        } else if (date.contains(".")) {
            fields = date.split("\\.");
        } else {
            throw new IllegalArgumentException("Invalid date");
        }

        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid date");
        }
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    // algorithm Rata Die
    public int dayOfTheWeek() {
        return 0;
    }

    private int gaussAlgorithm() {
        return (1 + 5 * (this.year - 1) % 4) + 4 * ((year - 1) % 100) + 6 * ((year - 1) % 400) % 7;
    }

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    private boolean isValid(int month, int day, int year) {
        if (month < 1 || month > 12) return false;
        else if (day < 1 || day > DAYS[month]) return false;
        else return month != 2 || day != 29 || isLeapYear(year);
    }

    @Override
    public int compareTo(SmartDate that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        SmartDate that = (SmartDate) other;
        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);
    }

    @Override
    public int hashCode() {
        return day + 31 * month + 31 * 12 * year;
    }
}
