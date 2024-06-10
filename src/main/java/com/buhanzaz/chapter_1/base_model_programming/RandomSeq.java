package com.buhanzaz.chapter_1.base_model_programming;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {
    public static void main(String[] args) {
        // Вывод N случайных значений из диапазона (lo, hi).
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for (int i = 1; i <= N; i++) {
            double x = StdRandom.uniformDouble(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
