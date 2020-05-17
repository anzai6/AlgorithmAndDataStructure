package com.leetcode.anzai.subject_61_80;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Subject63 {

    /**
     *
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

     现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

     subject_62.png

     网格中的障碍物和空位置分别用 1 和 0 来表示。

     说明：m?和 n 的值均不超过 100。

     示例?1:

     输入:
     [
     ? [0,0,0],
     ? [0,1,0],
     ? [0,0,0]
     ]
     输出: 2
     解释:
     3x3 网格的正中间有一个障碍物。
     从左上角到右下角一共有 2 条不同的路径：
     1. 向右 -> 向右 -> 向下 -> 向下
     2. 向下 -> 向下 -> 向右 -> 向右
     *
     */

    /**
     * 动态规划法：1.根据回溯算法和状态树寻找重复子问题；2.列出状态转移方程；3.翻译成代码
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 状态转移方程：f(m,n) = f(m-1,n) + f(m,n-1)
        // 这里可以把它反转过来遍历，
        obstacleGrid[0][0] = 1;
        // 初始化第一排
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) { // 障碍物归0
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        // 初始化第一列
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) { // 障碍物归0
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    /**
     * 回溯算法：可惜超时了，要加上备忘录才行（加上备忘录还是超时了......）
     *
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        uniquePathsWithObstaclesInternal(0, 0, m - 1, n - 1, result, obstacleGrid);
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
    private void uniquePathsWithObstaclesInternal(int column, int row, int m, int n, int[][] result, int[][] obstacleGrid) {
        if (result[column][row] != 0 || obstacleGrid[column][row] == 1) {// 计算过(备忘录)或者是障碍物
            return;
        }

        if (column == m && row == n) {
            result[column][row] = 1;
            return;
        }

        int down = 0;
        int right = 0;
        // 向下
        if (row < n) {
            uniquePathsWithObstaclesInternal(column, row + 1, m, n, result, obstacleGrid);
            down = result[column][row + 1];
        }
        // 向右
        if (column < m) {
            uniquePathsWithObstaclesInternal(column + 1, row, m, n, result, obstacleGrid);
            right = result[column + 1][row];
        }
        result[column][row] = down + right;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] obstacleGrid = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 1 && j == 1) {
                    obstacleGrid[i][j] = 1;
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        obstacleGrid[0][0] = 0;
        Subject63 subject = new Subject63();
        System.out.print(subject.uniquePathsWithObstacles(obstacleGrid));
    }

}
