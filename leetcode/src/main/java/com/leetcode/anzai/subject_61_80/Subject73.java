package com.leetcode.anzai.subject_61_80;

import java.util.Arrays;

/**
 * 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class Subject73 {

    /**
     *
     给定一个  m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

     示例  1:

     输入:
     [
     [1,1,1],
     [1,0,1],
     [1,1,1]
     ]
     输出:
     [
     [1,0,1],
     [0,0,0],
     [1,0,1]
     ]
     示例  2:

     输入:
     [
     [0,1,2,0],
     [3,4,5,2],
     [1,3,1,5]
     ]
     输出:
     [
     [0,0,0,0],
     [0,4,5,0],
     [0,3,1,0]
     ]

     进阶:

     一个直接的解决方案是使用   O(mn)  的额外空间，但这并不是一个好的解决方案。
     一个简单的改进方案是使用 O(m  +  n) 的额外空间，但这仍然不是最好的解决方案。
     你能想出一个常数空间的解决方案吗？
     *
     */

    /**
     * 初步想法：遍历数组，遇到第一个0的时候，把这个0所在的行和列当做转态记录的行和列，
     * 之后遍历到其它的0时，把这个最新的0对应的行和列的下标映射到转态记录的行和列中，即将转态记录的行和列中相应的下标置为0，
     * 最后再遍历一遍数组赋值0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // 第一个，将 i 和 j 赋值给状态记录的 row 和 column
                    if (row == -1 && column == -1) {
                        row = i;
                        column = j;
                    } else {
                        matrix[row][j] = 0; // 将状态记录的行对应的列的值赋0
                        matrix[i][column] = 0;  // 将状态记录的列对应的行的值赋0
                    }
                }
            }
        }

        if (row == -1 || column == -1) {
            return;
        }
        // 再一次遍历，根据状态记录的行和列赋值
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) { // 先跳过状态行，省得赋值后影响后面的判断
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == column) { // 先跳过状态列，省得赋值后影响后面的判断
                    continue;
                }
                if (matrix[row][j] == 0 || matrix[i][column] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后才是状态行和列置的值为0
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }

    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
//        int[][] matrix = new int[][]{
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
        int[][] matrix = new int[][]{{1}};
        Subject73 subject = new Subject73();
        subject.setZeroes(matrix);
        if (matrix == null || matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
