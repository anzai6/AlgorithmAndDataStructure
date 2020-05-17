package com.example.lib.course36_ACAutomata.teacher;

import java.util.LinkedList;
import java.util.Queue;

// AC�Զ�����ʵ�����дʲ���
public class ACAutomata {
    private AcNode root = new AcNode('/'); // �洢�������ַ�

    // �� ACAutomata ���в���һ���ַ���
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
     * ƥ�����д�
     *
     * @param text
     */
    public void match(char[] text) { // text ������
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // ʧ��ָ�뷢�����õĵط�
            }
            p = p.children[idx];
            if (p == null) p = root; // ���û��ƥ��ģ��� root ��ʼ����ƥ��
            AcNode tmp = p;
            while (tmp != root) { // ��ӡ������ƥ���ģʽ��
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1;
                    System.out.println(" ƥ����ʼ�±� " + pos + "; ���� " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }

    /**
     * ����failָ��
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
        public AcNode[] children = new AcNode[26]; // �ַ���ֻ���� a~z �� 26 ���ַ�
        public boolean isEndingChar = false; // ��β�ַ�Ϊ true
        public int length = -1; // �� isEndingChar=true ʱ����¼ģʽ������
        public AcNode fail; // ʧ��ָ��

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

