package com.example.lib.course9_queue.finals;

/**
 * ��������ʵ�ֵĶ���
 * <p>
 * Author: Zheng
 */
public class QueueBasedOnLinkedList {

    // ���еĶ��׺Ͷ�β

    // ���
    public void enqueue(String value) {
    }

    // ����
    public String dequeue() {
        return null;
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
