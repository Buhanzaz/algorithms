package com.buhanzaz.chapter_1._1_base_model_programming.experiments;

import java.util.Arrays;

public final class ModelingGameBones {
    private static final byte SIDES = 6;
    private static final byte LENGTH_ARRAY = 2 * SIDES + 1;

    private static double[] modeling() {
        double[] dist = new double[LENGTH_ARRAY];

        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    private static byte rollOfTheDice() {
        return (byte) (Math.random() * SIDES + 1);
    }

    public static void main(String[] args) {
        double[] model = modeling();
        double[] controlStatistics = Arrays.stream(model).map(d -> (Math.round(d * 1000.0) / 1000.0)).toArray();

        int stat = 1;
        int[] statArr = new int[stat];

        for (int i = 0; i < stat; i++) {
            boolean equals = false;
            int N = 500;

            while (!equals) {
                byte[] statistics = new byte[N];

                for (int j = 0; j < N; j++) {
                    byte x = rollOfTheDice();
                    byte y = rollOfTheDice();
                    byte answer = (byte) (x + y);

                    //System.out.printf("%d + %d = %d\n", x, y, answer);

                    statistics[j] = answer;
                }
                Arrays.sort(statistics);

                double[] value = computeHistogramValue(statistics);
                double[] controlValue = Arrays.stream(value).map(d -> (Math.round(d * 1000.0) / 1000.0)).toArray();

                equals = Arrays.equals(controlStatistics, controlValue);

                if (!equals) {
                    N += 500;
                }
            }

            statArr[i] = N;
        }

        System.out.println("AVG: " + Arrays.stream(statArr).sum() / statArr.length);
    }

    public static double[] computeHistogramValue(byte[] whitelist) {
        Arrays.sort(whitelist);
        byte intervalSize = 1;
        byte minDiapason = 0;
        byte maxDiapason = intervalSize;
        double[] histogramArr = new double[LENGTH_ARRAY];
        double onePercent = (100.0 / whitelist.length) / 100;

        int index = 0;
        for (int i = 0; i < histogramArr.length; i++) {
            int count = 0;

            for (; index < whitelist.length; index++) {
                double value = whitelist[index];
                if (value >= minDiapason && value < maxDiapason) {
                    count++;
                } else {
                    histogramArr[i] = count;
                    minDiapason += intervalSize;
                    maxDiapason += intervalSize;
                    break;
                }
            }

            histogramArr[i] = count * onePercent;
        }


        return histogramArr;
    }
}
