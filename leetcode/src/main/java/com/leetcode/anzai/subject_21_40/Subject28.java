package com.leetcode.anzai.subject_21_40;

/**
 * 实现strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Subject28 {

    /**
     *
     实现?strStr()?函数。

     给定一个?haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回? -1。

     示例 1:

     输入: haystack = "hello", needle = "ll"
     输出: 2
     示例 2:

     输入: haystack = "aaaaa", needle = "bba"
     输出: -1
     说明:

     当?needle?是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

     对于本题而言，当?needle?是空字符串时我们应当返回 0 。这与C语言的?strstr()?以及 Java的?indexOf()?定义相符。
     *
     */

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null)
            return -1;
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Subject28 subject = new Subject28();
        System.out.print(subject.strStr("aaaaa", "bba"));
    }
}
