package com.example.lib.course58_exercise.queue;

/**
 * 用链表实现一个链式队列
 */
public class LinkQueueExercise<T> {

    private int size; // 链表长度
    // head表示队头下标，tail表示队尾下标
    private Node head; // 头节点
    private Node tail; // 尾节点

    public LinkQueueExercise() {
        size = 0;
    }


    /**
     * 入队
     *
     * @param obj
     * @return
     */
    public boolean enQueue(T obj) {
        Node newNode = new Node(obj, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T deQueue() {
        if (head == null) // 队列为空
            return null;

        T obj = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        --size;
        return obj;
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
