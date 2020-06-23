package com.example.lib.course23_tree.finals;

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
        while (p != null){
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
     * 删除节点,找到删除借点后，继续寻找它左边最大值或者右边最小值替换自己的位置
     *
     * @return
     */
    public boolean delete(int value) {
        Node p = tree;
        Node pre = null;
        while (p != null){
            if (p.data < value) { // 大于，往右
                pre = p;
                p = p.right;
            } else if (p.data > value) { // 小于，往左
                pre = p;
                p = p.left;
            } else { // 等于,继续寻找它左边最大值
                if(p.left == null){
                    if(pre == null){
                        tree = p.right;
                    }else {
                        if(pre.data > value){ // 在父节点的左边
                            pre.left = p.right;
                        }else {
                            pre.right = p.right;
                        }
                    }
                }else

                return p;
            }
        }
        return false;
    }

    /**
     * 查找最大
     *
     * @return
     */
    public Node findMax() {
        return null;
    }

    /**
     * 查找最小
     *
     * @return
     */
    public Node findMin() {
        return null;
    }

    public void preOrderPrint() {
    }

    /**
     * 前序遍历：当前节点->左子节点->右子节点
     *
     * @param node
     */
    public void preOrderPrint(Node node) {
    }

    public void centerOrderPrint() {
    }

    /**
     * 中序遍历：左子节点->当前节点->右子节点
     * 即相当于顺序遍历
     *
     * @param node
     */
    public void centerOrderPrint(Node node) {
    }

    public void postOrderPrint() {
    }

    /**
     * 后序遍历：左子节点->右子节点->当前节点
     *
     * @param node
     */
    public void postOrderPrint(Node node) {
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
    }

    /**
     * 获取当前树的高度（层数减一）
     * 递归公式 当前节点高度 = 子节点高度 + 1；
     *
     * @return
     */
    public int getHigh() {
        return 1;
    }

    /**
     * 获取节点高度(左右子树节点的最大值加一)
     *
     * @param node
     */
    public int getNodeHigh(Node node) {
        return 0;
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
