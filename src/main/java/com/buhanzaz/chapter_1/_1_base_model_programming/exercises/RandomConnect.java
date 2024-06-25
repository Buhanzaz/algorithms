package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class RandomConnect {


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        draw(N, p);
    }

    private static void draw(int N, double p) {
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.05);

        double[][] coordinate = new double[N][2];
        for (int i = 0; i < N; i++) {
            coordinate[i][0] = Math.sin(2 * Math.PI * i / N);
            coordinate[i][1] = Math.cos(2 * Math.PI * i / N);
            StdDraw.point(coordinate[i][0], coordinate[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(coordinate[i][0], coordinate[i][1], coordinate[j][0], coordinate[j][1]);
                }
            }
        }
    }
}
