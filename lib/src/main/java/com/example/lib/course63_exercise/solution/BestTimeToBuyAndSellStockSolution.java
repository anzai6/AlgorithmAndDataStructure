package com.example.lib.course63_exercise.solution;

/**
 * ������Ʊ�����ʱ��
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStockSolution {

    /**
     *
     ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

     ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������

     ע���㲻���������Ʊǰ������Ʊ��

     ʾ�� 1:

     ����: [7,1,5,3,6,4]
     ���: 5
     ����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
     ʾ�� 2:

     ����: [7,6,4,3,1]
     ���: 0
     ����: �����������, û�н������, �����������Ϊ 0��

     *
     */

    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minNum = Integer.MAX_VALUE;
        int maxNum = minNum;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int num = prices[i];
            if (minNum > num) { // �ҳ���Сֵ
                minNum = num;
                maxNum = num;
                continue;
            }

            if (num > maxNum) { // �ҳ����ֵͬʱ��������
                maxNum = num;
                // ���������
                int profit = maxNum - minNum;
                if (maxProfit < profit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices = new int[]{7,6,4,3,1};
        BestTimeToBuyAndSellStockSolution solution = new BestTimeToBuyAndSellStockSolution();
        System.out.println(solution.maxProfit(prices));
    }
}
