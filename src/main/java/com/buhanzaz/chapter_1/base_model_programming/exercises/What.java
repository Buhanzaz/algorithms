package com.buhanzaz.chapter_1.base_model_programming.exercises;


import edu.princeton.cs.algs4.StdOut;

/**1.1.6*/
public class What {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;

        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
