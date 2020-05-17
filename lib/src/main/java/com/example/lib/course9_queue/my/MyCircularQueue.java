package com.example.lib.course9_queue.my;

/**
 * �����������
 * Created by qinshunan on 2019/2/27.
 */
public class MyCircularQueue<T> {

    private int capacity; // ��������
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head;
    private int tail;
    private T[] items;
    private int size; // ���е����ݳ���

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * ���
     *
     * @param t
     */
    public boolean enQueue(T t) {

        if (size == capacity) { // ����
            return false;
        }
        items[tail] = t;
        ++tail;
        ++size;

        if (tail == capacity) // β�굽�����һ��λ��ʱ��ת����һ��λ��
            tail = 0;

        return true;
    }

    /**
     * @return
     */
    public T deQueue() {
        if (size == 0) // ���п���
            return null;
        T t = items[head];
        ++head;
        --size;
        if (head == capacity) // ͷ�굽�����һ��λ��ʱ��ת����һ��λ��
            head = 0;
        return t;
    }

    public void printAll() {
        for (int i = head; i < head + size; ++i) {
            int h;
            if (i >= capacity)
                h = i - capacity;
            else
                h = i;
            System.out.print("value: " + items[h]);
        }
        System.out.println();
        for (int i = head; i < head + size; ++i) {
            int h;
            if (i >= capacity)
                h = i - capacity;
            else
                h = i;
            System.out.print("index: " + h);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyCircularQueue<String> myCircularQueue = new MyCircularQueue<>(10);
        for (int i = 0; i < 5; i++) {
            myCircularQueue.enQueue(i + "");
        }
        System.out.println("��ӣ�5");
        myCircularQueue.printAll();

        for (int i = 0; i < 6; i++) {
            myCircularQueue.deQueue();
        }
        System.out.println("���ӣ�6");
        myCircularQueue.printAll();

        for (int i = 0; i < 10; i++) {
            myCircularQueue.enQueue(i + "");
        }
        System.out.println("��ӣ�10");
        myCircularQueue.printAll();

    }

}
