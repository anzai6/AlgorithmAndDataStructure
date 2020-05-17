package com.example.lib.course13_sort.my;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * 计数排序：要求排序的都是数组中存储的都是非负整数，而且范围不大，可做成稳定性的，需要空间n即非原地排序,时间复杂的是：7n+c
 * Created by qinshunan on 2019/3/11.
 */
public class MyCountingSort {


    /**
     * 计数排序
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {

        if (len <= 1)
            return;

        int maxItem = 0;

        // 找出最大值
        for (int i = 0; i < len; i++) {
            if (maxItem < arr[i])
                maxItem = arr[i];
        }

        // 申请一个计数数组newCountArr，下标大小[0,maxItem],
        int[] newCountArr = new int[maxItem + 1];

        // 计算每个元素的个数，放入newCountArr中，arr数组的值对应newCountArr的下标；比如arr的某个值2,则newCountArr[2]的值对应的是arr[]=2的个数
        for (int i = 0; i < len; i++) {
            newCountArr[arr[i]]++;
        }

        // 依次累加：将计算的个数相加得出排序的位置：比如newCountArr[5] = 7；则5在arr中的位置最高是7，如果有两个5，则排在6,7位
        for (int i = 1; i <= maxItem; i++) {
            newCountArr[i] += newCountArr[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] newArr = new int[len];
        // 计算排序的关键步骤了，有点难理解:从len-1开始而不是0开始是为了保证稳定性，遍历数组arr,通过它的值找到在newCountArr对应的下标，赋值给newArr,后面再拷贝newArr到arr
        for (int i = len - 1; i >= 0; i--) {
            int item = arr[i];
            int index = newCountArr[item]--;
            newArr[index - 1] = item;
        }

        // 拷贝数组
        for (int i = 0; i < len; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        MyCountingSort myCountingSort = new MyCountingSort();
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
