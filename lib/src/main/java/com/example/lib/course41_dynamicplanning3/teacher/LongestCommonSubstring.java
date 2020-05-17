package com.example.lib.course41_dynamicplanning3.teacher;

/**
 * 最长公共子串长度，比较两个字符串之间的编辑距离最长公共子串长度，比如：从"matcmu"到"mtacnu"的最长公共子串是"mtcu"，允许增加、删除,不许替换字符
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到最长公共子串长度最长的单词，用于纠正用户输入的错误单词
 */

public class LongestCommonSubstring {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    public int getMaxLength(String str1, String str2) {
        if (str1 == null || str1.length() == 0)
            return str2.length();
        if (str2 == null || str2.length() == 0)
            return str1.length();
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = str1.length();
        m = str2.length();
//        minDist = Integer.MAX_VALUE;
//        lwstBT(0, 0, 0);
        return lcs(a, n, b, m);
    }

    // 回溯算法：调用方式 lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwstBT(i + 1, j + 1, edist);
        } else { // 两个字符不匹配
            lwstBT(i + 1, j, edist + 1); // 删除 a[i] 或者 b[j] 前添加一个字符
            lwstBT(i, j + 1, edist + 1); // 删除 b[j] 或者 a[i] 前添加一个字符
            lwstBT(i + 1, j + 1, edist + 1); // 将 a[i] 和 b[j] 替换为相同字符
        }
    }

    // 根据回溯算法画出递归树，看是否存在重复子问题，如果存在则考虑动态规划算法，不存在则回溯算法就是最好的解决办法


    // 根据递归树和重复子问题思考分析列出状态转移方程如下，1.可以根据状态转移方程画出一个二维状态表并翻译成代码
    // 2.可以通过递归加备忘录实现代码

    /*
    如果：a[i]==b[j]，那么：max_lcs(i, j) 就等于：
    max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j), max_lcs(i, j-1))；

    如果：a[i]!=b[j]，那么：max_lcs(i, j) 就等于：
    max(max_lcs(i-1,j-1), max_lcs(i-1, j), max_lcs(i, j-1))；

    其中 max 表示求三数中的最大值。
    */


    /**
     * 动态规划的代码
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        for (int j = 0; j < m; ++j) {// 初始化第 0 行：a[0..0] 与 b[0..j] 的 maxlcs
            if (a[0] == b[j]) maxlcs[0][j] = 1;
            else if (j != 0) maxlcs[0][j] = maxlcs[0][j - 1];
            else maxlcs[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) {// 初始化第 0 列：a[0..i] 与 b[0..0] 的 maxlcs
            if (a[i] == b[0]) maxlcs[i][0] = 1;
            else if (i != 0) maxlcs[i][0] = maxlcs[i - 1][0];
            else maxlcs[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) { // 填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxlcs[i][j] = max(
                        maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
                else maxlcs[i][j] = max(
                        maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
            }
        }
        return maxlcs[n - 1][m - 1];
    }

    private int max(int x, int y, int z) {
        int maxv = Integer.MIN_VALUE;
        if (x > maxv) maxv = x;
        if (y > maxv) maxv = y;
        if (z > maxv) maxv = z;
        return maxv;
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println("长度：" + longestCommonSubstring.getMaxLength("mitcmu", "mtacnu"));
    }
}
