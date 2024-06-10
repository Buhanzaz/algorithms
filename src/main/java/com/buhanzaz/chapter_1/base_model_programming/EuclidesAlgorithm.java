package com.buhanzaz.chapter_1.base_model_programming;

/**
 * Чтобы вычислить наибольший общий делитель двух не отрицательных целых чисел a и b, нужно сделать следующее.
 * Если b == 0, берем в качестве ответа a. Если не равно 0, разделим a на b с вычислением остатка c. Ответом является
 * наибольший общий делитель b и c.
 */
public class EuclidesAlgorithm {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int c = a % b;
        return gcd(b, c);
    }
}
