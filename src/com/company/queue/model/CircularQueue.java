package com.company.queue.model;

import java.util.NoSuchElementException;

public class CircularQueue<T> {

    private T[] queue;
    private int front;
    private int back;

    public CircularQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public void add(T obj) {
        if (size() == queue.length - 1) {
            int numItems = size();

            T[] newArray = (T[]) new Object[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            front = 0;
            back = numItems;
            queue = newArray;
        }
        queue[back] = obj;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }

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
        } else if (front == queue.length) {
            front = 0;
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
        if (front <= back) {
            return back - front;
        }
        return back - front + queue.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        System.out.println();
    }

}
