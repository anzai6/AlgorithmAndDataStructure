package com.example.lib.course63_exercise.solution;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */

public class MinimumPathSumSolution {

    /**
     *
     给定一个包含非负整数的 m x n网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

     说明：每次只能向下或者向右移动一步。

     示例:

     输入:
     [
     [1,3,1],
     [1,5,1],
     [4,2,1]
     ]
     输出: 7
     解释: 因为路径 1→3→1→1→1 的总和最小。

     *
     */

    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        row = grid.length;
        column = grid[0].length;
        if (column == 0)
            return 0;
        int[][] pathList = new int[row][column];
        // 初始化边界数据，哨兵规则
        pathList[0][0] = grid[0][0]; // 第一个
        for (int i = 1; i < row; i++) { // 第一列
            pathList[i][0] = pathList[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) { // 第一行
            pathList[0][i] = pathList[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                // 从上过来或者从左过来，选最小的值
                int left = pathList[i][j - 1];
                int top = pathList[i - 1][j];
                int minPath = left > top ? top : left; // 取最小值
                pathList[i][j] = minPath + grid[i][j]; // 加上当前坐标的值
            }
        }

        return pathList[row - 1][column - 1];
    }

    /**
     * 回溯算法+备忘录
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        if (grid[0].length == 0)
            return 0;
        row = grid.length;
        column = grid[0].length;
        int[][] pathList = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                pathList[i][j] = Integer.MAX_VALUE;
            }
        }
        minPathSumBP(0, 0, 0, grid, pathList);
        return pathList[row - 1][column - 1];
    }

    int row;
    int column;

    /**
     * 回溯算法+备忘录：深度优先遍历
     *
     * @param i    行坐标
     * @param j    列坐标
     * @param path 到达（i,j）顶点时，前面的路径之和
     */
    private void minPathSumBP(int i, int j, int path, int[][] grid, int[][] pathList) {
        if (row - 1 == i && j == column - 1) {
            path += grid[i][j];
            if (pathList[i][j] > path) {
                pathList[i][j] = path;
            }
            return;
        }

        if (i < row && i >= 0 && j >= 0 && j < column) {
            path += grid[i][j]; // 前面的路径之和加上当前的路径
            if (pathList[i][j] <= path) { // 大于备忘录的值
                return;
            }
            pathList[i][j] = path;
//            minPathSumBP(i, j - 1, path, grid, pathList); // 往左
            minPathSumBP(i, j + 1, path, grid, pathList); // 往右
//            minPathSumBP(i - 1, j, path, grid, pathList); // 往上
            minPathSumBP(i + 1, j, path, grid, pathList); // 往下
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        /*int[][] grid = new int[][]{
                {5, 4, 2, 9, 6, 0, 3, 5, 1, 4, 9, 8, 4, 9, 7, 5, 1},
                {3, 4, 9, 2, 9, 9, 0, 9, 7, 9, 4, 7, 8, 4, 4, 5, 8},
                {6, 1, 8, 9, 8, 0, 3, 7, 0, 9, 8, 7, 4, 9, 2, 0, 1},
                {4, 0, 0, 5, 1, 7, 4, 7, 6, 4, 1, 0, 1, 0, 6, 2, 8},
                {7, 2, 0, 2, 9, 3, 4, 7, 0, 8, 9, 5, 9, 0, 1, 1, 0},
                {8, 2, 9, 4, 9, 7, 9, 3, 7, 0, 3, 6, 5, 3, 5, 9, 6},
                {8, 9, 9, 2, 6, 1, 2, 5, 8, 3, 7, 0, 4, 9, 8, 8, 8},
                {5, 8, 5, 4, 1, 5, 6, 6, 3, 3, 1, 8, 3, 9, 6, 4, 8},
                {0, 2, 2, 3, 0, 2, 6, 7, 2, 3, 7, 3, 1, 5, 8, 1, 3},
                {4, 4, 0, 2, 0, 3, 8, 4, 1, 3, 3, 0, 7, 4, 2, 9, 8},
                {5, 9, 0, 4, 7, 5, 7, 6, 0, 8, 3, 0, 0, 6, 6, 6, 8},
                {0, 7, 1, 8, 3, 5, 1, 8, 7, 0, 2, 9, 2, 2, 7, 1, 5},
                {1, 0, 0, 0, 6, 2, 0, 0, 2, 2, 8, 0, 9, 7, 0, 8, 0},
                {1, 1, 7, 2, 9, 6, 5, 4, 8, 7, 8, 5, 0, 3, 8, 1, 5},
                {8, 9, 7, 8, 1, 1, 3, 0, 1, 2, 9, 4, 0, 1, 5, 3, 1},
                {9, 2, 7, 4, 8, 7, 3, 9, 2, 4, 2, 2, 7, 8, 2, 6, 7},
                {3, 8, 1, 6, 0, 4, 8, 9, 8, 0, 2, 5, 3, 5, 5, 7, 5},
                {1, 8, 2, 5, 7, 7, 1, 9, 9, 8, 9, 2, 4, 9, 5, 4, 0},
                {3, 4, 4, 1, 5, 3, 3, 8, 8, 6, 3, 5, 3, 8, 7, 1, 3}};*/
        MinimumPathSumSolution solution = new MinimumPathSumSolution();
        System.out.println(solution.minPathSum(grid));
    }
}
