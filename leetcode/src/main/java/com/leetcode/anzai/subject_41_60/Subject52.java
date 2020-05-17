package com.leetcode.anzai.subject_41_60;

/**
 * N�ʺ� II
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class Subject52 {

    /**
     *
     n?�ʺ������о�������ν� n?���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������

     Subject51_8-queens.png

     ��ͼΪ 8 �ʺ������һ�ֽⷨ��

     ����һ������ n������ n �ʺ�ͬ�Ľ��������������

     ʾ��:

     ����: 4
     ���: 2
     ����: 4 �ʺ������������������ͬ�Ľⷨ��
     [
     ?[".Q..", ?// �ⷨ 1
     ? "...Q",
     ? "Q...",
     ? "..Q."],

     ?["..Q.", ?// �ⷨ 2
     ? "Q...",
     ? "...Q",
     ? ".Q.."]
     ]

     *
     */

    /**
     * ������������ʹ�û����㷨��
     * ��̬�滮�أ�������
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        count = 0;
        int[] result = new int[n]; // ���԰ڷŵĽ�����±��ʾ�У�ֵ��ʾ��
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        solveNQueensBtInternal(0, n, result);
        return count;
    }

    private int count = 0;

    /**
     * �����㷨��һ��һ�еı�����Ȼ�������������Ͻ����Ͻ��Ƿ���ֵ���ж��Ƿ�����
     *
     * @param row ��ǰ���ڵڼ��У�һ��ʼ���ô�0��ʼ
     * @param n
     * @return
     */
    public void solveNQueensBtInternal(int row, int n, int[] result) {
        if (n == row) { // ȡresult��ֵ�Ž�list
            ++count;
            return;
        }

        // ����row�е�����λ��
        for (int i = 0; i < n; i++) {
            if (canPut(row, i, result)) { // �ܷ�����
                result[row] = i; // ��ֵ
                solveNQueensBtInternal(row + 1, n, result); // ����һ��
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
        Subject52 subject = new Subject52();
        System.out.println(subject.totalNQueens(10));
    }

}
