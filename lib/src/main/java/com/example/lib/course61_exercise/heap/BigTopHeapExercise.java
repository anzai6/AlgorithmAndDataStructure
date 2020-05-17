package com.example.lib.course61_exercise.heap;

/**
 * 大顶堆:下标从1开始，子节点下标除以2是父节点，父节点乘2就是子节点（还可以加1）
 */
public class BigTopHeapExercise {

    private static final int DEFAULT_CAPACITY = 16;
    private int[] data; // 下标从1开始，子节点
    private int mCapacity; // 容量
    private int size; // 数据长度

    public BigTopHeapExercise() {
        this(DEFAULT_CAPACITY);
    }

    public BigTopHeapExercise(int capacity) {
        mCapacity = capacity;
        data = new int[mCapacity + 1]; // 因为从1开始计算下标，所以要加1
        size = 0;
    }

    /**
     * 插入
     *
     * @param value 插入的值
     * @return 插入的下标, 不成功返回0
     */
    public int insert(int value) {
        if (mCapacity <= size) // 数组已满
            return 0;
        size++;
        data[size] = value;
        fromDownToUpHeapUp(size);
        return size;
    }

    /**
     * 删除
     *
     * @param index 删除的值的下标
     * @return 成功标记
     */
    public boolean delete(int index) {
        if (size == 0 || index < 1 || index > size)
            return false;

        // 把删除节点跟最后一个节点交换内容
        if (index != size) {
            data[index] = data[size];
            fromUpToDownHeapUp(index);
        }
        data[size] = 0;
        size--;
        return true;
    }

    /**
     * 从上到下堆化:依次跟子节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    private void fromUpToDownHeapUp(int index) {
        if (index < 1)
            return;
        while (index <= size) {
            int leftSup = index * 2; // 左子节点
            int rightSup = leftSup + 1; // 左子节点
            int maxIndex = index;
            if (leftSup <= size && data[leftSup] > data[maxIndex])
                maxIndex = leftSup;
            if (leftSup <= size && data[rightSup] > data[maxIndex])
                maxIndex = rightSup;

            if (maxIndex == index) { // 不用堆化了
                return;
            } else {
                swap(index, maxIndex);
                index = maxIndex;
            }
        }
    }

    /**
     * 从下到上堆化:依次跟父节点比较交换位置，直到符合堆结构
     *
     * @param index 待堆化的节点下标
     */
    private void fromDownToUpHeapUp(int index) {
        if (index > size)
            return;
        while (index > 1) {
            int fIndex = index / 2; // 父节点
            if (data[index] > data[fIndex])
                swap(index, fIndex);
            index = fIndex;
        }
    }

    /**
     * 交换两个下标的数据
     *
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int item = data[index1];
        data[index1] = data[index2];
        data[index2] = item;
    }
}
