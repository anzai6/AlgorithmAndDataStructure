package com.example.lib.course63_exercise.solution;

/**
 * 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatchingSolution {

    /**
     *
     给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

     '.' 匹配任意单个字符
     '*' 匹配零个或多个前面的那一个元素
     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

     说明:

     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     示例 1:

     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     示例 2:

     输入:
     s = "aa"
     p = "a*"
     输出: true
     解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     示例 3:

     输入:
     s = "ab"
     p = ".*"
     输出: true
     解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     示例 4:

     输入:
     s = "aab"
     p = "c*a*b"
     输出: true
     解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     示例 5:

     输入:
     s = "mississippi"
     p = "mis*is*p*."
     输出: false

     *
     */


    /**
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        isMatch = false;
        if (p == null)
            return false;
        if (s == null)
            return false;

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        sLen = s.length();
        pLen = p.length();
        boolean[][] isCheck = new boolean[sLen][pLen];
        isMatchBT(sChars, pChars, 0, 0, isCheck);
        return isMatch;
    }

    private boolean isMatch = false;
    private int sLen;
    private int pLen;

    /**
     * @param sChars
     * @param pChars
     * @param i      sChars的位置
     * @param j      pChars的位置
     */
    private void isMatchBT(char[] sChars, char[] pChars, int i, int j, boolean[][] isCheck) {
        if (isMatch) // 有匹配的直接终止所有
            return;

        if (i >= sLen || j >= pLen) {
            if (i >= sLen && j >= pLen) { // 两个都匹配成功
                isMatch = true;
            } else if (i == sLen) { // p没有匹配完，则只有剩下的都是"*"才能匹配成功
                int k = j;
                for (; k < pLen; k++) {
                    if (pChars[k] == '*') { // 匹配零个或多个前面的那一个元素
                        continue;
                    } else if (k < pLen - 1 && '*' == pChars[k + 1]) { // 下一个是"*"时，可以跳过一个
                        continue;
                    } else
                        return;
                }
                if (k == pLen)
                    isMatch = true;
            }
            return;
        }

        if (isCheck[i][j])
            return;
        else isCheck[i][j] = true;

        if (pChars[j] == '.') { // 匹配任意单个字符
            if (j < pLen - 1 && '*' == pChars[j + 1]) { // 下一个是"*"时，可以跳过一个
                isMatchBT(sChars, pChars, i, j + 1, isCheck);
            }
            isMatchBT(sChars, pChars, i + 1, j + 1, isCheck);
        } else if (pChars[j] == '*') { // 匹配零个或多个前面的那一个元素
            if (j > 0) {
                char lastChar = pChars[j - 1];
                for (int k = 0; k <= sLen - i; k++) {
                    if (isMatch) // 有匹配的直接终止循环
                        return;
                    if (lastChar == '.') { // 匹配零个或多个任意字符
                        isMatchBT(sChars, pChars, k + i, j + 1, isCheck); // 匹配零个或多个
                    } else {
                        if (k == 0) {
                            isMatchBT(sChars, pChars, i, j + 1, isCheck); // 匹配零个
                        } else if (sChars[k + i - 1] == lastChar) {
                            isMatchBT(sChars, pChars, k + i, j + 1, isCheck); // 匹配多个
                        } else
                            break;
                    }
                }
            }
        } else { // 不是特殊字符
            if (sChars[i] == pChars[j]) { // 可以匹配
                isMatchBT(sChars, pChars, i + 1, j + 1, isCheck);
            }

            if (j < pLen - 1 && '*' == pChars[j + 1]) { // 下一个是"*"时，可以跳过一个
                isMatchBT(sChars, pChars, i, j + 1, isCheck);
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatchingSolution solution = new RegularExpressionMatchingSolution();
//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "a*"));
//        System.out.println(solution.isMatch("aa", ".*"));
//        System.out.println(solution.isMatch("aab", "c*a*b"));
//        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("a", "ab*"));
//        System.out.println(solution.isMatch("a", "ab*a"));
//        System.out.println(solution.isMatch("ab", ".*.."));
//        System.out.println(solution.isMatch("", ".*"));
        System.out.println(solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }

}
