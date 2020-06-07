package com.example.lib.course9_queue.finals;

/**
 * 动态数组队列(不含扩容)
 * Created by wangzheng on 2018/10/9.
 */
public class DynamicArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
    }

    // 入队操作，将item放入队尾
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
