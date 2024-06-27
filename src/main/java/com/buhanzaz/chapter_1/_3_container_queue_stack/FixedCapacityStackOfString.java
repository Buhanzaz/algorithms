package com.buhanzaz.chapter_1._3_container_queue_stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// USE to be or not to - be - - that - - - is
public class FixedCapacityStackOfString {
    private final String[] stack;
    private int N;

    public FixedCapacityStackOfString(int cap) {
        stack = new String[cap];
    }

    public void push(String item) {
        stack[N++] = item;
    }

    public String pop() {
        return stack[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(100);

        while(! StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }
}
