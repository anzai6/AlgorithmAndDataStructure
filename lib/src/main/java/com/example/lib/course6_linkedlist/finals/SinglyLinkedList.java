package com.example.lib.course6_linkedlist.finals;

import com.example.lib.Node;

/**
 * 1��������Ĳ��롢ɾ�������Ҳ�����
 * 2�������д洢����int���͵����ݣ�
 *
 * Author��Zheng
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {

        return head;
    }

    public Node findByIndex(int index) {

        return head;
    }

    //��ͷ���
    //��ͷ������
    //���ֲ������������˳���෴������
    public void insertToHead(int value) {
    }

    public void insertToHead(Node newNode) {
    }

    //˳�����
    //����β������
    public void insertTail(int value){
    }
    public void insertAfter(Node p, int value) {
    }

    public void insertAfter(Node p, Node newNode) {
    }

    public void insertBefore(Node p, int value) {
    }

    public void insertBefore(Node p, Node newNode) {

    }

    public void deleteByNode(Node p) {
    }

    public void deleteByValue(int value) {
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //�ж������������true or false
    public boolean TFResult(Node left, Node right){
        return false;
    }
    //���ж��Ƿ�Ϊ����

    public boolean palindrome(){
        return false;
    }

    //����������ת
    public Node inverseLinkList_head(Node p){
        return p;

    }

    //��ͷ��������ת
    public Node inverseLinkList(Node p){
        return p;

    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String[]args){

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        int data[] = {1,2,5,2,1};
//        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("��ӡ����:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("����");
        }else{
            System.out.println("���ǻ���");
        }
    }

}
