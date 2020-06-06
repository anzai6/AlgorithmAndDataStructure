package com.example.lib.course36_ACAutomata.finals;

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
    // 加入敏感词分别是：c,bc,bcd,abcd;匹配主串是abcfee,则当匹配到d和f不等使，根据c的fail指针指向中间那个c,判断c是结束节点，
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
    public void insert(char[] text) {
    }

    /**
     * 对Trie树预处理构建失败指针
     */
    public void buildFailPoint() {
    }

    /**
     * 匹配主串中存在的敏感词
     *
     * @param mainText
     */
    public void matchSensitiveWords(char[] mainText) {
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

