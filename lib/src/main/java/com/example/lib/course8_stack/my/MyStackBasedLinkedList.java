package com.example.lib.course8_stack.my;

/**
 * 基于链表实现的栈：链式栈
 */
public class MyStackBasedLinkedList {

    private Node top;
    private int size = 0;

    /**
     * 入栈
     *
     * @param value
     */
    public void push(String value) {
        Node newNode = new Node(value, null);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        ++size;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (top == null)
            return "";
        String value = top.data;
        top = top.next;
        --size;
        return value;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        size = 0;
        top = null;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static class Node {
        private String data;
        private Node next;


        public Node(String value, Node nextNode) {
            data = value;
            next = nextNode;
        }
    }
}
