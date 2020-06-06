package com.example.lib.course39_dynamicplanning1.finals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �κ�˼�����������������
 * Created by qinshunan on 2019/5/9.
 */

public class ThinkingAfterCass {

    // ����ĳ������ֻ�ܵ�������һ�����ڵ���������
    // ����ӵ�һ�������ƶ������ƶ�����ײ�����������������֮�ͣ�����Ϊ·���ĳ���
    // ����߲��ƶ�����ײ�����·��
    // ʹ�û����㷨������⣬���Ǻ�ʱ����
    // ʹ�ö�̬�滮����Ч��

    //                   5
    //                 /   \
    //                7     8
    //               / \   / \
    //              2    3    4
    //             / \  / \  / \
    //            4    1    6   1
    //           / \  / \  / \ / \
    //          6    7    9   4   5

    private Node top;
    // �洢��Ҫ������ݵ�Node�����������Node����������ݵ����Ƴ�����
    private Queue<Node> mQueue;
    private int[] dataList = {5, 7, 8, 2, 3, 4, 4, 1, 6, 1, 6, 7, 9, 4, 5};
    int totalPath = 0;

    /**
     * Ѱ�ҵ���ײ�����·�����·��
     */
    public void getShortestPath2() {


    }

    public ThinkingAfterCass() {
    }

    /**
     * ����ڵ�,ͬʱ���㵽��ÿһ���ڵ�����·��
     *
     * @param data
     */
    public void addData(int data) {
    }

    public void print() {
        if (top != null) {
            Queue<Node> printQueue = new LinkedList<>();
            Queue<Node> nextQueue = new LinkedList<>();
            printQueue.add(top);
            while (!printQueue.isEmpty()) {
                Node node = printQueue.poll();
                System.out.print(node.data + "(" + node.minPath + ")" + " - ");
                if (node.left != null && !nextQueue.contains(node.left))
                    nextQueue.add(node.left);
                if (node.right != null && !nextQueue.contains(node.right))
                    nextQueue.add(node.right);

                if (printQueue.isEmpty()) {
                    System.out.println(); // ��һ��
                    printQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }
    }

    class Node {
        Node left;
        Node right;
        Node leftParent;
        Node rightParent;
        int data;
        // �����¼�Ӷ����ڵ㵽�ﵱǰ�ڵ�����·��
        int minPath;

        public Node(int data) {
            this.data = data;
        }

    }


    public static void main(String[] args) {
        ThinkingAfterCass thinkingAfterCass = new ThinkingAfterCass();
        thinkingAfterCass.print();
        thinkingAfterCass.getShortestPath2();
    }
}
