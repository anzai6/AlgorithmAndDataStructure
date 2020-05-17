package com.example.lib.course57_exercise.linkedlist;

/**
 * 实现两个有序的链表合并为一个有序链表
 */
public class LinkedListExercise3 {

    Node head; // 头结点
    Node tail; // 尾节点
    int size; // 链表长度

    public LinkedListExercise3() {
    }


    public boolean add(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            size = 1;
            head = newNode;
            tail = newNode;
            return true;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
        return false;
    }

    public boolean delete(int data) {
        if (head == null)
            return false;

        if (head.data == data) {
            head = head.next;
            size--;
            if (head == null) // 链表为空了
                tail = null;
            return true;
        }

        Node pre = head;
        Node p = head.next;
        while (p != null) {
            if (p.data == data) {
                pre.next = p.next;
                if (p == tail) // 删除的是最后一个
                    tail = pre;
                size--;
                return true;
            }

            pre = p;
            p = p.next;
        }
        return false;
    }

    public Node find(int data) {
        if (head == null)
            return null;

        Node p = head;
        while (p != null) {
            if (p.data == data) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public boolean update(int oldData, int newData) {
        Node p = find(oldData);
        if (p != null) {
            p.data = newData;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.print("单链表： ");
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 两个有序的链表合并为一个有序链表
     */
    public void merge(Node node1, Node node2) {
        Node newHead = null;
        Node newTail = null;
        if (node1 == null)
            newHead = node2;
        if (node2 == null)
            newHead = node1;

        while (node1 != null && node2 != null) {
            Node newNode;
            if (node1.data <= node2.data) {
                newNode = node1;
                node1 = node1.next;
            } else {
                newNode = node2;
                node2 = node2.next;
            }

            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
                newTail.next = null;
            }
        }

        if (newTail != null) {
            if (node1 == null) {
                newTail.next = node2;
            } else {
                newTail.next = node1;
            }
        }

        System.out.print("合并的有序链表： ");
        Node p = newHead;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println();
    }

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListExercise3 linkedListExercise1 = new LinkedListExercise3();
        LinkedListExercise3 linkedListExercise2 = new LinkedListExercise3();
        LinkedListExercise3 linkedListExercise3 = new LinkedListExercise3();
        int num = 31;
        for (int i = 0; i < num; i++) {
            if (i % 3 == 0) {
                linkedListExercise1.add(i);
            } else {
                linkedListExercise2.add(i);
            }
        }

        linkedListExercise1.print();
        linkedListExercise2.print();
        System.out.println();
        linkedListExercise3.merge(linkedListExercise1.head, linkedListExercise2.head);

    }
}
