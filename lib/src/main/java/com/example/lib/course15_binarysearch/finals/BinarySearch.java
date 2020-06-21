package com.example.lib.course15_binarysearch.finals;

import com.example.lib.course13_sort.finals.CountingSort;

import java.util.HashMap;

/**
 * 二分查找
 * Created by qinshunan on 2019/3/12.
 */

public class BinarySearch {

    /**
     * 二分查找(要求数组有序，不重复)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int len, int value) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] > value) { // 大于，在下区间
                high = center - 1;
            } else if (arr[center] < value) { // 小于，在上区间
                low = center + 1;
            } else {
                return center;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int recursionBinarySearch(int[] arr, int len, int value) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return -1;
        }
        return subRecursionBinarySearch(arr, 0, len - 1, value);
    }

    public int subRecursionBinarySearch(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int center = (low + high) / 2;
        if (arr[center] > value) { // 大于，在下区间
            return subRecursionBinarySearch(arr, low, center - 1, value);
        } else if (arr[center] < value) { // 小于，在上区间
            return subRecursionBinarySearch(arr, center + 1, high, value);
        } else {
            return center;
        }
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int maxValue = 2 * n;
        int value = (int) (Math.random() * maxValue);
        int[] data1 = getRandomArrayNoSame(n, maxValue);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("计数排序：");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        BinarySearch myBinarySearch = new BinarySearch();
        int a1 = myBinarySearch.binarySearch(data1, n, value);
        int a2 = myBinarySearch.recursionBinarySearch(data1, n, value);
        System.out.println("二分查找：value = " + value + ", 位置：" + a1 + " : " + a2);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * 获取一个随机数组,元素不同
     *
     * @param n 长度
     * @return
     */
    public static int[] getRandomArrayNoSame(int n, int maxValue) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int newValue = (int) (Math.random() * maxValue);
            while (hashMap.containsKey(newValue)) {
                newValue = (int) (Math.random() * maxValue);
            }
            hashMap.put(Integer.valueOf(newValue), Integer.valueOf(newValue));
            data[i] = newValue;
        }
        return data;
    }
}
