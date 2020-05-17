package com.leetcode.anzai.subject_21_40;

/**
 * ����
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class Subject38 {

    /**
     *
     ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     6.     312211
     7.     13112221
     1?������??"one 1"??("һ��һ") , ��?11��
     11 ������?"two 1s"?("����һ"��, ��?21��
     21 ������?"one 2", ?"one 1"?��"һ����"?,??"һ��һ")?, ��?1211��

     ����һ�������� n��1 ��?n?�� 30��������������еĵ� n �

     ע�⣺����˳�򽫱�ʾΪһ���ַ�����

     ?

     ʾ��?1:

     ����: 1
     ���: "1"
     ʾ�� 2:

     ����: 4
     ���: "1211"
     *
     */

    /**
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        return countAndSayInternal(1, n, "1");
    }

    /**
     * ���� countAndSayInternal(1, n, "1");
     *
     * @param i     �Ѿ�ִ���˵� i ��
     * @param n     һ��Ҫִ�ж�����
     * @param value �Ѿ�ִ���˵� i �������
     * @return
     */
    private String countAndSayInternal(int i, int n, String value) {
        if (i >= n)
            return value;

        StringBuilder sb = new StringBuilder();
        char lastChar = value.charAt(0);
        int count = 1;
        for (int j = 1; j < value.length(); j++) {
            char currentChar = value.charAt(j);
            if (lastChar == currentChar) {
                count++;
            } else {
                sb.append(count).append(lastChar);
                lastChar = currentChar;
                count = 1;
            }
        }
        sb.append(count).append(lastChar);

        return countAndSayInternal(i + 1, n, sb.toString());
    }

    public static void main(String[] args) {
        Subject38 subject = new Subject38();
        System.out.println(subject.countAndSay(7));
    }

}
