package com.company.sorting;

import org.apache.commons.lang3.ArrayUtils;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class SortingUtil {

    public static int[] bubbleSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            throw new InvalidParameterException("Invalid array");
        }
        int unsortedPartitionIndex = arr.length - 1;

        while (unsortedPartitionIndex > 0) {
            for (int i = 0; i < unsortedPartitionIndex; i++) {
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
            for (int i = 0; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largestElementPosition]) {
                    largestElementPosition = i;
                }
            }
            swap(arr, lastUnsortedIndex, largestElementPosition);
            lastUnsortedIndex--;
        }
        return arr;
    }

    public static int[] insertionSort_iterative(int[] arr) {
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

    public static int[] insertionSort_recursive(int[] arr, int numItems) {
        if (numItems < 2) {
            return null;
        }

        int unsortedIndex = numItems - 1;

        insertionSort_recursive(arr, unsortedIndex);

        int el = arr[unsortedIndex];
        int j;
        for (j = unsortedIndex; j > 0 && arr[j - 1] > el; j--) {
            arr[j] = arr[j - 1];
        }
        arr[j] = el;

        return arr;
    }

    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
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

    public static int[] mergeSort(int[] arr, int start, int end, SortOrderCO sortOrder) {
        if (end - start < 2) {
            return null;
        }

        // do partitioning
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid, sortOrder);
        mergeSort(arr, mid, end, sortOrder);
        merge(arr, start, mid, end, sortOrder);
        return arr;
    }

    private static void merge(int[] arr, int start, int mid, int end, SortOrderCO sortOrder) {
        if (sortOrder == SortOrderCO.ASCENDING && arr[mid - 1] <= arr[mid] ||
                sortOrder == SortOrderCO.DESCENDING && arr[mid - 1] >= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            if (sortOrder == SortOrderCO.ASCENDING) {
                temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            } else {
                temp[tempIndex++] = arr[i] >= arr[j] ? arr[i++] : arr[j++];
            }
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
            while (i < j && arr[--j] >= pivot) ;
            if (i < j) {
                arr[i] = arr[j];
            }

            // NOTE: empty loop body
            while (i < j && arr[++i] <= pivot) ;
            if (i < j) {
                arr[j] = arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }

    public static int[] countingSort(int[] arr, int min, int max) {

        int[] countArray = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i] - min]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[arrIndex++] = i + min;
                countArray[i]--;
            }
        }
        return arr;
    }

    public static int[] radixSort(int[] arr, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
        return arr;
    }

    private static void radixSingleSort(int[] arr, int position, int radix) {
        int numItems = arr.length;

        int[] countArray = new int[radix];

        for (int value : arr) {
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }

        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    public static int[] jdkSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] parallelJDKSort(int[] arr) {
        Arrays.parallelSort(arr);
        return arr;
    }

    public static String[] radixSort_challenge(String[] arr, int width) {
        int radix = 26;
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(arr, i, radix);
        }
        return arr;
    }

    private static void radixSingleSort(String[] arr, int position, int radix) {
        int numItems = arr.length;

        int[] countArray = new int[radix];

        for (String value : arr) {
            countArray[getCountArrayPosition(value, position)]++;
        }

        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getCountArrayPosition(arr[tempIndex], position)]] = arr[tempIndex];
        }

        System.arraycopy(temp, 0, arr, 0, numItems);
    }

    private static int getCountArrayPosition(String value, int position) {
        return value.charAt(position) - 'a';
    }
}
