package com.example.lib.course9_queue.finals;

/**
 * ���ζ���
 * Created by wangzheng on 2018/10/9.
 */
public class CircularQueue {
    // ���飺items�������С��n
    private String[] items;

    // ����һ����СΪcapacity������
    public CircularQueue(int capacity) {
    }

    // ���
    public boolean enqueue(String item) {
        return true;
    }

    // ����
    public String dequeue() {
        return null;
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
