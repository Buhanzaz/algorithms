package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.1.7
 */
public class What2 {
    public static void main(String[] args) {
        // a
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }

        StdOut.printf("%.5f\n", t);

        // b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 1; j < i; j++)
                sum++;
        StdOut.println(sum);

        // c
        final int N = 10;
        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 1; j < N; j++)
                sum2++;
        StdOut.println(sum2);
    }
}
