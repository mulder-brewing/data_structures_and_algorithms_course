package com.company.list;

import com.company.list.model.Employee;
import com.company.list.model.linked_list.doubly.EmployeeDoublyLinkedList;
import com.company.list.model.linked_list.single.integer.IntegerLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListUtilTest {
    @Test
    void test_arrayListBasics() {
        ListUtil.arrayListBasics();
    }

    @Test
    void test_vectorBasics() {
        ListUtil.vectorBasics();
    }

    @Test
    void test_linkedList() {
        ListUtil.linkedList();
    }

    @Test
    void test_doublyLinkedList() {
        ListUtil.doublyLinkedList();
    }

    @Test
    void test_jdkLinkedList() {
        ListUtil.jdkLinkedList();
    }

    @Test
    void test_addBeforeChallenge_success() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(johnDoe);
        list.addToFront(janeDoe);
        list.addToFront(johnWick);

        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        Assertions.assertTrue(list.addBefore(tonyMontanna, janeDoe));

        EmployeeDoublyLinkedList expected = new EmployeeDoublyLinkedList();
        expected.addToFront(johnDoe);
        expected.addToFront(janeDoe);
        expected.addToFront(tonyMontanna);
        expected.addToFront(johnWick);

        Assertions.assertEquals(expected, list);
    }

    @Test
    void test_addBeforeChallenge_success_replaceHead() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(johnDoe);
        list.addToFront(janeDoe);
        list.addToFront(johnWick);

        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        Assertions.assertTrue(list.addBefore(tonyMontanna, johnWick));

        EmployeeDoublyLinkedList expected = new EmployeeDoublyLinkedList();
        expected.addToFront(johnDoe);
        expected.addToFront(janeDoe);
        expected.addToFront(johnWick);
        expected.addToFront(tonyMontanna);

        Assertions.assertEquals(expected, list);
    }

    @Test
    void test_addBeforeChallenge_addBeforeNotFound() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(johnDoe);
        list.addToFront(janeDoe);
        list.addToFront(johnWick);

        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        Assertions.assertFalse(list.addBefore(tonyMontanna, tonyMontanna));
    }

    @Test
    void test_insertSorted() {
        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(4);
        list.insertSorted(2);
        list.insertSorted(1);
        list.insertSorted(5);

        Assertions.assertEquals(1, list.getHead().getInteger());
        Assertions.assertEquals(2, list.getHead().getNext().getInteger());
        Assertions.assertEquals(4, list.getHead().getNext().getNext().getInteger());
        Assertions.assertEquals(5, list.getHead().getNext().getNext().getNext().getInteger());
    }
}