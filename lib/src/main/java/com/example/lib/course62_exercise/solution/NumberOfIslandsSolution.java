package com.example.lib.course62_exercise.solution;

/**
 * 岛屿的个数
 * https://leetcode-cn.com/problems/number-of-islands/description/
 */

public class NumberOfIslandsSolution {

    /**
     *
     给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
     一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
     你可以假设网格的四个边均被水包围。

     示例 1:

     输入:
     11110
     11010
     11000
     00000

     输出: 1

     示例 2:

     输入:
     11000
     11000
     00100
     00011

     输出: 3

     010
     101
     010

     [["0","1","0"],["1","0","1"],["0","1","0"]]

     ["1","1","1","1","1","1","1","1","1"],
     ["1","0","0","0","0","0","0","0","1"],
     ["1","0","1","0","1","0","1","0","1"],
     ["1","0","1","1","1","1","1","0","1"],
     ["1","0","1","0","1","0","1","0","1"],
     ["1","0","0","0","0","0","0","0","1"],
     ["1","1","1","1","1","1","1","1","1"],

     *
     */

    /**
     * 网友加强版，从上下左右遍历的解法，比较简单
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    bfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    void bfs(char[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
            grid[x][y] = '0';
            bfs(grid, x - 1, y);
            bfs(grid, x + 1, y);
            bfs(grid, x, y - 1);
            bfs(grid, x, y + 1);
        }
    }


    /**
     * 从横向纵向遍历的解法，比较繁琐麻烦，菜逼的我
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length; // 行
        int column = grid[0].length; // 列
        boolean[][] visited = new boolean[row][column];  // 记录访问过的点
        int count = 0; // 岛屿个数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j]) { // 没有访问过
                    visited[i][j] = true;
                    if (grid[i][j] == '1') { // 遇见一个陆地
                        scan(grid, visited, i, j); // 把所有跟这个陆地相连的其它陆地置为已经访问过,即从横向和纵向扫描
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void scan(char[][] grid, boolean[][] visited, int row, int column) {
        scanRow(grid, visited, row, column); // 把所有跟这个陆地相连的其它陆地置为已经访问过,即从横向和纵向扫描
        scanColumn(grid, visited, row, column); // 把所有跟这个陆地相连的其它陆地置为已经访问过,即从横向和纵向扫描
    }

    /**
     * 遍历顶点grid[row][column]的所有相邻陆地,从横向扫描
     *
     * @param grid
     * @param visited
     * @param row
     * @param column
     */
    private void scanRow(char[][] grid, boolean[][] visited, int row, int column) {
        // 横向扫描，即一行一行扫描
        for (int i = column; i < grid[row].length; i++) {
            if (grid[row][i] == '0') {// 横向遇到水就停止遍历
                visited[row][i] = true;
                break;
            }

            if (!visited[row][i]) { // 没有访问过
                visited[row][i] = true;
                if (grid[row][i] == '1') { // 遇见陆地，扫描陆地底下的所有顶点
                    scan(grid, visited, row, i);
                } else // 横向遇到水就停止遍历
                    break;
            }
        }
        // 横向扫描，即一列一列扫描
        for (int i = column - 1; i >= 0; i--) {
            if (grid[row][i] == '0') {// 横向遇到水就停止遍历
                visited[row][i] = true;
                break;
            }

            if (!visited[row][i]) { // 没有访问过
                visited[row][i] = true;
                if (grid[row][i] == '1') { // 遇见陆地，扫描陆地底下的所有顶点
                    scan(grid, visited, row, i);
                } else // 横向遇到水就停止遍历
                    break;
            }
        }
    }

    /**
     * 遍历顶点grid[row][column]的所有相邻陆地,从和纵向扫描
     *
     * @param grid
     * @param visited
     * @param row
     * @param column
     */
    private void scanColumn(char[][] grid, boolean[][] visited, int row, int column) {
        // 纵向扫描，即一列一列扫描
        for (int i = row; i < grid.length; i++) {
            if (grid[i][column] == '0') {// 横向遇到水就停止遍历
                visited[i][column] = true;
                break;
            }

            if (!visited[i][column]) { // 没有访问过
                visited[i][column] = true;
                if (grid[i][column] == '1') { // 遇见陆地，扫描陆地底下的所有顶点
                    scan(grid, visited, i, column);
                } else // 横向遇到水就停止遍历
                    break;
            }
        }

        // 纵向扫描，即一列一列扫描
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][column] == '0') {// 横向遇到水就停止遍历
                visited[i][column] = true;
                break;
            }

            if (!visited[i][column]) { // 没有访问过
                visited[i][column] = true;
                if (grid[i][column] == '1') { // 遇见陆地，扫描陆地底下的所有顶点
                    scan(grid, visited, i, column);
                } else // 横向遇到水就停止遍历
                    break;
            }
        }
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        char[][] grid = new char[][]{{'0', '1', '0'}, {'1', '0', '1'}, {'0', '1', '0'}};
//        char[][] grid = new char[][]{{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
//        char[][] grid = new char[][]{
//                {'1', '1', '1', '1', '1', '1', '1', '1', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '0', '1', '0', '1', '0', '1', '0', '1'},
//                {'1', '0', '1', '1', '1', '1', '1', '0', '1'},
//                {'1', '0', '1', '0', '1', '0', '1', '0', '1'},
//                {'1', '0', '0', '0', '0', '0', '0', '0', '1'},
//                {'1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        char[][] grid = new char[][]{
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'0', '0', '0', '0', '0'}};
        NumberOfIslandsSolution solution = new NumberOfIslandsSolution();
        System.out.println(solution.numIslands(grid));
    }
}
