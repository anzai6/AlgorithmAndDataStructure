package com.example.lib.course7_linkedlist.my;

/**
 * 1) ������ת
 * 2) �����л��ļ��
 * 3) �������������ϲ�
 * 4) ɾ����������n�����
 * 5) ��������м���
 * <p>
 * Created by qinshunan on 2019/2/22.
 */

public class MyLinkedListAlgo {

    /**
     * ������ת
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
     * ����������Ƿ���ڻ�
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
     * �������������ϲ���һ�����������
     */
    public static Node mergeTwoLinkeds(Node node1, Node node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        Node p = node1;
        Node q = node2;
        Node head;
        if (p.data <= p.data) { // �Ǹ�С���ƶ��ĸ������ָ��
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node newN = head;
        while (p != null && q != null) {

            if (p.data <= q.data) { // �Ǹ�С���ƶ���һ�������ָ��
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
     * ɾ������ĵ�����K���ڵ�
     *
     * @param node
     * @return
     */
    public static Node deleteReciprocalK(Node node, int k) {

        if (node == null || node.next == null)
            return node;

        Node fast = node;

        // ��ָ����ǰ�ƶ�K���ڵ���Ϊ��ָ��
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        // ����K���ڵ�
        if (fast == null)
            return node;

        Node slow = node;
        Node pre = null;

        // ���ڿ�ָ����ǰ�ƶ���K���ڵ㣬����ָ���ƶ���ĩβʱ��ָ��ով���ĩβK���ڵ㣬��ʱ��ָ����ǵ�����K���ڵ�
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) { // �պ�K���ڵ�
            node = node.next;
        } else {
            pre.next = pre.next.next; // ɾ��
        }
        return node;
    }

    /**
     * ���м���
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

//        System.out.println("��תǰ��");
//        printAll(headNode);
//        System.out.println("��ת��");
//        printAll(singleLinkedReversal(headNode));

//        node.next = center;// �������컷
//        System.out.println("node�Ƿ���ڻ���" + checkContainCircle(headNode));

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

        System.out.println("headNode1��");
        printAll(headNode1);
        System.out.println("headNode2��");
        printAll(headNode2);
        System.out.println("�ϲ���");
        printAll(mergeTwoLinkeds(headNode1, headNode2));*/


        Node headNode3 = new Node(0, null);
        Node node3 = headNode3;
        for (int i = 1; i < 10; i++) {
            node3.next = new Node(i, null);
            node3 = node3.next;
        }

        System.out.println("ɾ��ǰ��");
        printAll(headNode3);
        System.out.println("ɾ����");
        printAll(deleteReciprocalK(headNode3,5));
    }
}
