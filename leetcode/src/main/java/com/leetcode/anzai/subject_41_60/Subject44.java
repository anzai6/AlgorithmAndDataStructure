package com.leetcode.anzai.subject_41_60;

/**
 * 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Subject44 {

    /**
     *
     给定一个字符串?(s) 和一个字符模式?(p) ，实现一个支持?'?'?和?'*'?的通配符匹配。

     '?' 可以匹配任何单个字符。
     '*' 可以匹配任意字符串（包括空字符串）。
     两个字符串完全匹配才算匹配成功。

     说明:

     s?可能为空，且只包含从?a-z?的小写字母。
     p?可能为空，且只包含从?a-z?的小写字母，以及字符???和?*。
     示例?1:

     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     示例?2:

     输入:
     s = "aa"
     p = "*"
     输出: true
     解释:?'*' 可以匹配任意字符串。
     示例?3:

     输入:
     s = "cb"
     p = "?a"
     输出: false
     解释:?'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     示例?4:

     输入:
     s = "adceb"
     p = "*a*b"
     输出: true
     解释:?第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     示例?5:

     输入:
     s = "acdcb"
     p = "a*c?b"
     输入: false
     *
     */

    /**
     * 网友更精简的动态规划
     * <p>
     * 递推公式：f(i,j) = f(i-1,j) -> p[j] = "*",f(i,j-1) -> p[j] = "*",f(i-1,j-1) -> p[j] = "*"或"?"或字符; 三个中有一个 true 即可
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p == null || s == null) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] resultList = new boolean[sLen + 1][pLen + 1]; // 注意这里分别+1，就不用像我写的那样判断各种临界情况，有点像哨兵，少很多判断
        resultList[0][0] = true;// 代表两个空的字符

        // 初始化 s 为空的情况 (注意 p 为空的情况除了 s 为空，剩下的都是 false 所以不用初始化了)
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                resultList[0][i] = true;
            } else {
                break; // 退出循环，因为剩下的都是 false 了
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 三个子状态有一个匹配即可
                    resultList[i][j] = resultList[i - 1][j] || resultList[i][j - 1] || resultList[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    resultList[i][j] = resultList[i - 1][j - 1];
                } else {
                    resultList[i][j] = false;
                }
            }
        }

        return resultList[sLen][pLen];
    }

    /**
     * 动态规划
     * <p>
     * 递推公式：f(i,j) = f(i-1,j) -> p[j] = "*",f(i,j-1) -> p[j] = "*",f(i-1,j-1) -> p[j] = "*"或"?"或字符; 三个中有一个 true 即可
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (p == null || s == null) {
            return false;
        }

        // 针对空的情况
        if ("".equals(s) && "".equals(p)) {
            return true;
        } else if ("".equals(s)) {
            int k = 0;
            // 剩下的都是"*"
            for (; k < p.length(); k++) {
                if ('*' == p.charAt(k)) {
                    continue;
                } else {
                    break;
                }
            }
            if (k == p.length()) {
                return true;
            }
            return false;
        } else if ("".equals(p)) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] resultList = new boolean[sLen][pLen];

        // 0-0位
        if (p.charAt(0) == '*' || p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
            resultList[0][0] = true;
        } else {
            resultList[0][0] = false;
        }

        // 第一行
        if (p.charAt(0) == '*') { // 只有 "*" 要遍历，其它一定是 false
            for (int i = 1; i < sLen; i++) {
                resultList[i][0] = true;
            }
        }

        // 第一列-这里比较难，有点绕
        if (resultList[0][0]) { // false 就不用往下遍历了，后面的一定是 false
            for (int i = 1; i < pLen; i++) {
                // 这里判断容易出错
                if (p.charAt(i) == '*') {
                    resultList[0][i] = true;
                } else if (p.charAt(0) == '*' && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(0))) {
                    // 这里的前提是 i 前面的字符都是 "*"
                    resultList[0][i] = true;

                    int k = i + 1;
                    // 剩下的都是"*"
                    for (; k < pLen; k++) {
                        if ('*' == p.charAt(k)) {
                            resultList[0][k] = true;
                        } else {
                            break;
                        }
                    }

                    break; // 后面不用判断了
                } else {
                    break; // 后面不用判断了
                }
            }
        }

        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < pLen; j++) {
                if (p.charAt(j) == '*') {
                    // 三个子状态有一个匹配即可
                    resultList[i][j] = resultList[i - 1][j] || resultList[i][j - 1] || resultList[i - 1][j - 1];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    resultList[i][j] = resultList[i - 1][j - 1];
                } else {
                    resultList[i][j] = false;
                }
            }
        }

        return resultList[sLen - 1][pLen - 1];
    }

    /**
     * 递归调用+备忘录
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        isMatch = false;
        boolean[][] matchList = new boolean[s.length() + 1][p.length() + 1];
        isMatchInternal(s, 0, p, 0, matchList);
        return isMatch;
    }

    private boolean isMatch = false;

    /**
     * 内部递归
     *
     * @param s
     * @param i
     * @param p
     * @param j
     * @param matchList
     */
    public void isMatchInternal(String s, int i, String p, int j, boolean[][] matchList) {
        if (isMatch) {
            return;
        }

        if (matchList[i][j]) {
            return;
        } else {
            matchList[i][j] = true;
        }

        if (i == s.length() && j == p.length()) {
            isMatch = true;
            return;
        } else if (i == s.length()) {
            int k = j;
            // 剩下的都是"*"
            for (; k < p.length(); k++) {
                if ('*' == p.charAt(k)) {
                    continue;
                } else {
                    break;
                }
            }
            if (k == p.length()) {
                isMatch = true;
                return;
            }
            return;
        } else if (j == p.length()) {
            return;
        }

        char pChar = p.charAt(j);

        if ('*' == pChar) {
            isMatchInternal(s, i, p, j + 1, matchList); // 匹配空
            isMatchInternal(s, i + 1, p, j + 1, matchList); // 匹配一个
            isMatchInternal(s, i + 1, p, j, matchList); // 匹配任意多个
        } else if ('?' == pChar) {
            isMatchInternal(s, i + 1, p, j + 1, matchList);
        } else if (s.charAt(i) == pChar) {
            isMatchInternal(s, i + 1, p, j + 1, matchList);
        }
        return;
    }

    public static void main(String[] args) {
        Subject44 subject = new Subject44();
        System.out.println(subject.isMatch("c", "*?*"));
    }
}