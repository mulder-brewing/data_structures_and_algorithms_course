package com.company.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;
import java.security.InvalidParameterException;

public class SortingUtilTest {

    private static int[] UNSORTED_ARRAY = new int[] { 5, 3, 1, 2, 6, 4 };
    private static int[] SORTED_ARRAY = new int[] { 1, 2, 3, 4, 5, 6 };

    @Test
    void test_bubbleSort_nullArray() {
        testHelper_invalidArray(() -> SortingUtil.bubbleSort(null));
    }

    @Test
    void test_bubbleSort_emptyArray() {
        testHelper_invalidArray(() -> SortingUtil.bubbleSort(new int[0]));
    }

    private static void testHelper_invalidArray(Executable executable) {
        InvalidParameterException ipe = Assertions.assertThrows(InvalidParameterException.class, executable);
        Assertions.assertEquals("Invalid array", ipe.getMessage());
    }

    @Test
    void test_bubbleSort_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.bubbleSort(UNSORTED_ARRAY));
    }

    @Test
    void test_selectionSort_nullArray() {
        testHelper_invalidArray(() -> SortingUtil.selectionSort(null));
    }

    @Test
    void test_selectionSort_emptyArray() {
        testHelper_invalidArray(() -> SortingUtil.selectionSort(new int[0]));
    }

    @Test
    void test_selectionSort_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.selectionSort(UNSORTED_ARRAY));
    }

    @Test
    void test_insertionSort_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.insertionSort(UNSORTED_ARRAY));
    }

    @Test
    void test_insertionSort_shellSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.shellSort(UNSORTED_ARRAY));
    }

}
