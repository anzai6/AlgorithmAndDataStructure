package com.example.lib.course28_heap.my;

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
        this(DEFAULT_CAPACITY);
    }

    public MyHeap(int capacity) {
        data = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入一个节点：插入数组尾部，然后从下到上堆化
     *
     * @param item 需要插入的数据
     */
    public void insert(int item) {
        if (count >= n) // 数组已满
            return;
        ++count;
        data[count] = item;
        fromDownToUpHeapUp(count);
    }

    /**
     * 删除某个节点的思路：跟最后一个节点交换位置，删除最后一个节点，然后对该节点进行从上到下的堆化
     *
     * @param index 删除节点的下标
     */
    public void delete(int index) {
        if (count <= 0 || index <= 0) // 数组已空或删除的元素不存在
            return;
        // 把删除节点跟最后一个节点交换内容
        if (index != count) {
            data[index] = data[count];
            fromUpToDownHeapUp(index);
        }
        --count;
    }

    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUp(int index) {
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
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUp(int index) {
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

}
