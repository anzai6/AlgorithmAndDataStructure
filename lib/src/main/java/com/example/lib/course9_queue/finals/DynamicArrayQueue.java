package com.example.lib.course9_queue.finals;

/**
 * ��̬�������(��������)
 * Created by wangzheng on 2018/10/9.
 */
public class DynamicArrayQueue {
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;

    // ����һ����СΪcapacity������
    public DynamicArrayQueue(int capacity) {
    }

    // ��Ӳ�������item�����β
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
