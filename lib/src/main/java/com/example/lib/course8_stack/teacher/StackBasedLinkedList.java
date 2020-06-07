package com.example.lib.course8_stack.teacher;

/**
 * ��������ʵ�ֵ�ջ��
 * <p>
 * Author: Zheng
 */
public class StackBasedLinkedList {
    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        // �ж��Ƿ�ջ��
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * ����-1��ʾջ��û�����ݡ�
     */
    public int pop() {
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
