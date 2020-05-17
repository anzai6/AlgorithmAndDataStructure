package com.example.lib.course6_linkedlist.my;

/**
 * ������ͷ���ڵ�nextָ����һ���ڵ㣬β���ڵ�nextΪ��
 * <p>
 * ��Ա���������¼�����
 * ����ͷ��������β�������뵽�ڵ�ǰ�棻���뵽�ڵ���棻ɾ���ڵ㣻��ӡ�ڵ�
 * �����������ͨ��ֵ���߽ڵ����
 * Created by qinshunan on 2019/1/31.
 */
public class MySingleLinkedList {


    private Node headNode;

    /**
     * ͨ��ֵ�ҽڵ�
     *
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = headNode;
        while (p != null && p.getData() != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * ͨ���±��ҽڵ�
     *
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = headNode;
        int count = 0;
        while (p != null && count != index) {
            p = p.next;
            ++count;
        }
        return p;
    }

    /**
     * ��ֵ����ͷ���ڵ�
     *
     * @param value
     */
    public void insertHead(int value) {
        insertHead(new Node(value, null));
    }

    /**
     * ���½ڵ����ͷ���ڵ�
     *
     * @param newNode
     */
    public void insertHead(Node newNode) {
        if (headNode != null) {
            newNode.next = headNode;
        } else {
        }
        headNode = newNode;

    }

    /**
     * ��ֵ����β���ڵ�
     *
     * @param value
     */
    public void insertTail(int value) {
        insertTail(new Node(value, null));
    }

    /**
     * ���½ڵ����β���ڵ�
     *
     * @param newNode
     */
    public void insertTail(Node newNode) {
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node p = headNode;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }


    }

    /**
     * ���½ڵ�ڵ����
     *
     * @param value
     */
    public void insertAfter(Node node, int value) {
        insertAfter(node, new Node(value, null));
    }

    /**
     * ���½ڵ�ڵ����
     *
     * @param newNode
     */
    public void insertAfter(Node node, Node newNode) {
        if (node == null || newNode == null) {
            return;
        }

        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * ���½ڵ�ڵ�ǰ��
     *
     * @param value
     */
    public void insertBefore(Node node, int value) {
        insertBefore(node, new Node(value, null));
    }

    /**
     * ���½ڵ�ڵ�ǰ��
     *
     * @param newNode
     */
    public void insertBefore(Node node, Node newNode) {
        if (node == null || newNode == null) {
            return;
        }

        if (node == headNode) {
            insertHead(newNode);
            return;
        }

        Node p = headNode;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p != null) {
            p.next = newNode;
            newNode.next = node;
        }
    }

    /**
     * ͨ��ֵɾ��
     *
     * @param value
     */
    public void deleteByValue(int value) {

        //1.ֻ��ɾ��һ��
        /*if (headNode != null && headNode.data == value) {
            headNode = headNode.next;
            return;
        }

        Node p = headNode;
        Node a = null;
        while (p != null && p.data != value) {
            a = p;
            p = p.next;
        }

        if (p != null)
            a.next = p.next;*/


        //2.�����ظ�ɾ��
        if (headNode != null && headNode.data == value) {
            headNode = headNode.next;
        }

        Node p = headNode;
        while (p != null) {
            if (p.next != null && p.next.getData() == value) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
    }

    /**
     * ͨ���ڵ�ɾ��
     *
     * @param node
     */
    public void deleteByNode(Node node) {

        if (node == null || headNode == null)
            return;

        if (node == headNode) {
            headNode = node.next;
            return;
        }

        Node p = headNode;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p != null)
            p.next = node.next;

    }

    public void printAll() {
        Node p = headNode;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * �ж���������������Ƿ�һ��
     *
     * @param left
     * @param right
     * @return true һ��
     */
    public boolean isContentSame(Node left, Node right) {
        if (left == null || right == null) {
            return false;
        }

        while (left != null && right != null) {
            if (left.data == right.data) {
                left = left.next;
                right = right.next;

                if (left == null && right != null)
                    return false;

                if (right == null && left != null)
                    return false;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * �ж�������ַ��Ƿ�����ַ��������Һʹ��ҵ���һ����
     *
     * @return
     */
    public boolean palindrome() {

        if (headNode == null) {
            return false;
        }
        if (headNode.next == null) {
            return true;
        }

        // �����ÿ���ָ���ҳ��м�ڵ�
        Node p = headNode; // ��ָ��
        Node q = headNode; // ��ָ��

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        System.out.println("�м�ڵ㣺" + p.getData());
        Node leftNode;
        Node rightNode;

        if (q.next == null) { // ������������
            rightNode = p.next;
            leftNode = inverseLinkListFront(p).next;
        } else { // ��������ż��
            rightNode = p.next;
            leftNode = inverseLinkListFront(p);
        }
        return isContentSame(leftNode, rightNode);
    }

    /**
     * �����м�ڵ㷭ת�б��ǰ�沿�֣�����p����,��p���ͷ���ڵ�
     *
     * @param p �м�ڵ�
     * @return ���ط�ת���ͷ���ڵ�
     */
    public Node inverseLinkListFront(Node p) {
        if (p == null || headNode == null) {
            return null;
        }

        Node q = headNode;
        // ��ת���������,
        Node newHodeHead = new Node(headNode.data,null);


        if(p == headNode){
            return newHodeHead;
        }

        // ��q��s��һλ
        if (q.next != null) {
            q = q.next;
        } else {
            return p;
        }

        while (q != p && q.next != null) {
            // ���µ�ǰq
            Node old = new Node(q.data,null);
            // q��ǰ�ƶ�
            q = q.next;
            // ��ǰ�ڵ��nextָ�����������һ���ڵ㣬ע���ǵ�����ģ��൱��ÿ�β���ͷ����
            old.next = newHodeHead;
            newHodeHead = old;
        }

        return new Node(p.data,newHodeHead);
    }

    public static void main(String[] args) {

        MySingleLinkedList link = new MySingleLinkedList();
        System.out.println("hello");
        int data[] = {};
//        int data[] = {1};
//        int data[] = {1,2};
//        int data[] = {1,1};
//        int data[] = {1,2,3,1};
//        int data[] = {1,2,5};
//        int data[] = {1,2,2,1};
//        int data[] = {1, 2, 5, 2, 1};
//        int data[] = {1,2,5,3,1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("��ӡԭʼ:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("����");
        } else {
            System.out.println("���ǻ���");
        }
    }

}
