package com.leetcode.anzai.subject_21_40;


import com.leetcode.anzai.ListNode;

/**
 * K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class Subject25 {

    /**
     给你一个链表，每?k?个节点一组进行翻转，请你返回翻转后的链表。

     k?是一个正整数，它的值小于或等于链表的长度。

     如果节点总数不是?k?的整数倍，那么请将最后剩余的节点保持原有顺序。

     示例 :

     给定这个链表：1->2->3->4->5

     当?k?= 2 时，应当返回: 2->1->4->3->5

     当?k?= 3 时，应当返回: 3->2->1->4->5

     说明 :

     你的算法只能使用常数的额外空间。
     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

     */

    /**
     * 我的普通版本
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;

        ListNode tail = null;
        ListNode listNode = head;


        int size = 1; // 链表总长度

        while (listNode.next != null) {
            listNode = listNode.next;
            size++;
        }
        listNode = head;

        for (int i = 0; i < size / k; i++) {
            ListNode newHead = listNode;
            for (int j = 0; j < k - 1; j++) {
                ListNode next = listNode.next;
                listNode.next = next.next;
                next.next = newHead;
                newHead = next;
            }
            if (i == 0) {
                head = newHead;
            } else {
                tail.next = newHead;
            }
            tail = listNode;
            listNode = listNode.next;
        }

        if (tail == null)
            return head;

        if (size % k != 0) // 剩余的
            tail.next = listNode;
        else {
            tail.next = null;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        l1.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Subject25 subject = new Subject25();
        ListNode listNode = subject.reverseKGroup(l1, 2);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
