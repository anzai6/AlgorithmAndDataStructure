package com.example.lib.course63_exercise.backtracking;

/**
 * 0-1�����������㷨
 */

public class ZeroOneKnapsackExercise {

    // 0-1��������n��������ѡ������װ�뱳��������������W�����岻�ɷָ����װ������������������ֵ
    int maxW = -1; // �洢��������Ʒ�����������ֵ
    int maxPackW = 150; // ����������
    int n = 10; // 10������
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // �±��Ӧ���壬ֵ�����������
    int[] packResult = new int[n]; // �±��Ӧ���壬ֵ�Ǵ��������Ƿ�װ��ȥ��0��װ��1 װ
    public int[] maxResult = new int[n]; // ��Ӧ��������Ľ��

    /**
     * �󱳰�װ����Ʒ�����������ֵ
     *
     * @return
     */
    public int getZeroOneKnapsackMax() {
        zeroOneKnapsack(0, maxPackW);
        return maxW;
    }

    /**
     * �����i�������Ƿ���뱳��
     *
     * @param i
     * @param w ����ʣ�������
     */
    private void zeroOneKnapsack(int i, int w) {
        if (i >= 10 || w == 0) {
            int totalW = maxPackW - w; // ����������
            if (maxW < totalW) {
                maxW = totalW;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }
        int thingW = packW[i]; // ��i����������
        if (w >= thingW) {
            packResult[i] = 1;
            zeroOneKnapsack(i + 1, w - thingW); // ���뱳��
        }
        packResult[i] = 0;
        zeroOneKnapsack(i + 1, w); // �����뱳��
    }

    private void printPackResult() {
        for (int i = 0; i < maxResult.length; i++) {
            System.out.print(maxResult[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroOneKnapsackExercise exercise = new ZeroOneKnapsackExercise();
        System.out.println("" + exercise.getZeroOneKnapsackMax());
        exercise.printPackResult();
    }
}
