package com.example.lib.course9_queue.finals;

import com.example.lib.course9_queue.my.MyCircularQueue;

/**
 * ���ζ���
 */
public class CircularQueue {
    private static final int DEFAULT_CAPACITY = 10;
    // ���飺items�������С��n
    private String[] items;
    private int n;
    private int head;
    private int tail; // ָ�����û��ֵ�Ĳ�λ

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    // ����һ����СΪcapacity������
    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        items = new String[capacity];
        n = capacity;
    }

    // ���,����һ���ռ����������Ƚ�����
    public boolean enqueue(String item) {
        int next = (tail + 1) % n;
        if(next == head){
            System.out.println("queue is full");
            return false;
        }
        items[tail] = item;
        tail = next;
        return true;
    }

    // ����
    public String dequeue() {
        if(tail == head){
            System.out.println("queue is empty");
            return "";
        }
        head = (head +1)%n;
        return items[head];
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
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
