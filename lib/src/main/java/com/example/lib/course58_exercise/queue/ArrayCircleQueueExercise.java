package com.example.lib.course58_exercise.queue;

/**
 * 用数组实现一个循环队列
 */
public class ArrayCircleQueueExercise<T> {

    private final static int CAPACITY = 16;
    T[] data;
    int mCapacity; // 数组长度
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;
    int size;

    public ArrayCircleQueueExercise() {
        this(CAPACITY);
    }

    public ArrayCircleQueueExercise(int capacity) {
        mCapacity = capacity;
        data = (T[]) new Object[mCapacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 入队
     *
     * @param obj
     * @return
     */
    public boolean enQueue(T obj) {
        if (obj == null)
            return false;
        if (size == mCapacity) {// 队满
            System.out.println("队列已满");
            return false;
        }

        if (tail == mCapacity) // 到达队尾就回头
            tail = 0;

        data[tail] = obj;
        ++tail;
        ++size;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T deQueue() {
        if (size == 0) // 队列为空
            return null;

        T obj = data[head];
        data[head] = null;
        ++head;
        if (head == mCapacity) // 到达队尾就回头
            head = 0;
        --size;
        return obj;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            int index = head + i;
            if (index > mCapacity - 1)
                index -= mCapacity;
            System.out.println("下标： " + index + "  --  值：" + data[index]);
        }
    }

    public static void main(String[] args) {
        ArrayCircleQueueExercise arrayCircleQueueExercise = new ArrayCircleQueueExercise<String>(8);
        for (int i = 0; i < 10; i++) {
            arrayCircleQueueExercise.enQueue(i + "");
        }
        arrayCircleQueueExercise.deQueue();
        arrayCircleQueueExercise.deQueue();
        arrayCircleQueueExercise.enQueue(9 + "");
        arrayCircleQueueExercise.enQueue(10 + "");
        arrayCircleQueueExercise.print();
    }

}
