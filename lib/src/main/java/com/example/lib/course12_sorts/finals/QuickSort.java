package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * 快速排序：时间复杂度nlogn,原地排序，非稳定性
 * （原理：挑选一个数作为基点将数组分为小于基点和大于等于基点两个区间，依次递归下去）
 * 复杂度分析：f(n) = f(k)+f(n-k)+n
 * 最坏情况，k每次为1，时间复杂度就是 O(n^2);
 * 最好情况,k每次为n/2，参照归并计算，时间复杂度就是 O(nlog^n);
 * 平均情况，
 * Created by qinshunan on 2019/3/6.
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr 待排序数组
     * @param n   数组大小
     */
    public void quickSort(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return;
        }
        quickSortInternally(arr, 0, n - 1);
    }

    /**
     * 快速排序从p~r区间（包含r）的数组项
     *
     * @param arr
     * @param p
     * @param r
     */
    private void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int center = getMiddle(arr, p, r);
        quickSortInternally(arr, p, center - 1);
        quickSortInternally(arr, center + 1, r);
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
        // 这个值可以进行优化，比如三数取中(头尾中间值三个数取中位数)，或者随机取一个值，这里为了方便直接取最后一位
        int value = arr[r];
        int center = p; // 遍历结束后 value 的坐标，即分界点坐标，左边是小于 value 的值，右边是大于 value 的值
        int i = p;
        while (i < r) {
            if (arr[i] >= value) {
                i++;
                continue;
            } else {
                int temp = arr[i];
                arr[i] = arr[center];
                arr[center] = temp;
                center++;
                i++;
            }
        }
        // 将 center 的值和最后一位交换
        arr[r] = arr[center];
        arr[center] = value;
        return center;
    }

    public static void main(String[] args) {
        QuickSort myQuickSort = new QuickSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("快速排序：");
        myQuickSort.quickSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
