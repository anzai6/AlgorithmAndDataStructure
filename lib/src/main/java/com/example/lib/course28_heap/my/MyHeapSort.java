package com.example.lib.course28_heap.my;

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
        buildHeap(data, len);
        // 把根节点即最大数跟最后一位数据len交换，然后在0~len-1范围对根节点进行从上到下的堆化
        // 依次下去即可成堆排序
        for (int i = len; i > 1; --i) {
            swap(data, i, 1); // 交换
            fromUpToDownHeapUp(data, i - 1, 1);
        }
    }

    /**
     * 把数组建成堆数组
     *
     * @param data
     * @param len  内容长度
     */
    public void buildHeap(int[] data, int len) {
        // len/2 是最后一个非叶子节点的节点，所以对len/2到1下标的数据进行从上到下的堆化
        for (int i = len / 2; i >= 1; --i) {
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
        // count/2之后的节点都是叶子节点（最后一个节点是count，它的父节点是count/2,所以）
        while (index >= 1) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            int maxP = index;// 三个节点中最大的哪一个
            // 特别注意，这里的leftChild和rightChild可能越过了count，所以要做一下判断
            if (leftChild <= count && data[maxP] < data[leftChild])
                maxP = leftChild;
            if (rightChild <= count && data[maxP] < data[rightChild])
                maxP = rightChild;

            // 最大值是自身则不需要堆化了
            if (maxP == index) {
                return;
            } else {
                swap(data, maxP, index);
                index = maxP;
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
        if (index <= 1) return; // 1是根节点
        // 父节点下标
        int p = index / 2;
        while (index > 1 && data[index] > data[p]) {
            // 大于则交换父子节点
            swap(data, index, p);

            index = p;
            p = index / 2;
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
        int n = 30;
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
