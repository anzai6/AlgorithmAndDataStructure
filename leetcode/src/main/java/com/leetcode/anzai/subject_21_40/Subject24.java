package com.leetcode.anzai.subject_21_40;


import com.leetcode.anzai.ListNode;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Subject24 {

    /**
     给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

     ?

     示例:

     给定 1->2->3->4, 你应该返回 2->1->4->3.

     */

    /**
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;

        ListNode listNode = head;
        ListNode tail = null;

        while (listNode != null && listNode.next != null){
            ListNode next = listNode.next;
            listNode.next = next.next;
            next.next = listNode;
            if(tail != null){
                tail.next = next;
            }else {
                head = next;
            }
            tail = listNode;
            listNode = listNode.next;
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

        Subject24 subject = new Subject24();
        ListNode listNode = subject.swapPairs( l1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
