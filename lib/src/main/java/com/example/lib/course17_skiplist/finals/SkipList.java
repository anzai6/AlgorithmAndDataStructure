package com.example.lib.course17_skiplist.finals;

import java.util.Random;

/**
 * �����һ��ʵ�ַ�����
 * �����д洢���������������Ҵ洢���ǲ��ظ��ġ�
 * <p>
 * Author��ZHENG
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // ��ͷ����

    private Random r = new Random();

    public Node find(int value) {
            return null;
    }

    public void insert(int value) {
    }

    public void delete(int value) {
    }

    // ��� level �Σ�������������� +1����ֹα���
    private int randomLevel() {

        return 1;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(15);
        skipList.find(15);
        skipList.find(4);
        skipList.find(3);
        skipList.find(2);
        skipList.find(1);
        skipList.printAll();
    }

}
