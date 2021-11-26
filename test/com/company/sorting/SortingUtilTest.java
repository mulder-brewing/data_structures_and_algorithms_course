package com.company.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.security.InvalidParameterException;

class SortingUtilTest {
    private static final int[] SORTED_ARRAY_ASC = new int[] { 1, 2, 3, 4, 5, 6 };
    private static final int[] SORTED_ARRAY_DSC = new int[] { 6, 5, 4, 3, 2, 1 };

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
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.bubbleSort(generateUnsortedArray()));
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
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.selectionSort(generateUnsortedArray()));
    }

    @Test
    void test_insertionSort_iterative_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.insertionSort_iterative(generateUnsortedArray()));
    }

    @Test
    void test_insertionSort_recursive_success() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC,
                SortingUtil.insertionSort_recursive(generateUnsortedArray(), SORTED_ARRAY_ASC.length));
    }

    @Test
    void test_insertionSort_shellSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.shellSort(generateUnsortedArray()));
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
    void test_mergeSort_ascending() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC,
                SortingUtil.mergeSort(generateUnsortedArray(), 0, SORTED_ARRAY_ASC.length, SortOrderCO.ASCENDING));
    }

    @Test
    void test_mergeSort_descending() {
        Assertions.assertArrayEquals(SORTED_ARRAY_DSC,
                SortingUtil.mergeSort(generateUnsortedArray(), 0, SORTED_ARRAY_DSC.length, SortOrderCO.DESCENDING));
    }

    @Test
    void test_quickSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC,
                SortingUtil.quickSort(generateUnsortedArray(), 0, SORTED_ARRAY_ASC.length));
    }

    @Test
    void test_countingSort_oneToTen() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.countingSort(generateUnsortedArray(), 1, 6));
    }

    @Test
    void test_countingSort_tenToTwenty() {
        Assertions.assertArrayEquals(new int[] { 10, 11, 11, 12, 14 },
                SortingUtil.countingSort(new int[] { 14, 12, 11, 11, 10 }, 10, 20));
    }

    @Test
    void test_radixSort() {
        int[] unsorted = new int[] { 4725, 4586, 1330, 8792, 1594, 5729 };
        int[] expected = new int[] { 1330, 1594, 4586, 4725, 5729, 8792 };
        Assertions.assertArrayEquals(expected, SortingUtil.radixSort(unsorted, 10, 4));
    }

    @Test
    void test_jdkSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.jdkSort(generateUnsortedArray()));
    }

    @Test
    void test_parallelJDKSort() {
        Assertions.assertArrayEquals(SORTED_ARRAY_ASC, SortingUtil.parallelJDKSort(generateUnsortedArray()));
    }

    @Test
    void test_radixSort_challenge() {
        Assertions.assertArrayEquals(new String[] { "abcde", "bbbbb", "bcdef", "dbaqc", "omadd" },
                SortingUtil.radixSort_challenge(new String[] { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" }, 5));
    }
}