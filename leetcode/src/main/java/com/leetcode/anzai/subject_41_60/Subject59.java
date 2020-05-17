package com.leetcode.anzai.subject_41_60;

/**
 * �������� II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class Subject59 {

    /**
     *
     ����һ��������?n������һ������ 1 ��?n^2?����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���

     ʾ��:

     ����: 3
     ���:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]
     *
     */

    /**
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        generateMatrixInternal(result, 0, n - 1, 0, n - 1, 1);
        return result;
    }

    /**
     * �ݹ鸳ֵ��ǰһ�������
     * ��ʼ���÷�ʽ�� generateMatrixInternal(matrix, 0, matrix.length-1, 0, matrix[0].length-1,1)
     *
     * @param matrix
     * @param startRow    Ҫ��ֵ�ĵ�һ��
     * @param endRow      Ҫ��ֵ������һ��
     * @param startColumn Ҫ��ֵ�ĵ�һ��
     * @param endColumn   Ҫ��ֵ�����һ��
     * @return
     */
    public void generateMatrixInternal(int[][] matrix, int startRow, int endRow, int startColumn, int endColumn, int value) {
        if (startRow > endRow || startColumn > endColumn) {
            return;
        }
        if (endRow < 0 || startRow > matrix.length - 1) {
            return;
        }
        if (endColumn < 0 || startColumn > matrix[0].length - 1) {
            return;
        }
        // ���������ֻ��һ��
        if (startRow == endRow) {
            for (int i = startColumn; i <= endColumn; i++) {
                matrix[startRow][i] = value;
                value++;
            }
            return; // �����ٵݹ���
        }
        // ���������ֻ��һ��
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][startColumn] = value;
                value++;
            }
            return; // �����ٵݹ���
        }

        // ��ֵ��һ��
        for (int i = startColumn; i <= endColumn; i++) {
            matrix[startRow][i] = value;
            value++;
        }
        // ��ֵ���һ��
        for (int i = startRow + 1; i <= endRow; i++) {
            matrix[i][endColumn] = value;
            value++;
        }
        // ��ֵ���һ��
        for (int i = endColumn - 1; i >= startColumn; i--) {
            matrix[endRow][i] = value;
            value++;
        }
        // ��ֵ��һ��
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            matrix[i][startColumn] = value;
            value++;
        }
        // ��ֵ��һ��
        generateMatrixInternal(matrix, startRow + 1, endRow - 1, startColumn + 1, endColumn - 1, value);
    }

    public static void main(String[] args) {
        int[][] result = null;
        Subject59 subject = new Subject59();
        result = subject.generateMatrix(6);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
