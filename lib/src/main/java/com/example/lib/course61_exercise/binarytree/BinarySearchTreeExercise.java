package com.example.lib.course61_exercise.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ʵ��һ�����������������֧�ֲ��롢ɾ�������Ҳ���
 */

public class BinarySearchTreeExercise {

    Node head;

    public BinarySearchTreeExercise() {

    }

    /**
     * ����
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
                if (data < p.data) { // ����
                    if (p.left == null) {
                        p.left = newNode;
                        newNode.parent = p;
                        return;
                    } else p = p.left;
                } else if (data > p.data) { // ����
                    if (p.right == null) {
                        p.right = newNode;
                        newNode.parent = p;
                        return;
                    } else p = p.right;
                } else {// ��Ⱦ�֤���Ѿ����ڸ�ֵ��ֱ�ӷ���
                    p.isDelete = false; // ȥ��ɾ���ı��
                    return;
                }
            }
        }
    }

    /**
     * ����
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
                if (p.data < data) { // ����
                    p = p.left;
                } else if (p.data > data) { // ����
                    p = p.right;
                } else {// ���
                    return p; // ����ɾ����Ƿ��ؽ��
//                    return !p.isDelete; // ����ɾ����Ƿ��ؽ��
                }
            }
        }
        return null;
    }

    /**
     * ����ǰ�����
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
                if (p.data < data) { // ����
                    pF = p;
                    p = p.left;
                } else if (p.data > data) { // ����
                    pF = p;
                    p = p.right;
                } else {// ���
                    return pF; // ����ɾ����Ƿ��ؽ��
//                    return !p.isDelete; // ����ɾ����Ƿ��ؽ��
                }
            }
        }
        return null;
    }


    /**
     * ɾ������ɾ�������Ϊtrue
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
                if (p.data < data) { // ����
                    p = p.left;
                } else if (p.data > data) { // ����
                    p = p.right;
                } else {// ���
                    p.isDelete = true; // ����ɾ�����
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * ɾ����ɾ���ڵ��������ڵ��ʱ��ɾ���ڵ�����ӽڵ����С�ڵ㻥����Ȼ��ɾ��
     *
     * @param data
     * @return
     */
    public boolean delete2(int data) {
        if (head == null)
            return false;
        Node p = head;
        Node dNode = null; // Ҫɾ���Ľڵ�
        Node dNodeF = null; // ɾ���ڵ���ӽڵ�
        while (p != null) {
            if (p.data < data) { // ����
                dNodeF = p;
                p = p.left;
            } else if (p.data > data) { // ����
                dNodeF = p;
                p = p.right;
            } else {// ���
                dNode = p;
//                p.isDelete = true; // ����ɾ�����
            }
        }

        if (dNode == null)
            return false;

        if (dNode.left != null && dNode.right != null) { // ɾ���ڵ���������ӽڵ�
            // ��ɾ���ڵ�����ӽڵ���Ѱ�ҵ���С�ڵ�
            Node minNode = dNode.right; // ��С�ڵ�
            Node minNodeF = dNode; //
            while (minNode.left != null) {
                minNodeF = minNode;
                minNode = minNode.left;
            }
            dNode.data = minNode.data; // ɾ���ڵ㻻Ϊ��С�ڵ��ֵ
            dNode = minNode; // ��Ϊɾ����С�ڵ�
            dNodeF = minNodeF;
        }

        Node child = null; // ɾ���ڵ���ӽڵ㣬����������ж�������ɾ���ڵ�ֻ����һ���ӽڵ���
        if (dNode.left != null) child = dNode.left;
        else if (dNode.right != null) child = dNode.right;
        else child = null;

        if (dNodeF == null) { // ɾ���ڵ�û�и��ڵ�
            head = child;
        } else if (dNodeF.left == dNode) { // ɾ���ڵ��Ǹ��ڵ�����ӽڵ�
            dNodeF.left = child;
        } else if (dNodeF.right == dNode) { // ɾ���ڵ��Ǹ��ڵ�����ӽڵ�
            dNodeF.right = child;
        }

        return true;
    }

    /**
     * ǰ���������ǰ�ڵ�->���ӽڵ�->���ӽڵ�
     */
    public void preOrderPrint() {
        preOrderPrint(head);
    }

    /**
     * ǰ���������ǰ�ڵ�->���ӽڵ�->���ӽڵ�
     */
    public void preOrderPrint(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    /**
     * ������������ӽڵ�->��ǰ�ڵ�->���ӽڵ�
     */
    public void centerOrderPrint() {
        centerOrderPrint(head);
    }

    /**
     * ������������ӽڵ�->��ǰ�ڵ�->���ӽڵ�
     */
    public void centerOrderPrint(Node node) {
        if (node == null)
            return;
        centerOrderPrint(node.left);
        System.out.print(node.data + " ");
        centerOrderPrint(node.right);
    }

    /**
     * ������������ӽڵ�->���ӽڵ�->��ǰ�ڵ�
     */
    public void postOrderPrint() {
        postOrderPrint(head);
    }

    /**
     * ������������ӽڵ�->���ӽڵ�->��ǰ�ڵ�
     */
    public void postOrderPrint(Node node) {
        if (node == null)
            return;
        postOrderPrint(node.left);
        postOrderPrint(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * �����ӡ
     */
    public void layerPrint() {
        layerPrint(head);
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
        Queue<Node> currentQueue = new LinkedList<>(); // ��ǰһ��
        Queue<Node> nextQueue = new LinkedList<>(); // ��һ��
        currentQueue.add(node);

        while (!currentQueue.isEmpty()) {
            Node p = currentQueue.poll();
            System.out.print(p.data + " ");
            if (p.left != null)
                nextQueue.add(p.left);
            if (p.right != null)
                nextQueue.add(p.right);

            if (currentQueue.isEmpty()) { // ������һ��
                System.out.println();
                if (!nextQueue.isEmpty()) { // ����һ��Ľڵ��Ϊ��ǰ��ӡ�㣬�����һ��
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }

    }

    /**
     * ��ȡ��ǰ���ĸ߶�
     *
     * @return
     */
    public int getHigh() {
        return getNodeHigh(head);
    }

    /**
     * ��ȡ��ǰ�ڵ�ĸ߶ȣ������ӽڵ����߶ȼ�1��
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
        } else // �������ӽڵ�
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

        System.out.println("���ĸ߶ȣ�" + binarySearchTreeExercise.getHigh());
//        System.out.println("���" + binarySearchTreeExercise.findMax().data + " -- ��С��" + binarySearchTreeExercise.findMin().data);

        int find = (int) (Math.random() * 20);
        Node fNode = binarySearchTreeExercise.search(find);
        System.out.println("���ң�" + find + (fNode != null ? fNode.toString() : "��"));

        int deleteV = (int) (Math.random() * 20);
        binarySearchTreeExercise.delete(deleteV);
        System.out.println("ɾ����" + deleteV);
        binarySearchTreeExercise.layerPrint();
//
        System.out.println("ǰ�����");
        binarySearchTreeExercise.preOrderPrint();
        System.out.println("");

        System.out.println("�������");
        binarySearchTreeExercise.centerOrderPrint();
        System.out.println("");

        System.out.println("�������");
        binarySearchTreeExercise.postOrderPrint();
        System.out.println("");

        System.out.println("�������");
        binarySearchTreeExercise.layerPrint();
    }
}
