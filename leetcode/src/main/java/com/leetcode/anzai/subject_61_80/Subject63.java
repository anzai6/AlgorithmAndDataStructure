package com.leetcode.anzai.subject_61_80;

/**
 * ��ͬ·��
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Subject63 {

    /**
     *
     һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

     ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

     ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����

     subject_62.png

     �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��

     ˵����m?�� n ��ֵ�������� 100��

     ʾ��?1:

     ����:
     [
     ? [0,0,0],
     ? [0,1,0],
     ? [0,0,0]
     ]
     ���: 2
     ����:
     3x3 ��������м���һ���ϰ��
     �����Ͻǵ����½�һ���� 2 ����ͬ��·����
     1. ���� -> ���� -> ���� -> ����
     2. ���� -> ���� -> ���� -> ����
     *
     */

    /**
     * ��̬�滮����1.���ݻ����㷨��״̬��Ѱ���ظ������⣻2.�г�״̬ת�Ʒ��̣�3.����ɴ���
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
        // ״̬ת�Ʒ��̣�f(m,n) = f(m-1,n) + f(m,n-1)
        // ������԰�����ת����������
        obstacleGrid[0][0] = 1;
        // ��ʼ����һ��
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) { // �ϰ����0
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        // ��ʼ����һ��
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) { // �ϰ����0
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
     * �����㷨����ϧ��ʱ�ˣ�Ҫ���ϱ���¼���У����ϱ���¼���ǳ�ʱ��......��
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
     * ���ݣ����������
     *
     * @param column
     * @param row
     * @param m
     * @param n
     */
    private void uniquePathsWithObstaclesInternal(int column, int row, int m, int n, int[][] result, int[][] obstacleGrid) {
        if (result[column][row] != 0 || obstacleGrid[column][row] == 1) {// �����(����¼)�������ϰ���
            return;
        }

        if (column == m && row == n) {
            result[column][row] = 1;
            return;
        }

        int down = 0;
        int right = 0;
        // ����
        if (row < n) {
            uniquePathsWithObstaclesInternal(column, row + 1, m, n, result, obstacleGrid);
            down = result[column][row + 1];
        }
        // ����
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
