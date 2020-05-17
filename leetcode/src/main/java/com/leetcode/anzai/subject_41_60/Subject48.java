package com.leetcode.anzai.subject_41_60;

/**
 * ��תͼ��
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class Subject48 {

    /**
     *
     ����һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��

     ��ͼ��˳ʱ����ת 90 �ȡ�

     ˵����

     �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��

     ʾ�� 1:

     ���� matrix =
     [
     [1,2,3],
     [4,5,6],
     [7,8,9]
     ],

     // �۲�����ת��
     00 01 02
     10 11 12
     20 21 22

     20 10 00
     21 11 01
     22 12 02

     00 - 02 - 22 - 20 - 00

     ԭ����ת�������ʹ���Ϊ:
     [
     [7,4,1],
     [8,5,2],
     [9,6,3]
     ]
     ʾ�� 2:

     ���� matrix =
     [
     [ 5, 1, 9,11],
     [ 2, 4, 8,10],
     [13, 3, 6, 7],
     [15,14,12,16]
     ],

     // ��һ��
     00 - 03 - 33 - 30 - 00
     01 - 13 - 32 - 20 - 01
     02 - 23 - 31 - 10 - 02

     // �ڶ���
     11 - 12 - 22 - 21 - 11

     ԭ����ת�������ʹ���Ϊ:
     [
     [15,13, 2, 5],
     [14, 3, 4, 1],
     [12, 6, 8, 9],
     [16, 7,10,11]
     ]
     *
     */

    /**
     * ��ʼ˼·����������һ��һ�����ת
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int count;
        // ��������һ��һ�����ת
        for (int i = 0; i < matrix.length / 2; i++) { // i �ǵ�ǰ�ڼ����������磺4x4����ֻ�����㣬3x3ֻ��һ��
            count = matrix.length - i * 2 - 1; // �� i ���Ԫ�ظ���(��Ҫ��ת�ģ�����һ��4��Ԫ�أ���ֻ��3����Ҫ��ת�ģ����Լ�һ)
            for (int j = 0; j < count; j++) {
                // 4x4������仯 �ο���
                // ��һ�㣺
                //     00 - 03 - 33 - 30 - 00
                //     01 - 13 - 32 - 20 - 01
                //     02 - 23 - 31 - 10 - 02
                // �ڶ��㣺
                //     11 - 12 - 22 - 21 - 11

                //     33 - 34 - 44 - 43 - 33

                // ÿһ��Ԫ�ع̶��任����
                // ��һ��:�й̶��� nums[i][j] �� nums[j][i + count]����
                swap(matrix, i, i + j, i + j, i + count);

                // �ڶ��Σ��й̶���nums[i][j] �� nums[i + count][i + count - j]����
                swap(matrix, i, i + j, i + count, i + count - j);

                // �����Σ��й̶���nums[i][j] �� nums[i + count][j]����
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

        System.out.println("��ʼ��");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        Subject48 subject = new Subject48();
        subject.rotate(matrix);

        System.out.println("��ת��");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
