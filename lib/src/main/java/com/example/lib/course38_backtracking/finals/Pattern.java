package com.example.lib.course38_backtracking.finals;

/**
 * �򵥵�������ʽ�����㷨
 * �����������ʽ��ֻ������"?"��"*"
 * ? ָӵ��һ������������ַ�
 * * ָӵ��һ����������ַ�
 * Created by qinshunan on 2019/5/7.
 */
public class Pattern {

    private char[] patternList;
    private int patternLen;
    private int textLen;
    private boolean isMatch = false; // �Ƿ�ƥ��

    public Pattern(String pattern) {
    }

    public boolean match(String text) {
        return false;
    }

    /**
     * @param textList        �ı��ַ�����
     * @param textMatchLen    �ı��ַ�������Ҫƥ����ַ�λ��
     * @param patternMatchLen ������ʽ�ַ�������Ҫƥ����ַ�λ��
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {
    }

    public static void main(String[] args) {
        Pattern myPattern = new Pattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
    }
}
