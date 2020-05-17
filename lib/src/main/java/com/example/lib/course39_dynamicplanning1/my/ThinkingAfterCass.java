package com.example.lib.course39_dynamicplanning1.my;

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

        Queue<Node> queue = new LinkedList<>();
        queue.addAll(mQueue);
        int minPath = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.minPath < minPath)
                minPath = node.minPath;
        }

        System.out.println("���·���ǣ�" + minPath);
    }

    public ThinkingAfterCass() {
        mQueue = new LinkedList<>();
        for (int i = 0; i < dataList.length; i++) {
            addData(dataList[i]);
        }
    }

    /**
     * ����ڵ�,ͬʱ���㵽��ÿһ���ڵ�����·��
     *
     * @param data
     */
    public void addData(int data) {
        totalPath += data;
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            top.minPath = top.data;
            mQueue.add(top);
        } else {
            Node addNode = mQueue.peek(); // ���ʵ�һ��Node��Ϊ��ǰ��Ҫ����ӽڵ��Node����ɾ��
            if (addNode.left == null) {  // �ȼ������ӽڵ�
                addNode.left = newNode;
                newNode.leftParent = addNode;
                newNode.minPath = newNode.data + addNode.minPath;
            } else { // �������ӽڵ㣬����ע��������ӽڵ����ܿ���ͬʱ������һ�����ӽڵ�����ӽڵ�
                newNode.rightParent = addNode;
                addNode.right = newNode;
                mQueue.poll(); // ������е�һ��Node����Ϊ��������Node�Ѿ�������

                Node nextNode = mQueue.peek(); // ������һ������ɾ��
                if (addNode.leftParent != null && addNode.leftParent == nextNode.rightParent) { // ����ͬ���ڵ�,�����һ���ڵ�������ӽڵ�
                    nextNode.left = newNode;
                    newNode.leftParent = nextNode;
                    newNode.minPath = newNode.data + Math.min(addNode.minPath, nextNode.minPath);
                } else { // ����ͬ���ڵ㣬�������󸸽ڵ�
                    newNode.minPath = newNode.data + addNode.minPath;
                }

            }
            mQueue.add(newNode);
        }
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
