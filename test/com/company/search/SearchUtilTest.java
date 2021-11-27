package com.company.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchUtilTest {

    @Test
    void test_linearSearchIndex() {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        Assertions.assertEquals(3, SearchUtil.linearSearchIndex(intArray, 7));
        Assertions.assertEquals(6, SearchUtil.linearSearchIndex(intArray, -22));
        Assertions.assertEquals(-1, SearchUtil.linearSearchIndex(intArray, 100));
    }

    @Test
    void test_binarySearchRecursive() {
        int[] intArray = { -22, -15, 1, 7, 13, 22, 54, 55 };
        Assertions.assertEquals(7, SearchUtil.binarySearchRecursive(intArray, 55));
        Assertions.assertEquals(0, SearchUtil.binarySearchRecursive(intArray, -22));
        Assertions.assertEquals(-1, SearchUtil.binarySearchRecursive(intArray, 100));
    }

}