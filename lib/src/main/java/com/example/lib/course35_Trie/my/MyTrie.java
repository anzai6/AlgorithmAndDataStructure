package com.example.lib.course35_Trie.my;

/**
 * Trie�����ʺ�ͨ��ǰ׺����ƥ���ַ���������������������Զ���ʾ���ܣ����磺����he ��ʾ hello
 * �������뷨���Զ���ȫ���༭�����Զ���ȫ�ȵȣ���̫�ʺ���ȫƥ����ַ������ң��ķ��ڴ���࣬����ú��������ɢ�б������
 * Created by qinshunan on 2019/4/19.
 */

public class MyTrie {
    private TrieNode headNode = new TrieNode('/'); // �洢�������ַ�

    /**
     * �� ACAutomata ���в���һ���ַ���
     *
     * @param list
     * @param len
     */
    public void insert(char[] list, int len) {
        TrieNode[] subTrieList = headNode.subTrieList;
        for (int i = 0; i < len; i++) {
            char item = list[i];
            int index = item - 'a';
            TrieNode trieNode = subTrieList[index];
            if (trieNode == null) {
                trieNode = new TrieNode(item);
                subTrieList[index] = trieNode;
            }
            if (i == len - 1)
                trieNode.isEndingChar = true;
            subTrieList = trieNode.subTrieList;
        }
    }

    /**
     * �� ACAutomata ���в���һ���ַ���
     *
     * @param list
     * @param len
     */
    public boolean find(char[] list, int len) {
        TrieNode root = headNode;
        for (int i = 0; i < len; i++) {
            char item = list[i];
            int index = item - 'a';
            TrieNode trieNode = root.subTrieList[index];
            if (trieNode != null && trieNode.item == item) { // ƥ�䵽��ͬ�ַ�
                root = trieNode;
                continue;
            } else {
                return false; // ��ƥ��
            }
        }
        if (root.isEndingChar) { // ��ȫƥ��
            return true;
        } else { // ����ƥ��,����ǰ׺ƥ��
            return false;
        }
    }


    class TrieNode {
        char item;
        TrieNode[] subTrieList = new TrieNode[26]; // ����ֻ�������26Сд��ĸ�����飬�����ǰ�����������֮���
        boolean isEndingChar = false;

        public TrieNode() {
        }

        public TrieNode(char item) {
            this.item = item;
        }

        public TrieNode(char item, boolean isEndingChar) {
            this.item = item;
            this.isEndingChar = isEndingChar;
        }
    }
}
