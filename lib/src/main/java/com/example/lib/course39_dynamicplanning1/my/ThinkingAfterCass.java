package com.example.lib.course39_dynamicplanning1.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 课后思考，杨辉三角形问题
 * Created by qinshunan on 2019/5/9.
 */

public class ThinkingAfterCass {

    // 进过某个数字只能到达下面一层响邻的两个数字
    // 假设从第一次往下移动，吧移动到最底层所经过的所有数字之和，定义为路径的长度
    // 求最高层移动到最底层的最短路径
    // 使用回溯算法可以求解，就是耗时过多
    // 使用动态规划更有效率

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
    // 存储需要添加数据的Node，如果左右子Node都已添加数据的则移出队列
    private Queue<Node> mQueue;
    private int[] dataList = {5, 7, 8, 2, 3, 4, 4, 1, 6, 1, 6, 7, 9, 4, 5};
    int totalPath = 0;

    /**
     * 寻找到达底层的最短路径最短路径
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

        System.out.println("最短路径是：" + minPath);
    }

    public ThinkingAfterCass() {
        mQueue = new LinkedList<>();
        for (int i = 0; i < dataList.length; i++) {
            addData(dataList[i]);
        }
    }

    /**
     * 插入节点,同时计算到达每一个节点的最短路径
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
            Node addNode = mQueue.peek(); // 访问第一个Node作为当前需要添加子节点的Node，不删除
            if (addNode.left == null) {  // 先加入左子节点
                addNode.left = newNode;
                newNode.leftParent = addNode;
                newNode.minPath = newNode.data + addNode.minPath;
            } else { // 加入右子节点，这里注意加入右子节点后可能可以同时加入下一个待加节点的左子节点
                newNode.rightParent = addNode;
                addNode.right = newNode;
                mQueue.poll(); // 清除队列第一个Node，因为它的左右Node已经添加完成

                Node nextNode = mQueue.peek(); // 访问下一个，不删除
                if (addNode.leftParent != null && addNode.leftParent == nextNode.rightParent) { // 有相同父节点,则给下一个节点添加左子节点
                    nextNode.left = newNode;
                    newNode.leftParent = nextNode;
                    newNode.minPath = newNode.data + Math.min(addNode.minPath, nextNode.minPath);
                } else { // 无相同父节点，单独加左父节点
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
                    System.out.println(); // 下一行
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
        // 这里记录从顶部节点到达当前节点的最短路径
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
