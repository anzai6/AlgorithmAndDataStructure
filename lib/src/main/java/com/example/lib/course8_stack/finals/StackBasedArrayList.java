package com.example.lib.course8_stack.finals;

import com.example.lib.Node;

/**
 * ��������ʵ�ֵ�ջ��
 * <p>
 * Author: Zheng
 */
public class StackBasedArrayList {
    private Node top = null;

    public void push(int value) {
    }

    /**
     * ����-1��ʾջ��û�����ݡ�
     */
    public int pop() {
        return 0;
    }

    public int getSize() {
        return 0;
    }

    public void clear() {
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
