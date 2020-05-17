package com.example.lib.course63_exercise.solution;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChangeSolution {

    /**
     *
     给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。

     示例?1:

     输入: coins = [1, 2, 5], amount = 11
     输出: 3
     解释: 11 = 5 + 5 + 1
     示例 2:

     输入: coins = [2], amount = 3
     输出: -1
     说明:
     你可以认为每种硬币的数量是无限的。

     *
     */

    /**
     * 动态规划-学习网友改进版
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

        int[] f = new int[amount + 1]; // 下标表示金额，值表示筹够这个金额需要的硬币枚数
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
     * 动态规划-我写的垃圾版
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

        int minCoins = Integer.MAX_VALUE; // 最小硬币
        for (int i = 0; i < coins.length; i++) {
            if (minCoins > coins[i])
                minCoins = coins[i];
        }

        if (minCoins > amount) // 最小硬币都比金额大
            return -1;

        int maxCount = amount / minCoins; // 最大次数

        boolean[][] isCheck = new boolean[maxCount][amount - minCoins + 1]; // 这里金额从最小硬币面值开始

        // 先计算好1枚硬币
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
     * 回溯算法+备忘录，失败
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

    int minCount = Integer.MAX_VALUE; // 硬币枚数

    /**
     * 回溯算法+备忘录，失败
     *
     * @param coins
     * @param count      硬币枚数
     * @param restAmount 剩余金额
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
