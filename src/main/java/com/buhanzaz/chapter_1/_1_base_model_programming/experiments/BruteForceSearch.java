package com.buhanzaz.chapter_1._1_base_model_programming.experiments;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BruteForceSearch {
    public static void main(String[] args) {
        long start = 0, finish = 0;
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();



        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            start = System.currentTimeMillis();
            if (BruteForceSearch.search(key, whitelist)) {
                StdOut.println(key);
            }
            finish = System.currentTimeMillis();
        }


        StdOut.println(finish - start);
    }

    public static boolean search(int key, int[] a) {
        return Arrays.stream(a).filter(i -> a[i] == key).findFirst().isPresent();
    }
}
