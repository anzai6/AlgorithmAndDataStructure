package com.example.lib.course9_queue.finals;

/**
 * 环形队列
 * Created by wangzheng on 2018/10/9.
 */
public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
    }

    // 入队
    public boolean enqueue(String item) {
        return true;
    }

    // 出队
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
