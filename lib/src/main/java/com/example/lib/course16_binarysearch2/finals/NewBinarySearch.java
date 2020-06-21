package com.example.lib.course16_binarysearch2.finals;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.finals.CountingSort;

/**
 * 二分查找扩展：查找：第一个等于给定值；最后一个等于给定值；第一个大于等于给定值；最后一个小于等于给定值；
 * Created by qinshunan on 2019/3/12.
 */

public class NewBinarySearch {

    /**
     * 二分查找(第一个等于给定值)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstEqual(int[] arr, int len, int value) {
        if (arr == null || len == 0 || arr.length < len) {
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
                // 相等的情况下，判断低一位是不是小于value，如果是证明就是第一个等于value的
                if (center <= 0 || arr[center - 1] < value) {
                    return center;
                } else { // 否则，继续往下区间找
                    high = center - 1;
                }
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
        if (arr == null || len == 0 || arr.length < len) {
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
                // 相等的情况下，判断高一位是不是大于value，如果是证明就是最后一个等于value的
                if (center >= len - 1 || arr[center + 1] > value) {
                    return center;
                } else { // 否则，继续往上区间找
                    low = center + 1;
                }
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
        if (arr == null || len == 0 || arr.length < len) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] >= value) { // 大于等于
                // 判断低一位是不是小于value，如果是证明就是第一个大于等于value的
                if (center <= 0 || arr[center - 1] < value) {
                    return center;
                } else { // 否则，继续往下区间找
                    high = center - 1;
                }
            } else { // 小于，在上区间
                low = center + 1;
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
        if (arr == null || len == 0 || arr.length < len) {
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
            } else { // 小于等于
                // 判断高一位是不是大于value，如果是证明就是最后一个小于等于value的
                if (center >= len - 1 || arr[center + 1] > value) {
                    return center;
                } else { // 否则，继续往上区间找
                    low = center + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int value = (int) (Math.random() * n);
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("计数排序：");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        System.out.println("二分查找的值：value = " + value);
        NewBinarySearch myBinarySearch = new NewBinarySearch();
        int a1 = myBinarySearch.binarySearchFirstEqual(data1, n, value);
        System.out.println("第一个等于给定值：" + a1);
        int a2 = myBinarySearch.binarySearchLastEqual(data1, n, value);
        System.out.println("最后一个等于给定值：" + a2);
        int a3 = myBinarySearch.binarySearchFirstBigEqual(data1, n, value);
        System.out.println("第一个大于等于给定值：" + a3);
        int a4 = myBinarySearch.binarySearchLastSmallEqual(data1, n, value);
        System.out.println("最后一个小于等于给定值：" + a4);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
