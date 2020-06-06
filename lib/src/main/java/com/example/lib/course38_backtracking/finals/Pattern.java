package com.example.lib.course38_backtracking.finals;

/**
 * 简单的正则表达式回溯算法
 * 这里简化正则表达式，只有两个"?"和"*"
 * ? 指拥有一个或零个任意字符
 * * 指拥有一个或任意个字符
 * Created by qinshunan on 2019/5/7.
 */
public class Pattern {

    private char[] patternList;
    private int patternLen;
    private int textLen;
    private boolean isMatch = false; // 是否匹配

    public Pattern(String pattern) {
    }

    public boolean match(String text) {
        return false;
    }

    /**
     * @param textList        文本字符数组
     * @param textMatchLen    文本字符数组中要匹配的字符位置
     * @param patternMatchLen 正则表达式字符数组中要匹配的字符位置
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {
    }

    public static void main(String[] args) {
        Pattern myPattern = new Pattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
    }
}
