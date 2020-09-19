package com.example.lib.course36_ACAutomata.finals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC�Զ�����ʵ�����дʲ���,���磺�û�����һ��������Ϊ�����������д�Ԥ�ȹ�����Trie����������ʧ��ָ��fail,
 * Ȼ��ƥ�������д��ڵ����д�
 * AC�Զ��������ڵ�ģʽ��ƥ���㷨KMP�㷨������Ԥ�ȴ����ʧ��ָ�룬KMP����next����
 */
public class ACAutomata {

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
    // �������дʷֱ��ǣ�c,bc,bcd,abcd;ƥ��������abcfee,��ƥ�䵽d��f����ʱ������c��failָ��ָ���м��Ǹ�c,�ж�c�ǽ����ڵ㣬
    // ���Եó�ƥ��"bc"���дʣ�Ȼ������м�ڵ�c��failָ��ָ�����ұ�c���ж�c�ǽ����ڵ���Եó�ƥ��"c"���д�
    // �����ߵ�d�ڵ㣬��d��ʧ��ָ����Ǵ�root�ߵ�d�γɵ��ַ���abcd��������ģʽ��ǰ׺ƥ������ƥ���׺�Ӵ���
    // �������bcd,��failָ��ָ���Ǹ��ƥ���׺�Ӵ���Ӧ��ģʽ����ǰ׺�����һ���ڵ�,�������м��d�ڵ�
    // �������d�ڵ��failָ��ָ���м�d�ڵ�
    // �������ͬ��ȵĽڵ��㵽ͬһ�㿴������ôĳ���ڵ��ʧ��ָ��ֻ���ܳ����������ڲ����һ��


    private AcNode root = new AcNode('/'); // �洢�������ַ�

    public ACAutomata() {
        root.fail = null;
    }

    /**
     * �� Trie ���в���һ��ģʽ�������дʣ�������û���ǲ����̬������Ӧ��failָ��
     */
    public void insert(char[] list) {
        if (list == null || list.length == 0) {
            System.out.println("list is empty");
            return;
        }
        AcNode acNode = root;
        for (int i = 0; i < list.length; i++) {
            int index = list[i] - 'a';
            AcNode subAcNode = acNode.children[index];
            if (subAcNode == null) {
                subAcNode = new AcNode(list[i]);
                acNode.children[index] = subAcNode;
            }
            acNode = subAcNode;
        }
        acNode.isEndingChar = true;
        acNode.length = list.length;
    }

    /**
     * ��Trie��Ԥ������ʧ��ָ�룬���������һ��һ��Ĺ���
     */
    public void buildFailPoint() {
        if (root.children == null) {
            System.out.println("data is empty");
            return;
        }
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
        if (mainText == null || mainText.length == 0) {
            System.out.println("mainText is empty");
            return;
        }

        AcNode acNode = root; // acNode�������Ѿ�ƥ�������һ���ַ���Ӧ�ڵ��failָ�룬Ĭ����root
        for (int i = 0; i < mainText.length; i++) {
            int index = mainText[i] - 'a';
            AcNode subTrieNode = acNode.children[index];

            if (subTrieNode == null) { // ��ƥ�䣬ͨ��ʧ��ָ���ҵ�ƥ��Ļ��߻ص�root
                AcNode failNode = acNode.fail;
                while (failNode != null && failNode.children[index] == null) {
                    failNode = failNode.fail;
                }
                if (failNode == null) { // û�з��ϵ�ʧ��ָ�룬�ص�root
                    subTrieNode = root;
                } else {
                    subTrieNode = failNode.children[index];
                }
            }

            AcNode tmp = subTrieNode;
            while (tmp != root) { // �ҳ����п�ƥ���ʧ��ָ��
                if (tmp.isEndingChar) { // ��β�ַ������ƥ����
                    int startIndex = i - tmp.length + 1;
                    System.out.println("ƥ����ʼ�±�" + startIndex + "; ���� " + tmp.length);
                }
                tmp = tmp.fail;
            }
            acNode = subTrieNode;
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
        ACAutomata myACAutomata = new ACAutomata();
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

