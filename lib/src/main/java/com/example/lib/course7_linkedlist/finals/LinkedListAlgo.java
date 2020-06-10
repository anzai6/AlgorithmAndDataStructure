package com.example.lib.course7_linkedlist.finals;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * <p>
 * Created by qinshunan on 2019/2/22.
 */

public class LinkedListAlgo {

    /**
     * 单链表反转
     *
     * @param node
     * @return
     */
    public static Node singleLinkedReversal(Node node) {
        Node newHead = null;
        Node p = node;
        Node preNode = null;
        while (p != null) {
            preNode = p;
            p = p.next;
            preNode.next = newHead;
            newHead = preNode;
        }
        return newHead;
    }

    /**
     * 检查链表中是否存在环
     *
     * @param node
     * @return
     */
    public static boolean checkContainCircle(Node node) {
        if (node == null) {
            return false;
        }
        Node slow = node;
        Node fastNode = node;
        while (fastNode.next != null && fastNode.next.next != null) {
            slow = slow.next;
            fastNode = fastNode.next.next;
            if (slow.data == fastNode.data) {
                return true;
            }
        }
        return false;
    }

    /**
     * 两个有序的链表合并成一个有序的链表
     */
    public static Node mergeTwoLinkeds(Node node1, Node node2) {
        Node tail = null;
        Node head = null;
        while (node1 != null && node2 != null) {
            Node node;
            if (node1.data < node2.data) {
                node = node1;
                node1 = node1.next;
            } else {
                node = node2;
                node2 = node2.next;
            }
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        Node last = null;// 剩下的node
        if (node1 == null) {
            last = node2;
        } else {
            last = node1;
        }

        if (head == null) {
            head = last;
            tail = last;
        } else {
            tail.next = last;
            tail = last;
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
        if (k <= 0) {
            return null;
        }
        Node kNode = node;
        int index = 0;
        while (kNode != null && index < k) {
            kNode = kNode.next;
            index++;
        }
        // 不够k个节点
        if (index != k) {
            return null;
        }
        Node slowNode = node;
        Node preNode = null;
        while (kNode != null) {
            kNode = kNode.next;
            preNode = slowNode;
            slowNode = slowNode.next;
        }
        // 删除倒数第k个
        if (preNode != null) {
            preNode.next = preNode.next.next;
        }
        slowNode.next = null;
        return node;
    }

    /**
     * 求中间结点
     *
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node slow = list;
        Node fastNode = list;
        while (fastNode.next != null && fastNode.next.next != null) {
            slow = slow.next;
            fastNode = fastNode.next.next;
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

//        System.out.println("中间节点：" + findMiddleNode(headNode).data);
//        System.out.println("反转前：");
//        printAll(headNode);
//        System.out.println("反转后：");
//        printAll(singleLinkedReversal(headNode));

//        node.next = center;// 给链表造环
//        System.out.println("node是否存在环：" + checkContainCircle(headNode));

        Node headNode1 = new Node(0, null);
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
        printAll(mergeTwoLinkeds(headNode1, headNode2));


//        Node headNode3 = new Node(0, null);
//        Node node3 = headNode3;
//        for (int i = 1; i < 10; i++) {
//            node3.next = new Node(i, null);
//            node3 = node3.next;
//        }
//
//        System.out.println("删除前：");
//        printAll(headNode3);
//        System.out.println("删除后：");
//        printAll(deleteReciprocalK(headNode3, 5));
    }
}
