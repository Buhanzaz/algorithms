package com.buhanzaz.chapter_1._1_base_model_programming;

import edu.princeton.cs.algs4.StdOut;

public class ReFibonacci {
    public static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
    public static long F(int N) {
        return (long) ((Math.pow(GOLDEN_RATIO, N) - Math.pow(1 - GOLDEN_RATIO, N)) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            //StdOut.print(N + ": F(N - 1) + F(N - 2) = " + Fibonacci.F(N));
            StdOut.println(" || " + N + ": xn = (φ^n − (1−φ)^n)/√5 = " + F(N));
        }
    }
}
