package com.example.lib.course58_exercise.solution;

/**
 * 设计一个双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 */

public class DesignCircularDequeSolution {

    /**
     *
     设计实现双端队列。
     你的实现需要支持以下操作：

     MyCircularDeque(k)：构造函数,双端队列的大小为k。
     insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
     insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
     deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
     deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
     getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     isEmpty()：检查双端队列是否为空。
     isFull()：检查双端队列是否满了。
     示例：

     MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
     circularDeque.insertLast(1);			        // 返回 true
     circularDeque.insertLast(2);			        // 返回 true
     circularDeque.insertFront(3);			        // 返回 true
     circularDeque.insertFront(4);			        // 已经满了，返回 false
     circularDeque.getRear();  				// 返回 2
     circularDeque.isFull();				        // 返回 true
     circularDeque.deleteLast();			        // 返回 true
     circularDeque.insertFront(4);			        // 返回 true
     circularDeque.getFront();				// 返回 4

     提示：

     所有值的范围为 [1, 1000]
     操作次数的范围为 [1, 1000]
     请不要使用内置的双端队列库。

     *
     *
     */

    /**
     *
     */
    private int size; // 队列长度
    private Node head; // 头结点
    private Node tail; // 尾部节点
    private int mCapacity; // 容量


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
        if (isFull()) // 已满
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
        if (isFull()) // 已满
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
        if (isEmpty()) // 队列为空
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
        if (isEmpty()) // 队列为空
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
