package com.leetcode.anzai.subject_61_80;

import java.util.Arrays;

/**
 * ��������
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class Subject73 {

    /**
     *
     ����һ��  m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��

     ʾ��  1:

     ����:
     [
     [1,1,1],
     [1,0,1],
     [1,1,1]
     ]
     ���:
     [
     [1,0,1],
     [0,0,0],
     [1,0,1]
     ]
     ʾ��  2:

     ����:
     [
     [0,1,2,0],
     [3,4,5,2],
     [1,3,1,5]
     ]
     ���:
     [
     [0,0,0,0],
     [0,4,5,0],
     [0,3,1,0]
     ]

     ����:

     һ��ֱ�ӵĽ��������ʹ��   O(mn)  �Ķ���ռ䣬���Ⲣ����һ���õĽ��������
     һ���򵥵ĸĽ�������ʹ�� O(m  +  n) �Ķ���ռ䣬������Ȼ������õĽ��������
     �������һ�������ռ�Ľ��������
     *
     */

    /**
     * �����뷨���������飬������һ��0��ʱ�򣬰����0���ڵ��к��е���ת̬��¼���к��У�
     * ֮�������������0ʱ����������µ�0��Ӧ���к��е��±�ӳ�䵽ת̬��¼���к����У�����ת̬��¼���к�������Ӧ���±���Ϊ0��
     * ����ٱ���һ�����鸳ֵ0
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
                    // ��һ������ i �� j ��ֵ��״̬��¼�� row �� column
                    if (row == -1 && column == -1) {
                        row = i;
                        column = j;
                    } else {
                        matrix[row][j] = 0; // ��״̬��¼���ж�Ӧ���е�ֵ��0
                        matrix[i][column] = 0;  // ��״̬��¼���ж�Ӧ���е�ֵ��0
                    }
                }
            }
        }

        if (row == -1 || column == -1) {
            return;
        }
        // ��һ�α���������״̬��¼���к��и�ֵ
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) { // ������״̬�У�ʡ�ø�ֵ��Ӱ�������ж�
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == column) { // ������״̬�У�ʡ�ø�ֵ��Ӱ�������ж�
                    continue;
                }
                if (matrix[row][j] == 0 || matrix[i][column] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // ������״̬�к����õ�ֵΪ0
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
