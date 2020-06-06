package com.example.lib.course32_stringmatch.finals;

import java.util.HashMap;
import java.util.Map;

/**
 * �ַ���ƥ���㷨��BF�㷨��Brute Force����ƥ���㷨����RK�㷨
 * Created by qinshunan on 2019/4/12.
 */

public class StringMatch {

    public static Map<String, Integer> dict = new HashMap<>();

    static {
        dict.put("a", 0);
        dict.put("b", 1);
        dict.put("c", 2);
        dict.put("d", 3);
        dict.put("e", 4);
        dict.put("f", 5);
        dict.put("g", 6);
        dict.put("h", 7);
        dict.put("i", 8);
        dict.put("j", 9);
        dict.put("k", 10);
        dict.put("l", 11);
        dict.put("m", 12);
        dict.put("n", 13);
        dict.put("o", 14);
        dict.put("p", 15);
        dict.put("q", 16);
        dict.put("r", 17);
        dict.put("s", 18);
        dict.put("t", 19);
        dict.put("u", 20);
        dict.put("v", 21);
        dict.put("w", 22);
        dict.put("s", 23);
        dict.put("y", 24);
        dict.put("z", 25);
    }

    /**
     * BF�㷨��Brute Force����ƥ���㷨�������ص��ַ���ƥ���㷨
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return
     */
    public int BF(String mainStr, String matchStr) {
        return -1;
    }

    /**
     * Rk�㷨������Hash��BF�㷨�����棩
     * ����涨ƥ�����a~z��26����ĸ��hash�㷨���ȸ�26��ĸ����26����������dict
     * Ȼ��������ʮ���Ƶļ��㹫ʽ����һ���ַ���hash��"abc" = 26^2*0+26^1*1+26^0*2
     * �ȱ����������������Ӵ���hashֵ��Ȼ���ģʽ����hashֵ�Ƚ�
     * ���hash�㷨���ڳ�ͻ������hash��ͬʱ�ȶ��Ӵ���ģʽ�����ַ������ж�
     * ֻҪhash���õ���Ժ�����ʱ�����ҳ�ͻ���������£�RK��������BF����Ϊ�����������ַ���֮ǰ�ıȶ�,����hash������֮ǰ�ıȶԣ��ٶȽϿ죩
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return
     */
    public int Rk(String mainStr, String matchStr) {
        return -1;
    }

    public static void main(String[] args) {
        StringMatch myStringMatch = new StringMatch();
        int i = myStringMatch.BF("ˮ�������", "����");
        System.out.print("" + i);
    }
}
