package com.leetcode.anzai.subject_21_40;


import com.leetcode.anzai.ListNode;

/**
 * K ��һ�鷭ת����
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class Subject25 {

    /**
     ����һ������ÿ?k?���ڵ�һ����з�ת�����㷵�ط�ת�������

     k?��һ��������������ֵС�ڻ��������ĳ��ȡ�

     ����ڵ���������?k?������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��

     ʾ�� :

     �����������1->2->3->4->5

     ��?k?= 2 ʱ��Ӧ������: 2->1->4->3->5

     ��?k?= 3 ʱ��Ӧ������: 3->2->1->4->5

     ˵�� :

     ����㷨ֻ��ʹ�ó����Ķ���ռ䡣
     �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����

     */

    /**
     * �ҵ���ͨ�汾
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;

        ListNode tail = null;
        ListNode listNode = head;


        int size = 1; // �����ܳ���

        while (listNode.next != null) {
            listNode = listNode.next;
            size++;
        }
        listNode = head;

        for (int i = 0; i < size / k; i++) {
            ListNode newHead = listNode;
            for (int j = 0; j < k - 1; j++) {
                ListNode next = listNode.next;
                listNode.next = next.next;
                next.next = newHead;
                newHead = next;
            }
            if (i == 0) {
                head = newHead;
            } else {
                tail.next = newHead;
            }
            tail = listNode;
            listNode = listNode.next;
        }

        if (tail == null)
            return head;

        if (size % k != 0) // ʣ���
            tail.next = listNode;
        else {
            tail.next = null;
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

        Subject25 subject = new Subject25();
        ListNode listNode = subject.reverseKGroup(l1, 2);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
