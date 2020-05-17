package com.leetcode.anzai.subject_81_100;

import com.leetcode.anzai.ListNode;

/**
 * ɾ�����������е��ظ�Ԫ��
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Subject83 {

    /**
     *
     ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�

     ʾ��?1:

     ����: 1->1->2
     ���: 1->2
     ʾ��?2:

     ����: 1->1->2->3->3
     ���: 1->2->3
     *
     */

    /**
     * ��һ����ͬ��ȥ��
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;

        while (node != null) {
            // ��һ���ڵ����ʱ������
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        head.next = node1;
//        ListNode node2 = new ListNode(3);
//        node1.next = node2;
//        ListNode node3 = new ListNode(3);
//        node2.next = node3;
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
//        ListNode node5 = new ListNode(4);
//        node4.next = node5;
//        ListNode node6 = new ListNode(5);
//        node5.next = node6;

        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(3);
        node4.next = node5;

        Subject83 subject = new Subject83();
        head = subject.deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

}
