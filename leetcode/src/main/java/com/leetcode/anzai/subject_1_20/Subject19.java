package com.leetcode.anzai.subject_1_20;

import com.leetcode.anzai.ListNode;

/**
 * ɾ������ĵ�����N���ڵ�
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Subject19 {

    /**
     *
     ����һ������ɾ������ĵ�����?n?���ڵ㣬���ҷ��������ͷ��㡣

     ʾ����

     ����һ������: 1->2->3->4->5, �� n = 2.

     ��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
     ˵����

     ������ n?��֤����Ч�ġ�

     ���ף�

     ���ܳ���ʹ��һ��ɨ��ʵ����
     *
     */

    /**
     * ���ÿ���ָ��
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n < 1)
            return head;

        if (head == null)
            return null;

        ListNode fastNode = head; // ��ָ��
        ListNode slowNode = head; // ��ָ��
        ListNode preNode = null; // Ҫɾ����ָ���ǰһ��ָ��

        // �Ȱѿ�ָ���ƶ� n λ
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
