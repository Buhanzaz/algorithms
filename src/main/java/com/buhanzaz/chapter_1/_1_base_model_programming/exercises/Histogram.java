package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import com.buhanzaz.my_api.ArrayGenerator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdStats;

import java.util.Arrays;

public class Histogram {


    public static void main(String[] args) {
//        int size = Integer.parseInt(args[0]) - 1;
////        double left = Double.parseDouble(args[1]);
////        double right = Double.parseDouble(args[2]);
//        In in = new In("%s%s.txt".formatted(Constants.FILE_PATH, args[3]));
//        double[] whitelist = in.readAllDoubles();
        int size = 5;
        double left = 0;
        double right = 1;
        double[] whitelist = ArrayGenerator.doubleArray(100, 0, 1);
        showHistogram(size, left, right, whitelist);
    }

    private static void showHistogram(int size, double left, double right, double[] whitelist) {
        int[] value = computeHistogramValue(size, left, right, whitelist);
        double intervalSize = (right - left) / size;
        int max = StdStats.max(value);

        double minX = left - 1;
        double maxX = right + 1;
        double minY = -2;
        double maxY = max + 2;

        double middleX = minX + (maxX - minX) / 2;
        double middleY = minY + (maxY - minY) / 2;

        StdDraw.setCanvasSize(1024, 600);
        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);

        StdDraw.text(middleX, maxY - 0.5, "Numbers in intervals");
        StdDraw.text(middleX + 0.25, middleY, "Numbers", 90);
        StdDraw.text(middleX, -1.2, "Intervals");

        for (int x = 0; x < size; x++) {
            double minValue = left + (intervalSize * x);
            double maxValue = minValue + intervalSize - 0.01;
            String interval = String.format(" [%.2f-%.2f] ", minValue, maxValue);
            StdDraw.text(left + (x + 0.5) * intervalSize, minY + 10, interval);
        }

        for (int y = 0; y < maxY; y++) {
            StdDraw.text(minX + 0.7, y, String.valueOf(y));
        }

        for (int i = 0; i < intervalSize; i++) {

            double x = left + (i + 0.5) * intervalSize;
            double y = value[i] / 2.0;
            double halfWidth = intervalSize / 3.0;
            double halfHeight = value[i] / 2.0;

            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }

    public static int[] computeHistogramValue(int size, double left, double right, double[] whitelist) {
        Arrays.sort(whitelist);
        double intervalSize = (right - left) / size;
        double minDiapason = left;
        double maxDiapason = left + intervalSize;
        int[] histogramArr = new int[size];
        int index = 0;
        for (int i = 0; i < histogramArr.length; i++) {
            int count = 0;

            for (; index < whitelist.length; index++) {
                double value = whitelist[index];
                if (value >= minDiapason && value < maxDiapason) {
                    count++;
                } else {
                    histogramArr[i] = count;
                    minDiapason += intervalSize;
                    maxDiapason += intervalSize;
                    break;
                }
            }

            histogramArr[i] = count;
        }

        return histogramArr;
    }


}
