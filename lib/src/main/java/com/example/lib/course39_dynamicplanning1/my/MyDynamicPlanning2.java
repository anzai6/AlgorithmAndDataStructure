package com.example.lib.course39_dynamicplanning1.my;

/**
 * ��̬�滮
 * Created by qinshunan on 2019/5/8.
 */

public class MyDynamicPlanning2 {

    // 0-1���������棺n�����壬ÿ�����廹�м�ֵ������������w���󱳰������ڵ�����ֵ

    private int[] weight = {2, 2, 4, 6, 3};  // ��Ʒ����
    private int[] value = {5, 7, 2, 4, 9};  // ��Ʒ��ֵ
    private int n = 5; // ��Ʒ����
    private int w = 16; // �������ܵ��������

    public void knapsack() {
        knapsack1(weight, n, w);
        knapsack2(weight, n, w);
    }

    /**
     * ��̬�滮-���԰�
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
        int[][] status = new int[n][w + 1]; // ��¼ĳ�������Ӧ�ı�������״̬,ֵ��Ӧ������Ӧ�ļ�ֵ
        // ��ʼ��
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                status[i][j] = -1;
            }
        }
        // ��̬�滮��Ҫ���������ڱ�ģʽ
        status[0][0] = 0;
        status[0][weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            // ��i�����岻װ
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j] >= 0) status[i][j] = status[i - 1][j];
            }

            // ��i������װ������,ע��Ҫ�Ӵ�С��������ֹ�Ժ�������ݸ���
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[i - 1][j] >= 0) {
                    int a = status[i - 1][j] + value[i];
                    if (a > status[i][j + weight[i]]) // ע���ص㣬ֻ���ܸ����ֵ
                        status[i][j + weight[i]] = a;
                }
            }
        }

        int v = 0;
        // �Ӻ���ǰ����
        for (int i = w; i >= 0; i--) {
            int a = status[n - 1][i];
            if (a > v) {
                v = a;
            }
        }
        System.out.println(v + "");
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
        int[] status = new int[w + 1]; // ��¼ĳ�������Ӧ�ı�������״̬
        for (int i = 0; i < w + 1; i++) {
            status[i] = -1;
        }
        // ��̬�滮��Ҫ���������ڱ�ģʽ
        status[0] = 0;
        status[weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            // ��i�����岻װ������ʡ���˲�װ��ѭ������
            /*for (int j = 0; j <= w; j++) {
            }*/

            // ��i������װ������ ע������ֻ�ܴӴ�Сѭ������Ȼѭ���ڵ��жϻ�Ժ����ֵ�и���
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[j] >= 0) {
                    int a = status[j] + value[i];
                    if (a > status[j + weight[i]]) // ע���ص㣬ֻ���ܸ����ֵ
                        status[j + weight[i]] = a;
                }
            }
        }

        int v = 0;
        // �Ӻ���ǰ����
        for (int i = w; i >= 0; i--) {
            int a = status[i];
            if (a > v) {
                v = a;
            }
        }
        System.out.println(v + "");
    }

    public static void main(String[] args) {
        MyDynamicPlanning2 myDynamicPlanning2 = new MyDynamicPlanning2();
        myDynamicPlanning2.knapsack();
    }
}
