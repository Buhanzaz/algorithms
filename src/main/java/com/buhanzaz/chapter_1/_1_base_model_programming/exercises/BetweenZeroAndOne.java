package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**1.1.5*/
public class BetweenZeroAndOne {
    public static void main(String[] args) {
        if (args.length == 2) {
            double[] arr = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();

            StdOut.println(arr[0] >= 0 && arr[0] <= 1 && arr[1] >= 0 && arr[1] <= 1);
        } else {
            StdOut.println("Please enter two numbers");
        }
    }
}
