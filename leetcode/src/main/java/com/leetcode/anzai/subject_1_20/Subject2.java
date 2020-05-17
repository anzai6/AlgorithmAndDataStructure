package com.leetcode.anzai.subject_1_20;

import com.leetcode.anzai.ListNode;

/**
 * �������
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Subject2 {

    /**
     * �������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
     * <p>
     * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
     * <p>
     * �����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
     * <p>
     * ʾ����
     * <p>
     * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * �����7 -> 0 -> 8
     * ԭ��342 + 465 = 807
     */


    /**
     * һ��ʼ˼·���ˣ������ӵĹ�ʽ���ˣ�342 + 465 = 807�����ȷֱ�������������ֵ������������һ�����������������������������Բ���
     * Ӧ����������ͬʱȡֵ��ӣ�����9�ͽ���10��������1����һλ
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
        ListNode tail = null; // ���һλ
        while (l1 != null && l2 != null) {
            int value1 = l1.val;
            int value2 = l2.val;
            int totalValue = value1 + value2 + last;
            if (totalValue > 9) { // 9����Ҫ���Ͻ�һλ�����Ƽӷ�
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
            if (totalValue > 9) { // 9����Ҫ���Ͻ�һλ�����Ƽӷ�
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
