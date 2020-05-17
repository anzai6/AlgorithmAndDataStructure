package com.example.lib.course7_linkedlist.my;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * <p>
 * Created by qinshunan on 2019/2/22.
 */

public class MyLinkedListAlgo {

    /**
     * 单链表反转
     *
     * @param node
     * @return
     */
    public static Node singleLinkedReversal(Node node) {
        if (node.next == null)
            return node;
        Node head = node.next;
        node.next = null;
        while (head.next != null) {
            Node front = head.next;
            head.next = node;
            node = head;
            head = front;
        }
        head.next = node;
        return head;
    }

    /**
     * 检查链表中是否存在环
     *
     * @param node
     * @return
     */
    public static boolean checkContainCircle(Node node) {

        if (node == null || node.next == null)
            return false;

        Node fast = node.next;
        Node slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    /**
     * 两个有序的链表合并成一个有序的链表
     */
    public static Node mergeTwoLinkeds(Node node1, Node node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        Node p = node1;
        Node q = node2;
        Node head;
        if (p.data <= p.data) { // 那个小就移动哪个链表的指针
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node newN = head;
        while (p != null && q != null) {

            if (p.data <= q.data) { // 那个小就移动哪一个链表的指针
                newN.next = p;
                p = p.next;
            } else {
                newN.next = q;
                q = q.next;
            }
            newN = newN.next;
        }

        if (p == null) {
            newN.next = q;
        } else {
            newN.next = p;
        }

        return head;
    }

    /**
     * 删除链表的倒数第K个节点
     *
     * @param node
     * @return
     */
    public static Node deleteReciprocalK(Node node, int k) {

        if (node == null || node.next == null)
            return node;

        Node fast = node;

        // 将指针往前移动K个节点作为快指针
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        // 不够K个节点
        if (fast == null)
            return node;

        Node slow = node;
        Node pre = null;

        // 由于快指针提前移动了K个节点，当快指针移动到末尾时满指针刚刚距离末尾K个节点，此时满指针就是倒数第K个节点
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) { // 刚好K个节点
            node = node.next;
        } else {
            pre.next = pre.next.next; // 删除
        }
        return node;
    }

    /**
     * 求中间结点
     *
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Node headNode = new Node(0, null);
        Node node = headNode;
        Node center = null;
        for (int i = 1; i < 10; i++) {
            node.next = new Node(i, null);
            node = node.next;
            if (i == 5)
                center = node;
        }

//        System.out.println("反转前：");
//        printAll(headNode);
//        System.out.println("反转后：");
//        printAll(singleLinkedReversal(headNode));

//        node.next = center;// 给链表造环
//        System.out.println("node是否存在环：" + checkContainCircle(headNode));

        /*Node headNode1 = new Node(0, null);
        Node node1 = headNode1;
        for (int i = 1; i < 10; i++) {
            node1.next = new Node(i * 3, null);
            node1 = node1.next;
        }

        Node headNode2 = new Node(6, null);
        Node node2 = headNode2;
        for (int i = 1; i < 10; i++) {
            node2.next = new Node(6 + i * 2, null);
            node2 = node2.next;
        }

        System.out.println("headNode1：");
        printAll(headNode1);
        System.out.println("headNode2：");
        printAll(headNode2);
        System.out.println("合并后：");
        printAll(mergeTwoLinkeds(headNode1, headNode2));*/


        Node headNode3 = new Node(0, null);
        Node node3 = headNode3;
        for (int i = 1; i < 10; i++) {
            node3.next = new Node(i, null);
            node3 = node3.next;
        }

        System.out.println("删除前：");
        printAll(headNode3);
        System.out.println("删除后：");
        printAll(deleteReciprocalK(headNode3,5));
    }
}
