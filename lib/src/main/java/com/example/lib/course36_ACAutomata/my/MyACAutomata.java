package com.example.lib.course36_ACAutomata.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC�Զ�����ʵ�����дʲ���,���磺�û�����һ��������Ϊ�����������д�Ԥ�ȹ�����Trie����������ʧ��ָ��fail,
 * Ȼ��ƥ�������д��ڵ����д�
 * AC�Զ��������ڵ�ģʽ��ƥ���㷨KMP�㷨������Ԥ�ȴ����ʧ��ָ�룬KMP����next����
 */
public class MyACAutomata {

    // ��ͼ�����ӣ�
    //             root
    //           /  |   \
    //          a   b    c
    //         /    |
    //        b     c
    //       /      |
    //      c       d
    //     /
    //    d
    // �������дʷֱ��ǣ�c,bc,bcd,abcd;ƥ��������abcfee,��ƥ�䵽d��f����ʹ������c��failָ��ָ���м��Ǹ�c,�ж�c�ǽ����ڵ㣬
    // ���Եó�ƥ��"bc"���дʣ�Ȼ������м�ڵ�c��failָ��ָ�����ұ�c���ж�c�ǽ����ڵ���Եó�ƥ��"c"���д�
    // �����ߵ�d�ڵ㣬��d��ʧ��ָ����Ǵ�root�ߵ�d�γɵ��ַ���abcd��������ģʽ��ǰ׺ƥ������ƥ���׺�Ӵ���
    // �������bcd,��failָ��ָ���Ǹ��ƥ���׺�Ӵ���Ӧ��ģʽ����ǰ׺�����һ���ڵ�,�������м��d�ڵ�
    // �������d�ڵ��failָ��ָ���м�d�ڵ�
    // �������ͬ��ȵĽڵ��㵽ͬһ�㿴������ôĳ���ڵ��ʧ��ָ��ֻ���ܳ����������ڲ����һ��


    private AcNode root = new AcNode('/'); // �洢�������ַ�

    public MyACAutomata() {
        root.fail = null;
    }

    /**
     * �� Trie ���в���һ��ģʽ�������дʣ�������û���ǲ����̬������Ӧ��failָ��
     */
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
     * ��Trie��Ԥ������ʧ��ָ��
     */
    public void buildFailPoint() {
        // һ����װ�ڵ�
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // ȡ��һ�������б�ɾ��
            AcNode p = queue.remove();

            for (int i = 0; i < p.children.length; i++) {
                AcNode pc = p.children[i];
                if (pc == null)
                    continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    // ͨ���ڵ�p��failָ��ָ��Ľڵ�q���ҵ��ڵ�pc��failָ��ָ��Ľڵ�qc
                    AcNode q = p.fail;
                    while (q != null) {
                        // ����ǹؼ�����pc.data == qc.data��qc����pc��failָ��
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) { // qc��Ϊ����qc����pc��failָ��
                            pc.fail = qc;
                            break;
                        }
                        // qcΪ����q����q��failָ�����������ȥ��ֱ��q==null
                        q = q.fail;
                    }

                    if (q == null)
                        pc.fail = root;
                }
                queue.add(pc);
            }
        }
    }

    /**
     * ƥ�������д��ڵ����д�
     *
     * @param mainText
     */
    public void matchSensitiveWords(char[] mainText) {
        int len = mainText.length;
        AcNode p = root;// p�������Ѿ�ƥ�������һ���ַ���Ӧ�ڵ��failָ�룬Ĭ����root
        for (int i = 0; i < len; i++) {
            int index = mainText[i] - 'a';
            while (p.children[index] == null && p != root) {
                p = p.fail;// ʧ��ָ�뷢�����õĵط�
            }
            p = p.children[index];
            if (p == null)
                p = root;
            AcNode tmp = p;
            while (tmp != root) { // ��ӡ������ƥ���ģʽ��
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1; // ����
                    System.out.println(" ƥ����ʼ�±� " + pos + "; ���� " + tmp.length);
                }
                tmp = tmp.fail;
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
        MyACAutomata myACAutomata = new MyACAutomata();
        String c = "c";
        String bc = "bc";
        String bcd = "bcd";
        String abcd = "abcd";
        String mainText = "abcfee";
        myACAutomata.insert(c.toCharArray());
        myACAutomata.insert(bc.toCharArray());
        myACAutomata.insert(bcd.toCharArray());
        myACAutomata.insert(abcd.toCharArray());

        myACAutomata.buildFailPoint();

        myACAutomata.matchSensitiveWords(mainText.toCharArray());

    }

}

