package com.example.lib.course58_exercise.solution;

/**
 * ���һ��˫�˶���
 * https://leetcode-cn.com/problems/design-circular-deque/
 */

public class DesignCircularDequeSolution {

    /**
     *
     ���ʵ��˫�˶��С�
     ���ʵ����Ҫ֧�����²�����

     MyCircularDeque(k)�����캯��,˫�˶��еĴ�СΪk��
     insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true��
     insertLast()����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true��
     deleteFront()����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true��
     deleteLast()����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true��
     getFront()����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
     getRear()�����˫�˶��е����һ��Ԫ�ء� ���˫�˶���Ϊ�գ����� -1��
     isEmpty()�����˫�˶����Ƿ�Ϊ�ա�
     isFull()�����˫�˶����Ƿ����ˡ�
     ʾ����

     MyCircularDeque circularDeque = new MycircularDeque(3); // ����������СΪ3
     circularDeque.insertLast(1);			        // ���� true
     circularDeque.insertLast(2);			        // ���� true
     circularDeque.insertFront(3);			        // ���� true
     circularDeque.insertFront(4);			        // �Ѿ����ˣ����� false
     circularDeque.getRear();  				// ���� 2
     circularDeque.isFull();				        // ���� true
     circularDeque.deleteLast();			        // ���� true
     circularDeque.insertFront(4);			        // ���� true
     circularDeque.getFront();				// ���� 4

     ��ʾ��

     ����ֵ�ķ�ΧΪ [1, 1000]
     ���������ķ�ΧΪ [1, 1000]
     �벻Ҫʹ�����õ�˫�˶��п⡣

     *
     *
     */

    /**
     *
     */
    private int size; // ���г���
    private Node head; // ͷ���
    private Node tail; // β���ڵ�
    private int mCapacity; // ����


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDequeSolution(int k) {
        mCapacity = checkNum(k);
        size = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) // ����
            return false;
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) // ����
            return false;
        Node newNode = new Node(value, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) // ����Ϊ��
            return false;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
            size = 0;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) // ����Ϊ��
            return false;
        Node p = head;
        Node pre = null;
        while (p.next != null) {
            pre = p;
            p = p.next;
        }
        tail = pre;
        size--;
        if (tail == null) {
            head = null;
            size = 0;
        } else
            tail.next = null;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty() ? -1 : head.data;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty() ? -1 : tail.data;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == mCapacity;
    }

    private int checkNum(int num) {
        if (num < 1)
            num = 1;
        else if (num > 1000)
            num = 1000;
        return num;
    }

    class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
