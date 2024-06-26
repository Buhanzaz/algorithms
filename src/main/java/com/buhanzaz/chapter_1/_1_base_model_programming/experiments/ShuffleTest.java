package com.buhanzaz.chapter_1._1_base_model_programming.experiments;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;
import java.util.stream.IntStream;

public class ShuffleTest {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        int[][] positions = new int[M][M];
        int[] intArray = new int[M];
        for (int i = 0; i < N; i++) {
            initArray(intArray);
            shuffle(intArray);

            for (int j = 0; j < intArray.length; j++) {
                positions[intArray[j]][j]++;
            }
        }

        printTest(positions);
    }

    private static void printTest(int[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            StdOut.printf("%3d  ", i);

            for (int j = 0; j < positions[0].length; j++) {
                StdOut.printf("%4d ", positions[i][j]);
            }

            StdOut.println();
        }
    }

    private static void initArray(int[] intArray) {
        IntStream.range(0, intArray.length).forEach(i -> intArray[i] = i);
    }

    public static void shuffle(int[] intArray) {
        validateNotNull(intArray);

        int n = intArray.length;

        for (int i = 0; i < n; i++) {
            int randomInt = i + random.nextInt(n-i);     // between i and n-1
            int temp = intArray[i];
            intArray[i] = intArray[randomInt];
            intArray[randomInt] = temp;
        }
    }

    private static void validateNotNull(int[] a) {
        if (a == null) throw new NullPointerException();
    }
}