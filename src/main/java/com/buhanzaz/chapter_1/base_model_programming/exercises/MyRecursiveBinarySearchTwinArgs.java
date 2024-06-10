package com.buhanzaz.chapter_1.base_model_programming.exercises;

import com.buhanzaz.Constants;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * 1.1.23
 */
public class MyRecursiveBinarySearchTwinArgs {
    public static int indexOf(int key, int[] a, int lo, int hi, int level) {
        int answer;

        printStat(level, hi, lo);

        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) {
            answer = indexOf(key, a, lo, mid - 1, ++level);
            printAnswer(level, answer);
            return answer;
        } else if (key > a[mid]) {
            answer = indexOf(key, a, mid + 1, hi, ++level);
            printAnswer(level, answer);
            return answer;
        } else {
            printAnswer(level, mid);
            return mid;
        }
    }

    public static int indexOf(int key, int[] a) {
        final int lo = 0;
        final int hi = a.length - 1;
        int level = 0;

        printStat(level, hi, lo);

        int answer = indexOf(key, a, lo, hi, ++level);

        printAnswer(level, answer);

        return answer;
    }

    private static void printStat(int level, int hi, int lo) {
        System.out.printf("Level: %d, Hi: %d, Lo: %d\n", level, hi, lo);
    }

    private static void printAnswer(int level, int answer) {
        System.out.printf("Level: %d, Answer: %d\n", level, answer);
    }

    public static void main(String[] args) {
        In in = new In("%s%s".formatted(Constants.FILE_PATH, args[0]));
        char operator = args[1].charAt(0);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            int index = MyRecursiveBinarySearchTwinArgs.indexOf(key, whitelist);

            if (index != -1 && operator == '+') {
                System.out.printf("Key: %d, Find: %d", index, key);
            } else if (index == -1 && operator == '-') {
                System.out.println("Not found key: " + key);
            } else {
                System.out.println("Not found");
            }
        }
    }
}