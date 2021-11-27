package com.company.search;

public class SearchUtil {

    public static int linearSearchIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int value) {
        return binarySearchRecursive(arr, 0, arr.length - 1, value);
    }

    private static int binarySearchRecursive(int[] arr, int start, int end, int value) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] > value) {
            return binarySearchRecursive(arr, start, middle - 1, value);
        } else {
            return binarySearchRecursive(arr, middle + 1, end, value);
        }
    }
}
