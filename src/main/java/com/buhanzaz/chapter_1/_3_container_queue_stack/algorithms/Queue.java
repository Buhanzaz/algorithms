package com.buhanzaz.chapter_1._3_container_queue_stack.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Алгоритм 1.3
 */
// USE to be or not to - be - - that - - - is
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    public Queue() {
        first = null;
        n = 0;
    }

    public static void main(String[] args) {
        Queue<String> stack = new Queue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.enqueue(item);
            else if (!stack.isEmpty()) StdOut.print(stack.dequeue() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;

        if (oldLast == null) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (first == null) last = null;

        n--;

        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return first.item;
    }

    public boolean isEmpty() {
        return first == null || this.n == 0;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
