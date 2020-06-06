package com.example.lib.course9_queue.finals;

/**
 * 基于链表实现的队列
 * <p>
 * Author: Zheng
 */
public class QueueBasedOnLinkedList {

    // 队列的队首和队尾

    // 入队
    public void enqueue(String value) {
    }

    // 出队
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
