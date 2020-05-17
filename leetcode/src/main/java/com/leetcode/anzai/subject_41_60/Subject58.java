package com.leetcode.anzai.subject_41_60;

/**
 * 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Subject58 {

    /**
     *
     给定一个仅包含大小写字母和空格?' '?的字符串，返回其最后一个单词的长度。

     如果不存在最后一个单词，请返回 0?。

     说明：一个单词是指由字母组成，但不包含任何空格的字符串。

     示例:

     输入: "Hello World"
     输出: 5
     *
     */

    /**
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {

        if (s == null) {
            return 0;
        }
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int charV = s.charAt(i);
            if (charV == ' ') {
                if (len == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "a ";
//        String s = "Hello World";
        Subject58 subject = new Subject58();
        System.out.println(subject.lengthOfLastWord(s));
    }

}
