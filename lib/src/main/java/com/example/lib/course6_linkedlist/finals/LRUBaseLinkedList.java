package com.example.lib.course6_linkedlist.finals;

/**
 * ���ڵ�����LRU�㷨��java��
 *
 * @author hoda
 * @create 2018-12-17
 */
public class LRUBaseLinkedList<T> {

    /**
     * Ĭ����������
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * ͷ���
     */
    private SNode<T> headNode;

    /**
     * ������
     */
    private int length;

    /**
     * ��������
     */
    private int capacity;

    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public void add(T data) {
        if (headNode == null) {
            length++;
            headNode = new SNode<>(data, null);
            return;
        }
        SNode pre = findPreNode(data);
        if (pre != null) { // ����
            deleteElemOptim(pre);
            insertElemAtBegin(data);
        } else if (headNode != null && headNode.element.equals(data)) {
            return;
        } else {
            if (length == capacity) {
                deleteElemAtEnd();
                length--;
            }
            length++;
            insertElemAtBegin(data);
        }
    }

    /**
     * ɾ��preNode�����һ��Ԫ��
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        if (preNode == null && preNode.next == null) {
            return;
        }
        preNode.next = preNode.next.next;
    }

    /**
     * ����ͷ������ڵ�
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode sNode = new SNode(data, null);
        sNode.next = headNode;
        headNode = sNode;
    }

    /**
     * ��ȡ���ҵ�Ԫ�ص�ǰһ�����
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode pre = null;
        SNode p = headNode;
        while (p != null) {
            if (p.element.equals(data)) {
                return pre;
            }
            pre = p;
            p = p.next;
        }
        return null;
    }

    /**
     * ɾ��β���
     */
    private void deleteElemAtEnd() {
        if (headNode == null || headNode.next == null) {
            headNode = null;
            return;
        }
        SNode pre = headNode;
        SNode p = headNode.next;
        while (p != null && p.next != null) {
            pre = p;
            p = p.next;
        }
        pre.next = null;
    }

    private void printAll() {
        SNode node = headNode;
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.next;
        }
        System.out.println();
    }

    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printAll();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.printAll();



        System.out.println("======�вβ���========");
        LRUBaseLinkedList lru = new LRUBaseLinkedList<Integer>(4);
        lru.add(1);
        lru.printAll();
        lru.add(2);
       lru.printAll();
        lru.add(3);
       lru.printAll();
        lru.add(4);
       lru.printAll();
        lru.add(2);
       lru.printAll();
        lru.add(4);
       lru.printAll();
        lru.add(7);
       lru.printAll();
        lru.add(1);
       lru.printAll();
        lru.add(2);
       lru.printAll();
    }
}
