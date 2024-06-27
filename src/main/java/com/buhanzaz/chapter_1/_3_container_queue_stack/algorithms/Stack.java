package com.buhanzaz.chapter_1._3_container_queue_stack.algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**Алгоритм 1.2*/
// USE to be or not to - be - - that - - - is
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(в стеке осталось " + stack.size() + ")");
    }


    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        Item item = first.item;
        first = first.next;

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
