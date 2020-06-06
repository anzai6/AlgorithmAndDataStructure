package com.example.lib.course13_sort.finals;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * 计数排序：要求排序的都是数组中存储的都是非负整数，而且范围不大，可做成稳定性的，需要空间n即非原地排序,时间复杂的是：7n+c
 * Created by qinshunan on 2019/3/11.
 */
public class CountingSort {


    /**
     * 计数排序
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {

    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 1000;
        int[] data1 = MySorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("计数排序：");
        myCountingSort.countingSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
