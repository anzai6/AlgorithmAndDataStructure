package com.leetcode.anzai.subject_61_80;

/**
 * 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class Subject67 {

    /**
     *
     给定两个二进制字符串，返回他们的和（用二进制表示）。

     输入为非空字符串且只包含数字?1?和?0。

     示例?1:

     输入: a = "11", b = "1"
     输出: "100"
     示例?2:

     输入: a = "1010", b = "1011"
     输出: "10101"
     *
     */


    /**
     * 不用反转：从后面开始往前加
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.min(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        int overNext = 0; // 是否有溢出1
        for (int i = 1; i <= len; i++) {
            int value = (a.charAt(aLen - i) - '0') + (b.charAt(bLen - i) - '0') + overNext;
            if (value == 3) {
                sb.append('1');
                overNext = 1;
            } else if (value == 2) {
                sb.append('0');
                overNext = 1;
            } else {
                sb.append(value + "");
                overNext = 0;
            }
        }

        // 剩余的
        String last = aLen > len ? a : b;
        for (int i = last.length() - len - 1; i >= 0; i--) {
            int value = (last.charAt(i) - '0') + overNext;
            if (value == 2) {
                sb.append('0');
                overNext = 1;
            } else {
                sb.append(value + "");
                overNext = 0;
            }
        }

        if (overNext == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
//        String a = "1010";
//        String b = "1011";
//        String a = "101010";
//        String b = "1011";
        Subject67 subject = new Subject67();
        System.out.print(subject.addBinary(a, b));
    }

}
