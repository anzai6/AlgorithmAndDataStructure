package com.example.lib.course28_heap.finals;

/**
 * 堆（完全二叉树）：插入、删除、堆排序、从上到下堆化、从下到上堆化、大顶堆、小顶堆
 * 这里默认使用大顶堆，即：某个节点一定大于或等于其所有子节点
 * 根节点从1开始计算
 * Created by qinshunan on 2019/4/9.
 */

public class MyHeap {

    // 堆数据
    private int[] data; // 数组从下标1开始存储数据
    // 默认容量
    private static final int DEFAULT_CAPACITY = 12;
    // 数据长度
    int count = 0;
    // 数组长度
    int n;

    public MyHeap() {
    }

    public MyHeap(int capacity) {
    }

    /**
     * 插入一个节点：插入数组尾部，然后从下到上堆化
     *
     * @param item 需要插入的数据
     */
    public void insert(int item) {
    }

    /**
     * 删除某个节点的思路：跟最后一个节点交换位置，删除最后一个节点，然后对该节点进行从上到下的堆化
     *
     * @param index 删除节点的下标
     */
    public void delete(int index) {
    }

    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUp(int index) {
    }

    /**
     * 从下到上堆化:依次跟父节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUp(int index) {
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

}
