package com.example.lib.course7_linkedlist.finals;

/**
 * 1) ������ת
 * 2) �����л��ļ��
 * 3) �������������ϲ�
 * 4) ɾ����������n�����
 * 5) ��������м���
 * <p>
 * Created by qinshunan on 2019/2/22.
 */

public class LinkedListAlgo {

    /**
     * ������ת
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
     * ����������Ƿ���ڻ�
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
     * �������������ϲ���һ�����������
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
        Node last = null;// ʣ�µ�node
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
     * ɾ������ĵ�����K���ڵ�
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
        // ����k���ڵ�
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
        // ɾ��������k��
        if (preNode != null) {
            preNode.next = preNode.next.next;
        }
        slowNode.next = null;
        return node;
    }

    /**
     * ���м���
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

//        System.out.println("�м�ڵ㣺" + findMiddleNode(headNode).data);
//        System.out.println("��תǰ��");
//        printAll(headNode);
//        System.out.println("��ת��");
//        printAll(singleLinkedReversal(headNode));

//        node.next = center;// �������컷
//        System.out.println("node�Ƿ���ڻ���" + checkContainCircle(headNode));

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

        System.out.println("headNode1��");
        printAll(headNode1);
        System.out.println("headNode2��");
        printAll(headNode2);
        System.out.println("�ϲ���");
        printAll(mergeTwoLinkeds(headNode1, headNode2));


//        Node headNode3 = new Node(0, null);
//        Node node3 = headNode3;
//        for (int i = 1; i < 10; i++) {
//            node3.next = new Node(i, null);
//            node3 = node3.next;
//        }
//
//        System.out.println("ɾ��ǰ��");
//        printAll(headNode3);
//        System.out.println("ɾ����");
//        printAll(deleteReciprocalK(headNode3, 5));
    }
}
