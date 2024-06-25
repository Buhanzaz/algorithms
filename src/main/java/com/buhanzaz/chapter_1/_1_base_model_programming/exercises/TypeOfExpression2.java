package com.buhanzaz.chapter_1._1_base_model_programming.exercises;

/**
 * 1.1.2
 * Чему равно каждое выражение?
 * (1 + 2.236) / 2
 * 1 + 2 + 3 + 4.0
 * 4.1 >= 4
 * 1 + 2 + "3"
 */
public class TypeOfExpression2 {
    public static void main(String[] args) {
        System.out.println((1 + 2.236) / 2); // 1.618
        System.out.println(1 + 2 + 3 + 4.0); // 10.0
        System.out.println(4.1 >= 4); // true
        System.out.println(1 + 2 + "3"); // 33
    }
}
