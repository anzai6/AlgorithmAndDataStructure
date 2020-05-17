package com.leetcode.anzai.subject_1_20;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Subject3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    /**
     * 改进版：
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int maxLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        int i = 0;
        int begin = 0; // 起点
        while (i < s.length()) {
            char value = s.charAt(i);
            if (hashMap.containsKey(value) && hashMap.get(value) >= begin) { // 遇到有相同的字符
                if (maxLen < i - begin)
                    maxLen = i - begin;
                begin = hashMap.get(value) + 1; // 新的起点：在前面相同的字符往前一位重新开始遍历
            } else {
                hashMap.put(value, i);
                ++i;
                if (maxLen < i - begin)
                    maxLen = i - begin;
            }
        }

        return maxLen;
    }

    /**
     * 最低级的方法：依次遍历放进HashMap
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null)
            return 0;
        int maxLen = 0;
        HashMap<Character, Integer> hashMap = new HashMap();
        int i = 0;
        while (i < s.length()) {
            char value = s.charAt(i);
            if (hashMap.containsKey(value)) { // 遇到有相同的字符
                if (maxLen < hashMap.size())
                    maxLen = hashMap.size();
                i = hashMap.get(value) + 1; // 在相同的字符往前一位重新开始遍历
                hashMap.clear();
            } else {
                hashMap.put(value, i);
                ++i;
                if (maxLen < hashMap.size())
                    maxLen = hashMap.size();
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Subject3 subject = new Subject3();
        System.out.println(subject.lengthOfLongestSubstring(" a"));
    }
}
