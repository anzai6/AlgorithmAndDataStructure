package com.leetcode.anzai.subject_61_80;

/**
 * ��Ч����
 * https://leetcode-cn.com/problems/valid-number/
 */
public class Subject65 {

    /**
     *
     ��֤�������ַ����Ƿ���Խ���Ϊʮ�������֡�

     ����:

     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     " -90e3   " => true
     " 1e" => false
     "e3" => false
     " 6e-1" => true
     " 99e2.5 " => false
     "53.5e93" => true
     " --6 " => false
     "-+3" => false
     "95a54e53" => false

     ˵��: �������⽫��������رȽ�ģ������ʵ�ִ���֮ǰ����Ӧ������˼�����п��ܵ�������������һ�ݿ��ܴ�������Чʮ���������е��ַ��б�

     ���� 0-9
     ָ�� - "e"
     ��/���� - "+"/"-"
     С���� - "."
     ��Ȼ���������У���Щ�ַ���������Ҳ����Ҫ��
     *
     */


    /**
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        return false;
    }

    private boolean isNumChar(char value) {
        return value >= '0' && value <= '9';
    }

    public static void main(String[] args) {
        Subject65 subject = new Subject65();
//        "0" => true
//        " 0.1 " => true
//        "abc" => false
//        "1 a" => false
//        "2e10" => true
//        " -90e3   " => true
//        " 1e" => false
//        "e3" => false
//        " 6e-1" => true
//        " 99e2.5 " => false
//        "53.5e93" => true
//        " --6 " => false
//        "-+3" => false
//        "95a54e53" => false
//        "46.e3" => false
//        "005047e+6" => true
        System.out.print(subject.isNumber("46.e3"));
    }

}
