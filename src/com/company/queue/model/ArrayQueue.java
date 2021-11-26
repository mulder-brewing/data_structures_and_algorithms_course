package com.company.queue.model;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    private T[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public void add(T obj) {
        if (back == queue.length) {
            T[] newArray = (T[]) new Object[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back++] = obj;
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T removed = queue[front];
        queue[front] = null;
        front++;

        if (isEmpty()) {
            front = 0;
            back = 0;
        }

        return removed;
    }

    public T peak() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        System.out.println();
    }

}
