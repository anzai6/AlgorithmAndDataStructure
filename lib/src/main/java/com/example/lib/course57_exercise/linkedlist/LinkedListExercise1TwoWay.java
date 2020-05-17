package com.example.lib.course57_exercise.linkedlist;

/**
 * ˫������֧����ɾ��Ĳ���
 */
public class LinkedListExercise1TwoWay {

    Node head; // ͷ���
    Node tail; // β�ڵ�
    int size; // ������

    public LinkedListExercise1TwoWay() {
    }


    public boolean add(int data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            size = 1;
            head = newNode;
            tail = newNode;
            return true;
        }

        tail.next = newNode;
        newNode.pre = tail;
        tail = newNode;
        size++;
        return true;
    }

    public boolean delete(int data) {
        if (head == null)
            return false;

        if (head.data == data) {
            head = head.next;
            size--;
            if (head == null) // ����Ϊ����
                tail = null;
            else
                head.pre = null;
            return true;
        }

        Node p = head.next;
        while (p != null) {
            if (p.data == data) {
                if (p.next == null) {
                    p.pre.next = null;
                } else {
                    p.pre.next = p.next;
                    p.next.pre = p.pre;
                }
                size--;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    // ���һ�����˫����ң�����head��tailͬʱ���м����,��������ûʲô�Ż�Ч��
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
        System.out.print("˫���� ");
        Node p = head;
        Node pre = null;
        while (p != null) {
            System.out.print(p.data + " <- -> ");
            if (p.pre == pre) {
                pre = p;
                p = p.next;
            } else
                break;
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
        LinkedListExercise1TwoWay linkedListExercise1TwoWay = new LinkedListExercise1TwoWay();
        int num = 10;
        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1TwoWay.add(a);
        }
        linkedListExercise1TwoWay.print();

        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            int b = (int) (Math.random() * 20);
            System.out.print(a + " update " + b + " - ");
            linkedListExercise1TwoWay.update(a, b);
        }
        System.out.println();
        linkedListExercise1TwoWay.print();

        for (int i = 0; i < num; i++) {
            int a = (int) (Math.random() * 20);
            System.out.print(a + " -> ");
            linkedListExercise1TwoWay.delete(a);
        }
        linkedListExercise1TwoWay.print();

    }
}
