package com.leetcode.anzai.subject_61_80;

import com.leetcode.anzai.ListNode;

/**
 * ��ת����
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Subject61 {

    /**
     *
     ����һ��������ת����������ÿ���ڵ������ƶ�?k?��λ�ã�����?k?�ǷǸ�����

     ʾ��?1:

     ����: 1->2->3->4->5->NULL, k = 2
     ���: 4->5->1->2->3->NULL
     ����:
     ������ת 1 ��: 5->1->2->3->4->NULL
     ������ת 2 ��: 4->5->1->2->3->NULL
     ʾ��?2:

     ����: 0->1->2->NULL, k = 4
     ���: 2->0->1->NULL
     ����:
     ������ת 1 ��: 2->0->1->NULL
     ������ת 2 ��: 1->2->0->NULL
     ������ת 3 ��:?0->1->2->NULL
     ������ת 4 ��:?2->0->1->NULL
     *
     */

    /**
     * ���ÿ���ָ��
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode fastKNode = head; // ��ָ�룬��� k ��
        int count = 0;
        while (fastKNode.next != null && count < k) {
            fastKNode = fastKNode.next;
            count++;
        }
        // �б�û��k��Ԫ��
        if (count != k) {
            // ����
            k %= (count + 1);
            // ���������ָ��
            fastKNode = head; // ��ָ�룬��� k ��
            count = 0;
            while (fastKNode.next != null && count < k) {
                fastKNode = fastKNode.next;
                count++;
            }
        }

        ListNode slowNode = head; // ��ָ��
        // �ҵ���ָ������λ��
        while (fastKNode.next != null) {
            slowNode = slowNode.next;
            fastKNode = fastKNode.next;
        }

        // ��תָ�룺�Ӻ���ת��ǰ��
        fastKNode.next = head;
        head = slowNode.next;
        slowNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        Subject61 subject = new Subject61();
        head = subject.rotateRight(head, 3);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
    }


}
