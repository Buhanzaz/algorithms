package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import com.buhanzaz.my_api.SpeedTesting;
import edu.princeton.cs.algs4.*;

import java.util.*;


/**Упражнение 1.2.1*/
public class ClientPoint2D {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Point2D[] points = new Point2D[N];

        createAndDrawPoints(points);

        SpeedTesting.startTime();
        double trivialAlgorithm = trivialAlgorithm(points);
        SpeedTesting.endTime();
        System.out.println(SpeedTesting.performance());

        SpeedTesting.startTime();
        double anotherTrivialAlgorithm = trivialAlgorithm(points);
        SpeedTesting.endTime();
        System.out.println(SpeedTesting.performance());

        System.out.printf("Minimal distance: %f\n", trivialAlgorithm);
        System.out.printf("Maximal distance: %f\n", anotherTrivialAlgorithm);
    }

    public static void createAndDrawPoints(Point2D[] points) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.show();

        for (int i = 0; i < points.length; i++) {
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();
            Point2D point = new Point2D(x, y);

            //point.draw();

            StdDraw.point(point.x(), point.y());
            points[i] = point;  
        }
    }

    public static double trivialAlgorithm(Point2D[] points) {
        List<Double> distanceList = new ArrayList<>();
        for (Point2D firstPoint : points) {
            for (Point2D secondPoint : points) {
                if (firstPoint != secondPoint) { // Потому что нам важна лишь ячейка памяти
                    distanceList.add(firstPoint.distanceTo(secondPoint));
                }
            }
        }

        return Collections.min(distanceList);
    }

    public static double anotherTrivialAlgorithm(Point2D[] points) {
        double minDistance = Double.MAX_VALUE;
        double currentDistance;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                currentDistance = points[i].distanceTo(points[j]);

                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }
        }

        return minDistance;
    }
}
