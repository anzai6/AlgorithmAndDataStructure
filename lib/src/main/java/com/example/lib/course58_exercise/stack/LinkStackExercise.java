package com.example.lib.course58_exercise.stack;

/**
 * 用链表实现一个链式栈
 */
public class LinkStackExercise<T> {

    int size; // 栈内内容长度
    Node head;
    Node tail;

    public LinkStackExercise() {
    }

    /**
     * 入栈
     *
     * @param obj
     * @return
     */
    public void push(T obj) {

        Node newNode = new Node(obj, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {

        if (head == null)
            return null;

        Node p = head;
        Node pre = null;
        while (p.next != null) {
            pre = p;
            p = p.next;
        }

        T obj = p.data;
        if (pre == null) { // 只有一个节点
            size = 0;
            head = null;
            tail = null;
        } else { // 去掉尾节点
            size--;
            tail = pre;
            tail.next = null;
        }

        return obj;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

}
