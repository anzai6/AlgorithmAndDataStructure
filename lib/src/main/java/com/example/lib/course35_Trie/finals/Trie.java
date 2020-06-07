package com.example.lib.course35_Trie.finals;

/**
 * Trie�����ʺ�ͨ��ǰ׺����ƥ���ַ���������������������Զ���ʾ���ܣ����磺����he ��ʾ hello
 * �������뷨���Զ���ȫ���༭�����Զ���ȫ�ȵȣ���̫�ʺ���ȫƥ����ַ������ң��ķ��ڴ���࣬����ú��������ɢ�б������
 * Created by qinshunan on 2019/4/19.
 */

public class Trie {
    private TrieNode headNode = new TrieNode('/'); // �洢�������ַ�

    /**
     * �� ACAutomata ���в���һ���ַ���
     *
     * @param list
     * @param len
     */
    public void insert(char[] list, int len) {
    }

    /**
     * �� ACAutomata ���в���һ���ַ���
     *
     * @param list
     * @param len
     */
    public boolean find(char[] list, int len) {
        return false;
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
