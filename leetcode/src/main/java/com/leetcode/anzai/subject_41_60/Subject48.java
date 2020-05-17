package com.leetcode.anzai.subject_41_60;

/**
 * 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class Subject48 {

    /**
     *
     给定一个 n?×?n 的二维矩阵表示一个图像。

     将图像顺时针旋转 90 度。

     说明：

     你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

     示例 1:

     给定 matrix =
     [
     [1,2,3],
     [4,5,6],
     [7,8,9]
     ],

     // 观察坐标转换
     00 01 02
     10 11 12
     20 21 22

     20 10 00
     21 11 01
     22 12 02

     00 - 02 - 22 - 20 - 00

     原地旋转输入矩阵，使其变为:
     [
     [7,4,1],
     [8,5,2],
     [9,6,3]
     ]
     示例 2:

     给定 matrix =
     [
     [ 5, 1, 9,11],
     [ 2, 4, 8,10],
     [13, 3, 6, 7],
     [15,14,12,16]
     ],

     // 第一层
     00 - 03 - 33 - 30 - 00
     01 - 13 - 32 - 20 - 01
     02 - 23 - 31 - 10 - 02

     // 第二层
     11 - 12 - 22 - 21 - 11

     原地旋转输入矩阵，使其变为:
     [
     [15,13, 2, 5],
     [14, 3, 4, 1],
     [12, 6, 8, 9],
     [16, 7,10,11]
     ]
     *
     */

    /**
     * 初始思路，从外往内一层一层的旋转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int count;
        // 从外往内一层一层的旋转
        for (int i = 0; i < matrix.length / 2; i++) { // i 是当前第几层数，比如：4x4，就只有两层，3x3只有一层
            count = matrix.length - i * 2 - 1; // 第 i 层的元素个数(需要旋转的，比如一行4个元素，那只有3个是要旋转的，所以减一)
            for (int j = 0; j < count; j++) {
                // 4x4的坐标变化 参考：
                // 第一层：
                //     00 - 03 - 33 - 30 - 00
                //     01 - 13 - 32 - 20 - 01
                //     02 - 23 - 31 - 10 - 02
                // 第二层：
                //     11 - 12 - 22 - 21 - 11

                //     33 - 34 - 44 - 43 - 33

                // 每一个元素固定变换三次
                // 第一次:列固定， nums[i][j] 和 nums[j][i + count]交换
                swap(matrix, i, i + j, i + j, i + count);

                // 第二次：行固定，nums[i][j] 和 nums[i + count][i + count - j]交换
                swap(matrix, i, i + j, i + count, i + count - j);

                // 第三次：列固定，nums[i][j] 和 nums[i + count][j]交换
                swap(matrix, i, i + j, i + count - j, i);
            }
        }
    }


    int centerValue;

    private void swap(int[][] nums, int i, int j, int toI, int toJ) {
        centerValue = nums[i][j];
        nums[i][j] = nums[toI][toJ];
        nums[toI][toJ] = centerValue;
    }

    public static void main(String[] args) {

//        int[][] matrix = new int[][]{{1}};
//        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        int[][] matrix = new int[n][n];
        int n = matrix.length;

        System.out.println("初始：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        Subject48 subject = new Subject48();
        subject.rotate(matrix);

        System.out.println("旋转后：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
