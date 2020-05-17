package com.leetcode.anzai.subject_81_100;

import com.leetcode.anzai.ListNode;

/**
 * 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 */
public class Subject86 {

    /**
     *
     给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

     你应当保留两个分区中每个节点的初始相对位置。

     示例:

     输入: head = 1->4->3->2->5->2, x = 3
     输出: 1->2->2->4->3->5
     *
     */

    /**
     * 先找到第一个大于等于 x 的节点 firstBigNode，然后所有小于 x 的节点都放到 firstBigNode 前面
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstBigNodePre = null; // 第一个大于等于 x 的节点的前驱结点
        ListNode firstBigNode = null; // 第一个大于等于 x 的节点
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            if (p.val >= x && firstBigNode == null) { // 找到第一个大于等于 x 的节点
                firstBigNodePre = pre;
                firstBigNode = p;
                pre = p;
                p = p.next;
            } else if (p.val < x && firstBigNode != null) {
                // 找到第一个大于等于 x 的节点后，后面小于 x 的节点都要移到 firstBigNode 前面
                pre.next = p.next;  // 移除 p

                // 将 p 插入到 firstBigNode 前面
                if (firstBigNodePre != null) {
                    firstBigNodePre.next = p;
                } else {
                    head = p;
                }
                firstBigNodePre = p;
                p.next = firstBigNode;

                p = pre.next; // 重置 p 节点继续循环
            } else {
                pre = p;
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(4);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(2);
        node4.next = node5;
        ListNode node6 = new ListNode(1);
        node5.next = node6;

//        ListNode node1 = new ListNode(1);
//        head.next = node1;
//        ListNode node2 = new ListNode(1);
//        node1.next = node2;
//        ListNode node3 = new ListNode(2);
//        node2.next = node3;
//        ListNode node4 = new ListNode(3);
//        node3.next = node4;
//        ListNode node5 = new ListNode(3);
//        node4.next = node5;

        Subject86 subject = new Subject86();
        ListNode p = subject.partition(head, 4);
        while (p != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
    }

}
