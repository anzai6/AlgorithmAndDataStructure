package com.example.lib.course16_binarysearch2.my;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.finals.CountingSort;

/**
 * 二分查找扩展：查找：第一个等于给定值；最后一个等于给定值；第一个大于等于给定值；最后一个小于等于给定值；
 * Created by qinshunan on 2019/3/12.
 */

public class MyNewBinarySearch {

    /**
     * 二分查找(第一个等于给定值)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstEqual(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // 注意不是low < high
            int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
            // 第一个等于给定值则它的小一位不存在或者小于给定值value
            if (arr[mid] == value &&
                    ((mid - 1) < 0 || arr[mid - 1] < value)) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // 记得升一位
            } else if (arr[mid] >= value) {
                high = mid - 1; // 记得降一位
            }
        }

        return -1;
    }

    /**
     * 二分查找(最后一个等于给定值)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchLastEqual(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // 注意不是low < high
            int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
            // 最后一个等于给定值则它的大一位不存在或者大于给定值value
            if (arr[mid] == value &&
                    ((mid + 1) > len-1 || arr[mid + 1] > value)) {
                return mid;
            } else if (arr[mid] <= value) {
                low = mid + 1; // 记得升一位
            } else if (arr[mid] > value) {
                high = mid - 1; // 记得降一位
            }
        }

        return -1;
    }


    /**
     * 二分查找(第一个大于等于给定值)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstBigEqual(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // 注意不是low < high
            int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
            // 第一个大于等于给定值则它的小一位不存在或者小于给定值value
            if (arr[mid] >= value &&
                    ((mid - 1) < 0 || arr[mid - 1] < value)) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // 记得升一位
            } else if (arr[mid] >= value) {
                high = mid - 1; // 记得降一位
            }
        }

        return -1;
    }

    /**
     * 二分查找(最后一个小于等于给定值)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchLastSmallEqual(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // 注意不是low < high
            int mid = low + (high - low) / 2; // 如果写成(low+high)/2则low+high有可能非常大造成整数溢出
            // 最后一个小于等于给定值则它的大一位不存在或者大于等于给定值value
            if (arr[mid] <= value &&
                    ((mid + 1) > len-1 || arr[mid + 1] > value)) {
                return mid;
            } else if (arr[mid] <= value) {
                low = mid + 1; // 记得升一位
            } else if (arr[mid] > value) {
                high = mid - 1; // 记得降一位
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("计数排序：");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        int value = 5;
        MyNewBinarySearch myBinarySearch = new MyNewBinarySearch();
        int a1 = myBinarySearch.binarySearchFirstEqual(data1, n, value);
        System.out.println("二分查找(第一个等于给定值)：" + a1);
        int a2 = myBinarySearch.binarySearchLastEqual(data1, n, value);
        System.out.println("二分查找(最后一个等于给定值)：" + a2);
        int a3 = myBinarySearch.binarySearchFirstBigEqual(data1, n, value);
        System.out.println("二分查找(第一个大于等于给定值)：" + a3);
        int a4 = myBinarySearch.binarySearchLastSmallEqual(data1, n, value);
        System.out.println("二分查找(最后一个小于等于给定值)：" + a4);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
