package com.leetcode.anzai.subject_81_100;

import com.leetcode.anzai.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Subject82 {

    /**
     *
     给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

     示例 1:

     输入: 1->2->3->3->4->4->5
     输出: 1->2->5
     示例 2:

     输入: 1->1->1->2->3
     输出: 2->3
     *
     */

    /**
     * 引入一个变量判断当前节点相同个数
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode node = head;
        int sameCount = 0; // 引入一个变量判断当前节点相同个数

        while (node != null) {
            // 当遇到不相等的节点时或者下一个节点为空时
            if (node.next == null || node.val != node.next.val) {
                if (sameCount != 0) { // 当前节点有相同的节点就不加入新链表
                    sameCount = 0;
                } else { // 加入新链表
                    if (newHead == null) {
                        newHead = node;
                        newTail = node;
                    } else {
                        newTail.next = node;
                        newTail = node;
                    }
                }
            } else {
                sameCount++;
            }
            node = node.next;
        }

        if (newTail != null) {
            newTail.next = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
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

        Subject82 subject = new Subject82();
        head = subject.deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

}
