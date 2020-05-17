package com.example.lib.course23_tree.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������������ӽڵ�С�ڸ��ڵ㣬���ӽڵ���ڸ��ڵ㣬����ڵ㲻ͬ
 * ���룬���ң�ɾ��������󣬲���С
 * Created by qinshunan on 2019/3/28.
 */

public class MyBinarySearchTree {

    // �����ڵ�
    private Node tree;

    /**
     * ����
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
            if (value < pValue) { // �������
                if (p.left == null) {
                    p.left = newNode;
                    return;
                } else {
                    p = p.left;
                }
            } else { // �����ұ�
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
     * ����
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = tree;
        while (p != null) {
            int pValue = p.data;
            if (value == pValue) { // �ҵ��ڵ�
                return p;
            } else if (value < pValue) { // �����
                p = p.left;
            } else { // ���ұ�
                p = p.right;
            }
        }
        return null;
    }

    /**
     * ɾ���ڵ�
     *
     * @return
     */
    public boolean delete(int value) {
        if (tree == null)
            return false;

        Node p = tree;
        // Ҫɾ���Ľڵ�
        Node dNode = null;
        // ɾ���ڵ�ĸ��ڵ�
        Node dNodeF = null;
        // �ҵ�ɾ���ڵ�
        while (p != null) {
            int pValue = p.data;
            if (value == pValue) { // �ҵ�ɾ���ڵ�
                dNode = p;
                p = null;
            } else if (value < pValue) { // �����
                dNodeF = p;
                p = p.left;
            } else { // ���ұ�
                dNodeF = p;
                p = p.right;
            }
        }

        // û�ҵ�ɾ���ڵ�
        if (dNode == null)
            return false;

        // ɾ���ڵ��������ڵ�,�ҵ������е���С�ڵ��滻Ҫɾ���Ľڵ�
        if (dNode.left != null && dNode.right != null) {
            Node rightMin = dNode.right; // ��С�ڵ�
            Node rightMinF = dNode; // ��С�ڵ�ĸ��ڵ�
            while (rightMin.left != null) { // �ҵ���С
                rightMinF = rightMin;
                rightMin = rightMin.left;
            }
            // �滻,����ͱ��ɾ��rightMin��
            dNode.data = rightMin.data;
            dNode = rightMin;
            dNodeF = rightMinF;
        }

        Node child = null;
        // ɾ���ڵ�û���ӽڵ����ֻ��һ���ӽڵ㣬����ֻҪ�ҵ��ӽڵ����ϸ��ڵ㼴�ɣ�Ҫ���Ǹ��ڵ�Ϊ�յ������
        if (dNode.left != null) child = dNode.left;
        else if (dNode.right != null) child = dNode.right;
        else child = null;

        if (dNodeF == null) { // ɾ���ڵ�û�и��ڵ�
            tree = child;
        } else if (dNodeF.left == dNode) // ɾ���ڵ��ڸ��ڵ�����
            dNodeF.left = child;
        else if (dNodeF.right == dNode) // ɾ���ڵ��ڸ��ڵ�����
            dNodeF.right = child;
        return true;
    }

    /**
     * �������
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
     * ������С
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
     * ǰ���������ǰ�ڵ�->���ӽڵ�->���ӽڵ�
     *
     * @param node
     */
    public void preOrderPrint(Node node) {
        if (node == null)
            return;
        // ��ǰ�ڵ�
        System.out.print(node.data + " ");
        // ���ӽڵ�
        preOrderPrint(node.left);
        // ���ӽڵ�
        preOrderPrint(node.right);
    }

    public void centerOrderPrint() {
        centerOrderPrint(tree);
    }

    /**
     * ������������ӽڵ�->��ǰ�ڵ�->���ӽڵ�
     * ���൱��˳�����
     * @param node
     */
    public void centerOrderPrint(Node node) {
        if (node == null)
            return;
        // ���ӽڵ�
        centerOrderPrint(node.left);
        // ��ǰ�ڵ�
        System.out.print(node.data + " ");
        // ���ӽڵ�
        centerOrderPrint(node.right);
    }

