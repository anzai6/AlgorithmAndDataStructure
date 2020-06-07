package com.example.lib.course38_backtracking.my;

/**
 * �����㷨
 * Created by qinshunan on 2019/5/7.
 */

public class MyBacktrackingAlgorithm {


    //            * * * * * * * Q
    //            * Q * * * * * *
    //            * * * * Q * * *
    //            * * Q * * * * *
    //            Q * * * * * * *
    //            * * * * * * Q *
    //            * * * Q * * * *
    //            * * * * * Q * *
    // �˻ʺ󣺰��а������������̣�����˸����ӣ�ÿ�������������Һ���ֱ�߲��������ӣ������Խ���Ҳ����������
    // �����㷨���ӵ�һ�е��ڰ������ΰڷ����ӣ�ÿһ��ÿһ��ֻ����һ�����ӣ��Խ����жϿ���ֻ�ж��Ѿ��ڷŵ����ӣ����϶Խ��ߵ�����
    int len = 8;
    int[] result = new int[len]; // �±��ʾ�У�ֵ��ʾ���ӷ�����һ��
    boolean isComplete = false; // ��ֹ����

    /**
     * ͨ��findEightQueens(0)��ʼһ��һ�еı����ҵ����ʰڷ����ӵ�λ�ã������������
     *
     * @param row ��
     */
    public void findEightQueens(int row) {
        if (row == 0)
            isComplete = false;

        if (row == 8) { // �ڷ����
            isComplete = true;
            printQueens(result);
            return;
        }

        for (int column = 0; column < len; column++) {
//            if (isComplete) // �ڷ���ɺ�ص�����ѭ��,���ҵ�һ���⼴��
//                return;
            if (isOk(row, column)) { // ��ʾ�ܹ��ڷ�
                result[row] = column; // �ڷ�
                findEightQueens(row + 1); // �ڷ���һ�е�����
            }
        }
    }

    /**
     * �����Ѱڷŵ����ӣ��ж���row��column�аڷ������Ƿ����
     *
     * @param row    ��
     * @param column ��
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftUpDiagonalAngle = column - 1; // ���϶Խ��ߵ�ֵ
        int rightUpDiagonalAngle = column + 1; // ���϶Խ��ߵ�ֵ

        for (int i = row - 1; i >= 0; i--) { // �����ݼ���������ǰ���Ѱڷźõ������ж��°ڷŵ�λ��row�Ƿ����
            if (result[i] == column) // ͬһ�еĲ�����
                return false;

            if (leftUpDiagonalAngle >= 0 && result[i] == leftUpDiagonalAngle) // �����϶Խ�����Ҳ������
                return false;

            if (rightUpDiagonalAngle < 8 && result[i] == rightUpDiagonalAngle) // �����¶Խ�����Ҳ������
                return false;

            --leftUpDiagonalAngle;
            ++rightUpDiagonalAngle;
        }
        return true;
    }


    private void printQueens(int[] result) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == result[i])
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 0-1��������n��������ѡ������װ�뱳��������������W�����岻�ɷָ����װ������������������ֵ
    int maxW = -1; // �洢��������Ʒ�����������ֵ
    int maxPackW = 150; // ����������
    int n = 10; // 10������
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // �±��Ӧ���壬ֵ�����������
    int[] packResult = new int[n]; // �±��Ӧ���壬ֵ�Ǵ��������Ƿ�װ��ȥ��0��װ��1 װ
    public int[] maxResult = new int[n]; // ��Ӧ��������Ľ��

    /**
     * pretendPack(0,0)����
     *
     * @param i  ��ǰ�ǵڼ�������
     * @param cw �Ѿ�װ�������������������
     */
    public void pretendPack(int i, int cw) {
        if (i == 0) {
            maxW = -1;
        }

        if (i == n || cw == maxPackW) { // ���������Ѿ�ѡ����ϻ��߱����Ѿ�װ��
            if (cw > maxW) {
                maxW = cw;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }
        packResult[i] = 0;
        pretendPack(i + 1, cw); // ��ǰ����û��װ��ȥ��ֱ�ӽ�����һ������
        if (cw + packW[i] <= maxPackW) { // ��ǰ����װ��ȥ���ᳬ��
            packResult[i] = 1;
            pretendPack(i + 1, cw + packW[i]);
        }
    }

    private void printPackResult() {
        for (int i = 0; i < maxResult.length; i++) {
            System.out.print(maxResult[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // �˻ʺ�����
        MyBacktrackingAlgorithm myBacktrackingAlgorithm = new MyBacktrackingAlgorithm();
//        myBacktrackingAlgorithm.findEightQueens(0);

        myBacktrackingAlgorithm.pretendPack(0, 0);
        myBacktrackingAlgorithm.printPackResult();
        System.out.println("maxW: " + myBacktrackingAlgorithm.maxW);
    }
}
