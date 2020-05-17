package com.example.lib.course57_exercise.solution.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * �ϲ� k ����������
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class SolutionMergeKSortedList {

    /**
     * ���ȼ����нⷨ������һ�����нڵ��������ȼ����У�Ȼ�󰤸������о�������Ҫ����
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) // ����
                    return 1;
                else if (o1.val < o2.val)
                    return -1;
                else
                    return 0;
            }
        });

        // �������нڵ㣬������ȼ�����
        for (int i = 0; i < lists.length; i++) {
            ListNode p = lists[i];
            while (p != null) {
                queue.add(p);
                p = p.next;
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!queue.isEmpty()) {
            ListNode newNode = queue.poll();
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        if (tail != null)
            tail.next = null;
        return head;
    }

    /**
     * �ݹ�ⷨ
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode p = recursionMergeKLists(lists, 0, lists.length - 1);

        return p;
    }

    /**
     * �ݹ�
     *
     * @param lists
     * @return
     */
    public ListNode recursionMergeKLists(ListNode[] lists, int low, int high) {

        if (low == high)
            return lists[low];

        int center = (low + high) / 2;

        ListNode p1 = recursionMergeKLists(lists, low, center);
        ListNode p2 = recursionMergeKLists(lists, center + 1, high);

        return mergeTwoList(p1, p2);
    }


    /**
     * ����ⷨ�������ϲ�
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode p = lists[0];

        for (int i = 1; i < lists.length; i++) {
            p = mergeTwoList(p, lists[i]);
        }

        return p;
    }


    /**
     * �������������ϲ�Ϊһ����������
     */
    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode newHead = null;
        ListNode newTail = null;
        if (node1 == null)
            newHead = node2;
        if (node2 == null)
            newHead = node1;

        while (node1 != null && node2 != null) {
            ListNode newNode;
            if (node1.val <= node2.val) {
                newNode = node1;
                node1 = node1.next;
            } else {
                newNode = node2;
                node2 = node2.next;
            }

            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
                newTail.next = null;
            }
        }

        if (newTail != null) {
            if (node1 == null) {
                newTail.next = node2;
            } else {
                newTail.next = node1;
            }
        }

        return newHead;
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        for (int i = 1; i < 4; i++) {
            ListNode p = new ListNode(i);
            ListNode tail = p;
            for (int j = 2; j < 5; j++) {
                ListNode newNode = new ListNode(i * j);
                tail.next = newNode;
                tail = newNode;
            }
            tail.next = null;
            lists[i - 1] = p;
        }

        SolutionMergeKSortedList solutionMergeKSortedList = new SolutionMergeKSortedList();
        ListNode p = solutionMergeKSortedList.mergeKLists(lists);
        while (p != null) {
            System.out.print(" " + p.val);
            p = p.next;
        }
    }
}
