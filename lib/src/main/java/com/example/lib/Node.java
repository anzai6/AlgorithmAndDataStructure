package com.example.lib;

/**
 * 单链表的节点
 * Created by qinshunan on 2019/1/31.
 */
public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
