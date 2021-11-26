package com.company.list.model.linked_list.single.employee;

import com.company.list.model.Employee;

public class EmployeeLinkedList {
    private EmployeeLinkedNode head;
    private int size;

    public int getSize() {
        return size;
    }

    public void addToFront(Employee employee) {
        EmployeeLinkedNode node = new EmployeeLinkedNode(employee);
        node.setNext(head);
        this.head = node;
        size++;
    }

    public EmployeeLinkedNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeLinkedNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeLinkedNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
