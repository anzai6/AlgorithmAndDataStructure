package com.example.lib.course28_heap.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * 堆排序：先把数组建成堆数组，然后再排序
 * 这里根节点从1开始计算
 * Created by qinshunan on 2019/4/9.
 */

public class MyHeapSort {

    /**
     * 堆排序：先把数组建成堆数组，然后再排序
     *
     * @param data
     * @param len  内容长度
     */
    public void heapSort(int[] data, int len) {
        if (data == null || len <= 1 || data.length < len) {
            return;
        }
        // 建堆
        buildHeap(data, len);
        // 排序，每次取最大值跟最后一个交换
        for (int i = len; i > 1; i--) {
            swap(data, i, 1);
            fromUpToDownHeapUp(data, i - 1, 1);
        }
    }

    /**
     * 把数组建成堆数组，从最后一个叶子结点的父节点开始，自上而下堆化建堆
     *
     * @param data
     * @param len  内容长度
     */
    public void buildHeap(int[] data, int len) {
        for (int i = len / 2; i >= 1; i--) {
            fromUpToDownHeapUp(data, len, i);
        }
    }


    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param data  数组
     * @param count 数组内容长度
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUp(int[] data, int count, int index) {
        if (index < 1) {
            return;
        }
        // 有子节点的情况下才循环
        while (index * 2 <= count) {
            int leftSub = index * 2; // 左子节点
            int rightSub = index * 2 + 1; // 右子节点
            int maxSub = leftSub; // 最大值的子节点坐标
            // 有右子节点且比左子节点大
            if (rightSub <= count && data[rightSub] > data[leftSub]) {
                maxSub = rightSub;
            }
            // 最大子节点大于自身则需要往下堆化
            if (data[maxSub] > data[index]) {
                swap(data, maxSub, index);
                index = maxSub;
            } else { // 堆化结束
                return;
            }
        }
    }

    /**
     * 从下到上堆化:依次跟父节点比较交换位置，直到符合堆结构
     *
     * @param data  数组
     * @param count 数组内容长度
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUp(int[] data, int count, int index) {
        if (index > count || index <= 1) {
            return;
        }
        int parentIndex = index / 2;
        // 父节点大于自身则需要往上堆化
        while (parentIndex >= 1 && data[parentIndex] < data[index]) {
            swap(data, parentIndex, index);
            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    /**
     * 交换数据
     *
     * @param list
     * @param i
     * @param p
     */
    private void swap(int[] list, int i, int p) {
        int item = list[p];
        list[p] = list[i];
        list[i] = item;
    }

    public static void main(String[] args) {
        MyHeapSort myHeapSort = new MyHeapSort();
        int n = 10;
        int[] data = Sorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data);
        System.out.println("堆排序：");
        myHeapSort.heapSort(data, n - 1);
        printArray(data);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
