package com.example.lib.course15_binarysearch.my;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.my.MyCountingSort;

/**
 * 二分查找
 * Created by qinshunan on 2019/3/12.
 */

public class MyBinarySearch {

    /**
     * 二分查找(要求数组有序，不重复)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // 注意不是low < high
            int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // 记得升一位
            } else if (arr[mid] > value) {
                high = mid - 1; // 记得降一位
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
        if (len <= 0)
            return -1;
        return subRecursionBinarySearch(arr, 0, len - 1, value);
    }

    public int subRecursionBinarySearch(int[] arr, int low, int high, int value) {
        if (low == high) {
            if (arr[low] == value) {
                return low;
            } else {
                return -1;
            }
        } else if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
        int a1 = subRecursionBinarySearch(arr, low, mid, value);
        int a2 = subRecursionBinarySearch(arr, mid + 1, high, value);

        return a1 != -1 ? a1 : a2;
    }

    public static void main(String[] args) {
        MyCountingSort myCountingSort = new MyCountingSort();
        int n = 4;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("计数排序：");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        MyBinarySearch myBinarySearch = new MyBinarySearch();
        int a1 = myBinarySearch.binarySearch(data1, n, 1);
        int a2 = myBinarySearch.recursionBinarySearch(data1, n, 1);
        System.out.println("二分查找：" + a1 + " : " + a2);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
