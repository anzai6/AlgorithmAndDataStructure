package com.example.lib.course33_stringmatch2.finals;

import java.util.Map;

/**
 * BM�ַ������ҷ�������ģʽ�������ַ���ǰƥ�䣬���û��ַ�����ͺ��ַ�������������Ч��
 * �����ַ�������Ҫ�����hash���ڴ棬����ڴ�Ҫ���ϸ����ֻʹ�ú��ַ�����
 * Created by qinshunan on 2019/4/16.
 */

public class BmMatch {


    /**
     * BM����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return ���ҵ���Ӧ�ַ��������ַ���mainStr���±�, ���磺bcda �в��� da ���� 2
     */
    public int bmSearch(String mainStr, String matchStr) {

        return -1;
    }

    /**
     * ���ַ�����
     *
     * @param mainStr      ����
     * @param matchStr     ģʽ��
     * @param s            ������±꿪ʼ��ǰƥ��ģʽ��
     * @param matchCharMap �洢ģʽ��ÿ���ַ���Ӧ���±��ɢ�б�
     * @return ���ػ��ַ��������ƶ��ĳ��ȣ�����0֤��ƥ��ɹ�
     */
    private int badCharRuleMatch(String mainStr, String matchStr, int s, Map<Character, Integer> matchCharMap) {
        return 0;
    }

    /**
     * ���ַ�����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @param s        ������±꿪ʼ��ǰƥ��ģʽ��
     * @param sufix    ֵ�洢ģʽ�������׺�Ӵ�ƥ����Ӵ���ģʽ���е���ʼ��ʼ�ַ����꣬�±������ƥ��ĺ�׺�Ӵ��ĳ���
     * @param prefix   ģʽ���������׺�Ӵ�ƥ���ǰ׺�Ӵ������䳤��Ϊ�±꣬��¼ֵΪtrue
     * @return ���ػ��ַ��������ƶ��ĳ��ȣ�����0֤��ƥ��ɹ�
     */
    private int goodCharRuleMatch(String mainStr, String matchStr, int s, int[] sufix, boolean[] prefix) {

        return 0;
    }


    public static void main(String[] args) {
        BmMatch myBmMatch = new BmMatch();
        String mainStr = "wrekjfsdkfjpouiewrsldkjfxcmlds;fksprioepwsfa";
        String matchStr = "sdfe";
        int i = myBmMatch.bmSearch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
