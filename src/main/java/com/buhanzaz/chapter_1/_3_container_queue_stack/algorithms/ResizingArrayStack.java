package com.buhanzaz.chapter_1._3_container_queue_stack.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
/**Алгоритм 1.1*/
// USE to be or not to - be - - that - - - is
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private final Item[] stack;
    private int N;

    public ResizingArrayStack(int cap) {
        stack = (Item[]) new Object[cap];
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(100);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }

    public void resize(int max) {
        // Перенос стека размером N <= max в новый массив размером max
        if (max < N) throw new StackOverflowError();

        Item[] temp = (Item[]) new Object[max];

        System.arraycopy(stack, 0, temp, 0, N);
    }

    public void push(Item item) {
        if (N == stack.length) resize(stack.length * 2);

        stack[N++] = item;
    }

    public Item pop() {
        Item item = stack[--N];
        stack[N] = null;

        if (N > 0 && N == stack.length / 4) resize(stack.length / 2);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {
        }
    }
}
