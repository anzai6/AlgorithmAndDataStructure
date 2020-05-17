package com.example.lib.course60_exercise.string;

/**
 * 实现一个字符集，只包含 a～z 这 26 个英文字母的 Trie 树
 */
public class TrieExercise {

    private Node head;

    public TrieExercise() {
        head = new Node('#'); // 根节点存储无意义字符
    }

    /**
     * 插入Trie树
     *
     * @param data
     */
    public void insert(String data) {
        if (data == null || data.length() == 0)
            return;
        char[] chars = data.toLowerCase().toCharArray();
        Node p = head;
        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            int index = value - 'a'; // 求出下标
            Node[] list = p.list;
            Node node = list[index];
            if (node == null) { // 不存在就插入
                node = new Node(value);
                list[index] = node;
            }
            p = node;
        }
        p.isEnd = true; // 结束
    }

    /**
     * Trie树查找
     *
     * @param data
     * @return
     */
    public boolean find(String data) {
        if (data == null || data.length() == 0)
            return false;
        char[] chars = data.toLowerCase().toCharArray();
        Node p = head;
        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            int index = value - 'a'; // 求出下标
            Node[] list = p.list;
            Node node = list[index];
            if (node != null && node.value == value) { // 存在匹配字符
                p = node;
            } else { // 不能存在
                return false;
            }

        }
        return p.isEnd; // 结束
    }

    static class Node {
        Node[] list = new Node[26]; // 26个字母
        char value;
        boolean isEnd;

        public Node(char value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        TrieExercise trieExercise = new TrieExercise();
        trieExercise.insert("Hello");
        trieExercise.insert("hi");
        trieExercise.insert("help");
        System.out.println(trieExercise.find("help"));
    }
}
