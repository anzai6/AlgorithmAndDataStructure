package com.example.lib.course23_tree.finals;

/**
 * ��������������ӽڵ�С�ڸ��ڵ㣬���ӽڵ���ڸ��ڵ㣬����ڵ㲻ͬ
 * ���룬���ң�ɾ��������󣬲���С
 * Created by qinshunan on 2019/3/28.
 */

public class BinarySearchTree {

    // �����ڵ�
    private Node tree;

    /**
     * ����
     *
     * @param value
     */
    public void insert(int value) {
    }

    /**
     * ����
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        return null;
    }

    /**
     * ɾ���ڵ�
     *
     * @return
     */
    public boolean delete(int value) {
        return true;
    }

    /**
     * �������
     *
     * @return
     */
    public Node findMax() {
        return null;
    }

    /**
     * ������С
     *
     * @return
     */
    public Node findMin() {
        return null;
    }

    public void preOrderPrint() {
    }

    /**
     * ǰ���������ǰ�ڵ�->���ӽڵ�->���ӽڵ�
     *
     * @param node
     */
    public void preOrderPrint(Node node) {
    }

    public void centerOrderPrint() {
    }

    /**
     * ������������ӽڵ�->��ǰ�ڵ�->���ӽڵ�
     * ���൱��˳�����
     * @param node
     */
    public void centerOrderPrint(Node node) {
    }

    public void postOrderPrint() {
    }

    /**
     * ������������ӽڵ�->���ӽڵ�->��ǰ�ڵ�
     *
     * @param node
     */
    public void postOrderPrint(Node node) {
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
    }

    /**
     * ��ȡ��ǰ���ĸ߶ȣ�������һ��
     * �ݹ鹫ʽ ��ǰ�ڵ�߶� = �ӽڵ�߶� + 1��
     *
     * @return
     */
    public int getHigh() {
        return 1;
    }

    /**
     * ��ȡ�ڵ�߶�(���������ڵ�����ֵ��һ)
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
