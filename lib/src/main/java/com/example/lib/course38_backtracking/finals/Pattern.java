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
        if (pattern == null) {
            throw new IllegalArgumentException("pattern is invalid");
        }
        patternList = pattern.toCharArray();
        patternLen = patternList.length;
    }

    public boolean match(String text) {
        if (text == null) {
            return false;
        }
        textLen = text.length();
        match(text.toCharArray(), 0, 0);

        return isMatch;
    }

    /**
     * @param textList        �ı��ַ�����
     * @param textMatchLen    �ı��ַ�������Ҫƥ����ַ�λ��
     * @param patternMatchLen ������ʽ�ַ�������Ҫƥ����ַ�λ��
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {
        if (isMatch) {
            return;
        }
        if (patternMatchLen == patternLen) { // ȫ��ƥ����
            if (textMatchLen == textLen) // ����������ص㣬ֻ�е�������ı���ƥ����ɲ���ƥ��ɹ�
                isMatch = true;
            return;
        }

        char pChar = patternList[patternMatchLen];
        if ('?' == pChar) { // ָӵ��һ������������ַ�
            // ӵ��һ��
            match(textList, textMatchLen + 1, patternMatchLen + 1);
            // ӵ�����
            match(textList, textMatchLen, patternMatchLen + 1);
        } else if ('*' == pChar) { // ָӵ��һ����������ַ�
            // ӵ�����
            match(textList, textMatchLen, patternMatchLen + 1);
            // ӵ�������
            match(textList, textMatchLen + 1, patternMatchLen);
        } else { // ����ƥ��
            if (textMatchLen < textLen && textList[textMatchLen] == pChar) {
                match(textList, textMatchLen + 1, patternMatchLen + 1);
            }
        }

    }

    public static void main(String[] args) {
        Pattern myPattern = new Pattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
        //
    }
}
