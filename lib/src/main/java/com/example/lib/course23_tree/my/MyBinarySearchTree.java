package com.example.lib.course23_tree.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树：左子节点小于父节点，右子节点大于父节点，假设节点不同
 * 插入，查找，删除，查最大，查最小
 * Created by qinshunan on 2019/3/28.
 */

public class MyBinarySearchTree {

    // 顶部节点
    private Node tree;

    /**
     * 插入
     *
     * @param value
     */
    public void insert(int value) {
        if (tree == null) {
            tree = new Node(value);
            return;
        }

        Node newNode = new Node(value);
        Node p = tree;
        while (p != null) {
            int pValue = p.data;
            if (value < pValue) { // 放在左边
                if (p.left == null) {
                    p.left = newNode;
                    return;
                } else {
                    p = p.left;
                }
            } else { // 放在右边
                if (p.right == null) {
                    p.right = newNode;
                    return;
                } else {
                    p = p.right;
                }
            }
        }
    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = tree;
        while (p != null) {
            int pValue = p.data;
            if (value == pValue) { // 找到节点
                return p;
            } else if (value < pValue) { // 在左边
                p = p.left;
            } else { // 在右边
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @return
     */
    public boolean delete(int value) {
        if (tree == null)
            return false;

        Node p = tree;
        // 要删除的节点
        Node dNode = null;
        // 删除节点的父节点
        Node dNodeF = null;
        // 找到删除节点
        while (p != null) {
            int pValue = p.data;
            if (value == pValue) { // 找到删除节点
                dNode = p;
                p = null;
            } else if (value < pValue) { // 在左边
                dNodeF = p;
                p = p.left;
            } else { // 在右边
                dNodeF = p;
                p = p.right;
            }
        }

        // 没找到删除节点
        if (dNode == null)
            return false;

        // 删除节点有两个节点,找到右树中的最小节点替换要删除的节点
        if (dNode.left != null && dNode.right != null) {
            Node rightMin = dNode.right; // 最小节点
            Node rightMinF = dNode; // 最小节点的父节点
            while (rightMin.left != null) { // 找到最小
                rightMinF = rightMin;
                rightMin = rightMin.left;
            }
            // 替换,下面就变成删除rightMin了
            dNode.data = rightMin.data;
            dNode = rightMin;
            dNodeF = rightMinF;
        }

        Node child = null;
        // 删除节点没有子节点或者只有一个子节点，所以只要找到子节点续上父节点即可（要考虑父节点为空的情况）
        if (dNode.left != null) child = dNode.left;
        else if (dNode.right != null) child = dNode.right;
        else child = null;

        if (dNodeF == null) { // 删除节点没有父节点
            tree = child;
        } else if (dNodeF.left == dNode) // 删除节点在父节点左树
            dNodeF.left = child;
        else if (dNodeF.right == dNode) // 删除节点在父节点右树
            dNodeF.right = child;
        return true;
    }

    /**
     * 查找最大
     *
     * @return
     */
    public Node findMax() {
        if (tree == null)
            return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 查找最小
     *
     * @return
     */
    public Node findMin() {
        if (tree == null)
            return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public void preOrderPrint() {
        preOrderPrint(tree);
    }

    /**
     * 前序遍历：当前节点->左子节点->右子节点
     *
     * @param node
     */
    public void preOrderPrint(Node node) {
        if (node == null)
            return;
        // 当前节点
        System.out.print(node.data + " ");
        // 左子节点
        preOrderPrint(node.left);
        // 右子节点
        preOrderPrint(node.right);
    }

    public void centerOrderPrint() {
        centerOrderPrint(tree);
    }

    /**
     * 中序遍历：左子节点->当前节点->右子节点
     * 即相当于顺序遍历
     * @param node
     */
    public void centerOrderPrint(Node node) {
        if (node == null)
            return;
        // 左子节点
        centerOrderPrint(node.left);
        // 当前节点
        System.out.print(node.data + " ");
        // 右子节点
        centerOrderPrint(node.right);
    }

    public void postOrderPrint() {
        postOrderPrint(tree);
    }

    /**
     * 后序遍历：左子节点->右子节点->当前节点
     *
     * @param node
     */
    public void postOrderPrint(Node node) {
        if (node == null)
            return;
        // 左子节点
        postOrderPrint(node.left);
        // 右子节点
        postOrderPrint(node.right);
        // 当前节点
        System.out.print(node.data + " ");
    }

    public void layerPrint() {
        layerPrint(tree);
    }

    /**
     * 按层打印：从上而下一层层打印，同一层从左往右打印
     * 思路：使用一个辅助队列，当打印某个节点时把它的子节点加入队列，同时记录当前层未打印节点数和下一层总节点数
     *
     * @param node
     */
    public void layerPrint(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>(); // 先进先出，即入队插入尾部，出队取头部

        queue.offer(node); // 根节点入队
        int current = 1; // 当前层未打印的节点数：默认根节点是1
        int next = 0; // 下一层总节点数：初始未知故为邻

        while (!queue.isEmpty()) {
            // 打印节点
            Node pNode = queue.poll(); // 去队列头元素
            System.out.print(pNode.data + " ");
            current--;

            // 同时入队左右子节点
            if (pNode.left != null) { // 从左开始保证从左往右打印
                queue.offer(pNode.left);
                next++;
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
                next++;
            }

            if (current == 0) { // 当前一层打印完了，转移到下一层，更新current和next
                current = next;
                next = 0;
                System.out.println();
            }
        }
    }

    /**
     * 获取当前树的高度（层数减一）
     * 递归公式 当前节点高度 = 子节点高度 + 1；
     *
     * @return
     */
    public int getHigh() {
        return getNodeHigh(tree);
    }

    /**
     * 获取节点高度(左右子树节点的最大值加一)
     *
     * @param node
     */
    public int getNodeHigh(Node node) {
        if (node == null)
            return -1;
        // 存在子节点,求子节点的最大高度
        if (node.left != null || node.right != null) {
            int leftHigh = 0;
            int rightHigh = 0;
            if (node.left != null)
                leftHigh = getNodeHigh(node.left);
            if (node.right != null)
                rightHigh = getNodeHigh(node.right);

            return leftHigh > rightHigh ? leftHigh + 1 : rightHigh + 1;
        } else { // 不存在子节点
            return 0;
        }
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 8, 18, 4, 14, 6, 16, 1, 11, 7, 17, 3, 13, 9, 19, 2, 12, 5, 15, 20, 0};
//        int length = data.length;
        int length = 20;
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        for (int i = 0; i < length; i++) {
            myBinarySearchTree.insert(data[i]);
        }

        System.out.println("树的高度：" + myBinarySearchTree.getHigh());
        System.out.println("最大：" + myBinarySearchTree.findMax().data + " -- 最小：" + myBinarySearchTree.findMin().data);
        myBinarySearchTree.layerPrint();

        int find = (int) (Math.random() * 20);
        Node fNode = myBinarySearchTree.find(find);
        System.out.println("查找：" + find + (fNode != null ? fNode.toString() : "空"));

        int deleteV = (int) (Math.random() * 20);
        myBinarySearchTree.delete(deleteV);
        System.out.println("删除：" + deleteV);
        myBinarySearchTree.layerPrint();

        System.out.println("前序遍历");
        myBinarySearchTree.preOrderPrint();
        System.out.println("");

        System.out.println("中序遍历");
        myBinarySearchTree.centerOrderPrint();
        System.out.println("");

        System.out.println("后序遍历");
        myBinarySearchTree.postOrderPrint();
        System.out.println("");
    }
}
