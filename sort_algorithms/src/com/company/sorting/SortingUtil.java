package com.company.sorting;

import org.apache.commons.lang3.ArrayUtils;

import java.security.InvalidParameterException;

public class SortingUtil {

    public static int[] bubbleSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            throw new InvalidParameterException("Invalid array");
        }
        int unsortedPartitionIndex = arr.length - 1;

        while (unsortedPartitionIndex > 0) {
            for(int i = 0; i < unsortedPartitionIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            unsortedPartitionIndex--;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            throw new InvalidParameterException("Invalid array");
        }
        int lastUnsortedIndex = arr.length - 1;

        while (lastUnsortedIndex > 0) {
            int largestElementPosition = 0;
            for(int i = 0; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largestElementPosition]) {
                    largestElementPosition = i;
                }
            }
            swap(arr, lastUnsortedIndex, largestElementPosition);
            lastUnsortedIndex--;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int el = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > el; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = el;
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int el = arr[i];
                int j;
                for (j = i; j > 0 && arr[j - gap] > el; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = el;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
