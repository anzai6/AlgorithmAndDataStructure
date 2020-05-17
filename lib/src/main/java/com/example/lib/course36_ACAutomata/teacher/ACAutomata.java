package com.example.lib.course36_ACAutomata.teacher;

import java.util.LinkedList;
import java.util.Queue;

// AC自动机，实现敏感词查找
public class ACAutomata {
    private AcNode root = new AcNode('/'); // 存储无意义字符

    // 往 ACAutomata 树中插入一个字符串
    public void insert(char[] text) {
        AcNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                AcNode newNode = new AcNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
        p.length = text.length;
    }

    /**
     * 匹配敏感词
     *
     * @param text
     */
    public void match(char[] text) { // text 是主串
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }
            p = p.children[idx];
            if (p == null) p = root; // 如果没有匹配的，从 root 开始重新匹配
            AcNode tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1;
                    System.out.println(" 匹配起始下标 " + pos + "; 长度 " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }

    /**
     * 构建fail指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }


    public class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含 a~z 这 26 个字符
        public boolean isEndingChar = false; // 结尾字符为 true
        public int length = -1; // 当 isEndingChar=true 时，记录模式串长度
        public AcNode fail; // 失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ACAutomata acAutomata = new ACAutomata();
        String c = "c";
        String bc = "bc";
        String bcd = "bcd";
        String abcd = "abcd";
        String mainText = "abcfee";
        acAutomata.insert(c.toCharArray());
        acAutomata.insert(bc.toCharArray());
        acAutomata.insert(bcd.toCharArray());
        acAutomata.insert(abcd.toCharArray());

        acAutomata.buildFailurePointer();

        acAutomata.match(mainText.toCharArray());
    }
}

