package com.buhanzaz.chapter_1._3_container_queue_stack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(" -> {
                }
                case "+", "-", "*", "/" -> ops.push(s);
                case ")" -> {
                    String op = ops.pop();
                    double val = vals.pop();

                    switch (op) {
                        case "+" -> val += vals.pop();
                        case "-" -> val -= vals.pop();
                        case "*" -> val *= vals.pop();
                        case "/" -> val /= vals.pop();
                        case "sqrt" -> val = Math.sqrt(val);
                    }
                    vals.push(val);
                }
                default -> vals.push(Double.parseDouble(s));
            }
            StdOut.println(vals.pop());
        }

    }
}
