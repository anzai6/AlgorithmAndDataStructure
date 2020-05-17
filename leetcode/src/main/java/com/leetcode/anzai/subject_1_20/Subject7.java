package com.leetcode.anzai.subject_1_20;

/**
 * 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Subject7 {

    /**
     *
     给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

     示例?1:

     输入: 123
     输出: 321
     ?示例 2:

     输入: -123
     输出: -321
     示例 3:

     输入: 120
     输出: 21
     注意:

     假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为?[?231,? 231?? 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     */


    /**
     * 普通解法
     * @param x
     * @return
     */
    public int reverse(int x) {
        String data = x + "";
        StringBuilder sb = new StringBuilder();
        //第一位单独处理
        int first = 0;
        if (data.charAt(0) == '-' || data.charAt(0) == '+') {
            sb.append(data.charAt(0));
            first = 1;
        }
        for (int i = data.length() - 1; i >= first; i--) {
            sb.append(data.charAt(i));
        }
        long result = Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }


    public static void main(String[] args) {
        Subject7 subject = new Subject7();
        System.out.println(subject.reverse(Integer.MAX_VALUE));
    }
}
