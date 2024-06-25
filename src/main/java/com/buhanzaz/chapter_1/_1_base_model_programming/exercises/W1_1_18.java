package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

/** Если мы заменяем знак в данном алгоритме (a + a) на (a * a) мы получаем рекурсивное возведение в степень.
 * Если не менять знак мы получаем рекурсивное умножение*/
public class W1_1_18 {
    public static int mystery(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        System.out.println(mystery(5, 2));
    }
}
