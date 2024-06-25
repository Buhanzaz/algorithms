package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

/**
 * 1.1.1
 * Чему равно каждое выражение?
 * (0 + 15) / 2
 * 2.0e-6 * 100_000_000.1
 * true && false || true && true
 */
public class TypeOfExpression {
    public static void main(String[] args) {
        System.out.println((0 + 15) / 2); // 5
        System.out.println(2.0e-6 * 100_000_000.01);
        System.out.println(0.000002 * 100_000_000.01);
        System.out.println(true && false || true && true); // true
    }
}
