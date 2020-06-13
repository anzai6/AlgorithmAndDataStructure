package com.example.lib.course8_stack.finals;

import com.example.lib.Node;

/**
 * 基于链表实现的栈。
 * <p>
 * Author: Zheng
 */
public class StackBasedLinkedList {
    private Node top = null;
    private int size;

    /**
     * 每次插入头部，而不是尾部，会简化很多代码
     * @param value
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        ++size;
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (top == null)
            return -1;
        int value = top.data;
        top = top.next;
        --size;
        return value;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

}
