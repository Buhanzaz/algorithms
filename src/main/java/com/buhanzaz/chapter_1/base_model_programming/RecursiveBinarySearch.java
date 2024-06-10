package com.buhanzaz.chapter_1.base_model_programming;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class RecursiveBinarySearch {
    public static int indexOf(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = lo + (hi- lo) / 2;

        if (key < a[mid]) return indexOf(key, a, lo, mid - 1);
        else if (key > a[mid]) return indexOf(key, a, mid + 1, hi);
        else return mid;
    }

    public static int indexOf(int key, int[] a) {
        return indexOf(key, a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            if (RecursiveBinarySearch.indexOf(key, whitelist) == -1) {
                StdOut.println(key);
            }
        }
    }
}
