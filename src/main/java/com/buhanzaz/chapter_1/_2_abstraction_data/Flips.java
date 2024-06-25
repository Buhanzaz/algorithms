package com.buhanzaz.chapter_1._2_abstraction_data;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**Листинг 1.2.1*/
public class Flips {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("орлов");
        Counter tails = new Counter("решек");

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();

            StdOut.println(heads);
            StdOut.println(tails);

            int d = heads.tally() - tails.tally();

            StdOut.printf("Разница: %d\n", d);
        }
    }
}
