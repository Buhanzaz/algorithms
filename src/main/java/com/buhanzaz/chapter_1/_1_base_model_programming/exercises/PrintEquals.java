package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**1.1.3*/
public class PrintEquals {
    public static void main(String[] args) {
        if (args.length == 3) {
            int[] arr = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                StdOut.println("Equals");
            } else {
                StdOut.println("Not Equals");
            }
        } else {
            StdOut.println("The program works with three values");
        }
    }
}
