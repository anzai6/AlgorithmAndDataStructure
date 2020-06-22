package com.example.lib.course17_skiplist.finals;

import java.util.Random;

/**
 * 我的跳表实现，跟老师的略有不同
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 * <p>
 * Author：ZHENG
 */
public class MySkipList {

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表

    private Random r = new Random();

    /**
     * 跳表查找
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        // 1.从上往下一层层的遍历
        Node p = head;
        for (int i = levelCount; i >= 0; i--) {
            // 遍历当前一层
            while (p.forwards[i] != null) {
                if (p.forwards[i].data < value) { // 小于,继续往后寻找
                    p = p.forwards[i];
                } else if (p.forwards[i].data == value) {  // 等于，找到了，直接返回
                    return p.forwards[i];
                } else { // 大于，结束这一层遍历，往下一层
                    break;
                }
            }
        }
        return null;
    }

    /**
     * 跳表插入
     *
     * @param value
     */
    public void insert(int value) {
        // 准备新节点的数据
        Node newNode = new Node();
        newNode.data = value;
        int maxLevel = randomLevel();
        newNode.maxLevel = maxLevel;
        if (maxLevel > levelCount) {
            levelCount = maxLevel;
        }

        // 建立新节点的跳表索引
        // 1.从上往下一层层的遍历，然后处理newNode的索引
        Node pre = head;
        for (int i = levelCount; i >= 0; i--) {
            // 遍历当前一层可以插入 newNode 的前驱索引
            while (pre.forwards[i] != null && pre.forwards[i].data < value) {
                pre = pre.forwards[i];
            }
            // 落在 newNode 的索引层内时，处理 newNode 的索引，否则遍历下一层
            if (i <= maxLevel) {
                if (pre.forwards[i] == null) { // 新节点处于索引的最后位置
                    pre.forwards[i] = newNode;
                } else { // 插入 newNode 索引
                    newNode.forwards[i] = pre.forwards[i].forwards[i];
                    pre.forwards[i] = newNode;
                }
            }
        }
    }

    /**
     * 跳表删除
     *
     * @param value
     */
    public void delete(int value) {
        // 1.从上往下一层层的遍历
        Node pre = head;
        for (int i = levelCount; i >= 0; i--) {
            // 遍历当前一层
            while (pre.forwards[i] != null) {
                if (pre.forwards[i].data < value) { // 小于,继续往后寻找
                    pre = pre.forwards[i];
                } else if (pre.forwards[i].data == value) {  //等于，找到了，替换索引，结束这一层遍历，往下一层
                    pre.forwards[i] = pre.forwards[i].forwards[i];
                    break;
                } else { // 大于，结束这一层遍历，往下一层
                    break;
                }
            }
        }
    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        // 根据 maxLevel 层数，指向下一个索引
        private Node forwards[] = new Node[MAX_LEVEL];
        // 当前节点在跳表中的索引的层数
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        MySkipList skipList = new MySkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(15);
        skipList.printAll();
        System.out.println("查找 15 ： " + skipList.find(15));
        System.out.println("查找 4 ： " + skipList.find(4));
        System.out.println("查找 3 ： " + skipList.find(3));
        System.out.println("查找 2 ： " + skipList.find(2));
        System.out.println("查找 1 ： " + skipList.find(1));

        System.out.println("删除 2 ： ");
        skipList.delete(2);
        skipList.printAll();
        System.out.println("删除 3 ： ");
        skipList.delete(3);
        skipList.printAll();
    }

}