    public void postOrderPrint() {
        postOrderPrint(tree);
    }

    /**
     * ������������ӽڵ�->���ӽڵ�->��ǰ�ڵ�
     *
     * @param node
     */
    public void postOrderPrint(Node node) {
        if (node == null)
            return;
        // ���ӽڵ�
        postOrderPrint(node.left);
        // ���ӽڵ�
        postOrderPrint(node.right);
        // ��ǰ�ڵ�
        System.out.print(node.data + " ");
    }

    public void layerPrint() {
        layerPrint(tree);
    }

    /**
     * �����ӡ�����϶���һ����ӡ��ͬһ��������Ҵ�ӡ
     * ˼·��ʹ��һ���������У�����ӡĳ���ڵ�ʱ�������ӽڵ������У�ͬʱ��¼��ǰ��δ��ӡ�ڵ�������һ���ܽڵ���
     *
     * @param node
     */
    public void layerPrint(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>(); // �Ƚ��ȳ�������Ӳ���β��������ȡͷ��

        queue.offer(node); // ���ڵ����
        int current = 1; // ��ǰ��δ��ӡ�Ľڵ�����Ĭ�ϸ��ڵ���1
        int next = 0; // ��һ���ܽڵ�������ʼδ֪��Ϊ��

        while (!queue.isEmpty()) {
            // ��ӡ�ڵ�
            Node pNode = queue.poll(); // ȥ����ͷԪ��
            System.out.print(pNode.data + " ");
            current--;

            // ͬʱ��������ӽڵ�
            if (pNode.left != null) { // ����ʼ��֤�������Ҵ�ӡ
                queue.offer(pNode.left);
                next++;
            }
            if (pNode.right != null) {
                queue.offer(pNode.right);
                next++;
            }

            if (current == 0) { // ��ǰһ���ӡ���ˣ�ת�Ƶ���һ�㣬����current��next
                current = next;
                next = 0;
                System.out.println();
            }
        }
    }

    /**
     * ��ȡ��ǰ���ĸ߶ȣ�������һ��
     * �ݹ鹫ʽ ��ǰ�ڵ�߶� = �ӽڵ�߶� + 1��
     *
     * @return
     */
    public int getHigh() {
        return getNodeHigh(tree);
    }

    /**
     * ��ȡ�ڵ�߶�(���������ڵ�����ֵ��һ)
     *
     * @param node
     */
    public int getNodeHigh(Node node) {
        if (node == null)
            return -1;
        // �����ӽڵ�,���ӽڵ�����߶�
        if (node.left != null || node.right != null) {
            int leftHigh = 0;
            int rightHigh = 0;
            if (node.left != null)
                leftHigh = getNodeHigh(node.left);
            if (node.right != null)
                rightHigh = getNodeHigh(node.right);

            return leftHigh > rightHigh ? leftHigh + 1 : rightHigh + 1;
        } else { // �������ӽڵ�
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

        System.out.println("���ĸ߶ȣ�" + myBinarySearchTree.getHigh());
        System.out.println("���" + myBinarySearchTree.findMax().data + " -- ��С��" + myBinarySearchTree.findMin().data);
        myBinarySearchTree.layerPrint();

        int find = (int) (Math.random() * 20);
        Node fNode = myBinarySearchTree.find(find);
        System.out.println("���ң�" + find + (fNode != null ? fNode.toString() : "��"));

        int deleteV = (int) (Math.random() * 20);
        myBinarySearchTree.delete(deleteV);
        System.out.println("ɾ����" + deleteV);
        myBinarySearchTree.layerPrint();

        System.out.println("ǰ�����");
        myBinarySearchTree.preOrderPrint();
        System.out.println("");

        System.out.println("�������");
        myBinarySearchTree.centerOrderPrint();
        System.out.println("");

        System.out.println("�������");
        myBinarySearchTree.postOrderPrint();
        System.out.println("");
    }
}
