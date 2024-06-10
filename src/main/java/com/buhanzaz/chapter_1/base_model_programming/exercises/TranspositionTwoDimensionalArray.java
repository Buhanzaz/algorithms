package com.buhanzaz.chapter_1.base_model_programming.exercises;

import java.util.Arrays;

/**1.1.13*/
public class TranspositionTwoDimensionalArray {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = i + j;
            }
        }

        int[][] transposition = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                transposition[i][j] = matrix[i][j];
            }
        }

        System.out.println(Arrays.deepToString(transposition));
    }
}
