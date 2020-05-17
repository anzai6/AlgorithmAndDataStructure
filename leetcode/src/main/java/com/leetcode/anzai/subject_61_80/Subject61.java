package com.leetcode.anzai.subject_61_80;

import com.leetcode.anzai.ListNode;

/**
 * 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Subject61 {

    /**
     *
     给定一个链表，旋转链表，将链表每个节点向右移动?k?个位置，其中?k?是非负数。

     示例?1:

     输入: 1->2->3->4->5->NULL, k = 2
     输出: 4->5->1->2->3->NULL
     解释:
     向右旋转 1 步: 5->1->2->3->4->NULL
     向右旋转 2 步: 4->5->1->2->3->NULL
     示例?2:

     输入: 0->1->2->NULL, k = 4
     输出: 2->0->1->NULL
     解释:
     向右旋转 1 步: 2->0->1->NULL
     向右旋转 2 步: 1->2->0->NULL
     向右旋转 3 步:?0->1->2->NULL
     向右旋转 4 步:?2->0->1->NULL
     *
     */

    /**
     * 利用快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode fastKNode = head; // 快指针，间隔 k 个
        int count = 0;
        while (fastKNode.next != null && count < k) {
            fastKNode = fastKNode.next;
            count++;
        }
        // 列表没有k个元素
        if (count != k) {
            // 求余
            k %= (count + 1);
            // 重新算出快指针
            fastKNode = head; // 快指针，间隔 k 个
            count = 0;
            while (fastKNode.next != null && count < k) {
                fastKNode = fastKNode.next;
                count++;
            }
        }

        ListNode slowNode = head; // 慢指针
        // 找到慢指针最后的位置
        while (fastKNode.next != null) {
            slowNode = slowNode.next;
            fastKNode = fastKNode.next;
        }

        // 旋转指针：从后旋转到前面
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
