package com.leetcode.anzai.subject_61_80;

/**
 * ��ͬ·��
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Subject62 {

    /**
     *
     һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

     ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

     ���ܹ��ж�������ͬ��·����

     subject_62.png

     ���磬��ͼ��һ��7 x 3 �������ж��ٿ��ܵ�·����

     ˵����m?�� n ��ֵ�������� 100��

     ʾ��?1:

     ����: m = 3, n = 2
     ���: 3
     ����:
     �����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
     1. ���� -> ���� -> ����
     2. ���� -> ���� -> ����
     3. ���� -> ���� -> ����
     ʾ��?2:

     ����: m = 7, n = 3
     ���: 28
     *
     */

    /**
     * ��̬�滮����1.���ݻ����㷨��״̬��Ѱ���ظ������⣻2.�г�״̬ת�Ʒ��̣�3.����ɴ���
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // ״̬ת�Ʒ��̣�f(m,n) = f(m-1,n) + f(m,n-1)
        // ������԰�����ת����������
        int[][] result = new int[m][n];
        result[0][0] = 1;
        // ��ʼ����һ��
        for (int i = 1; i < m; i++) {
            result[i][0] = 1;
        }
        // ��ʼ����һ��
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
     * �����㷨����ϧ��ʱ�ˣ�Ҫ���ϱ���¼����
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
     * ���ݣ����������
     *
     * @param column
     * @param row
     * @param m
     * @param n
     */
    private void uniquePathsInternal(int column, int row, int m, int n, int[][] result) {
        // ��û�м����������¼
        if (result[column][row] == 0) {

            int down = 0;
            int right = 0;
            // ����
            if (row < n) {
                uniquePathsInternal(column, row + 1, m, n, result);
                down = result[column][row + 1];
            }
            // ����
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
