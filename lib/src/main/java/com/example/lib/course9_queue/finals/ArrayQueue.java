package com.example.lib.course9_queue.finals;

/**
 * Created by wangzheng on 2018/10/9.
 */
// ������ʵ�ֵĶ���
public class ArrayQueue {
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;

    // ����һ����СΪcapacity������
    public ArrayQueue(int capacity) {
    }

    // ���
    public boolean enqueue(String item) {
        return true;
    }

    // ����
    public String dequeue() {
        return "";
    }

    public void printAll() {
        for (String str : items) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
