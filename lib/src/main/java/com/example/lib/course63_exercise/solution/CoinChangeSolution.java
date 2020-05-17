package com.example.lib.course63_exercise.solution;

/**
 * ��Ǯ�һ�
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChangeSolution {

    /**
     *
     ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��

     ʾ��?1:

     ����: coins = [1, 2, 5], amount = 11
     ���: 3
     ����: 11 = 5 + 5 + 1
     ʾ�� 2:

     ����: coins = [2], amount = 3
     ���: -1
     ˵��:
     �������Ϊÿ��Ӳ�ҵ����������޵ġ�

     *
     */

    /**
     * ��̬�滮-ѧϰ���ѸĽ���
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (coins.length == 0) {
            return -1;
        }

        int[] f = new int[amount + 1]; // �±��ʾ��ֵ��ʾ�ﹻ��������Ҫ��Ӳ��ö��
        f[0] = 0;

        for (int i = 1; i <= amount; i++) {

            int cost = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (f[i - coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }

            f[i] = cost;
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

    /**
     * ��̬�滮-��д��������
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (coins.length == 0) {
            return -1;
        }

        int minCoins = Integer.MAX_VALUE; // ��СӲ��
        for (int i = 0; i < coins.length; i++) {
            if (minCoins > coins[i])
                minCoins = coins[i];
        }

        if (minCoins > amount) // ��СӲ�Ҷ��Ƚ���
            return -1;

        int maxCount = amount / minCoins; // ������

        boolean[][] isCheck = new boolean[maxCount][amount - minCoins + 1]; // ���������СӲ����ֵ��ʼ

        // �ȼ����1öӲ��
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (coin == amount)
                return 1;
            else if (coin < amount)
                isCheck[0][coin - minCoins] = true;
        }

        for (int i = 1; i < maxCount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (coin > amount)
                    continue;
                for (int k = amount - minCoins; k >= 0; k--) {
                    if (isCheck[i - 1][k]) {
                        if (k + minCoins + coin == amount)
                            return i + 1;
                        else if (k + minCoins + coin < amount) {
                            isCheck[i][k + coin] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    /**
     * �����㷨+����¼��ʧ��
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || amount < 0)
            return -1;
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (minCoins > coins[i])
                minCoins = coins[i];
        }
        if (minCoins == Integer.MIN_VALUE)
            minCoins = 1;
        boolean[][] isCheck = new boolean[amount / minCoins + 1][amount + 1];
        coinChangeBT(coins, 0, amount, isCheck);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    int minCount = Integer.MAX_VALUE; // Ӳ��ö��

    /**
     * �����㷨+����¼��ʧ��
     *
     * @param coins
     * @param count      Ӳ��ö��
     * @param restAmount ʣ����
     */
    private void coinChangeBT(int[] coins, int count, int restAmount, boolean[][] isCheck) {
        if (restAmount > 0) {
            if (isCheck[count][restAmount])
                return;
            isCheck[count][restAmount] = true;
            for (int j = 0; j < coins.length; j++) {
                coinChangeBT(coins, count + 1, restAmount - coins[j], isCheck);
            }
            return;
        }
        if (restAmount == 0) {
            if (minCount > count)
                minCount = count;
            return;
        }
    }

    public static void main(String[] args) {
//        int[] coins = new int[]{1, 2, 5};
        int[] coins = new int[]{2147483647};
//        int[] coins = new int[]{94, 91, 377, 368, 207, 40, 415, 61};
        CoinChangeSolution solution = new CoinChangeSolution();
        System.out.println(solution.coinChange(coins, 2));
    }
}
