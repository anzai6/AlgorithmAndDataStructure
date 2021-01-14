package com.example.lib.course38_backtracking.finals;

/**
 * �����㷨
 * Created by qinshunan on 2019/5/7.
 */

public class BacktrackingAlgorithm {


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

    public void findEightQueens() {
        for (int i = 0; i < len; i++) {
            result[i] = -1;
        }
        findEightQueens(0);
    }

    /**
     * ͨ��findEightQueens(0)��ʼһ��һ�еı����ҵ����ʰڷ����ӵ�λ�ã������������
     *
     * @param row ��
     */
    public void findEightQueens(int row) {
        if (row == 8) {
            isComplete = true;
            printQueens(result);
            return;
        }
        // ����ÿһ��
        for (int i = 0; i < len; i++) {
            if (isComplete) {
                return;
            }
            if (!isOk(row, i)) {
                continue;
            }
            result[row] = i;
            findEightQueens(row + 1);
            // ����
            result[row] = -1;
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
        // һ��һ�������ж����ϽǺ����Ͻ��Լ���ǰ��
        for (int i = row - 1; i >= 0; i--) {

            // ��ǰ���Ƿ��������
            if (result[i] == column) {
                return false;
            }

            // ���Ͻ�
            if (result[row - i] == column - i) {
                return false;
            }
            // ���Ͻ�
            if (row + i < len && result[row + i] == column + i) {
                return false;
            }
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
        if (i == n || cw == maxPackW) { // ���������Ѿ�ѡ����ϻ��߱����Ѿ�װ��
            if (cw > maxW) {
                maxW = cw;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }

        // ��װ������
        packResult[i] = 0;
        pretendPack(i + 1, cw);

        // װ������
        if (maxPackW >= cw + packW[i]) {
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
        BacktrackingAlgorithm myBacktrackingAlgorithm = new BacktrackingAlgorithm();
        myBacktrackingAlgorithm.findEightQueens();

        // 0-1 ��������
        myBacktrackingAlgorithm.pretendPack(0, 0);
        myBacktrackingAlgorithm.printPackResult();
        System.out.println("maxW: " + myBacktrackingAlgorithm.maxW);
    }
}
