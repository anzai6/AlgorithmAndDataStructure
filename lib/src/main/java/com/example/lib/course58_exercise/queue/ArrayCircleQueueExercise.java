package com.example.lib.course58_exercise.queue;

/**
 * ������ʵ��һ��ѭ������
 */
public class ArrayCircleQueueExercise<T> {

    private final static int CAPACITY = 16;
    T[] data;
    int mCapacity; // ���鳤��
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
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
     * ���
     *
     * @param obj
     * @return
     */
    public boolean enQueue(T obj) {
        if (obj == null)
            return false;
        if (size == mCapacity) {// ����
            System.out.println("��������");
            return false;
        }

        if (tail == mCapacity) // �����β�ͻ�ͷ
            tail = 0;

        data[tail] = obj;
        ++tail;
        ++size;
        return true;
    }

    /**
     * ����
     *
     * @return
     */
    public T deQueue() {
        if (size == 0) // ����Ϊ��
            return null;

        T obj = data[head];
        data[head] = null;
        ++head;
        if (head == mCapacity) // �����β�ͻ�ͷ
            head = 0;
        --size;
        return obj;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            int index = head + i;
            if (index > mCapacity - 1)
                index -= mCapacity;
            System.out.println("�±꣺ " + index + "  --  ֵ��" + data[index]);
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
