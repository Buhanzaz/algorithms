package com.buhanzaz.chapter_1.base_model_programming.exercises;

public class MyToBinaryString {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        StringBuilder s = new StringBuilder();

        for (int n = N; n > 0; n /= 2) {
            s.insert(0, (n % 2));
        }
        System.out.println(s);
    }
}
