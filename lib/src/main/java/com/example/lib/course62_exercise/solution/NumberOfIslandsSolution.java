package com.example.lib.course62_exercise.solution;

/**
 * ����ĸ���
 * https://leetcode-cn.com/problems/number-of-islands/description/
 */

public class NumberOfIslandsSolution {

    /**
     *
     ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������
     һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�
     ����Լ���������ĸ��߾���ˮ��Χ��

     ʾ�� 1:

     ����:
     11110
     11010
     11000
     00000

     ���:?1

     ʾ��?2:

     ����:
     11000
     11000
     00100
     00011

     ���: 3

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
     * ���Ѽ�ǿ�棬���������ұ����Ľⷨ���Ƚϼ�
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
     * �Ӻ�����������Ľⷨ���ȽϷ����鷳���˱Ƶ���
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length; // ��
        int column = grid[0].length; // ��
        boolean[][] visited = new boolean[row][column];  // ��¼���ʹ��ĵ�
        int count = 0; // �������
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!visited[i][j]) { // û�з��ʹ�
                    visited[i][j] = true;
                    if (grid[i][j] == '1') { // ����һ��½��
                        scan(grid, visited, i, j); // �����и����½������������½����Ϊ�Ѿ����ʹ�,���Ӻ��������ɨ��
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void scan(char[][] grid, boolean[][] visited, int row, int column) {
        scanRow(grid, visited, row, column); // �����и����½������������½����Ϊ�Ѿ����ʹ�,���Ӻ��������ɨ��
        scanColumn(grid, visited, row, column); // �����и����½������������½����Ϊ�Ѿ����ʹ�,���Ӻ��������ɨ��
    }

    /**
     * ��������grid[row][column]����������½��,�Ӻ���ɨ��
     *
     * @param grid
     * @param visited
     * @param row
     * @param column
     */
    private void scanRow(char[][] grid, boolean[][] visited, int row, int column) {
        // ����ɨ�裬��һ��һ��ɨ��
        for (int i = column; i < grid[row].length; i++) {
            if (grid[row][i] == '0') {// ��������ˮ��ֹͣ����
                visited[row][i] = true;
                break;
            }

            if (!visited[row][i]) { // û�з��ʹ�
                visited[row][i] = true;
                if (grid[row][i] == '1') { // ����½�أ�ɨ��½�ص��µ����ж���
                    scan(grid, visited, row, i);
                } else // ��������ˮ��ֹͣ����
                    break;
            }
        }
        // ����ɨ�裬��һ��һ��ɨ��
        for (int i = column - 1; i >= 0; i--) {
            if (grid[row][i] == '0') {// ��������ˮ��ֹͣ����
                visited[row][i] = true;
                break;
            }

            if (!visited[row][i]) { // û�з��ʹ�
                visited[row][i] = true;
                if (grid[row][i] == '1') { // ����½�أ�ɨ��½�ص��µ����ж���
                    scan(grid, visited, row, i);
                } else // ��������ˮ��ֹͣ����
                    break;
            }
        }
    }

    /**
     * ��������grid[row][column]����������½��,�Ӻ�����ɨ��
     *
     * @param grid
     * @param visited
     * @param row
     * @param column
     */
    private void scanColumn(char[][] grid, boolean[][] visited, int row, int column) {
        // ����ɨ�裬��һ��һ��ɨ��
        for (int i = row; i < grid.length; i++) {
            if (grid[i][column] == '0') {// ��������ˮ��ֹͣ����
                visited[i][column] = true;
                break;
            }

            if (!visited[i][column]) { // û�з��ʹ�
                visited[i][column] = true;
                if (grid[i][column] == '1') { // ����½�أ�ɨ��½�ص��µ����ж���
                    scan(grid, visited, i, column);
                } else // ��������ˮ��ֹͣ����
                    break;
            }
        }

        // ����ɨ�裬��һ��һ��ɨ��
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][column] == '0') {// ��������ˮ��ֹͣ����
                visited[i][column] = true;
                break;
            }

            if (!visited[i][column]) { // û�з��ʹ�
                visited[i][column] = true;
                if (grid[i][column] == '1') { // ����½�أ�ɨ��½�ص��µ����ж���
                    scan(grid, visited, i, column);
                } else // ��������ˮ��ֹͣ����
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
