package com.example.lib.course6_linkedlist.finals;

import com.example.lib.Node;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：Zheng
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {

        return head;
    }

    public Node findByIndex(int index) {

        return head;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
    }

    public void insertToHead(Node newNode) {
    }

    //顺序插入
    //链表尾部插入
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

    //判断两个链表相等true or false
    public boolean TFResult(Node left, Node right){
        return false;
    }
    //　判断是否为回文

    public boolean palindrome(){
        return false;
    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p){
        return p;

    }

    //无头结点的链表翻转
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

        System.out.println("打印回文:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }

}
