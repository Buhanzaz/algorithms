package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

public class W1_1_15 {
    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
