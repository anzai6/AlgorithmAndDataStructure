package com.example.lib.course7_linkedlist.finals;

import com.example.lib.Node;

/**
 * 1) ������ת
 * 2) �����л��ļ��
 * 3) �������������ϲ�
 * 4) ɾ����������n�����
 * 5) ��������м���
 * <p>
 * Author: Zheng
 */
public class LinkedListAlgo {

    // ������ת
    public static Node reverse(Node list) {

        return null;
    }

    // ��⻷
    public static boolean checkCircle(Node list) {
        return false;
    }

    // ��������ϲ�
    public static Node mergeSortedLists(Node la, Node lb) {

        return null;
    }

    // ɾ��������K�����
    public static Node deleteLastKth(Node list, int k) {
        return list;
    }

    // ���м���
    public static Node findMiddleNode(Node list) {
        return null;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

}