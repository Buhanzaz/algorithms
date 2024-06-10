package com.buhanzaz.chapter_1.base_model_programming.exercises;

public class W1_1_21 {
    public static void outStat(String name, int a, int b) {
        double x = (double) a / b;
        System.out.printf("%s %d %d %.3f\n", name, a, b, x);
    }

    public static void main(String[] args) {
        String name = args[0];
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        outStat(name, a, b);
    }
}
