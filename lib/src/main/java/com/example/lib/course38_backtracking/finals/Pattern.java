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
        if (pattern == null) {
            throw new IllegalArgumentException("pattern is invalid");
        }
        patternList = pattern.toCharArray();
        patternLen = patternList.length;
    }

    public boolean match(String text) {
        if (text == null) {
            return false;
        }
        textLen = text.length();
        match(text.toCharArray(), 0, 0);

        return isMatch;
    }

    /**
     * @param textList        文本字符数组
     * @param textMatchLen    文本字符数组中要匹配的字符位置
     * @param patternMatchLen 正则表达式字符数组中要匹配的字符位置
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {
        if (isMatch) {
            return;
        }
        if (patternMatchLen == patternLen) { // 全部匹配完
            if (textMatchLen == textLen) // 理解这里是重点，只有当正则和文本都匹配完成才是匹配成功
                isMatch = true;
            return;
        }

        char pChar = patternList[patternMatchLen];
        if ('?' == pChar) { // 指拥有一个或零个任意字符
            // 拥有一个
            match(textList, textMatchLen + 1, patternMatchLen + 1);
            // 拥有零个
            match(textList, textMatchLen, patternMatchLen + 1);
        } else if ('*' == pChar) { // 指拥有一个或任意个字符
            // 拥有零个
            match(textList, textMatchLen, patternMatchLen + 1);
            // 拥有任意个
            match(textList, textMatchLen + 1, patternMatchLen);
        } else { // 单个匹配
            if (textMatchLen < textLen && textList[textMatchLen] == pChar) {
                match(textList, textMatchLen + 1, patternMatchLen + 1);
            }
        }

    }

    public static void main(String[] args) {
        Pattern myPattern = new Pattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
        //
    }
}
