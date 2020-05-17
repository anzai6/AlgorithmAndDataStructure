package com.leetcode.anzai.subject_41_60;

/**
 * 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class Subject59 {

    /**
     *
     给定一个正整数?n，生成一个包含 1 到?n^2?所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

     示例:

     输入: 3
     输出:
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
     * 递归赋值当前一层的数字
     * 初始调用方式： generateMatrixInternal(matrix, 0, matrix.length-1, 0, matrix[0].length-1,1)
     *
     * @param matrix
     * @param startRow    要赋值的第一行
     * @param endRow      要赋值最后最后一行
     * @param startColumn 要赋值的第一列
     * @param endColumn   要赋值的最后一列
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
        // 特殊情况：只有一行
        if (startRow == endRow) {
            for (int i = startColumn; i <= endColumn; i++) {
                matrix[startRow][i] = value;
                value++;
            }
            return; // 不用再递归了
        }
        // 特殊情况：只有一列
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][startColumn] = value;
                value++;
            }
            return; // 不用再递归了
        }

        // 赋值第一行
        for (int i = startColumn; i <= endColumn; i++) {
            matrix[startRow][i] = value;
            value++;
        }
        // 赋值最后一列
        for (int i = startRow + 1; i <= endRow; i++) {
            matrix[i][endColumn] = value;
            value++;
        }
        // 赋值最后一行
        for (int i = endColumn - 1; i >= startColumn; i--) {
            matrix[endRow][i] = value;
            value++;
        }
        // 赋值第一列
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            matrix[i][startColumn] = value;
            value++;
        }
        // 赋值下一层
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
