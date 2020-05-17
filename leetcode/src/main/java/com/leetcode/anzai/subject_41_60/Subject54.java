package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Subject54 {

    /**
     *
     给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

     示例?1:

     输入:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     输出: [1,2,3,6,9,8,7,4,5]
     示例?2:

     输入:
     [
     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     ]
     输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     */

    /**
     * 初步分析利用递归，一层一层的打印
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        spiralOrderInternal(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, list);
        return list;
    }

    /**
     * 递归打印当前一层的数字
     * 初始调用方式： spiralOrderInternal(matrix, 0, matrix.length-1, 0, matrix[0].length-1)
     *
     * @param matrix
     * @param startRow    要打印的第一行
     * @param endRow      要打印最后最后一行
     * @param startColumn 要打印的第一列
     * @param endColumn   要打印的最后一列
     * @return
     */
    public void spiralOrderInternal(int[][] matrix, int startRow, int endRow, int startColumn, int endColumn, List<Integer> list) {
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
                list.add(matrix[startRow][i]);
            }
            return; // 不用再递归了
        }
        // 特殊情况：只有一列
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][startColumn]);
            }
            return; // 不用再递归了
        }

        // 打印第一行
        for (int i = startColumn; i <= endColumn; i++) {
            list.add(matrix[startRow][i]);
        }
        // 打印最后一列
        for (int i = startRow + 1; i <= endRow; i++) {
            list.add(matrix[i][endColumn]);
        }
        // 打印最后一行
        for (int i = endColumn - 1; i >= startColumn; i--) {
            list.add(matrix[endRow][i]);
        }
        // 打印第一列
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            list.add(matrix[i][startColumn]);
        }
        // 打印下一层
        spiralOrderInternal(matrix, startRow + 1, endRow - 1, startColumn + 1, endColumn - 1, list);
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 2, 3, 4}};
//        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}};
        int[][] matrix = new int[][]{{1}};
//        int[][] matrix = new int[][]{{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}};
//        int[][] matrix = new int[][]{{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
        Subject54 subject = new Subject54();
        List<Integer> list = subject.spiralOrder(matrix);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
        }
    }

}
