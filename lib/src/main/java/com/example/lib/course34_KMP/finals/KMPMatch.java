package com.example.lib.course34_KMP.finals;

/**
 * 从前往后匹配，遇到不匹配的就停下来，然后在已经匹配的子串中寻找最大前缀子串并移动
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
        // 数据预处理
        int[] results = getPreMatchData(mainStr.toCharArray(), matchLen);

        // 开始匹配
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = 0;
            for (; j < matchLen; j++) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else if (j == 0) { // 第一个就不匹配
                    i++;
                    break;
                } else {
                    int index = results[j - 1];
                    int moveIndex = 0;
                    if (index == -1) { // 没有可匹配的前缀子串
                        moveIndex = j;
                    } else {
                        moveIndex = j - 1 - index;
                    }
                    i += moveIndex;
                    break;
                }
            }
            if (j == matchLen) { // 匹配成功
                return i;
            }
        }
        return -1;
    }


    /**
     * 预处理找到模式串中所有子串对应的最长匹配前缀子串，也是最长匹配后缀子串
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
