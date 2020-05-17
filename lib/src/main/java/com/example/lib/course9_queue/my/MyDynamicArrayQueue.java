package com.example.lib.course9_queue.my;

/**
 * 动态数组队列(不含扩容)
 * Created by qinshunan on 2019/2/27.
 */
public class MyDynamicArrayQueue<T> {

    private int capacity; // 数组容量
    // head表示队头下标，tail表示队尾下标
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
     * 入队
     *
     * @param t
     */
    public boolean enQueue(T t) {
        if (tail == capacity) { // 到达尾部
            if (head == 0) return false;// 已满
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
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
