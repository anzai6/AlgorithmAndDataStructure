package com.example.lib.course13_sort.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * 计数排序：要求排序的都是数组中存储的都是非负整数，而且范围不大，可做成稳定性的，需要空间n即非原地排序,时间复杂的是：7n+c
 * 如果数据过大或者是负数，可以降低数值（如全部元素减去10000）或者变为正整数排序再逆序
 * Created by qinshunan on 2019/3/11.
 */
public class CountingSort {


    /**
     * 计数排序，假设数组中存储的都是非负整数。
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return;
        }
        if (arr.length == 1) {
            return;
        }
        int maxItem = arr[0];
        // 在不知道最大值的情况下，遍历一次寻找最大值
        for (int i = 1; i < len; i++) {
            if (arr[i] > maxItem) {
                maxItem = arr[i];
            }
        }

        // 根据最大值创建新数组，所以不是原地排序了
        int[] countArr = new int[maxItem + 1];
        // 计算每个元素的个数，放入countArr中，arr数组的值对应countArr的下标；比如arr的某个值2,则countArr[2]的值对应的是arr[]=2的个数
        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }
        // 将计数结果汇总，这一步是精华，汇总后每个元素存放她在 arr 数组的顶格位置，
        // 比如 countArr[8] = 9; 则元素8的最大 position 为在 arr 的下标为 9 的 item，结合下面的排序就懂了
        for (int i = 1; i < maxItem + 1; i++) {
            countArr[i] += countArr[i - 1];
        }

        // 新建数组存放排序好的元素
        int[] tempArr = new int[len];
        // 排序，从后往前遍历（为了保证稳定性）原数组 aar ，遍历到某个 item 时去 countArr 查看所处的最大位置下标，
        // 然后存入对应下标的 tempArr 数组
        for (int i = len - 1; i >= 0; i--) {
            int value = arr[i];
            int valueIndex = (countArr[value]-- - 1);
            tempArr[valueIndex] = value;
        }

        // copy
        for (int i = 0; i < len; i++) {
            arr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 100;
        int[] data1 = Sorts.getRandomArray(n);
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
