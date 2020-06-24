package com.example.lib.course23_tree.finals;

import java.util.LinkedList;

/**
 * 二叉查找树：左子节点小于父节点，右子节点大于父节点，假设节点不同
 * 插入，查找，删除，查最大，查最小
 * Created by qinshunan on 2019/3/28.
 */

public class BinarySearchTree {

    // 顶部节点
    private Node tree;

    /**
     * 插入，节点不能相同
     *
     * @param value
     */
    public void insert(int value) {
        Node newNode = new Node(value);
        if (tree == null) {
            tree = newNode;
            return;
        }
        Node p = tree;
        while (p != null) {
            if (p.data < value) { // 大于，往右
                if (p.right != null) { // 不为空，继续
                    p = p.right;
                } else { // 为空，直接插入
                    p.right = newNode;
                    return;
                }
            } else if (p.data > value) { // 小于，往左
                if (p.left != null) { // 不为空，继续
                    p = p.left;
                } else { // 为空，直接插入
                    p.left = newNode;
                    return;
                }
            } else { // 等于，直接返回
                return;
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
            if (p.data < value) { // 大于，往右
                p = p.right;
            } else if (p.data > value) { // 小于，往左
                p = p.left;
            } else { // 等于，直接返回
                return p;
            }
        }
        return null;
    }

    /**
     * 删除节点,
     * 1.找到删除借点后
     * 2.判断左右子节点都存在才需要寻找替换的节点，否则直接删除自身即可
     * 3.左右子节点都存在时寻找它左边最大值或者右边最小值的节点，将它的值替换到待删除节点，然后自己成为新的待删除节点
     * 4.删除待删除节点（此时待删除节点一定不可能有两个子节点）
     *
     * @return
     */
    public boolean delete(int value) {
        Node p = tree;
        Node fNode = null; // 待删除节点
        Node preFNode = null; // 待删除节点的父节点
        while (p != null) {
            if (p.data < value) { // 大于，往右
                preFNode = p;
                p = p.right;
            } else if (p.data > value) { // 小于，往左
                preFNode = p;
                p = p.left;
            } else { // 等于，退出循环
                fNode = p;
                p = null;
                break;
            }
        }

        // 没有找到对应节点
        if (fNode == null) {
            return false;
        }

        // 只有左右子节点都存在才需要寻找替换的节点，否则直接删除自身即可
        // 寻找它左边最大值或者右边最小值的节点，这里寻找左边最大值
        if (fNode.left != null || fNode.right != null) {
            Node leftSubNode = fNode.left;
            Node leftSubNodePre = fNode;
            // 一直往右，找到最大节点
            while (leftSubNode.right != null) {
                leftSubNodePre = leftSubNode;
                leftSubNode = leftSubNode.right;
            }

            // 替换值后，等于删除了 value
            fNode.data = leftSubNode.data;
            // 更新待删除节点和父节点
            fNode = leftSubNode;
            preFNode = leftSubNodePre;
        }

        // 此时，待删除节点不会同时有左右子节点了，所以用子节点代替
        Node child = fNode.left != null ? fNode.left : fNode.right;

        if (preFNode == null) {
            tree = child;
            return true;
        }

        if (preFNode.left == fNode) {
            preFNode.left = child;
        } else {
            preFNode.right = child;
        }

        return true;
    }

    /**
     * 查找最大
     *
     * @return
     */
    public Node findMax() {
        if (tree == null) {
            return null;
        }
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
        if (tree == null) {
            return null;
        }
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
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public void centerOrderPrint() {
        centerOrderPrint(tree);
    }

    /**
     * 中序遍历：左子节点->当前节点->右子节点
     * 即相当于顺序遍历
     *
     * @param node
     */
    public void centerOrderPrint(Node node) {
        if (node == null) {
            return;
        }
        centerOrderPrint(node.left);
        System.out.print(node.data + " ");
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
        if (node == null) {
            return;
        }
        postOrderPrint(node.left);
        postOrderPrint(node.right);
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
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Node> nextLayerNodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node p = nodes.poll();
            System.out.print(p.data + " ");
            if (p.left != null) {
                nextLayerNodes.add(p.left);
            }
            if (p.right != null) {
                nextLayerNodes.add(p.right);
            }
            if (nodes.isEmpty()) { // 遍历完一层，换下一层
                nodes = nextLayerNodes;
                nextLayerNodes = new LinkedList<>();
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
        if (node == null) {
            return -1;
        }
        int leftHigh = getNodeHigh(node.left);
        int rightHigh = getNodeHigh(node.right);
        int max = Math.max(leftHigh, rightHigh);
        return 1 + max;
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 8, 18, 4, 14, 6, 16, 1, 11, 7, 17, 3, 13, 9, 19, 2, 12, 5, 15, 20, 0};
        int length = data.length;
        BinarySearchTree myBinarySearchTree = new BinarySearchTree();
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
