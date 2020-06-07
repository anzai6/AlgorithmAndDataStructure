package com.example.lib.course58_exercise.queue;

/**
 * ������ʵ��һ����ʽ����
 */
public class LinkQueueExercise<T> {

    private int size; // ������
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private Node head; // ͷ�ڵ�
    private Node tail; // β�ڵ�

    public LinkQueueExercise() {
        size = 0;
    }


    /**
     * ���
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
     * ����
     *
     * @return
     */
    public T deQueue() {
        if (head == null) // ����Ϊ��
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
