package com.example.lib.course9_queue.finals;

/**
 * 动态数组队列(不含扩容),出队不变，入队到达队尾重新移动数组到前面
 */
public class DynamicArrayQueue {
    private static final int DEFAULT_CAPACITY = 10;
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    private int head;
    private int tail;

    public DynamicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                System.out.println("queue is full");
                return false;
            }
            int count = tail - head;
            // 搬移数组到前面
            for (int i = 0; i < count; i++) {
                items[i] = items[i + head];
            }
            head = 0;
            tail = count;
        }
        items[tail++] = item;
        return true;
    }

    // 出队
    public String dequeue() {
        if (head == tail) {
            System.out.println("queue is empty");
            return "";
        }
        return items[head++];
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
