package com.company.list.model.linked_list.single.integer;

public class IntegerLinkedList {
    private IntegerLinkedNode head;
    private int size;

    public IntegerLinkedNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertSorted(Integer integer) {
        IntegerLinkedNode node = new IntegerLinkedNode(integer);

        if (isEmpty()) {
            head = node;
        } else {
            // Find correct sorted position to insert
            IntegerLinkedNode currentNode = head;
            IntegerLinkedNode insertAfterNode = null;
            while (currentNode != null) {
                if (node.getInteger() >= currentNode.getInteger() &&
                        (currentNode.getNext() == null || node.getInteger() <= currentNode.getNext().getInteger())) {
                    insertAfterNode = currentNode;
                    break;
                }
                currentNode = currentNode.getNext();
            }

            if (insertAfterNode == null) {
                // insert at the front
                node.setNext(head);
                head = node;
            } else {
                // insert after that node
                node.setNext(insertAfterNode.getNext());
                insertAfterNode.setNext(node);
            }
        }
        size++;
    }

    public void printList() {
        IntegerLinkedNode current = head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
            if (current == null) {
                System.out.println();
            }
        }
    }
}
