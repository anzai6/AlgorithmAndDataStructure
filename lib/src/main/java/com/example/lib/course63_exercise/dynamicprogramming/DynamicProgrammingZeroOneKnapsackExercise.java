package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * 0-1��������̬�滮�㷨
 */

public class DynamicProgrammingZeroOneKnapsackExercise {

    // 0-1��������n��������ѡ������װ�뱳��������������W�����岻�ɷָ����װ������������������ֵ
    int maxPackW = 150; // ����������
    int n = 10; // 10������
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // �±��Ӧ���壬ֵ�����������

    /**
     * �󱳰�װ����Ʒ�����������ֵ:��̬�滮���԰�
     *
     * @return
     */
    public int dynamicProgramming() {
        boolean[][] packResult = new boolean[n][maxPackW + 1]; // ��Ӧ��������
        packResult[0][packW[0]] = true; // ��һ������װ��ȥ
        packResult[0][0] = true; // ��һ�����岻װ��ȥ
        for (int i = 1; i < n; i++) {
            int thingW = packW[i];  // ��������
            for (int j = maxPackW; j >= 0; j--) {
                if (packResult[i - 1][j]) { // װ������
                    packResult[i][j] = true; // ��װ��ȥ
                    if (thingW + j <= maxPackW) // ����װ��ȥ
                        packResult[i][j + thingW] = true;
                }

            }
        }

        int maxW = -1; // �洢��������Ʒ�����������ֵ

        for (int i = maxPackW; i >= 0; i--) {
            if (packResult[n - 1][i]) { // ���ֵ
                maxW = i;
                break;
            }
        }

        // �����ÿ������װ���߲�װ
        int rest = maxW;
        for (int i = n - 1; i >= 1; i--) {
            if (rest >= packW[i] && packResult[i - 1][rest - packW[i]]) { // װ
                rest -= packW[i];
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

        // ��һ��
        if (rest == packW[0] && packResult[0][packW[0]]) { // װ
            System.out.print("1 ");
        } else {
            System.out.print("0 ");
        }
        System.out.println();
        return maxW;
    }

    /**
     * �󱳰�װ����Ʒ�����������ֵ:��̬�滮��ʡ��
     *
     * @return
     */
    public int dynamicProgramming2() {
        boolean[] packResult = new boolean[maxPackW + 1]; // ��Ӧ��������
        packResult[packW[0]] = true; // ��һ������װ��ȥ
        packResult[0] = true; // ��һ�����岻װ��ȥ
        for (int i = 1; i < n; i++) {
            int thingW = packW[i];  // ��������
            for (int j = maxPackW; j >= 0; j--) {
                if (packResult[j]) { // װ������
                    if (thingW + j <= maxPackW) // ����װ��ȥ
                        packResult[j + thingW] = true;
                }

            }
        }

        int maxW = -1; // �洢��������Ʒ�����������ֵ

        for (int i = maxPackW; i >= 0; i--) {
            if (packResult[i]) { // ���ֵ
                maxW = i;
                break;
            }
        }

        return maxW;
    }


    public static void main(String[] args) {
        DynamicProgrammingZeroOneKnapsackExercise exercise = new DynamicProgrammingZeroOneKnapsackExercise();
        System.out.println("" + exercise.dynamicProgramming2());
    }
}
