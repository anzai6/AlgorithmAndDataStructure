package com.example.lib.course9_queue.teacher;

/**
 * ���ζ���
 * Created by wangzheng on 2018/10/9.
 */
public class CircularQueue {
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head = 0;
    private int tail = 0;

    // ����һ����СΪcapacity������
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // ���
    public boolean enqueue(String item) {
        // ��������
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // ����
    public String dequeue() {
        // ���head == tail ��ʾ����Ϊ��
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
