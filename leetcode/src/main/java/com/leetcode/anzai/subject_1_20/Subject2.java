package com.leetcode.anzai.subject_1_20;

import com.leetcode.anzai.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Subject2 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */


    /**
     * 一开始思路错了，被例子的公式误导了（342 + 465 = 807）：先分别求出两个链表的值再相加再求最后一个链表，这个方法很容易有溢出，所以不对
     * 应该两个链表同时取值相加，大于9就进求10的余数，1进下一位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        int last = 0;
        ListNode head = null;
        ListNode tail = null; // 最后一位
        while (l1 != null && l2 != null) {
            int value1 = l1.val;
            int value2 = l2.val;
            int totalValue = value1 + value2 + last;
            if (totalValue > 9) { // 9以上要向上进一位，类似加法
                totalValue %= 10;
                last = 1;
            } else last = 0;

            ListNode listNode = new ListNode(totalValue);
            if (head == null) {
                head = listNode;
                tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode next;
        if (l1 == null) {
            next = l2;
        } else
            next = l1;

        while (last == 1) {
            int totalValue = ((next == null) ? 0 : next.val) + last;
            if (totalValue > 9) { // 9以上要向上进一位，类似加法
                totalValue %= 10;
                last = 1;
            } else {
                last = 0;
            }
            ListNode listNode = new ListNode(totalValue);
            if (head == null) {
                head = listNode;
                tail = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
            if (next != null)
                next = next.next;
        }
        tail.next = next;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(9);
        head.next = listNode1;
        ListNode listNode2 = new ListNode(9);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(9);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(9);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(9);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(9);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(9);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(9);
        listNode7.next = listNode8;
        ListNode listNode9 = new ListNode(9);
        listNode8.next = listNode9;
        Subject2 subject = new Subject2();
        ListNode listNode = subject.addTwoNumbers(new ListNode(9), head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
