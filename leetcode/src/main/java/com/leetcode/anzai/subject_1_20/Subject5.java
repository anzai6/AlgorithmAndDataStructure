package com.leetcode.anzai.subject_1_20;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Subject5 {

    /**
     *
     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设?s 的最大长度为 1000。

     示例 1：

     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     示例 2：

     输入: "cbbd"
     输出: "bb"

     输入: "cbcacbcb"
     输出: "cbcacbc"

     输入: "cbcacbcbcbcacb"
     输出: "bcacbcbcbcacb"

     输入: "cbcacbcbbcbcacb"
     输出: "bcacbcbbcbcacb"
     *
     */


    /**
     * 初步版本：以每一个字符为中间点向两边扩散，找出最大的回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1)
            return s;
        char[] list = s.toCharArray();
        int maxLow = 0; // 最长回文子串起点坐标
        int maxHigh = 0; // 最长回文子串终点坐标
        int maxLen = 0; // 最长回文子串长度
        for (int i = 0; i < list.length - 1; i++) {
            char center = list[i];
            int low = 0;
            int high = 0;

            // 偶数回文子串
            if (list[i + 1] == center) { // 往前一位跟 center 相等,比如：bb
                low = i - 1;
                high = i + 2;
                while (low >= 0 && high <= list.length - 1) {
                    if (list[low] == list[high]) {
                        --low;
                        ++high;
                    } else
                        break;
                }
                int len = high - low - 1;
                if (len > maxLen) {
                    maxLen = len;
                    maxLow = low + 1;
                    maxHigh = high - 1;
                }
            }

            // 奇数回文子串
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high <= list.length - 1) {
                if (list[low] == list[high]) {
                    --low;
                    ++high;
                } else
                    break;
            }
            int len = high - low - 1;
            if (len > maxLen) {
                maxLen = len;
                maxLow = low + 1;
                maxHigh = high - 1;
            }
        }

        return s.substring(maxLow, maxHigh + 1);
    }


    public static void main(String[] args) {
        Subject5 subject = new Subject5();
        System.out.println(subject.longestPalindrome("cbcacbcbbcbcacb"));
    }
}
