package com.company.stack.model;

import java.util.LinkedList;

public class LinkedStack<X> {

    private LinkedList<X> stack;

    public LinkedStack() {
        stack = new LinkedList<X>();
    }

    public void push(X obj) {
        stack.push(obj);
    }

    public X peek() {
        return stack.peek();
    }

    public X pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        stack.forEach(o -> System.out.println(o));
        System.out.println();
    }
}
