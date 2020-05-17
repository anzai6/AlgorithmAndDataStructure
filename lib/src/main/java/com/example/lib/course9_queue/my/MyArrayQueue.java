package com.example.lib.course9_queue.my;

/**
 * 用数组实现的队列
 * Created by qinshunan on 2019/2/27.
 */
public class MyArrayQueue<T> {

    private int capacity; // 数组容量
    // head表示队头下标，tail表示队尾下标
    private int head;
    private int tail;
    private T[] items;

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    /**
     * 入队
     *
     * @param t
     */
    public boolean enQueue(T t) {
        if (tail == capacity) { // 已满
            return false;
        }
        items[tail] = t;
        ++tail;
        return true;
    }

    /**
     * @return
     */
    public T deQueue() {
        if (head == tail) // 队列空了
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
