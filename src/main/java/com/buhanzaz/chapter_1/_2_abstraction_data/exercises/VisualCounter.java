package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

public class VisualCounter {
    private int N;
    private int max;
    private int counter;
    private int totalOperations;

    public VisualCounter(int n, int max) {
        N = n;
        this.max = Math.abs(max);

        StdDraw.setCanvasSize(256, 256);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0, n + 1);
        StdDraw.setYscale(-max - 3, max + 3);
    }

    public void increment() {
        if (counter != max && totalOperations < N) {
            counter++;
            totalOperations++;

            draw();
        }
    }

    public void decrement() {
        if (Math.abs(counter) <= max && totalOperations < N) {
            counter--;
            totalOperations++;

            draw();
        }
    }

    public void draw() {
        StdDraw.point(totalOperations, counter);
    }

    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(100, 1000);

        for (int i = 0; i < 100; i++) {
            if (Math.random() >= 0.2) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }
    }

}
