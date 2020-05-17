package com.example.lib.course6_linkedlist.my;

/**
 * 单链表：头部节点next指向下一个节点，尾部节点next为空
 * <p>
 * 成员方法有以下几个：
 * 插入头部；插入尾部；插入到节点前面；插入到节点后面；删除节点；打印节点
 * 分两种情况，通过值或者节点操作
 * Created by qinshunan on 2019/1/31.
 */
public class MySingleLinkedList {


    private Node headNode;

    /**
     * 通过值找节点
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
     * 通过下标找节点
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
     * 把值插入头部节点
     *
     * @param value
     */
    public void insertHead(int value) {
        insertHead(new Node(value, null));
    }

    /**
     * 把新节点插入头部节点
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
     * 把值插入尾部节点
     *
     * @param value
     */
    public void insertTail(int value) {
        insertTail(new Node(value, null));
    }

    /**
     * 把新节点插入尾部节点
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
     * 把新节点节点后面
     *
     * @param value
     */
    public void insertAfter(Node node, int value) {
        insertAfter(node, new Node(value, null));
    }

    /**
     * 把新节点节点后面
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
     * 把新节点节点前面
     *
     * @param value
     */
    public void insertBefore(Node node, int value) {
        insertBefore(node, new Node(value, null));
    }

    /**
     * 把新节点节点前面
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
     * 通过值删除
     *
     * @param value
     */
    public void deleteByValue(int value) {

        //1.只能删除一个
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


        //2.可以重复删除
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
     * 通过节点删除
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
     * 判断两个链表的内容是否一样
     *
     * @param left
     * @param right
     * @return true 一样
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
     * 判断链表的字符是否回文字符（从左到右和从右到左一样）
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

        // 先利用快慢指针找出中间节点
        Node p = headNode; // 慢指针
        Node q = headNode; // 快指针

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        System.out.println("中间节点：" + p.getData());
        Node leftNode;
        Node rightNode;

        if (q.next == null) { // 链表长度是奇数
            rightNode = p.next;
            leftNode = inverseLinkListFront(p).next;
        } else { // 链表长度是偶数
            rightNode = p.next;
            leftNode = inverseLinkListFront(p);
        }
        return isContentSame(leftNode, rightNode);
    }

    /**
     * 根据中间节点翻转列表的前面部分（包括p自身）,即p变成头部节点
     *
     * @param p 中间节点
     * @return 返回翻转后的头部节点
     */
    public Node inverseLinkListFront(Node p) {
        if (p == null || headNode == null) {
            return null;
        }

        Node q = headNode;
        // 翻转后的新链表,
        Node newHodeHead = new Node(headNode.data,null);


        if(p == headNode){
            return newHodeHead;
        }

        // 让q比s快一位
        if (q.next != null) {
            q = q.next;
        } else {
            return p;
        }

        while (q != p && q.next != null) {
            // 存下当前q
            Node old = new Node(q.data,null);
            // q往前移动
            q = q.next;
            // 当前节点的next指向新链表的下一个节点，注意是当倒叙的，相当如每次插入头部。
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

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }

}
