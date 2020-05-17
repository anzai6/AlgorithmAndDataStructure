package com.example.lib.course9_queue.my;

/**
 * 环形数组队列
 * Created by qinshunan on 2019/2/27.
 */
public class MyCircularQueue<T> {

    private int capacity; // 数组容量
    // head表示队头下标，tail表示队尾下标
    private int head;
    private int tail;
    private T[] items;
    private int size; // 队列的内容长度

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 入队
     *
     * @param t
     */
    public boolean enQueue(T t) {

        if (size == capacity) { // 已满
            return false;
        }
        items[tail] = t;
        ++tail;
        ++size;

        if (tail == capacity) // 尾标到达最后一个位置时，转到第一个位置
            tail = 0;

        return true;
    }

    /**
     * @return
     */
    public T deQueue() {
        if (size == 0) // 队列空了
            return null;
        T t = items[head];
        ++head;
        --size;
        if (head == capacity) // 头标到达最后一个位置时，转到第一个位置
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
        System.out.println("入队：5");
        myCircularQueue.printAll();

        for (int i = 0; i < 6; i++) {
            myCircularQueue.deQueue();
        }
        System.out.println("出队：6");
        myCircularQueue.printAll();

        for (int i = 0; i < 10; i++) {
            myCircularQueue.enQueue(i + "");
        }
        System.out.println("入队：10");
        myCircularQueue.printAll();

    }

}
