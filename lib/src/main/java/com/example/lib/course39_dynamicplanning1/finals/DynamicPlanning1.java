package com.example.lib.course39_dynamicplanning1.finals;

/**
 * ��̬�滮
 * Created by qinshunan on 2019/5/8.
 */

public class DynamicPlanning1 {

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

    }

    /**
     * ����������㷨ʵ��
     * ʹ��findPackWeight2(0, 0);
     *
     * @param i  ��i������
     * @param cw ��ǰ����װ�ص�����
     */
    public void findPackWeight2(int i, int cw) {
    }

    public void knapsack() {
    }

    /**
     * ��̬�滮-�����԰�
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
    }

    /**
     * ��̬�滮-��ʡ�ռ���ǿ��
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack2(int[] weight, int n, int w) {
    }


    public static void main(String[] args) {
        DynamicPlanning1 myDynamicPlanning1 = new DynamicPlanning1();
//        myDynamicPlanning1.findPackWeight(0, 0);
//        myDynamicPlanning1.findPackWeight2(0, 0);
//        System.out.println(myDynamicPlanning1.maxW);


        myDynamicPlanning1.knapsack();
    }
}
