package com.example.lib.course9_queue.my;

/**
 * ��̬�������(��������)
 * Created by qinshunan on 2019/2/27.
 */
public class MyDynamicArrayQueue<T> {

    private int capacity; // ��������
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head;
    private int tail;
    private T[] items;

    public MyDynamicArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    /**
     * ���
     *
     * @param t
     */
    public boolean enQueue(T t) {
        if (tail == capacity) { // ����β��
            if (head == 0) return false;// ����
            // ���ݰ���
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // ������֮�����¸���head��tail
            head = 0;
            tail = tail - head;
        }
        items[tail] = t;
        ++tail;
        return true;
    }

    /**
     * @return
     */
    public T deQueue() {
        if (head == tail) // ���п���
            return null;
        T t = items[head];
        ++head;
        return t;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}
