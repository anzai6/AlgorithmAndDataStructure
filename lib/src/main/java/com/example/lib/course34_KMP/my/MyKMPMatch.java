package com.example.lib.course34_KMP.my;

import com.example.lib.course32_stringmatch.my.MyStringMatch;

/**
 * Created by qinshunan on 2019/4/18.
 */
public class MyKMPMatch {


    public int KMPMatch(String mainStr, String matchStr) {

        if (mainStr == null || mainStr.length() == 0)
            return -1;

        if (matchStr == null || mainStr.length() == 0)
            return -1;

        if (matchStr.length() > mainStr.length())
            return -1;

        if (matchStr.length() == mainStr.length())
            return mainStr.equals(matchStr) ? 0 : -1;

        if (matchStr.length() <= 2) // 长度2以内用BF暴力搜索算法可能更快（加上坏规则还会更快，这里不考虑了）
            return new MyStringMatch().BF(mainStr, matchStr);

        int mainLen = mainStr.length();
        int matchLen = matchStr.length();

        char[] mainChar = mainStr.toCharArray();
        char[] matchChar = matchStr.toCharArray();

        int[] next = getPreMatchData(matchChar, matchLen);

        int j = 0;
        for (int i = 0; i < mainLen; i++) {
            while (j > 0 && mainChar[i] != matchChar[j]) { // 一直找到 mainChar[i] 和 matchChar[j]
                j = next[j - 1] + 1;
            }
            if (mainChar[i] == matchChar[j]) {
                ++j;
            }
            if (j == matchLen) { // 找到匹配模式串的了
                return i - matchLen + 1;
            }
        }
        return -1;
    }


    /**
     * 预处理找到模式串中所有子串对应的最长匹配前缀子串，也是最长匹配后缀子串
     */
    private int[] getPreMatchData(char[] b, int matchLen) {

        // int[] next;模式串子串尾字符作为下标，值为最长可匹配前缀子串的尾字符下标
        int[] next = new int[matchLen];
        int k = -1;
        next[0] = k; // 首字符没有子串

        // 假设b[0~i-1]最长可匹配后缀子串是k
        // 如果b[k+1] == b[i],则b[0~i]最长可匹配后缀子串是k+1
        // 如果b[k+1] != b[i],且b[0~i]最长可匹配后缀子串是x
        // 则x-1一定是b[0~i-1]的某个可匹配后缀子串长度，但不一定是最长，且b[x] == b[i]，且x-1 <= k ，即b[0,x-1]必定属于b[0,k]--好好体会，这个是关键
        // 所以求x-1就是不断的寻找b[0,k]中某个最长可匹配子串，这个子串长度为y,而且b[y+1] == b[i]，从大到小依次寻找，比如0~k的最长可匹配后缀子串是y = next[k]，则代入b[y+1] == b[i]，
        // 结果相等则可求出x = y + 1，不等则y = next[y],继续往下求
        // 这里用到的是动态规划的思路，即通过0求1的值，然后求2.3.4.5...i依次类推
        // ***重点*** 关键思想就是动态规划，找出通过next[i-1]求next[i]的规律，即b[k+1] 与 b[i] 的比较 ***重点***
        // b[k+1] == b[i] 则直接next[i-1]+1搞定，
        // 若b[k+1] != b[i] 则从所有可匹配子串中找到符合b[k+1] == b[i]的可匹配后缀子串


        for (int i = 1; i < matchLen; i++) {

            // 此时k是b[0~i-1]最长可匹配后缀子串，通过不断缩小范围寻找到b[k + 1] == b[i]的最长可匹配后缀子串长度k
            // 一个模式串b[0,k]其所有可匹配子串尾字符依次是：next[k]、next[next[k]]、next[next[next[k]]]....直到等于-1
            // 结合上面的注释好好理解
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }

            // 这里如果b[k + 1] 不等于 b[i]证明没有最长可匹配后缀子串，即k = -1;
            if (b[k + 1] == b[i]) {
                ++k;
            }

            next[i] = k;
        }

        return next;
    }


    public static void main(String[] args) {
        MyKMPMatch myKMP = new MyKMPMatch();
        String mainStr = "wrekjfsdkfjpouiewrsdkojfxcmlds;fksprioepwsfa";
        String matchStr = "sdko";
        int i = myKMP.KMPMatch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
