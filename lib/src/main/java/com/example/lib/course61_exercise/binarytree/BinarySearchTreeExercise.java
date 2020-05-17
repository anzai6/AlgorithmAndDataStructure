package com.example.lib.course61_exercise.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一个二叉查找树，并且支持插入、删除、查找操作
 */

public class BinarySearchTreeExercise {

    Node head;

    public BinarySearchTreeExercise() {

    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p != null) {
                if (data < p.data) { // 左树
                    if (p.left == null) {
                        p.left = newNode;
                        newNode.parent = p;
                        return;
                    } else p = p.left;
                } else if (data > p.data) { // 右树
                    if (p.right == null) {
                        p.right = newNode;
                        newNode.parent = p;
                        return;
                    } else p = p.right;
                } else {// 相等就证明已经存在该值，直接返回
                    p.isDelete = false; // 去掉删除的标记
                    return;
                }
            }
        }
    }

    /**
     * 查找
     *
     * @param data
     * @return
     */
    public Node search(int data) {
        if (head == null) {
            return null;
        } else {
            Node p = head;
            while (p != null) {
                if (p.data < data) { // 左树
                    p = p.left;
                } else if (p.data > data) { // 右树
                    p = p.right;
                } else {// 相等
                    return p; // 根据删除标记返回结果
//                    return !p.isDelete; // 根据删除标记返回结果
                }
            }
        }
        return null;
    }

    /**
     * 查找前驱结点
     *
     * @param data
     * @return
     */
    public Node findParentNode(int data) {
        if (head == null) {
            return null;
        } else {
            Node p = head;
            Node pF = null;
            while (p != null) {
                if (p.data < data) { // 左树
                    pF = p;
                    p = p.left;
                } else if (p.data > data) { // 右树
                    pF = p;
                    p = p.right;
                } else {// 相等
                    return pF; // 根据删除标记返回结果
//                    return !p.isDelete; // 根据删除标记返回结果
                }
            }
        }
        return null;
    }


    /**
     * 删除，把删除标记置为true
     *
     * @param data
     * @return
     */
    public boolean delete(int data) {
        if (head == null) {
            return false;
        } else {
            Node p = head;
            while (p != null) {
                if (p.data < data) { // 左树
                    p = p.left;
                } else if (p.data > data) { // 右树
                    p = p.right;
                } else {// 相等
                    p.isDelete = true; // 设置删除标记
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除，删除节点有两个节点的时候将删除节点和右子节点的最小节点互换，然后删除
     *
     * @param data
     * @return
     */
    public boolean delete2(int data) {
        if (head == null)
            return false;
        Node p = head;
        Node dNode = null; // 要删除的节点
        Node dNodeF = null; // 删除节点的子节点
        while (p != null) {
            if (p.data < data) { // 左树
                dNodeF = p;
                p = p.left;
            } else if (p.data > data) { // 右树
                dNodeF = p;
                p = p.right;
            } else {// 相等
                dNode = p;
//                p.isDelete = true; // 设置删除标记
            }
        }

        if (dNode == null)
            return false;

        if (dNode.left != null && dNode.right != null) { // 删除节点存在两个子节点
            // 在删除节点的右子节点中寻找到最小节点
            Node minNode = dNode.right; // 最小节点
            Node minNodeF = dNode; //
            while (minNode.left != null) {
                minNodeF = minNode;
                minNode = minNode.left;
            }
            dNode.data = minNode.data; // 删除节点换为最小节点的值
            dNode = minNode; // 改为删除最小节点
            dNodeF = minNodeF;
        }

        Node child = null; // 删除节点的子节点，由于上面的判读，所以删除节点只会有一个子节点了
        if (dNode.left != null) child = dNode.left;
        else if (dNode.right != null) child = dNode.right;
        else child = null;

        if (dNodeF == null) { // 删除节点没有父节点
            head = child;
        } else if (dNodeF.left == dNode) { // 删除节点是父节点的左子节点
            dNodeF.left = child;
        } else if (dNodeF.right == dNode) { // 删除节点是父节点的右子节点
            dNodeF.right = child;
        }

        return true;
    }

    /**
     * 前序遍历：当前节点->左子节点->右子节点
     */
    public void preOrderPrint() {
        preOrderPrint(head);
    }

    /**
     * 前序遍历：当前节点->左子节点->右子节点
     */
    public void preOrderPrint(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    /**
     * 中序遍历：左子节点->当前节点->右子节点
     */
    public void centerOrderPrint() {
        centerOrderPrint(head);
    }

    /**
     * 中序遍历：左子节点->当前节点->右子节点
     */
    public void centerOrderPrint(Node node) {
        if (node == null)
            return;
        centerOrderPrint(node.left);
        System.out.print(node.data + " ");
        centerOrderPrint(node.right);
    }

    /**
     * 后序遍历：左子节点->右子节点->当前节点
     */
    public void postOrderPrint() {
        postOrderPrint(head);
    }

    /**
     * 后序遍历：左子节点->右子节点->当前节点
     */
    public void postOrderPrint(Node node) {
        if (node == null)
            return;
        postOrderPrint(node.left);
        postOrderPrint(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 按层打印
     */
    public void layerPrint() {
        layerPrint(head);
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
        Queue<Node> currentQueue = new LinkedList<>(); // 当前一层
        Queue<Node> nextQueue = new LinkedList<>(); // 下一层
        currentQueue.add(node);

        while (!currentQueue.isEmpty()) {
            Node p = currentQueue.poll();
            System.out.print(p.data + " ");
            if (p.left != null)
                nextQueue.add(p.left);
            if (p.right != null)
                nextQueue.add(p.right);

            if (currentQueue.isEmpty()) { // 遍历完一层
                System.out.println();
                if (!nextQueue.isEmpty()) { // 将下一层的节点变为当前打印层，清空下一层
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }

    }

    /**
     * 获取当前树的高度
     *
     * @return
     */
    public int getHigh() {
        return getNodeHigh(head);
    }

    /**
     * 获取当前节点的高度（左右子节点最大高度加1）
     *
     * @param node
     * @return
     */
    public int getNodeHigh(Node node) {
        if (node == null)
            return -1;
        if (node.left != null || node.right != null) {
            int leftHigh = 0;
            int rightHigh = 0;
            if (node.left != null)
                leftHigh = getNodeHigh(node.left);
            if (node.right != null)
                rightHigh = getNodeHigh(node.right);
            return leftHigh > rightHigh ? leftHigh + 1 : rightHigh + 1;
        } else // 不存在子节点
            return 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        boolean isDelete = false;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 8, 18, 4, 14, 6, 16, 1, 11, 7, 17, 3, 13, 9, 19, 2, 12, 5, 15, 20, 0};
//        int length = data.length;
        int length = 20;
        BinarySearchTreeExercise binarySearchTreeExercise = new BinarySearchTreeExercise();
        for (int i = 0; i < length; i++) {
            binarySearchTreeExercise.insert(data[i]);
        }

        System.out.println("树的高度：" + binarySearchTreeExercise.getHigh());
//        System.out.println("最大：" + binarySearchTreeExercise.findMax().data + " -- 最小：" + binarySearchTreeExercise.findMin().data);

        int find = (int) (Math.random() * 20);
        Node fNode = binarySearchTreeExercise.search(find);
        System.out.println("查找：" + find + (fNode != null ? fNode.toString() : "空"));

        int deleteV = (int) (Math.random() * 20);
        binarySearchTreeExercise.delete(deleteV);
        System.out.println("删除：" + deleteV);
        binarySearchTreeExercise.layerPrint();
//
        System.out.println("前序遍历");
        binarySearchTreeExercise.preOrderPrint();
        System.out.println("");

        System.out.println("中序遍历");
        binarySearchTreeExercise.centerOrderPrint();
        System.out.println("");

        System.out.println("后序遍历");
        binarySearchTreeExercise.postOrderPrint();
        System.out.println("");

        System.out.println("按层遍历");
        binarySearchTreeExercise.layerPrint();
    }
}
