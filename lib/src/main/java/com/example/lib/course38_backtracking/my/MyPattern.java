package com.example.lib.course38_backtracking.my;

/**
 * �򵥵�������ʽ�����㷨
 * �����������ʽ��ֻ������"?"��"*"
 * ? ָӵ��һ������������ַ�
 * * ָӵ��һ����������ַ�
 * Created by qinshunan on 2019/5/7.
 */
public class MyPattern {

    private char[] patternList;
    private int patternLen;
    private int textLen;
    private boolean isMatch = false; // �Ƿ�ƥ��

    public MyPattern(String pattern) {
        this.patternList = pattern.toCharArray();
        patternLen = pattern.length();
    }

    public boolean match(String text) {
        textLen = text.length();
        isMatch = false;
        match(text.toCharArray(), 0, 0);
        return isMatch;
    }

    /**
     * @param textList        �ı��ַ�����
     * @param textMatchLen    �ı��ַ�������Ҫƥ����ַ�λ��
     * @param patternMatchLen ������ʽ�ַ�������Ҫƥ����ַ�λ��
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {

        if (isMatch)// �Ѿ�ƥ��ɹ�
            return;

        if (patternMatchLen == patternLen) { // ȫ��ƥ����
            if (textMatchLen == textLen) // ����������ص㣬ֻ�е�������ı���ƥ����ɲ���ƥ��ɹ�
                isMatch = true;
            return;
        }

        if (textMatchLen >= textLen) // �ı��Ѿ�ƥ����
            return;

        char patternChar = patternList[patternMatchLen];
        if ('?' == patternChar) { // ƥ��?
            match(textList, textMatchLen + 1, patternMatchLen + 1); // һ��
            match(textList, textMatchLen, patternMatchLen + 1); // 0��
        } else if ('*' == patternChar) { // ƥ��*
            for (int i = 0; i < textLen; i++) {
                match(textList, textMatchLen + i, patternMatchLen); // �����
            }
        } else {
            char textChar = textList[textMatchLen];
            if (textChar == patternChar) { // ��ͬ�ַ�ƥ��
                match(textList, textMatchLen + 1, patternMatchLen + 1); // ��һ��
            } else { // ��ƥ��
            }
        }
    }

    public static void main(String[] args) {
        MyPattern myPattern = new MyPattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
    }
}
