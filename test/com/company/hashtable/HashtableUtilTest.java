package com.company.hashtable;

import com.company.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class HashtableUtilTest {

    @Test
    void test_simpleHashTable() {
        HashtableUtil.probeHashTable();
    }

    @Test
    void test_chainHashTable() {
        HashtableUtil.chainHashTable();
    }

    @Test
    void test_hashMap() {
        HashtableUtil.hashMap();
    }

    @Test
    void test_bucketSort() {
        Assertions.assertArrayEquals(new int[] { 43, 46, 54, 66, 83, 92, 95 },
                HashtableUtil.bucketSort(new int[] { 92, 95, 83, 43, 46, 66, 54 }));
    }

    @Test
    void test_removeDuplicates() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoy = new Employee("Jane", "Doy", 2);
        Employee rickBob = new Employee("Rick", "Bob", 3);

        List<Employee> list = new LinkedList<>();
        list.add(johnDoe);
        list.add(janeDoy);
        list.add(janeDoy);
        list.add(rickBob);

        List<Employee> expected = new LinkedList<>();
        expected.add(johnDoe);
        expected.add(janeDoy);
        expected.add(rickBob);

        Assertions.assertEquals(expected, HashtableUtil.removeDuplicates(list));
    }

}