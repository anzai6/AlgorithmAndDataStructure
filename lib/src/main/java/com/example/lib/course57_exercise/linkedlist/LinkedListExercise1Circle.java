package com.example.lib.course57_exercise.linkedlist;

/**
 * 循环链表、支持增删查改操作
 */
public class LinkedListExercise1Circle {

    Node head; // 头结点
    Node tail; // 尾节点
    int size; // 链表长度

    public LinkedListExercise1Circle() {
    }


    public boolean add(int data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            size = 1;
            head = newNode;
            tail = newNode;
            setCircle();
            return true;
        }

        tail.next = newNode;
        newNode.pre = tail;
        tail = newNode;
        size++;
        setCircle();
        return true;
    }

    public boolean delete(int data) {
        if (head == null)
            return false;

        if (head.data == data) {
            head = head.next;
            size--;
            if (head == null) // 链表为空了
                tail = null;
            else {
                setCircle();
            }
            return true;
        }

        Node p = head.next;
        while (p != head) {
            if (p.data == data) {
                p.pre.next = p.next;
                p.next.pre = p.pre;
                size--;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public Node find(int data) {
        if (head == null)
            return null;

        if (head.data == data) {
            return head;
        }

        Node p = head.next;

        while (p != head) {
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

    /**
     * 设置循环，头尾相连
     */
    private void setCircle() {
        head.pre = tail;
        tail.next = head;
    }

    public void print() {
        System.out.print("循环链表： ");

        if (head != null) {
            System.out.print(head.data + " <- -> ");
        }else{
            return;
        }

        Node p = head.next;

        while (p != head) {
            System.out.print(p.data + " <- -> ");
            p = p.next;
        }

        System.out.println();
    }

    class Node {
        int data;
        Node next;
        Node pre;

        public Node(int data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        LinkedListExercise1Circle linkedListExercise1Circle = new LinkedListExercise1Circle();
        int num = 10;
        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1Circle.add(a);
        }
        linkedListExercise1Circle.print();

        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            int b = (int) (Math.random() * 20);
            System.out.print(a + " update " + b + " - ");
            linkedListExercise1Circle.update(a, b);
        }
        System.out.println();
        linkedListExercise1Circle.print();

        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1Circle.delete(a);
        }
        linkedListExercise1Circle.print();

    }
}
