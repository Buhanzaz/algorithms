package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

public class W1_1_14 {

    public static int lg(int n) {
        double a = Math.log(n) / Math.log(2);
        return (int) Math.floor(a);
    }

    public static int lg2(int n) {
        int count = 0;
        for (; n > 1; n /= 2) count++;
        return count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(lg(i) + "____");
            System.out.println(lg2(i));
        }
    }
}
