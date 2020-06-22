package com.example.lib.course17_skiplist.finals;

import java.util.Random;

/**
 * �ҵ�����ʵ�֣�����ʦ�����в�ͬ
 * �����һ��ʵ�ַ�����
 * �����д洢���������������Ҵ洢���ǲ��ظ��ġ�
 * <p>
 * Author��ZHENG
 */
public class MySkipList {

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // ��ͷ����

    private Random r = new Random();

    /**
     * �������
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        // 1.��������һ���ı���
        Node p = head;
        for (int i = levelCount; i >= 0; i--) {
            // ������ǰһ��
            while (p.forwards[i] != null) {
                if (p.forwards[i].data < value) { // С��,��������Ѱ��
                    p = p.forwards[i];
                } else if (p.forwards[i].data == value) {  // ���ڣ��ҵ��ˣ�ֱ�ӷ���
                    return p.forwards[i];
                } else { // ���ڣ�������һ�����������һ��
                    break;
                }
            }
        }
        return null;
    }

    /**
     * �������
     *
     * @param value
     */
    public void insert(int value) {
        // ׼���½ڵ������
        Node newNode = new Node();
        newNode.data = value;
        int maxLevel = randomLevel();
        newNode.maxLevel = maxLevel;
        if (maxLevel > levelCount) {
            levelCount = maxLevel;
        }

        // �����½ڵ����������
        // 1.��������һ���ı�����Ȼ����newNode������
        Node pre = head;
        for (int i = levelCount; i >= 0; i--) {
            // ������ǰһ����Բ��� newNode ��ǰ������
            while (pre.forwards[i] != null && pre.forwards[i].data < value) {
                pre = pre.forwards[i];
            }
            // ���� newNode ����������ʱ������ newNode �����������������һ��
            if (i <= maxLevel) {
                if (pre.forwards[i] == null) { // �½ڵ㴦�����������λ��
                    pre.forwards[i] = newNode;
                } else { // ���� newNode ����
                    newNode.forwards[i] = pre.forwards[i].forwards[i];
                    pre.forwards[i] = newNode;
                }
            }
        }
    }

    /**
     * ����ɾ��
     *
     * @param value
     */
    public void delete(int value) {
        // 1.��������һ���ı���
        Node pre = head;
        for (int i = levelCount; i >= 0; i--) {
            // ������ǰһ��
            while (pre.forwards[i] != null) {
                if (pre.forwards[i].data < value) { // С��,��������Ѱ��
                    pre = pre.forwards[i];
                } else if (pre.forwards[i].data == value) {  //���ڣ��ҵ��ˣ��滻������������һ�����������һ��
                    pre.forwards[i] = pre.forwards[i].forwards[i];
                    break;
                } else { // ���ڣ�������һ�����������һ��
                    break;
                }
            }
        }
    }

    // ��� level �Σ�������������� +1����ֹα���
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
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
        // ���� maxLevel ������ָ����һ������
        private Node forwards[] = new Node[MAX_LEVEL];
        // ��ǰ�ڵ��������е������Ĳ���
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
        MySkipList skipList = new MySkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(15);
        skipList.printAll();
        System.out.println("���� 15 �� " + skipList.find(15));
        System.out.println("���� 4 �� " + skipList.find(4));
        System.out.println("���� 3 �� " + skipList.find(3));
        System.out.println("���� 2 �� " + skipList.find(2));
        System.out.println("���� 1 �� " + skipList.find(1));

        System.out.println("ɾ�� 2 �� ");
        skipList.delete(2);
        skipList.printAll();
        System.out.println("ɾ�� 3 �� ");
        skipList.delete(3);
        skipList.printAll();
    }

}
