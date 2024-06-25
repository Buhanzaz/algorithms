package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

public class ClientInterval2D {
    private static final Map<Interval2D, Interval1D[]> intervalMap = new HashMap<>();

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = new Interval2D[N];

        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }

        creteAndDrawIntervals(intervals, min, max);
        System.out.printf("Intersections: %d\n", countIntersections(intervals));
        System.out.printf("Contained: %d\n", countContained(intervals));
    }


    public static void creteAndDrawIntervals(Interval2D[] intervals, double min, double max) {
        StdDraw.setCanvasSize(258, 258);
        StdDraw.setPenRadius(.0015);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.show();

        for (int i = 0; i < intervals.length; i++) {
            Interval1D width = generatorInterval1D(min, max);
            Interval1D height = generatorInterval1D(min, max);

            intervals[i] = new Interval2D(width, height);
            intervalMap.put(intervals[i], new Interval1D[]{width, height});
            intervals[i].draw();
        }
    }

    private static Interval1D generatorInterval1D(double min, double max) {
        double minimum = StdRandom.uniformDouble(min, max);
        double maximum = StdRandom.uniformDouble(min, max);

        if (minimum > maximum) {
            double temp = minimum;
            minimum = maximum;
            maximum = temp;
        }

        return new Interval1D(minimum, maximum);
    }

    public static int countIntersections(Interval2D[] intervals) {
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Да наверное было бы проще будь у класса Interval2D get методы для получения x и y
    public static int countContained(Interval2D[] intervals) {
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (isContained(intervals[i], intervals[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isContained(Interval2D interval1, Interval2D interval2) {
        Interval1D[] firstInterval1D = intervalMap.get(interval1);
        Interval1D[] secondInterval1D = intervalMap.get(interval2);

        double firstX1Min = firstInterval1D[0].min();
        double firstX2Max = firstInterval1D[0].max();
        double firstY1Min = firstInterval1D[1].min();
        double firstY2Max = firstInterval1D[1].max();

        double secondX1Min = secondInterval1D[0].min();
        double secondX2Max = secondInterval1D[0].max();
        double secondY1Min = secondInterval1D[1].min();
        double secondY2Max = secondInterval1D[1].max();

        return (firstX1Min >= secondX1Min && firstX2Max <= secondX2Max)
                && (firstY1Min >= secondY1Min && firstY2Max <= secondY2Max);
    }
}
