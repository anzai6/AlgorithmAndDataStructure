package com.example.lib.course6_linkedlist.finals;

import java.util.Scanner;

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
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * ͷ���
     */
    private SNode<T> headNode;

    /**
     * ������
     */
    private Integer length;

    /**
     * ��������
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
    }

    public LRUBaseLinkedList(Integer capacity) {
    }

    public void add(T data) {
    }

    /**
     * ɾ��preNode�����һ��Ԫ��
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
    }

    /**
     * ����ͷ������ڵ�
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
    }

    /**
     * ��ȡ���ҵ�Ԫ�ص�ǰһ�����
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        return null;
    }

    /**
     * ɾ��β���
     */
    private void deleteElemAtEnd() {
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
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
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
