package com.leetcode.anzai.subject_1_20;

/**
 * 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class Subject9 {

    /**
     *
     判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

     示例 1:

     输入: 121
     输出: true
     示例?2:

     输入: -121
     输出: false
     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3:

     输入: 10
     输出: false
     解释: 从右向左读, 为 01 。因此它不是一个回文数。
     进阶:

     你能不将整数转为字符串来解决这个问题吗？
     *
     */

    /**
     * 不转为字符串的办法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x >= 0 && x <= 9)
            return true;

        int newValue = 0;
        int oldValue = x;
        while (true) {
            int last = oldValue % 10; // 个位数
            if (newValue < Integer.MAX_VALUE / 10
                    || (newValue == Integer.MAX_VALUE / 10 && last <= Integer.MAX_VALUE % 10))
                newValue = newValue * 10 + last;
            else return false;
            if (oldValue >= 10)
                oldValue = oldValue / 10;
            else
                break;
        }
        return newValue == x;
    }


    /**
     * 转为字符串的办法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        String data = x + "";
        if (data.length() == 1)
            return true;
        int low = 0;
        int high = data.length() - 1;
        while (low <= high) {
            if (data.charAt(low) == data.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Subject9 subject = new Subject9();
        System.out.println(subject.isPalindrome(Integer.MAX_VALUE));
    }
}
