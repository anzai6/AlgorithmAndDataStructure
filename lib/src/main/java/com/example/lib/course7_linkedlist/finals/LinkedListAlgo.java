package com.example.lib.course7_linkedlist.finals;

import com.example.lib.Node;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * <p>
 * Author: Zheng
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list) {

        return null;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {

        return null;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        return null;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

}