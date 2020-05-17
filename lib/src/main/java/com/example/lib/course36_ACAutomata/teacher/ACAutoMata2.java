package com.example.lib.course36_ACAutomata.teacher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author wayne
 */
public class ACAutoMata2 {
    private ACNode root;

    public ACAutoMata2() {
        this.root = new ACNode("/");
    }

    private void insert(String pattern) {
        ACNode node = this.root;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            String c = pattern.charAt(i) + "";
            if (Objects.isNull(node.children.get(c))) {
                node.children.put(c, new ACNode(c));
            }
            node = node.children.get(c);
        }

        node.isEndingChar = true;
        node.length = pattern.length();
    }

    private void buildFailurePointer() {
        ACNode root = this.root;
        LinkedList<ACNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ACNode p = queue.pop();

            for (ACNode pc : p.children.values()) {
                if (Objects.isNull(pc)) {
                    continue;
                }

                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = p.fail;
                    while (Objects.nonNull(q)) {
                        ACNode qc = q.children.get(pc.data);
                        if (Objects.nonNull(qc)) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (Objects.isNull(q)) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    private Boolean match(String text) {
        ACNode root = this.root;
        ACNode p = root;

        int n = text.length();
        for (int i = 0; i < n; i++) {
            String c = text.charAt(i) + "";
            while (Objects.isNull(p.children.get(c)) && p != root) {
                p = p.fail;
            }

            p = p.children.get(c);
            if (Objects.isNull(p)) {
                p = root;
            }

            ACNode tmp = p;
            while (tmp != root) {
                if (tmp.isEndingChar == true) {
                    System.out.println("Start from " + (i - p.length + 1));
                    return true;
                }
                tmp = tmp.fail;
            }
        }

        return false;
    }

    public static boolean match(String text, String[] patterns) {
        ACAutoMata2 automata = new ACAutoMata2();
        for (String pattern : patterns) {
            automata.insert(pattern);
        }

        automata.buildFailurePointer();
        return automata.match(text);
    }

    public class ACNode {
        private String data;
        private Map<String, ACNode> children;
        private Boolean isEndingChar;
        private Integer length;
        private ACNode fail;

        public ACNode(String data) {
            this.data = data;
            this.children = new HashMap<>();
            this.isEndingChar = false;
            this.length = 0;
            this.fail = null;
        }
    }

    public static void main(String[] args) {
        String[] patterns = {"at", "art", "oars", "soar"};
        String text = "soarsoars";
        System.out.println(match(text, patterns));

        String[] patterns2 = {"Fxtec Pro1", "�ȸ�Pixel"};

        String text2 = "һ���ܲ�λ���׶صĹ�˾Fxtex��MWC�Ͼ��Ƴ���һ����ΪFxtec Pro1���ֻ����û�����������ǲ����˲໬ʽȫ������ơ�DxOMark����ܰ񷢲� ��ΪP20 Pro/�ȸ�Pixel 3����";
        System.out.println(match(text2, patterns2));
    }
}
