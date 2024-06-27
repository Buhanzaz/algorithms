package com.buhanzaz.chapter_1._3_container_queue_stack.exercises;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.EmptyStackException;

/**Упражнение 1.3.1*/
// USE to be or not to - be - - that - - - is
public class FixedCapacityStack<Item> {
    private final Item[] stack;
    private int n;
    private int max;

    public FixedCapacityStack(int cap) {
        stack = (Item[]) new Object[cap];
        max = cap;
    }

    public void push(Item item) {
        if (isFull()) throw new StackOverflowError("Stack overflow");

        stack[n++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack[--n];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == max;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(2);

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }
}
