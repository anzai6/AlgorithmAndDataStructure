package com.example.lib.course58_exercise.stack;

/**
 * ������ʵ��һ����ʽջ
 */
public class LinkStackExercise<T> {

    int size; // ջ�����ݳ���
    Node head;
    Node tail;

    public LinkStackExercise() {
    }

    /**
     * ��ջ
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
     * ��ջ
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
        if (pre == null) { // ֻ��һ���ڵ�
            size = 0;
            head = null;
            tail = null;
        } else { // ȥ��β�ڵ�
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
