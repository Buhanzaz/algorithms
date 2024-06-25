package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

import com.buhanzaz.my_api.Constants;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * 1.1.22
 */
public class MyRecursiveBinarySearchEqualsKey {
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

    public static int rank(int index, int[] sortedArray) {
        int count = 0;
        int value = sortedArray[index];

        for (int i = index; i >= 0; i--) {
            if (value != sortedArray[i]) {
                value = sortedArray[i];
                count++;
            }
        }

        return count;
    }

    public static int count(int index, int[] sortedArray) {
        int count = 0;
        int value = 0;

        for (int i = index; i >= 0; i--) {
            if (value == sortedArray[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        In in = new In("%s%s.txt".formatted(Constants.FILE_PATH, args[0]));
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();

            int index = MyRecursiveBinarySearchEqualsKey.indexOf(key, whitelist);
            if (index != -1) {
                System.out.println("Zero: " + count(index, whitelist));
                System.out.printf("Value < %d = %d\n", whitelist[index], rank(index, whitelist));
                System.out.printf("Key: %d, Find: %d", index, key);
            } else {
                System.out.println("Not found");
            }
        }
    }
}
