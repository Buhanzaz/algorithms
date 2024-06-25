package com.buhanzaz.chapter_1._1_base_model_programming;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {
    public static void main(String[] args) {
        // Среднее значение чисел и StdIn.
        double sum = 0;
        int count = 0;

        while (!StdIn.isEmpty()) {
            // Чтение числа и накопление суммы.
            sum += StdIn.readDouble();
            count++;
        }

        double average = sum / count;
        StdOut.printf("Среднее - %.5f\n", average);
    }
}
