package com.buhanzaz.chapter_1._2_abstraction_data;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Листинг 1.2.4
 */
public class FlipsMax {
    public static Counter max(Counter x, Counter y) {
        if (x.tally() > y.tally()) return x;
        else return y;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("орлы");
        Counter tails = new Counter("решки");

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();

            if (heads.tally() == tails.tally())
                StdOut.println("Ничья");
            else
                StdOut.printf(max(heads, tails) + " победили!\n");
        }
    }
}
