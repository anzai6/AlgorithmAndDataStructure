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
        this(DEFAULT_CAPACITY);
    }

    public MyHeap(int capacity) {
        n = capacity;
        data = new int[n + 1];
        count = 0;
    }

    /**
     * 插入一个节点：插入数组尾部，然后从下到上堆化
     *
     * @param item 需要插入的数据
     */
    public void insert(int item) {
        // 已满
        if (count == n) {
            return;
        }
        data[++count] = item;
        fromDownToUpHeapUp(count);
    }

    /**
     * 删除某个节点的思路：跟最后一个节点交换位置，删除最后一个节点，然后对该节点进行从上到下的堆化
     *
     * @param index 删除节点的下标
     */
    public void delete(int index) {
        if (index < 1 || index > count) {
            return;
        }
        // 将最后一个提上来代替index位置的值，然后自上而下堆化
        data[index] = data[count];
        count--;
        fromUpToDownHeapUp(index);
    }

    /**
     * 定点出堆，大顶堆也就是取出最大值
     */
    public int pop() {
        int max = data[1];
        // 将最后一个提上来代替第一个，然后自上而下堆化
        delete(1);
        return max;
    }

    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUp(int index) {
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
     * 从上到下堆化(递归写法)
     *
     * @param index 待堆化的节点下标
     */
    public void fromUpToDownHeapUpDG(int index) {
        if (index < 1 || index * 2 > count) {
            return;
        }
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
            fromUpToDownHeapUp(maxSub);
        }
    }

    /**
     * 从下到上堆化（非递归写法）
     * 依次跟父节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUp(int index) {
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
     * 从下到上堆化的递归写法
     *
     * @param index 待堆化的节点下标
     */
    public void fromDownToUpHeapUpDG(int index) {
        int parentIndex = index / 2;
        if (parentIndex < 1 || index > count) {
            return;
        }
        // 父节点大于自身则需要往上堆化
        if (data[parentIndex] < data[index]) {
            swap(data, parentIndex, index);
            fromDownToUpHeapUpDG(parentIndex);
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
