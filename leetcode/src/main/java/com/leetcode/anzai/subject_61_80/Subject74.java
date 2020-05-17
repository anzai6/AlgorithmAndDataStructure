package com.leetcode.anzai.subject_61_80;

/**
 * ������ά����
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Subject74 {

    /**
     *
     ��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�

     ÿ���е����������Ұ��������С�
     ÿ�еĵ�һ����������ǰһ�е����һ��������
     ʾ�� 1:

     ����:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 3
     ���: true
     ʾ�� 2:

     ����:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 13
     ���: false
     *
     */

    /**
     * �ö�������
     * �ȴӵ�һ���ѵ����һ��С�� target ��ֵ���±꣬Ȼ������һ���� target
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

        // ����������һ��,�ҵ����һ��С�� target ���к�
        while (low <= high) {
            center = low + (high - low) / 2; // ��Ϊ������ֹ���

            if (matrix[center][0] > target) { // ����
                high = center - 1;
            } else if (matrix[center][0] < target) { // С��
                // �ҵ����һ��С�� target ���к�
                if (center < matrix.length - 1 && matrix[center + 1][0] > target) {
                    high = center;
                    break;
                } else {
                    low = center + 1;
                }
            } else { // ����
                return true;
            }
        }
        targetRow = high;

        if (targetRow < 0 || targetRow >= matrix.length) {
            return false;
        }

        // �������� targetRow ��
        low = 0;
        high = matrix[targetRow].length - 1;
        while (low <= high) {
            center = low + (high - low) / 2; // ��Ϊ������ֹ���

            if (matrix[targetRow][center] > target) { // ����
                high = center - 1;
            } else if (matrix[targetRow][center] < target) { // С��
                low = center + 1;
            } else { // ����
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
            System.out.println("��ʼ��");
        }
    }

}
