package com.example.lib.course36_ACAutomata.finals;

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
    // �������дʷֱ��ǣ�c,bc,bcd,abcd;ƥ��������abcfee,��ƥ�䵽d��f����ʹ������c��failָ��ָ���м��Ǹ�c,�ж�c�ǽ����ڵ㣬
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
    public void insert(char[] text) {
    }

    /**
     * ��Trie��Ԥ������ʧ��ָ��
     */
    public void buildFailPoint() {
    }

    /**
     * ƥ�������д��ڵ����д�
     *
     * @param mainText
     */
    public void matchSensitiveWords(char[] mainText) {
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

