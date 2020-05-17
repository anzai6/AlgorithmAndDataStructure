package com.leetcode.anzai.subject_61_80;

/**
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Subject74 {

    /**
     *
     编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

     每行中的整数从左到右按升序排列。
     每行的第一个整数大于前一行的最后一个整数。
     示例 1:

     输入:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 3
     输出: true
     示例 2:

     输入:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 13
     输出: false
     *
     */

    /**
     * 用二分搜索
     * 先从第一列搜到最后一个小于 target 的值的下标，然后在这一行搜 target
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length - 1;
        int targetRow = -1;
        int center = -1;

        // 二分搜索第一列,找到最后一个小于 target 的行号
        while (low <= high) {
            center = low + (high - low) / 2; // 改为减法防止溢出

            if (matrix[center][0] > target) { // 大于
                high = center - 1;
            } else if (matrix[center][0] < target) { // 小于
                // 找到最后一个小于 target 的行号
                if (center < matrix.length - 1 && matrix[center + 1][0] > target) {
                    high = center;
                    break;
                } else {
                    low = center + 1;
                }
            } else { // 等于
                return true;
            }
        }
        targetRow = high;

        if (targetRow < 0 || targetRow >= matrix.length) {
            return false;
        }

        // 二分搜索 targetRow 行
        low = 0;
        high = matrix[targetRow].length - 1;
        while (low <= high) {
            center = low + (high - low) / 2; // 改为减法防止溢出

            if (matrix[targetRow][center] > target) { // 大于
                high = center - 1;
            } else if (matrix[targetRow][center] < target) { // 小于
                low = center + 1;
            } else { // 等于
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}
//        };
//        int[][] matrix = new int[][]{{1}};
        int[][] matrix = new int[][]{};
        Subject74 subject = new Subject74();

        System.out.println(subject.searchMatrix(matrix, 13));
        int a = Test.T;
        int b = Test.S;
    }

    static class Test {
        public final static int T = 1;
        public static int S = 1;

        static {
            System.out.println("初始化");
        }
    }

}
