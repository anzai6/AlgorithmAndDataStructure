package com.example.lib.course39_dynamicplanning1.my;

/**
 * ���ﳵ��������̶�����ë
 * Created by qinshunan on 2019/5/8.
 */

public class MyTest {
    // ���ﳵ�У�Ѱ�Ҵﵽ��200��50����Ʒ��Ҫ������޶�����ë������Ʒ�ܺ͸���200����͵ļ۸�
    // ��n����Ʒ���ҵ��ﵽ����200����������ֵ��Ʒ
    // items ��Ʒ�۸�n ��Ʒ����, w ��ʾ�������������� 200


    private int[] price = {2, 13, 21, 8, 5, 17, 26, 19, 24};  // ��Ʒ�۸�
    private int n = 9; // ��Ʒ����
    private int w = 53; // ��������

    public void knapsack() {
        knapsack1(price, n, w);
    }

    /**
     * ��̬�滮-�����԰�
     *
     * @param price
     * @param n
     * @param w
     */
    public void knapsack1(int[] price, int n, int w) {
        boolean[][] status = new boolean[n][w * 2 + 1]; // ����̶����ֻ�ܳ���w�������ļ۸�
        // ��̬�滮��Ҫ���������ڱ�ģʽ
        status[0][0] = true;
        status[0][price[0]] = true;
        for (int i = 1; i < n; i++) {
            // ��ѡ��i����Ʒ
            for (int j = 0; j <= w * 2; j++) {
                if (status[i - 1][j]) status[i][j] = true;
            }

            // ѡ���i����Ʒ
            for (int j = 0; j <= w * 2 - price[i]; j++) {
                if (status[i - 1][j]) status[i][j + price[i]] = true;
            }
        }

        int v = w;
        // ��ǰ���������������һ��������С��ֵ�����պ�������ֵ
        for (; v < w * 2 + 1; v++) {
            if (status[n - 1][v]) {
                System.out.println("��Ʒ�ܼ۸�" + v + "Ԫ");
                break;
            }
        }

        System.out.println("ѡ�����Ʒ��");
        // �ҳ�ѡ�����Ʒ,����ֻ����ѡ������һ��
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {// ��һ����Ʒ���⴦��
                if (status[0][price[0]] && v == price[0])
                    System.out.println(i + " ");
            } else {
                // ��ȥ��ǰ��Ʒ�۸����һ�е�ֵ���ڣ���ǰ��Ʒ��ѡ����
                if (v >= price[i] && status[i - 1][v - price[i]]) {
                    v -= price[i];
                    System.out.print(i + " - ");
                } else { // ���ﻹ������ѡ����ѡ�񣬾Ͳ�д��

                }
            }
        }
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.knapsack();
    }
}
