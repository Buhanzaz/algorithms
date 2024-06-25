package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdOut;

public class W1_1_20 {
    public static double factorial(int n) {
        if (n == 1) return 0;
        return factorial(n - 1) + Math.log(n);
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        StdOut.println(factorial(N));
    }
}
