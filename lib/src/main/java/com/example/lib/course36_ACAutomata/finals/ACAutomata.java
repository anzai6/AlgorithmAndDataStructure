package com.example.lib.course36_ACAutomata.finals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC自动机，实现敏感词查找,例如：用户输入一段文字作为主串，将敏感词预先构建成Trie树并构建好失败指针fail,
 * 然后匹配主串中存在的敏感词
 * AC自动机类似于单模式串匹配算法KMP算法，都是预先处理好失败指针，KMP的是next数组
 */
public class ACAutomata {

    // 下图作例子：
    //             root
    //           /  |   \
    //          a   b    c
    //         /    |
    //        b     c
    //       /      |
    //      c       d
    //     /
    //    d
    // 加入敏感词分别是：c,bc,bcd,abcd;匹配主串是abcfee,则当匹配到d和f不等时，根据c的fail指针指向中间那个c,判断c是结束节点，
    // 可以得出匹配"bc"敏感词，然后继续中间节点c的fail指针指向右右边c，判断c是结束节点可以得出匹配"c"敏感词
    // 假设走到d节点，则d的失败指针就是从root走到d形成的字符串abcd，跟所有模式串前缀匹配的最长可匹配后缀子串，
    // 这里就是bcd,而fail指针指向那个最长匹配后缀子串对应的模式串的前缀的最后一个节点,这里是中间的d节点
    // 所以左边d节点的fail指针指向中间d节点
    // 如果把相同深度的节点算到同一层看待，那么某个节点的失败指针只可能出现在他所在层的上一层


    private AcNode root = new AcNode('/'); // 存储无意义字符

    public ACAutomata() {
        root.fail = null;
    }

    /**
     * 往 Trie 树中插入一个模式串（敏感词），这里没考虑插入后动态更新相应的fail指针
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
     * 对Trie树预处理构建失败指针，按层遍历，一层一层的构建
     */
    public void buildFailPoint() {
        if (root.children == null) {
            System.out.println("data is empty");
            return;
        }
        // 一层层的装节点
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 取第一个并从列表删掉
            AcNode p = queue.remove();

            for (int i = 0; i < p.children.length; i++) {
                AcNode pc = p.children[i];
                if (pc == null)
                    continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    // 通过节点p的fail指针指向的节点q，找到节点pc的fail指针指向的节点qc
                    AcNode q = p.fail;
                    while (q != null) {
                        // 这个是关键，即pc.data == qc.data则qc就是pc的fail指针
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) { // qc不为空则qc就是pc的fail指针
                            pc.fail = qc;
                            break;
                        }
                        // qc为空则q等于q的fail指针继续遍历下去，直到q==null
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
     * 匹配主串中存在的敏感词
     *
     * @param mainText
     */
    public void matchSensitiveWords(char[] mainText) {
        if (mainText == null || mainText.length == 0) {
            System.out.println("mainText is empty");
            return;
        }

        AcNode acNode = root; // acNode代表着已经匹配过的上一个字符对应节点的fail指针，默认是root
        for (int i = 0; i < mainText.length; i++) {
            int index = mainText[i] - 'a';
            AcNode subTrieNode = acNode.children[index];

            if (subTrieNode == null) { // 不匹配，通过失败指针找到匹配的或者回到root
                AcNode failNode = acNode.fail;
                while (failNode != null && failNode.children[index] == null) {
                    failNode = failNode.fail;
                }
                if (failNode == null) { // 没有符合的失败指针，回到root
                    subTrieNode = root;
                } else {
                    subTrieNode = failNode.children[index];
                }
            }

            AcNode tmp = subTrieNode;
            while (tmp != root) { // 找出所有可匹配的失败指针
                if (tmp.isEndingChar) { // 结尾字符，输出匹配结果
                    int startIndex = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + startIndex + "; 长度 " + tmp.length);
                }
                tmp = tmp.fail;
            }
            acNode = subTrieNode;
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

