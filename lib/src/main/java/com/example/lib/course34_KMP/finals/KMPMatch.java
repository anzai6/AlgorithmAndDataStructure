package com.example.lib.course34_KMP.finals;

/**
 * ��ǰ����ƥ�䣬������ƥ��ľ�ͣ������Ȼ�����Ѿ�ƥ����Ӵ���Ѱ�����ǰ׺�Ӵ����ƶ�
 * Created by qinshunan on 2019/4/18.
 */
public class KMPMatch {


    public int KMPMatch(String mainStr, String matchStr) {
        if (mainStr == null || mainStr.length() == 0
                || matchStr == null || matchStr.length() == 0
                || mainStr.length() < matchStr.length()) {
            return -1;
        }
        int mainLen = mainStr.length();
        int matchLen = matchStr.length();
        // ����Ԥ����
        int[] results = getPreMatchData(mainStr.toCharArray(), matchLen);

        // ��ʼƥ��
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = 0;
            for (; j < matchLen; j++) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else if (j == 0) { // ��һ���Ͳ�ƥ��
                    i++;
                    break;
                } else {
                    int index = results[j - 1];
                    int moveIndex = 0;
                    if (index == -1) { // û�п�ƥ���ǰ׺�Ӵ�
                        moveIndex = j;
                    } else {
                        moveIndex = j - 1 - index;
                    }
                    i += moveIndex;
                    break;
                }
            }
            if (j == matchLen) { // ƥ��ɹ�
                return i;
            }
        }
        return -1;
    }


    /**
     * Ԥ�����ҵ�ģʽ���������Ӵ���Ӧ���ƥ��ǰ׺�Ӵ���Ҳ���ƥ���׺�Ӵ�
     */
    private int[] getPreMatchData(char[] b, int matchLen) {
        if (matchLen <= 0) {
            throw new IllegalArgumentException("matchLen is invalid");
        }
        int[] results = new int[matchLen];
        for (int i = 0; i < matchLen; i++) {
            results[i] = -1;
        }
        for (int i = 1; i < matchLen - 1; i++) {
            int pre = results[i - 1];
            while (b[i] != b[pre + 1] && pre != -1) {
                pre = results[pre];
            }
            if (b[i] == b[pre + 1]) {
                results[i] = pre + 1;
            } else {
                results[i] = -1;
            }
        }
        return results;
    }


    public static void main(String[] args) {
        KMPMatch myKMP = new KMPMatch();
        String mainStr = "wrekjfsdkfjpouiewrsdkojfxcmlds;fksprioepwsfa";
        String matchStr = "sdkf";
        int i = myKMP.KMPMatch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
