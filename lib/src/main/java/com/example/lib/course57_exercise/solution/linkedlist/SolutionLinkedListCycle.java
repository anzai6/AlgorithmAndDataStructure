package com.example.lib.course57_exercise.solution.linkedlist;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class SolutionLinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode p = head;
        ListNode fastNode = head.next; // 2倍速指针

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            p = p.next;
            if (p == fastNode)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SolutionLinkedListCycle solution = new SolutionLinkedListCycle();
        ListNode head = new ListNode(1);
        System.out.println("" + solution.hasCycle(head));
    }
}
