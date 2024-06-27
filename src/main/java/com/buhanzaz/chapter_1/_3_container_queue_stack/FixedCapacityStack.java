package com.buhanzaz.chapter_1._3_container_queue_stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// USE to be or not to - be - - that - - - is
public class FixedCapacityStack<Item> {
    private final Item[] stack;
    private int N;

    public FixedCapacityStack(int cap) {
        stack = (Item[]) new Object[cap];
    }

    public void push(Item item) {
        stack[N++] = item;
    }

    public Item pop() {
        return stack[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);

        while(! StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }
}
