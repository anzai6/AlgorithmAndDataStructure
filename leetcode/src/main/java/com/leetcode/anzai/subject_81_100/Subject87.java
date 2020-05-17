package com.leetcode.anzai.subject_81_100;

import java.util.HashMap;

/**
 * 扰乱字符串
 * https://leetcode-cn.com/problems/scramble-string/
 */
public class Subject87 {

    /**
     *
     给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。

     下图是字符串 s1 = "great" 的一种可能的表示形式。

     great
     /      \
     gr      eat
     /  \    /   \
     g   r  e    at
     / \
     a   t
     在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。

     例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
     rgeat
     /       \
     rg       eat
     /  \    /    \
     r   g  e     at
     / \
     a   t
     我们将 "rgeat” 称作 "great" 的一个扰乱字符串。

     同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。

     rgtae
     /      \
     rg       tae
     / \      /  \
     r   g    ta  e
     / \
     t   a
     我们将 "rgtae” 称作 "great" 的一个扰乱字符串。

     给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。

     示例 1:

     输入: s1 = "great", s2 = "rgeat"
     输出: true
     示例 2:

     输入: s1 = "abcde", s2 = "caebd"
     输出: false
     *
     */

    /**
     * 初步思路，递归解法，由于都是一分为二扰乱字的，所以可以将两个字符串都一分为二，
     * 然后两两比较，注意不止是同侧两两比较，异侧也要比，然后判断是否有某侧是相同的
     * <p>
     * 日，想成对等分了，原来可以任意分的.....
     * 修改为可以任意切割点切割
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        return isScrambleRecursive(s1, s2, hashMap);
    }

    /**
     * 递归解法具体实现，由于超出时间限制需要加入备忘录，不过依旧很慢，
     * 参照网友题解加入“判断两个字符串每个字母出现的次数是否一致”的优化，效果显著，同时如果去掉备忘录更快
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScrambleRecursive(String s1, String s2, HashMap<String, Boolean> hashMap) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 1) {
            return s1.equals(s2);
        }

        String key = new StringBuilder(s1).append("#").append(s2).toString();
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }

        //判断两个字符串每个字母出现的次数是否一致
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        //如果两个字符串的字母出现不一致直接返回 false
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                hashMap.put(key, false);
                return false;
            }
        }

        // 以 i 为分割点，注意分两种情况
        for (int i = 1; i < s1.length(); i++) {
            // 切割点在 s2 头部
            if (isScrambleRecursive(s1.substring(0, i), s2.substring(0, i), hashMap)
                    && isScrambleRecursive(s1.substring(i), s2.substring(i), hashMap)) {
                hashMap.put(key, true);
                return true;
            }
            // 切割点在 s2 尾部
            if (isScrambleRecursive(s1.substring(0, i), s2.substring(s2.length() - i), hashMap)
                    && isScrambleRecursive(s1.substring(i), s2.substring(0, s2.length() - i), hashMap)) {
                hashMap.put(key, true);
                return true;
            }
        }
        hashMap.put(key, false);
        return false;
    }


    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
//        s1 = "great";
//        s2 = "rgtae";
//        s1 = "abcde";
//        s2 = "caebd";
//        s1 = "abab";
//        s2 = "aabb";
        Subject87 subject = new Subject87();
        System.out.print(subject.isScramble(s1, s2));
    }

}
