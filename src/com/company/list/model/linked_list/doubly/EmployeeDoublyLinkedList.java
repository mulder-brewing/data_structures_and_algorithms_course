package com.company.list.model.linked_list.doubly;

import com.company.list.model.Employee;

import java.util.Objects;

public class EmployeeDoublyLinkedList {
    private EmployeeDoublyLinkedNode head;
    private EmployeeDoublyLinkedNode tail;
    private int size;

    public int getSize() {
        return size;
    }

    public EmployeeDoublyLinkedNode getHead() {
        return head;
    }

    public EmployeeDoublyLinkedNode getTail() {
        return tail;
    }

    public void addToFront(Employee employee) {
        EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(employee);

        if (isEmpty()) {
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(employee);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public boolean addBefore(Employee employee, Employee addBeforeEmployee) {
        // Find the employee
        EmployeeDoublyLinkedNode addBeforeNode = head;
        while (addBeforeNode != null) {
            if (addBeforeNode.getEmployee().equals(addBeforeEmployee)) {
                // Found it, insert before.
                EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(employee);
                if (addBeforeNode.equals(head)) {
                    head = node;
                } else {
                    addBeforeNode.getPrevious().setNext(node);
                }
                node.setPrevious(addBeforeNode.getPrevious());
                addBeforeNode.setPrevious(node);
                node.setNext(addBeforeNode);
                size++;
                return true;
            }
            addBeforeNode = addBeforeNode.getNext();
        }
        return false;
    }

    public EmployeeDoublyLinkedNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeDoublyLinkedNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(head.getPrevious());
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        removedNode.setPrevious(null);
        return removedNode;
    }

    public EmployeeDoublyLinkedNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeDoublyLinkedNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(tail.getNext());
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setNext(null);
        removedNode.setPrevious(null);
        return removedNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeDoublyLinkedNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDoublyLinkedList that = (EmployeeDoublyLinkedList) o;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail) &&
                nodesAreEqual(that);
    }

    private boolean nodesAreEqual(EmployeeDoublyLinkedList that) {
        EmployeeDoublyLinkedNode thisCurrentNode = head;
        EmployeeDoublyLinkedNode thatCurrentNode = that.getHead();
        while (thisCurrentNode != null && thatCurrentNode != null) {
            if (!thisCurrentNode.equals(thatCurrentNode)) {
                return false;
            }
            thisCurrentNode = thisCurrentNode.getNext();
            thatCurrentNode = thatCurrentNode.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }
}
