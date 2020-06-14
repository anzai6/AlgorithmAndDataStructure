package com.example.lib.course9_queue.finals;

/**
 * ��̬�������(��������),���Ӳ��䣬��ӵ����β�����ƶ����鵽ǰ��
 */
public class DynamicArrayQueue {
    private static final int DEFAULT_CAPACITY = 10;
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;
    private int head;
    private int tail;

    public DynamicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    // ����һ����СΪcapacity������
    public DynamicArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        items = new String[capacity];
        n = capacity;
    }

    // ��Ӳ�������item�����β
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                System.out.println("queue is full");
                return false;
            }
            int count = tail - head;
            // �������鵽ǰ��
            for (int i = 0; i < count; i++) {
                items[i] = items[i + head];
            }
            head = 0;
            tail = count;
        }
        items[tail++] = item;
        return true;
    }

    // ����
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
