package com.example.lib.course39_dynamicplanning1.my;

/**
 * ��̬�滮
 * Created by qinshunan on 2019/5/8.
 */

public class MyDynamicPlanning1 {

    // 0-1������n�����壬����������w���󱳰�װ�����ֵ

    private int maxW = Integer.MIN_VALUE; // ����ŵ� maxW ��
    private int[] weight = {2, 2, 4, 6, 3};  // ��Ʒ����
    private int n = 5; // ��Ʒ����
    private int w = 16; // �������ܵ��������

    // ���û���ʵ��

    /**
     * ��ͨ������㷨ʵ��
     * ʹ��findPackWeight1(0, 0);
     *
     * @param i  ��i������
     * @param cw ��ǰ����װ�ص�����
     */
    public void findPackWeight1(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }

        findPackWeight1(i + 1, cw); // ��װ����
        if (cw + weight[i] <= w) {
            findPackWeight1(i + 1, cw + weight[i]); // װ����
        }

    }

    private boolean[][] findPackWeightStatus = new boolean[n][w]; // ��¼�Լ��������״̬

    /**
     * ����������㷨ʵ��
     * ʹ��findPackWeight2(0, 0);
     *
     * @param i  ��i������
     * @param cw ��ǰ����װ�ص�����
     */
    public void findPackWeight2(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }

        if (findPackWeightStatus[i][cw]) // �Ѿ��������״̬
            return;

        findPackWeightStatus[i][cw] = true;
        findPackWeight1(i + 1, cw); // ��װ����
        if (cw + weight[i] <= w) {
            findPackWeight1(i + 1, cw + weight[i]); // װ����
        }
    }

    public void knapsack() {
        knapsack2(weight, n, w);
//        knapsack1(weight, n, w);
    }

    /**
     * ��̬�滮-�����԰�
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
        boolean[][] status = new boolean[n][w + 1]; // ��¼ĳ�������Ӧ�ı�������״̬
        // ��̬�滮��Ҫ���������ڱ�ģʽ
        status[0][0] = true;
        status[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // ��i�����岻װ
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j]) status[i][j] = true;
            }

            // ��i������װ������
            for (int j = 0; j <= w - weight[i]; j++) {
                if (status[i - 1][j]) status[i][j + weight[i]] = true;
            }
        }

        // �Ӻ���ǰ������������һ����������ֵ
        for (int i = w; i >= 0; i--) {
            if (status[n - 1][i]) {
                System.out.println(i + "");
                return;
            }
        }
    }

    /**
     * ��̬�滮-��ʡ�ռ���ǿ��
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack2(int[] weight, int n, int w) {
        // ���������һ������ʹ�ö�ά�����ʡ�˿ռ�
        boolean[] status = new boolean[w + 1]; // ��¼ĳ�������Ӧ�ı�������״̬
        // ��̬�滮��Ҫ���������ڱ�ģʽ
        status[0] = true;
        status[weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // ��i�����岻װ������ʡ���˲�װ��ѭ������
            /*for (int j = 0; j <= w; j++) {
            }*/

            // ��i������װ������ ע������ֻ�ܴӴ�Сѭ������Ȼѭ���ڵ��жϻ�Ժ����ֵ�и���
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[j]) status[j + weight[i]] = true;
            }
        }

        // �Ӻ���ǰ������������һ����������ֵ
        for (int i = w; i >= 0; i--) {
            if (status[i]) {
                System.out.println(i + "");
                return;
            }
        }
    }


    public static void main(String[] args) {
        MyDynamicPlanning1 myDynamicPlanning1 = new MyDynamicPlanning1();
//        myDynamicPlanning1.findPackWeight(0, 0);
//        myDynamicPlanning1.findPackWeight2(0, 0);
//        System.out.println(myDynamicPlanning1.maxW);


        myDynamicPlanning1.knapsack();
    }
}
