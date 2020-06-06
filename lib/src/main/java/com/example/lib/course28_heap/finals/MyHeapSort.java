package com.example.lib.course28_heap.finals;

import com.example.lib.course11_sorts.my.MySorts;

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
    }

    /**
     * 把数组建成堆数组
     *
     * @param data
     * @param len  内容长度
     */
    public void buildHeap(int[] data, int len) {
    }


    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param data  数组
     * @param count 数组内容长度
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUp(int[] data, int count, int index) {
    }

    /**
     * 从下到上堆化:依次跟父节点比较交换位置，直到符合堆结构
     *
     * @param data  数组
     * @param count 数组内容长度
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUp(int[] data, int count, int index) {
    }

    /**
     * 交换数据
     *
     * @param list
     * @param i
     * @param p
     */
    private void swap(int[] list, int i, int p) {
    }

    public static void main(String[] args) {
        MyHeapSort myHeapSort = new MyHeapSort();
        int n = 30;
        int[] data = MySorts.getRandomArray(n);
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
