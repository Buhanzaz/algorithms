package com.buhanzaz.chapter_1.base_model_programming.exercises;

import java.util.Arrays;

public class Histogram {


    public static void main(String[] args) {
//        int number = Integer.parseInt(args[0]);
////        double left = Double.parseDouble(args[1]);
////        double right = Double.parseDouble(args[2]);
//        In in = new In("%s%s.txt".formatted(Constants.FILE_PATH, args[3]));
//        double[] whitelist = in.readAllDoubles();
        int number = 1;
        double left = 0;
        double right = 7;
        double[] whitelist = {1, 1, 2, 2, 4, 4, 4, 5, 5, 6};
        histogram(number, left, right, whitelist);
    }

    private static void histogram(int number, double left, double right, double[] whitelist) {
        Arrays.sort(whitelist);

        double intervalSize = (right - left) / number;

        for (int i = 0; i < whitelist.length; i++) {

        }

    }
}
