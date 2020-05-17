package com.leetcode.anzai.subject_1_20;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Subject14 {

    /**
     *
     编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串?""。

     示例?1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     示例?2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。
     说明:

     所有输入只包含小写字母?a-z?。
     *
     */

    /**
     * 分治算法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefixDC(strs, 0, strs.length - 1);
    }

    /**
     * 分治
     *
     * @param strs
     * @param low  区间下边界
     * @param high 区间上边界
     * @return 返回区间最长公共前缀长度
     */
    public String longestCommonPrefixDC(String[] strs, int low, int high) {
        if (low > high)
            return "";
        if (low == high)
            return strs[low];
        if (high - low == 1) {
            return getTwoStrCommonQZ(strs[low], strs[high]);
        }
        int center = high + (low - high) / 2;
        String commonQZ1 = longestCommonPrefixDC(strs, low, center);
        if (center + 1 > high || center + 1 > strs.length - 1)
            return commonQZ1;
        String commonQZ2 = longestCommonPrefixDC(strs, center + 1, high);

        return getTwoStrCommonQZ(commonQZ1, commonQZ2);
    }

    /**
     * 求两个字符串的公共前缀
     *
     * @param str1
     * @param str2
     * @return
     */
    private String getTwoStrCommonQZ(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                break;
        }
        return str1.substring(0, i);
    }

    /**
     * 水平扫描法:用第一个字符串依次和后面的比对，找出最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String compareStr = ""; // 最短的字符串
        int commonLen = Integer.MAX_VALUE; // 最长公共子串的长度

        // 先找出最小的字符串长度
        for (int i = 0; i < strs.length; i++) {
            if (commonLen > strs[i].length()) {
                commonLen = strs[i].length();
                compareStr = strs[i];
            }
        }

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            int j = 0;
            for (; j < commonLen; j++) { // 只需要遍历commonLen长度即可
                if (compareStr.charAt(j) != str.charAt(j)) { // 不相等的字符
                    break;
                }
            }
            if (j == 0) // 没有公共前缀
                return "";
            commonLen = j;
        }
        return compareStr.substring(0, commonLen);
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        Subject14 subject = new Subject14();
        System.out.println(subject.longestCommonPrefix(strs));
    }
}
