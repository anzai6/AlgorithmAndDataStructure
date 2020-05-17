package com.leetcode.anzai.subject_1_20;

import com.leetcode.anzai.ListNode;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Subject19 {

    /**
     *
     给定一个链表，删除链表的倒数第?n?个节点，并且返回链表的头结点。

     示例：

     给定一个链表: 1->2->3->4->5, 和 n = 2.

     当删除了倒数第二个节点后，链表变为 1->2->3->5.
     说明：

     给定的 n?保证是有效的。

     进阶：

     你能尝试使用一趟扫描实现吗？
     *
     */

    /**
     * 利用快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n < 1)
            return head;

        if (head == null)
            return null;

        ListNode fastNode = head; // 快指针
        ListNode slowNode = head; // 慢指针
        ListNode preNode = null; // 要删除的指针的前一个指针

        // 先把快指针移动 n 位
        int i = 1;
        while (i < n && fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next;
            i++;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            preNode = slowNode;
            slowNode = slowNode.next;
        }

        if (preNode != null) {
            preNode.next = slowNode.next;
        } else {
            head = head.next;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Subject19 subject = new Subject19();
        ListNode listNode = subject.removeNthFromEnd(head, 1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
