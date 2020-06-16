package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * 快速排序：时间复杂度nlogn,原地排序，非稳定性
 * （原理：挑选一个数作为基点将数组分为小于基点和大于等于基点两个区间，依次递归下去）
 * Created by qinshunan on 2019/3/6.
 */

public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr 待排序数组
     * @param n   数组大小
     */
    public void quickSor(int[] arr, int n) {
    }

    /**
     * 快速排序从p~r区间（包含r）的数组项
     *
     * @param arr
     * @param p
     * @param r
     */
    private void mergeSortInternally(int[] arr, int p, int r) {
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
        return 0;
    }

    public static void main(String[] args) {
        QuickSort myQuickSort = new QuickSort();
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
