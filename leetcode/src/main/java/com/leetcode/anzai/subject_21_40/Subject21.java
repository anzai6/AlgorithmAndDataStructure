package com.leetcode.anzai.subject_21_40;


import com.leetcode.anzai.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Subject21 {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。?
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            ListNode listNode;
            if (val1 > val2) {
                listNode = l2;
                l2 = l2.next;
            } else {
                listNode = l1;
                l1 = l1.next;
            }

            listNode.next = null;

            if (head == null) {
                head = listNode;
                tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
        }

        ListNode listNode;
        if (l1 == null) {
            listNode = l2;
        } else {
            listNode = l1;
        }

        if (tail != null)
            tail.next = listNode;
        else
            head = listNode;

        return head;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(9);
        l1.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode l2 = new ListNode(1);
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(5);
        ListNode listNode14 = new ListNode(6);
        l2.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;


        Subject21 subject = new Subject21();
        ListNode listNode = subject.mergeTwoLists(l2, l1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
