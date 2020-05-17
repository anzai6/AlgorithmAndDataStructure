package com.leetcode.anzai.subject_81_100;

import com.leetcode.anzai.ListNode;

/**
 * �ָ�����
 * https://leetcode-cn.com/problems/partition-list/
 */
public class Subject86 {

    /**
     *
     ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��

     ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�

     ʾ��:

     ����: head = 1->4->3->2->5->2, x = 3
     ���: 1->2->2->4->3->5
     *
     */

    /**
     * ���ҵ���һ�����ڵ��� x �Ľڵ� firstBigNode��Ȼ������С�� x �Ľڵ㶼�ŵ� firstBigNode ǰ��
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstBigNodePre = null; // ��һ�����ڵ��� x �Ľڵ��ǰ�����
        ListNode firstBigNode = null; // ��һ�����ڵ��� x �Ľڵ�
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            if (p.val >= x && firstBigNode == null) { // �ҵ���һ�����ڵ��� x �Ľڵ�
                firstBigNodePre = pre;
                firstBigNode = p;
                pre = p;
                p = p.next;
            } else if (p.val < x && firstBigNode != null) {
                // �ҵ���һ�����ڵ��� x �Ľڵ�󣬺���С�� x �Ľڵ㶼Ҫ�Ƶ� firstBigNode ǰ��
                pre.next = p.next;  // �Ƴ� p

                // �� p ���뵽 firstBigNode ǰ��
                if (firstBigNodePre != null) {
                    firstBigNodePre.next = p;
                } else {
                    head = p;
                }
                firstBigNodePre = p;
                p.next = firstBigNode;

                p = pre.next; // ���� p �ڵ����ѭ��
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
