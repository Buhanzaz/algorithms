package com.buhanzaz.my_api;

import java.util.stream.IntStream;

public final class ArrayGenerator {
    public static double[] doubleArray(int length, double min, double max) {
        return IntStream.range(0, length).mapToDouble(i -> min + Math.random() * (max - min)).toArray();
    }

    public static int[] intArray(int length, int min, int max) {
        return IntStream.range(0, length).map(i -> (min + (int) (Math.random() * (max - min)))).toArray();
    }
}
