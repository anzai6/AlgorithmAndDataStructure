package com.example.lib.course34_KMP.finals;

/**
 * Created by qinshunan on 2019/4/18.
 */
public class KMPMatch {


    public int KMPMatch(String mainStr, String matchStr) {

        return -1;
    }


    /**
     * Ԥ�����ҵ�ģʽ���������Ӵ���Ӧ���ƥ��ǰ׺�Ӵ���Ҳ���ƥ���׺�Ӵ�
     */
    private int[] getPreMatchData(char[] b, int matchLen) {

        return null;
    }


    public static void main(String[] args) {
        KMPMatch myKMP = new KMPMatch();
        String mainStr = "wrekjfsdkfjpouiewrsdkojfxcmlds;fksprioepwsfa";
        String matchStr = "sdko";
        int i = myKMP.KMPMatch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
