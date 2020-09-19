package com.example.lib.course35_Trie.finals;

/**
 * Trie树：适合通过前缀搜素匹配字符串，类似于搜索引擎的自动提示功能，比如：输入he 提示 hello
 * 还有输入法的自动补全，编辑器的自动补全等等，不太适合完全匹配的字符串查找，耗费内存过多，这个用红黑树或者散列表更合适
 * Created by qinshunan on 2019/4/19.
 */
public class Trie {
    private TrieNode headNode = new TrieNode('/'); // 存储无意义字符

    /**
     * 往 Trie 树中插入一个字符串
     *
     * @param list
     * @param len
     */
    public void insert(char[] list, int len) {
        if (list == null || list.length == 0) {
            System.out.println("list is empty");
            return;
        }
        TrieNode trieNode = headNode;
        for (int i = 0; i < len; i++) {
            int index = list[i] - 'a';
            TrieNode subTrieNode = trieNode.subTrieList[index];
            if (subTrieNode == null) {
                subTrieNode = new TrieNode(list[i]);
                trieNode.subTrieList[index] = subTrieNode;
            }
            trieNode = subTrieNode;
        }
        trieNode.isEndingChar = true;
    }

    /**
     * 在 Trie 树中查找一个字符串
     *
     * @param list
     * @param len
     */
    public boolean find(char[] list, int len) {
        if (list == null || list.length == 0) {
            System.out.println("list is empty");
            return false;
        }
        TrieNode trieNode = headNode;
        for (int i = 0; i < len; i++) {
            int index = list[i] - 'a';
            TrieNode subTrieNode = trieNode.subTrieList[index];
            if (subTrieNode == null) {
                return false;
            }
            trieNode = subTrieNode;
        }
        // 不能完全匹配，只是前缀则会返回false
        return trieNode.isEndingChar;
    }


    class TrieNode {
        char item;
        TrieNode[] subTrieList = new TrieNode[26]; // 这里只定义的是26小写字母的数组，不考虑包含数组中文之类的
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
