package com.leetcode.anzai.subject_61_80;

import java.util.HashMap;

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Subject76 {

    /**
     *
     给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

     示例：

     输入: S = "ADOBECODEBANC", T = "ABC"
     输出: "BANC"
     说明：

     如果 S 中不存这样的子串，则返回空字符串 ""。
     如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     */

    /**
     * 根据网友和官方解答：使用滑动窗口，滑动窗口一般会有两个指针，一个滑动的时候另一个不动
     * 这里的思路是：
     * 1.左右指针 left 和 right 从0开始；
     * 2.右指针 right 往右移动直到 [left, right] 区间的字符串包含 t 字符串；
     * 3.停止 right 移动，然后 left 左指针往右移动，直到 [left, right] 刚好不包含 t 字符串，中间不断更新满足包含条件的最小子串；
     * 4.重复步骤 2 和 3 直到 right 指针到达 s 字符串的终点。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null
                || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        // T 字符串的所有字符制作的 subHashMap，
        HashMap<Character, Integer> targetHashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetHashMap.put(t.charAt(i), targetHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0; // 右指针
        int count = 0;  //  [left, right] 区间满足包含 t 中字符串的个数，当 count == t.length() 时，即满足覆盖子串要求
        // sourceHashMap: T 字符串的字符在 S 中的 [left, right] 位置全纪录
        HashMap<Character, Integer> sourceHashMap = new HashMap<>();

        int minSubStrLen = Integer.MAX_VALUE;
        int subStrStarIndex = -1;
        while (right < s.length()) {
            if (targetHashMap.containsKey(s.charAt(right))) {
                int rightCount = sourceHashMap.getOrDefault(s.charAt(right), 0);
                sourceHashMap.put(s.charAt(right), ++rightCount);
                // 注意，由于自动装箱，这里使用Integer == Integer 超过 127 是不成立的，所以要用 .intValue() 来比较
                if (rightCount == targetHashMap.get(s.charAt(right))) {
                    count++;
                }

                while (count == targetHashMap.size()) { // 满足覆盖子串要求的前提下，往上移动 left 指针
                    if ((right - left) < minSubStrLen) {
                        subStrStarIndex = left;
                        minSubStrLen = right - left;
                    }
                    // 往上移动 left 指针
                    if (sourceHashMap.containsKey(s.charAt(left))) {
                        int leftCount = sourceHashMap.get(s.charAt(left));
                        sourceHashMap.put(s.charAt(left), leftCount - 1);
                        if (leftCount == targetHashMap.get(s.charAt(left)).intValue()) {
                            count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }

        return subStrStarIndex == -1 ? "" : s.substring(subStrStarIndex, subStrStarIndex + minSubStrLen + 1);
    }


    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "ABCODEBANC";
//        String t = "ABC";
        String s = "AA";
        String t = "AA";
        Subject76 subject = new Subject76();
        System.out.println(subject.minWindow(s, t));
    }

}
