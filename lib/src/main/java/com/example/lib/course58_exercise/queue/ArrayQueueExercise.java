package com.example.lib.course58_exercise.queue;

/**
 * 用数组实现一个顺序队列
 */
public class ArrayQueueExercise<T> {

    private final static int CAPACITY = 16;
    T[] data;
    int mCapacity; // 数组长度
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueueExercise() {
        this(CAPACITY);
    }

    public ArrayQueueExercise(int capacity) {
        mCapacity = capacity;
        data = (T[]) new Object[mCapacity];
        head = 0;
        tail = 0;
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
        if (tail == mCapacity) // 队满
            return false;

        data[tail] = obj;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T deQueue() {
        if (head == tail) // 队列为空
            return null;

        T obj = data[head];
        data[head] = null;
        ++head;
        return obj;
    }

}
