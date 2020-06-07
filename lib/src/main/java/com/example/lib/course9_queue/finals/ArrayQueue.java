package com.example.lib.course9_queue.finals;

/**
 * Created by wangzheng on 2018/10/9.
 */
// 用数组实现的队列
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
    }

    // 入队
    public boolean enqueue(String item) {
        return true;
    }

    // 出队
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
