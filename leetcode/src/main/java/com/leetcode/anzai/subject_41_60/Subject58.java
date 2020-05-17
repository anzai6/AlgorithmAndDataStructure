package com.leetcode.anzai.subject_41_60;

/**
 * ���һ�����ʵĳ���
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Subject58 {

    /**
     *
     ����һ����������Сд��ĸ�Ϳո�?' '?���ַ��������������һ�����ʵĳ��ȡ�

     ������������һ�����ʣ��뷵�� 0?��

     ˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����

     ʾ��:

     ����: "Hello World"
     ���: 5
     *
     */

    /**
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {

        if (s == null) {
            return 0;
        }
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int charV = s.charAt(i);
            if (charV == ' ') {
                if (len == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "a ";
//        String s = "Hello World";
        Subject58 subject = new Subject58();
        System.out.println(subject.lengthOfLastWord(s));
    }

}
