package com.example.lib.course9_queue.my;

/**
 * ��������ʵ�ֵĶ���
 * Created by qinshunan on 2019/2/27.
 */

public class MyQueueBasedOnLinkedList {

    private Node head;
    private Node tail;

    /**
     * ���
     *
     * @param data
     */
    public void enQueue(String data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * ����
     *
     * @return
     */
    public String deQueue() {
        String value;
        if (head != null) {
            value = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            value = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data);
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
