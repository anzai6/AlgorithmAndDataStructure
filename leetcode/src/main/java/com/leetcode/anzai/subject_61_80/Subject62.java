package com.leetcode.anzai.subject_61_80;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Subject62 {

    /**
     *
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

     问总共有多少条不同的路径？

     subject_62.png

     例如，上图是一个7 x 3 的网格。有多少可能的路径？

     说明：m?和 n 的值均不超过 100。

     示例?1:

     输入: m = 3, n = 2
     输出: 3
     解释:
     从左上角开始，总共有 3 条路径可以到达右下角。
     1. 向右 -> 向右 -> 向下
     2. 向右 -> 向下 -> 向右
     3. 向下 -> 向右 -> 向右
     示例?2:

     输入: m = 7, n = 3
     输出: 28
     *
     */

    /**
     * 动态规划法：1.根据回溯算法和状态树寻找重复子问题；2.列出状态转移方程；3.翻译成代码
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // 状态转移方程：f(m,n) = f(m-1,n) + f(m,n-1)
        // 这里可以把它反转过来遍历，
        int[][] result = new int[m][n];
        result[0][0] = 1;
        // 初始化第一排
        for (int i = 1; i < m; i++) {
            result[i][0] = 1;
        }
        // 初始化第一列
        for (int i = 1; i < n; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

    /**
     * 回溯算法：可惜超时了，要加上备忘录才行
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] result = new int[m][n];
        result[m - 1][n - 1] = 1;
        uniquePathsInternal(0, 0, m - 1, n - 1, result);
        return result[0][0];
    }

    /**
     * 回溯：向左和向下
     *
     * @param column
     * @param row
     * @param m
     * @param n
     */
    private void uniquePathsInternal(int column, int row, int m, int n, int[][] result) {
        // 还没有计算过：备忘录
        if (result[column][row] == 0) {

            int down = 0;
            int right = 0;
            // 向下
            if (row < n) {
                uniquePathsInternal(column, row + 1, m, n, result);
                down = result[column][row + 1];
            }
            // 向右
            if (column < m) {
                uniquePathsInternal(column + 1, row, m, n, result);
                right = result[column + 1][row];
            }
            result[column][row] = down + right;
        }
    }

    public static void main(String[] args) {
        Subject62 subject = new Subject62();
        System.out.print(subject.uniquePaths(7, 3));
    }

}
