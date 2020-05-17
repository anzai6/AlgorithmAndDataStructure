package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * N�ʺ�
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Subject51 {

    /**
     *
     n?�ʺ������о�������ν� n?���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������

     Subject51_8-queens.png

     ��ͼΪ 8 �ʺ������һ�ֽⷨ��

     ����һ������ n���������в�ͬ�� n �ʺ�����Ľ��������

     ÿһ�ֽⷨ����һ����ȷ��?n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��

     ע�⣺����������ÿ�������������Һ���ֱ�߲��������ӣ������Խ���Ҳ����������

     ʾ��:

     ����: 4
     ���: [
     [".Q..",  // �ⷨ 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // �ⷨ 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     ����: 4 �ʺ��������������ͬ�Ľⷨ��
     *
     */

    /**
     * ������������ʹ�û����㷨��
     * ��̬�滮�أ�������
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }

        List<List<String>> list = new ArrayList<>();
        int[] result = new int[n]; // ���԰ڷŵĽ�����±��ʾ�У�ֵ��ʾ��
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        solveNQueensBtInternal(0, n, result, list);
        return list;
    }

    /**
     * �����㷨��һ��һ�еı�����Ȼ�������������Ͻ����Ͻ��Ƿ���ֵ���ж��Ƿ�����
     *
     * @param row ��ǰ���ڵڼ��У�һ��ʼ���ô�0��ʼ
     * @param n
     * @return
     */
    public void solveNQueensBtInternal(int row, int n, int[] result, List<List<String>> list) {
        if (n == row) { // ȡresult��ֵ�Ž�list
            List<String> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (result[i] == j) { // �ڷ�λ��
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                subList.add(sb.toString());
            }
            list.add(subList);
            return;
        }

        // ����row�е�����λ��
        for (int i = 0; i < n; i++) {
            if (canPut(row, i, result)) { // �ܷ�����
                result[row] = i; // ��ֵ
                solveNQueensBtInternal(row + 1, n, result, list); // ����һ��
                result[row] = -1; // ��ԭ
            } else { // �ж���һ��λ��
                continue;
            }
        }
    }

    /**
     * �жϸ�λ���Ƿ��ܷ�ֹ����
     *
     * @param row
     * @param column
     * @return
     */
    private boolean canPut(int row, int column, int[] result) {
        // �����ϽǴ���Խ��ߣ���Ϊ�����ֵ��ûȷ�������������½��ǲ����жϵ�
        int leftUpRadiusValue = column - 1; // ���Ͻ�
        int rightUpRadiusValue = column + 1; // ���Ͻ�

        // �� row-1 ����һ�п�ʼ�����ж�
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) { // ͬһ��
                return false;
            }
            if (leftUpRadiusValue == result[i]) {
                return false;
            }
            if (rightUpRadiusValue == result[i]) {
                return false;
            }
            leftUpRadiusValue--;
            rightUpRadiusValue++;
        }
        return true;
    }

    public static void main(String[] args) {
        Subject51 subject = new Subject51();
        List<List<String>> list = subject.solveNQueens(5);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j));
                System.out.println();
            }
            System.out.println("------------------------------");
        }
    }

}
