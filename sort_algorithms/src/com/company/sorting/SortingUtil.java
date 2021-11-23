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

    public static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int recursiveFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return null;
        }

        // do partitioning
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
        return arr;
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
         while (i < mid && j < end) {
             temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
         }

         System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
         System.arraycopy(temp, 0, arr, start, tempIndex);
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return null;
        }

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && arr[--j] >= pivot);
            if (i < j) {
                arr[i] = arr[j];
            }

            // NOTE: empty loop body
            while (i < j && arr[++i] <= pivot);
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }
}
