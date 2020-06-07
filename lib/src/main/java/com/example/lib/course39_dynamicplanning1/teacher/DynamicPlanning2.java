package com.example.lib.course39_dynamicplanning1.teacher;

/**
 * ��̬�滮
 */
public class DynamicPlanning2 {

    // 0-1���������汾,��������,ÿ�����廹�м�ֵ,������ֵ
    private int maxV = Integer.MIN_VALUE; // ����ŵ� maxV ��
    private int[] items = {2, 2, 4, 6, 3};  // ��Ʒ������
    private int[] value = {3, 4, 8, 9, 6}; // ��Ʒ�ļ�ֵ
    private int n = 5; // ��Ʒ����
    private int w = 9; // �������ܵ��������

    public void f(int i, int cw, int cv) { // ���� f(0, 0, 0)
        if (cw == w || i == n) { // cw==w ��ʾװ����,i==n ��ʾ��Ʒ����������
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i + 1, cw, cv); // ѡ��װ�� i ����Ʒ
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], cv + value[i]); // ѡ��װ�� i ����Ʒ
        }
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // ��ʼ�� states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; ++i) { // ��̬�滮��״̬ת��
            for (int j = 0; j <= w; ++j) { // ��ѡ��� i ����Ʒ
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // ѡ��� i ����Ʒ
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // �ҳ����ֵ
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

}