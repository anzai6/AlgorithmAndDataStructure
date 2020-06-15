package com.example.lib.course9_queue.finals;

/**
 * 环形队列
 */
public class CircularQueue {
    private static final int DEFAULT_CAPACITY = 10;
    // 数组：items，数组大小：n
    private String[] items;
    private int n;
    private int head;
    private int tail; // 指向的是没有值的槽位

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        items = new String[capacity];
        n = capacity;
    }

    // 入队,空置一个空间操作起来会比较容易
    public boolean enqueue(String item) {
        int next = (tail + 1) % n;
        if (next == head) {
            System.out.println("queue is full");
            return false;
        }
        items[tail] = item;
        tail = next;
        return true;
    }

    // 出队
    public String dequeue() {
        if (tail == head) {
            System.out.println("queue is empty");
            return "";
        }
        items[head] = null;
        head = (head + 1) % n;
        return items[head];
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(10);
        for (int i = 0; i < 5; i++) {
            myCircularQueue.enqueue(i + "");
        }
        System.out.println("入队：5");
        myCircularQueue.printAll();

        for (int i = 0; i < 6; i++) {
            myCircularQueue.dequeue();
        }
        System.out.println("出队：6");
        myCircularQueue.printAll();

        for (int i = 0; i < 10; i++) {
            myCircularQueue.enqueue(i + "");
        }
        System.out.println("入队：10");
        myCircularQueue.printAll();

    }
}
