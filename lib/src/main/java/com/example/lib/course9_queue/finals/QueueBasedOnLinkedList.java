package com.example.lib.course9_queue.finals;

/**
 * ��������ʵ�ֵĶ���
 * <p>
 * Author: Zheng
 */
public class QueueBasedOnLinkedList {

    private Node head;
    private Node tail;
    private int count;

    // ���еĶ��׺Ͷ�β

    // ���
    public void enqueue(String value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        count++;
    }

    // ����
    public String dequeue() {
        if (count == 0) {
            System.out.println("queue is empty");
            return "";
        }
        Node node = head;
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return node.data;
    }

    public void printAll() {
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}
