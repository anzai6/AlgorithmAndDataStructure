package com.example.lib.course57_exercise.linkedlist;

/**
 * 实现单链表反转
 */
public class LinkedListExercise2 {

    Node head; // 头结点
    Node tail; // 尾节点
    int size; // 链表长度

    public LinkedListExercise2() {
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
     * 单链表反转
     */
    public void reversalLinkedList() {
        System.out.print("反转前： ");
        print();

        if (head != tail) { // 需要反转
            Node p = head.next;
            Node pre = head;

            tail = head;
            tail.next = null;

            while (p.next != null) {
                Node h = p;
                p = p.next;
                h.next = pre;
                pre = h;
            }

            head = p;
            p.next = pre;
        }


        System.out.print("反转后： ");
        print();
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
        LinkedListExercise2 linkedListExercise2 = new LinkedListExercise2();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise2.add(a);
        }
        /*linkedListExercise2.print();

        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise2.delete(a);
        }
        linkedListExercise2.print();*/
        System.out.println();
        linkedListExercise2.reversalLinkedList();

    }
}
