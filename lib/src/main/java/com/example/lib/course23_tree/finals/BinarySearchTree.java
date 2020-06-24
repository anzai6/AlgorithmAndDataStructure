package com.example.lib.course23_tree.finals;

import java.util.LinkedList;

/**
 * ��������������ӽڵ�С�ڸ��ڵ㣬���ӽڵ���ڸ��ڵ㣬����ڵ㲻ͬ
 * ���룬���ң�ɾ��������󣬲���С
 * Created by qinshunan on 2019/3/28.
 */

public class BinarySearchTree {

    // �����ڵ�
    private Node tree;

    /**
     * ���룬�ڵ㲻����ͬ
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
            if (p.data < value) { // ���ڣ�����
                if (p.right != null) { // ��Ϊ�գ�����
                    p = p.right;
                } else { // Ϊ�գ�ֱ�Ӳ���
                    p.right = newNode;
                    return;
                }
            } else if (p.data > value) { // С�ڣ�����
                if (p.left != null) { // ��Ϊ�գ�����
                    p = p.left;
                } else { // Ϊ�գ�ֱ�Ӳ���
                    p.left = newNode;
                    return;
                }
            } else { // ���ڣ�ֱ�ӷ���
                return;
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
            if (p.data < value) { // ���ڣ�����
                p = p.right;
            } else if (p.data > value) { // С�ڣ�����
                p = p.left;
            } else { // ���ڣ�ֱ�ӷ���
                return p;
            }
        }
        return null;
    }

    /**
     * ɾ���ڵ�,
     * 1.�ҵ�ɾ������
     * 2.�ж������ӽڵ㶼���ڲ���ҪѰ���滻�Ľڵ㣬����ֱ��ɾ��������
     * 3.�����ӽڵ㶼����ʱѰ����������ֵ�����ұ���Сֵ�Ľڵ㣬������ֵ�滻����ɾ���ڵ㣬Ȼ���Լ���Ϊ�µĴ�ɾ���ڵ�
     * 4.ɾ����ɾ���ڵ㣨��ʱ��ɾ���ڵ�һ���������������ӽڵ㣩
     *
     * @return
     */
    public boolean delete(int value) {
        Node p = tree;
        Node fNode = null; // ��ɾ���ڵ�
        Node preFNode = null; // ��ɾ���ڵ�ĸ��ڵ�
        while (p != null) {
            if (p.data < value) { // ���ڣ�����
                preFNode = p;
                p = p.right;
            } else if (p.data > value) { // С�ڣ�����
                preFNode = p;
                p = p.left;
            } else { // ���ڣ��˳�ѭ��
                fNode = p;
                p = null;
                break;
            }
        }

        // û���ҵ���Ӧ�ڵ�
        if (fNode == null) {
            return false;
        }

        // ֻ�������ӽڵ㶼���ڲ���ҪѰ���滻�Ľڵ㣬����ֱ��ɾ��������
        // Ѱ����������ֵ�����ұ���Сֵ�Ľڵ㣬����Ѱ��������ֵ
        if (fNode.left != null || fNode.right != null) {
            Node leftSubNode = fNode.left;
            Node leftSubNodePre = fNode;
            // һֱ���ң��ҵ����ڵ�
            while (leftSubNode.right != null) {
                leftSubNodePre = leftSubNode;
                leftSubNode = leftSubNode.right;
            }

            // �滻ֵ�󣬵���ɾ���� value
            fNode.data = leftSubNode.data;
            // ���´�ɾ���ڵ�͸��ڵ�
            fNode = leftSubNode;
            preFNode = leftSubNodePre;
        }

        // ��ʱ����ɾ���ڵ㲻��ͬʱ�������ӽڵ��ˣ��������ӽڵ����
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
     * �������
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
     * ������С
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
     * ǰ���������ǰ�ڵ�->���ӽڵ�->���ӽڵ�
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
     * ������������ӽڵ�->��ǰ�ڵ�->���ӽڵ�
     * ���൱��˳�����
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
     * ������������ӽڵ�->���ӽڵ�->��ǰ�ڵ�
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
     * �����ӡ�����϶���һ����ӡ��ͬһ��������Ҵ�ӡ
     * ˼·��ʹ��һ���������У�����ӡĳ���ڵ�ʱ�������ӽڵ������У�ͬʱ��¼��ǰ��δ��ӡ�ڵ�������һ���ܽڵ���
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
            if (nodes.isEmpty()) { // ������һ�㣬����һ��
                nodes = nextLayerNodes;
                nextLayerNodes = new LinkedList<>();
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
