package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * ���ʵ��һ���������е������������
 */

public class LongestIncrementalSubsequenceExercise {

    // ������һ���������а��� n ����ͬ�����֣���������������е�����������г��ȣ�
    // ���� 2, 9, 3, 6, 5, 1, 7 ����һ���������У���������������о��� 2, 3, 5, 7��
    // ��������������еĳ����� 4��

    int[] list = new int[]{2, 9, 3, 6, 5, 1, 7};
    int n = list.length;
    int maxSequenceLength = Integer.MIN_VALUE; // ����������г���

    private int getMaxSequence() {
//        lisBT(0, 0, -1);
//        return maxSequenceLength;
        return lisDP();
    }

    /**
     * �����㷨������ lisDP(0,0,-1);
     *
     * @param i              �ڼ�λ
     * @param sequenceLength ǰ��ĵ��������еĳ���
     * @param maxNum         ǰ��ĵ��������е����ֵ
     */
    private void lisBT(int i, int sequenceLength, int maxNum) {
        if (i == n) {
            if (maxSequenceLength < sequenceLength)
                maxSequenceLength = sequenceLength;
            return;
        }
        if (list[i] >= maxNum) // �����򳤶ȼ�һ
            lisBT(i + 1, sequenceLength + 1, list[i]);
        // ���Ƚ�ֱ����һλ
        lisBT(i + 1, sequenceLength, maxNum);
    }

    // ���ݹ�ʽ��f(i) : list[i] >= maxNum(ǰ��ĵ��������е����ֵ) -> f(i-1)+1
    // list[i] < maxNum(ǰ��ĵ��������е����ֵ) -> f(i-1)

    /**
     * ��̬�滮
     * @return
     */
    private int lisDP() {
        int[] result = new int[n]; // �±�index�ǵ��������еĳ��ȣ�ֵ�洢���ǵ��������еĳ���Ϊindex�����ֵ
        for (int i = 1; i < n; i++) {
            result[i] = -1;
        }
        result[0] = list[0];

        for (int i = 1; i < n; i++) {
            int item = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] < 0)
                    continue;
                int maxNum = result[j];

                if (j == 0 && item < maxNum) { // ��һ�����⴦��
                    result[j] = item;
                } else if (item >= maxNum) {
                    int next = result[j + 1];
                    if (next < 0 || next > item)
                        result[j + 1] = item;
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] > -1) {
                maxLength = i + 1;
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncrementalSubsequenceExercise exercise = new LongestIncrementalSubsequenceExercise();
        System.out.println("����������г��ȣ�" + exercise.getMaxSequence());
    }
}
