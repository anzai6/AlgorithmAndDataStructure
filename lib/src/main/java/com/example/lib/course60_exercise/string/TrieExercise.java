package com.example.lib.course60_exercise.string;

/**
 * ʵ��һ���ַ�����ֻ���� a��z �� 26 ��Ӣ����ĸ�� Trie ��
 */
public class TrieExercise {

    private Node head;

    public TrieExercise() {
        head = new Node('#'); // ���ڵ�洢�������ַ�
    }

    /**
     * ����Trie��
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
            int index = value - 'a'; // ����±�
            Node[] list = p.list;
            Node node = list[index];
            if (node == null) { // �����ھͲ���
                node = new Node(value);
                list[index] = node;
            }
            p = node;
        }
        p.isEnd = true; // ����
    }

    /**
     * Trie������
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
            int index = value - 'a'; // ����±�
            Node[] list = p.list;
            Node node = list[index];
            if (node != null && node.value == value) { // ����ƥ���ַ�
                p = node;
            } else { // ���ܴ���
                return false;
            }

        }
        return p.isEnd; // ����
    }

    static class Node {
        Node[] list = new Node[26]; // 26����ĸ
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
