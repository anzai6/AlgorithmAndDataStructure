package com.leetcode.anzai.subject_81_100;

import com.leetcode.anzai.ListNode;

/**
 * ɾ�����������е��ظ�Ԫ�� II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Subject82 {

    /**
     *
     ����һ����������ɾ�����к����ظ����ֵĽڵ㣬ֻ����ԭʼ������ û���ظ����� �����֡�

     ʾ�� 1:

     ����: 1->2->3->3->4->4->5
     ���: 1->2->5
     ʾ�� 2:

     ����: 1->1->1->2->3
     ���: 2->3
     *
     */

    /**
     * ����һ�������жϵ�ǰ�ڵ���ͬ����
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
        int sameCount = 0; // ����һ�������жϵ�ǰ�ڵ���ͬ����

        while (node != null) {
            // ����������ȵĽڵ�ʱ������һ���ڵ�Ϊ��ʱ
            if (node.next == null || node.val != node.next.val) {
                if (sameCount != 0) { // ��ǰ�ڵ�����ͬ�Ľڵ�Ͳ�����������
                    sameCount = 0;
                } else { // ����������
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
