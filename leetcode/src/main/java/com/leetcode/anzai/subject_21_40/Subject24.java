package com.leetcode.anzai.subject_21_40;


import com.leetcode.anzai.ListNode;

/**
 * �������������еĽڵ�
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Subject24 {

    /**
     ����һ���������������������ڵĽڵ㣬�����ؽ����������

     �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����

     ?

     ʾ��:

     ���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.

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
