package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * 最长公共子串长度，比较两个字符串之间的编辑距离最长公共子串长度，比如：从"matcmu"到"mtacnu"的最长公共子串是"mtcu"，允许增加、删除,不许替换字符
 * 常用于拼写纠错，比如用户输入一个字符串单词，拿去跟词库单词比较，找到最长公共子串长度最长的单词，用于纠正用户输入的错误单词
 */

public class LongestCommonSubStringExercise {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int maxLength = Integer.MIN_VALUE; // 最长公共子串长度

    public int getMaxLength(String str1, String str2) {
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = a.length;
        m = b.length;
//        lcsBT(0, 0, 0);
//        return maxLength;

        return lcsDP();
    }

    /**
     * 计算最长公共子串长度的回溯算法
     *
     * @param i    数组a的下标
     * @param j    数组b的下标
     * @param length 当前的公共子串长度
     */
    private void lcsBT(int i, int j, int length) {
        if (i == n || j == m) {
            if (maxLength < length)
                maxLength = length;
            return;
        }

        if (a[i] == b[j]) {
            lcsBT(i + 1, j + 1, length+1);
        } else {
            lcsBT(i + 1, j, length); // 数组a进一位
            lcsBT(i, j + 1, length); // 数组b进一位
            lcsBT(i + 1, j + 1, length); // 数组a和b都进一位
        }
    }

    // 回溯公式：f(i,j): 当a[i] == b[j] -> f(i,j) = max( f(i-1,j-1)+1, f(i-1,j), f(i,j-1) )
    // 当a[i] != b[j] -> f(i,j) = max( f(i-1,j-1), f(i-1,j), f(i,j-1) )

    /**
     * 动态规划算法
     *
     * @return
     */
    private int lcsDP() {
        int[][] maxLength = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第 0 行:a[0..0] 与 b[0..j] 的编辑距离
            if (a[0] == b[j]) maxLength[0][j] = 1;
            else if (j != 0) maxLength[0][j] = maxLength[0][j - 1];
            else maxLength[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) { // 初始化第 0 列:a[0..i] 与 b[0..0] 的编辑距离
            if (a[i] == b[0]) maxLength[i][0] = 1;
            else if (i != 0) maxLength[i][0] = maxLength[i - 1][0];
            else maxLength[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxLength[i][j] = max(
                        maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1] + 1);
                else maxLength[i][j] = max(
                        maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1]);
            }
        }
        return maxLength[n - 1][m - 1];
    }

    /**
     * 求三个数最小值
     *
     * @param i
     * @param j
     * @param f
     * @return
     */
    private int max(int i, int j, int f) {
        if (i > j) {
            return i > f ? i : f;
        } else {
            return j > f ? j : f;
        }
    }

    public static void main(String[] args) {
        LongestCommonSubStringExercise longestCommonSubStringExercise = new LongestCommonSubStringExercise();
        System.out.println("最长公共子串：" + longestCommonSubStringExercise.getMaxLength("mitcmu", "mtacnu"));
    }
}
