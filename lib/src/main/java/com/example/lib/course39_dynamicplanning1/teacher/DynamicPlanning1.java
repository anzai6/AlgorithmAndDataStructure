package com.example.lib.course39_dynamicplanning1.teacher;

/**
 * ��̬�滮
 */
public class DynamicPlanning1 {

    // 0-1���� ����

    // �����㷨ʵ�֡�ע�⣺�Ұ�����ı�����������˳�Ա������
    /*
    private int maxW = Integer.MIN_VALUE; // ����ŵ� maxW ��
    private int[] weight = {2, 2, 4, 6, 3};  // ��Ʒ����
    private int n = 5; // ��Ʒ����
    private int w = 9; // �������ܵ��������

    public void f(int i, int cw) { // ���� f(0, 0)
        if (cw == w || i == n) { // cw==w ��ʾװ����,i==n ��ʾ��Ʒ����������
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i + 1, cw); // ѡ��װ�� i ����Ʒ
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // ѡ��װ�� i ����Ʒ
        }
    }
    */

    // ��̬�滮
    private int maxW = Integer.MIN_VALUE; // ����ŵ� maxW ��
    private int[] weight = {2, 2, 4, 6, 3};  // ��Ʒ����
    private int n = 5; // ��Ʒ����
    private int w = 9; // �������ܵ��������
    private boolean[][] mem = new boolean[5][10]; // ����¼,Ĭ��ֵ false

    public void f(int i, int cw) { // ���� f(0, 0)
        if (cw == w || i == n) { // cw==w ��ʾװ����,i==n ��ʾ��Ʒ����������
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // �ظ�״̬
        mem[i][cw] = true; // ��¼ (i, cw) ���״̬
        f(i + 1, cw); // ѡ��װ�� i ����Ʒ
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // ѡ��װ�� i ����Ʒ
        }
    }

    // weight: ��Ʒ����,n: ��Ʒ����,w: �����ɳ�������
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // Ĭ��ֵ false
        states[0][0] = true;  // ��һ�е�����Ҫ���⴦��,���������ڱ��Ż�
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // ��̬�滮״̬ת��
            for (int j = 0; j <= w; ++j) {// ���ѵ� i ����Ʒ���뱳��
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {// �ѵ� i ����Ʒ���뱳��
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // ������
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }

    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // Ĭ��ֵ false
        states[0] = true;  // ��һ�е�����Ҫ���⴦��,���������ڱ��Ż�
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // ��̬�滮
            for (int j = w - items[i]; j >= 0; --j) {// �ѵ� i ����Ʒ���뱳��
                if (states[j] == true) states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // ������
            if (states[i] == true) return i;
        }
        return 0;
    }

}