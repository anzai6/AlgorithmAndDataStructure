package com.example.lib.course6_linkedlist.finals;

import com.example.lib.Node;

/**
 * 1��������Ĳ��롢ɾ�������Ҳ�����
 * 2�������д洢����int���͵����ݣ�
 * <p>
 * Author��Zheng
 */
public class SinglyLinkedList {

    private Node head = null;
    private Node tail = null;
    private int size;

    public Node findByValue(int value) {
        if (head == null) {
            System.out.println("list is empty");
            return null;
        }

        Node p = head;
        while (p != null) {
            if (p.data == value) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public Node findByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index is invalid");
            return null;
        }
        int i = 0;
        Node p = head;
        while (i < index) {
            p = p.next;
            i++;
        }
        return p;
    }

    //��ͷ���
    //��ͷ������
    //���ֲ������������˳���෴������
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }

    public void insertToHead(Node newNode) {
        if (newNode == null) {
            return;
        }
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    //˳�����
    //����β������
    public void insertTail(int value) {
        Node node = new Node(value, null);
        insertTail(node);
    }

    public void insertTail(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);

    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (newNode == null) {
            return;
        }
        Node node = head;
        while (node != null) {
            if (node.data == p.data) {
                newNode.next = node.next;
                node.next = newNode;
                // ����β�ڵ�
                if (newNode.next == null) {
                    tail = newNode;
                }
                size++;
                return;
            }
            node = node.next;
        }
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (newNode == null) {
            return;
        }
        Node node = head;
        Node preNode = null;
        while (node != null) {
            if (node.data == p.data) {
                newNode.next = node;
                // ����ͷ�ڵ�
                if (preNode == null) {
                    head = newNode;
                } else {
                    preNode.next = newNode;
                }
                size++;
                return;
            }
            preNode = node;
            node = node.next;
        }
    }

    public void deleteByNode(Node p) {
        if (p == null) {
            return;
        }
        deleteByValue(p.data);
    }

    public void deleteByValue(int value) {
        Node node = head;
        Node preNode = null;
        while (node != null) {
            if (node.data == value) {
                // ����ͷ�ڵ�
                if (preNode == null) {
                    head = node.next;
                } else {
                    preNode.next = node.next;
                    // ����β�ڵ�
                    if (preNode.next == null) {
                        tail = preNode;
                    }
                }
                size--;
                return;
            }
            node = node.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //�ж������������true or false
    public boolean TFResult(Node left, Node right) {
        while (left != null && right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        return true;
    }
    //���ж��Ƿ�Ϊ����

    public boolean palindrome() {
        if (size <= 1) {
            return true;
        }
        if (size == 2 || size == 3) {
            return head.data == tail.data;
        }

        Node slow = head;
        Node fastNode = head.next;
        while (fastNode.next != null && fastNode.next.next != null) {
            slow = slow.next;
            fastNode = fastNode.next.next;
        }

        Node newNode = null;
        Node centerNode = null;
        if (fastNode.next != null) { // ��������
            newNode = slow.next.next;
            centerNode = slow.next;
        } else { // ż������
            newNode = slow.next;
        }
        slow.next = null; // �ض�ǰ��벿��
        newNode = inverseLinkList(newNode); // ��벿������ת
        boolean isPalindrome = TFResult(head, newNode); // �ж��Ƿ����
        // ��ԭ����
        newNode = inverseLinkList(newNode); // ��벿�������ٷ�ת����ԭ��
        if (centerNode != null) {
            centerNode.next = newNode;
            newNode = centerNode;
        }
        slow.next = newNode;
        return isPalindrome;
    }

    //����������ת
    public Node inverseLinkList_head(Node p) {
        return p;

    }

    //��ͷ��������ת
    public Node inverseLinkList(Node p) {
        Node newHead = null;
        Node preNode = null;

        while (p != null) {
            preNode = p;
            p = p.next;
            preNode.next = newHead;
            newHead = preNode;
        }

        return newHead;

    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String[] args) {

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        int data[] = {1, 2, 3, 4, 5, 4, 3, 2, 1};
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

        System.out.println("��ӡ����:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("����");
        } else {
            System.out.println("���ǻ���");
        }
    }

}
