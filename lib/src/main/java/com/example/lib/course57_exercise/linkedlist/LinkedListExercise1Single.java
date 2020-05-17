package com.example.lib.course57_exercise.linkedlist;

/**
 * 实现单链表、支持增删查改操作
 */
public class LinkedListExercise1Single {

    Node head; // 头结点
    Node tail; // 尾节点
    int size; // 链表长度

    public LinkedListExercise1Single() {
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

    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListExercise1Single linkedListExercise1Single = new LinkedListExercise1Single();
        int num = 10;
        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1Single.add(a);
        }
        linkedListExercise1Single.print();

        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1Single.delete(a);
        }
        linkedListExercise1Single.print();

    }
}
