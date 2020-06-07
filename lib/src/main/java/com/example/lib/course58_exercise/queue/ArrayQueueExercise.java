package com.example.lib.course58_exercise.queue;

/**
 * ������ʵ��һ��˳�����
 */
public class ArrayQueueExercise<T> {

    private final static int CAPACITY = 16;
    T[] data;
    int mCapacity; // ���鳤��
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
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
     * ���
     *
     * @param obj
     * @return
     */
    public boolean enQueue(T obj) {
        if (obj == null)
            return false;
        if (tail == mCapacity) // ����
            return false;

        data[tail] = obj;
        ++tail;
        return true;
    }

    /**
     * ����
     *
     * @return
     */
    public T deQueue() {
        if (head == tail) // ����Ϊ��
            return null;

        T obj = data[head];
        data[head] = null;
        ++head;
        return obj;
    }

}
