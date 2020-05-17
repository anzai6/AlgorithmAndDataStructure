package com.example.lib.course38_backtracking.my;

/**
 * 简单的正则表达式回溯算法
 * 这里简化正则表达式，只有两个"?"和"*"
 * ? 指拥有一个或零个任意字符
 * * 指拥有一个或任意个字符
 * Created by qinshunan on 2019/5/7.
 */
public class MyPattern {

    private char[] patternList;
    private int patternLen;
    private int textLen;
    private boolean isMatch = false; // 是否匹配

    public MyPattern(String pattern) {
        this.patternList = pattern.toCharArray();
        patternLen = pattern.length();
    }

    public boolean match(String text) {
        textLen = text.length();
        isMatch = false;
        match(text.toCharArray(), 0, 0);
        return isMatch;
    }

    /**
     * @param textList        文本字符数组
     * @param textMatchLen    文本字符数组中要匹配的字符位置
     * @param patternMatchLen 正则表达式字符数组中要匹配的字符位置
     */
    public void match(char[] textList, int textMatchLen, int patternMatchLen) {

        if (isMatch)// 已经匹配成功
            return;

        if (patternMatchLen == patternLen) { // 全部匹配完
            if (textMatchLen == textLen) // 理解这里是重点，只有当正则和文本都匹配完成才是匹配成功
                isMatch = true;
            return;
        }

        if (textMatchLen >= textLen) // 文本已经匹配完
            return;

        char patternChar = patternList[patternMatchLen];
        if ('?' == patternChar) { // 匹配?
            match(textList, textMatchLen + 1, patternMatchLen + 1); // 一个
            match(textList, textMatchLen, patternMatchLen + 1); // 0个
        } else if ('*' == patternChar) { // 匹配*
            for (int i = 0; i < textLen; i++) {
                match(textList, textMatchLen + i, patternMatchLen); // 任意个
            }
        } else {
            char textChar = textList[textMatchLen];
            if (textChar == patternChar) { // 相同字符匹配
                match(textList, textMatchLen + 1, patternMatchLen + 1); // 下一个
            } else { // 不匹配
            }
        }
    }

    public static void main(String[] args) {
        MyPattern myPattern = new MyPattern("?df?sd?p");
        System.out.println(myPattern.match("fdfwsdp") + "");
    }
}
