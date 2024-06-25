package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;

public class ClientInterval1D {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];

        createIntervals(intervals);
        printIntervalIntersections(intervals);
    }

    public static void createIntervals(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            double min = StdRandom.uniformDouble();
            double max = StdRandom.uniformDouble();

            if (min > max) {
                double temp = min;
                min = max;
                max = temp;
            }

            intervals[i] = new Interval1D(min, max);
        }
    }

    public static void printIntervalIntersections(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    System.out.printf("Interval 1: (Min - %f), (Max - %f)\n", intervals[i].min(), intervals[i].max());
                    System.out.printf("Interval 2: (Min - %f), (Max - %f)\n\n", intervals[j].min(), intervals[j].max());
                }
            }
        }
    }
}
