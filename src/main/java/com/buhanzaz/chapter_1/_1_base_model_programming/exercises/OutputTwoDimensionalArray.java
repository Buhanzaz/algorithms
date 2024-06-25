package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdOut;

/*1.1.11*/
public class OutputTwoDimensionalArray {
    public static void main(String[] args) {
        boolean[][] arr = { { true, false, true }, { false , true , false }, { false , true , false } };

        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) StdOut.print("*");
                else StdOut.print(" ");
            }
            StdOut.println();
        }
    }
}
