package com.example.lib.course57_exercise.linkedlist;

/**
 * ʵ����������м���
 */
public class LinkedListExercise4 {

    Node head; // ͷ���
    Node tail; // β�ڵ�
    int size; // ������

    public LinkedListExercise4() {
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
            if (head == null) // ����Ϊ����
                tail = null;
            return true;
        }

        Node pre = head;
        Node p = head.next;
        while (p != null) {
            if (p.data == data) {
                pre.next = p.next;
                if (p == tail) // ɾ���������һ��
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
        System.out.print("������ ");
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * ��������м��㣨Ҫ���ǣ�����ָ�룩
     */
    public Node getCenterNode() {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        if (head.next.next == null)
            return head;

        Node p = head;
        Node next2 = head.next.next; // �����ٽڵ�

        while (next2.next != null && next2.next.next != null) {
            p = p.next;
            next2 = next2.next.next;
        }

        if (next2.next == null) { // ������������
            return p.next;
        } else { // ��������ż��
            return p.next;
        }

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
        LinkedListExercise4 linkedListExercise1 = new LinkedListExercise4();
        int num = 9;
        for (int i = 0; i < num; i++) {
            linkedListExercise1.add((int) (Math.random() * 20));
        }

        linkedListExercise1.print();
        Node center = linkedListExercise1.getCenterNode();
        if (center != null)
            System.out.println("�м�ڵ㣺" + center.data);

    }
}
