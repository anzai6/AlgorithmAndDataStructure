package com.example.lib.course9_queue.finals;

/**
 * Created by wangzheng on 2018/10/9.
 */
// 用数组实现的队列
public class ArrayQueue {
    private static final int DEFAULT_CAPACITY = 10;
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    private int count;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        if (count == n) {
            System.out.println("queue is full");
            return false;
        }
        items[count++] = item;
        return true;
    }

    // 出队
    public String dequeue() {
        if (count == 0) {
            System.out.println("queue is empty");
            return "";
        }
        String value = items[0];
        for (int i = 0; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
        return value;
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
