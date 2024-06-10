package com.buhanzaz.chapter_1.base_model_programming;

import edu.princeton.cs.algs4.StdDraw;

public class FunctionValue {
    public static void show(int n) {
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n * n);
        StdDraw.setPenRadius(.01);

        for (int i = 1; i <= n; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    public static void main(String[] args) {
        show(Integer.parseInt(args[0]));
    }
}
