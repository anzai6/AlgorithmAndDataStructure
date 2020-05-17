package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Subject54 {

    /**
     *
     ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�

     ʾ��?1:

     ����:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     ���: [1,2,3,6,9,8,7,4,5]
     ʾ��?2:

     ����:
     [
     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     ]
     ���: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     */

    /**
     * �����������õݹ飬һ��һ��Ĵ�ӡ
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
     * �ݹ��ӡ��ǰһ�������
     * ��ʼ���÷�ʽ�� spiralOrderInternal(matrix, 0, matrix.length-1, 0, matrix[0].length-1)
     *
     * @param matrix
     * @param startRow    Ҫ��ӡ�ĵ�һ��
     * @param endRow      Ҫ��ӡ������һ��
     * @param startColumn Ҫ��ӡ�ĵ�һ��
     * @param endColumn   Ҫ��ӡ�����һ��
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
        // ���������ֻ��һ��
        if (startRow == endRow) {
            for (int i = startColumn; i <= endColumn; i++) {
                list.add(matrix[startRow][i]);
            }
            return; // �����ٵݹ���
        }
        // ���������ֻ��һ��
        if (startColumn == endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                list.add(matrix[i][startColumn]);
            }
            return; // �����ٵݹ���
        }

        // ��ӡ��һ��
        for (int i = startColumn; i <= endColumn; i++) {
            list.add(matrix[startRow][i]);
        }
        // ��ӡ���һ��
        for (int i = startRow + 1; i <= endRow; i++) {
            list.add(matrix[i][endColumn]);
        }
        // ��ӡ���һ��
        for (int i = endColumn - 1; i >= startColumn; i--) {
            list.add(matrix[endRow][i]);
        }
        // ��ӡ��һ��
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            list.add(matrix[i][startColumn]);
        }
        // ��ӡ��һ��
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
