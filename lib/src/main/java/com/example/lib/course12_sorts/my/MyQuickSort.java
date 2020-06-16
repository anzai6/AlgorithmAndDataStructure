package com.example.lib.course12_sorts.my;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * 快速排序：时间复杂度nlogn,原地排序，非稳定性
 * （原理：挑选一个数作为基点将数组分为小于基点和大于等于基点两个区间，依次递归下去）
 * Created by qinshunan on 2019/3/6.
 */

public class MyQuickSort {

    /**
     * 快速排序
     *
     * @param arr 待排序数组
     * @param n   数组大小
     */
    public void quickSor(int[] arr, int n) {
        mergeSortInternally(arr, 0, n - 1);
    }

    /**
     * 快速排序从p~r区间（包含r）的数组项
     *
     * @param arr
     * @param p
     * @param r
     */
    private void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) return;
        int m = getMiddle(arr, p, r);
        mergeSortInternally(arr, p, m-1);
        mergeSortInternally(arr, m + 1, r);
    }

    /**
     * 获取p~r区间内某个值的分界点
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private int getMiddle(int[] arr, int p, int r) {
        int basicItem = arr[r]; // 比较的基准，
        int m = p; // m即是将要返回的分界点，小于m（不包括m）的是小于基准项的区间，大于m的是大于等于基准项的区间

        for (int i = p; i < r; i++) { // 因为arr[r]选为基准，不用遍历
            if (arr[i] < basicItem) { // 小于放到m以内的区间
                if (i == m) { // 即是还没有大于等于基准的数字出现
                    m++;
                } else { // 已经有大于等于基准的数字出现,所以i和m不同步了，i在前面
                    int index = arr[i];
                    arr[i] = arr[m];
                    arr[m] = index;
                    m++;
                }
            }
        }


        arr[r] = arr[m];
        arr[m] = basicItem;
        return m;
    }

    public static void main(String[] args) {
        MyQuickSort myQuickSort = new MyQuickSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("快速排序：");
        myQuickSort.quickSor(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
