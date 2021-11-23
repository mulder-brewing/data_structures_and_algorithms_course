package com.company.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;
import java.security.InvalidParameterException;

public class SortingUtilTest {

    private static final int[] SORTED_ARRAY = new int[] { 1, 2, 3, 4, 5, 6 };
    
    private static int[] generateUnsortedArray() {
        return new int[] { 5, 3, 1, 2, 6, 4 };
    }

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
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.bubbleSort(generateUnsortedArray()));
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
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.selectionSort(generateUnsortedArray()));
    }

    @Test
    void test_insertionSort_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.insertionSort(generateUnsortedArray()));
    }

    @Test
    void test_insertionSort_shellSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.shellSort(generateUnsortedArray()));
    }

    @Test
    void test_iterativeFactorial() {
        Assertions.assertEquals(6, SortingUtil.iterativeFactorial(3));
    }

    @Test
    void test_recursiveFactorial() {
        Assertions.assertEquals(6, SortingUtil.recursiveFactorial(3));
    }

    @Test
    void test_mergeSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.mergeSort(generateUnsortedArray(), 0, SORTED_ARRAY.length));
    }

    @Test
    void test_quickSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY, SortingUtil.quickSort(generateUnsortedArray(), 0, SORTED_ARRAY.length));
    }

}
