package com.example.lib.course9_queue.teacher;

/**
 * Created by wangzheng on 2018/10/9.
 */
// ������ʵ�ֵĶ���
public class ArrayQueue {
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head = 0;
    private int tail = 0;

    // ����һ����СΪcapacity������
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // ���
    public boolean enqueue(String item) {
        // ���tail == n ��ʾ�����Ѿ�����
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    // ����
    public String dequeue() {
        // ���head == tail ��ʾ����Ϊ��
        if (head == tail) return null;
        // Ϊ�����������Ե�ͬѧ���ĸ�����ȷ����--�����ŵ�����һ����д��
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
