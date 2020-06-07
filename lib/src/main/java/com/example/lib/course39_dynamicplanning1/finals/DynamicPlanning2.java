package com.example.lib.course39_dynamicplanning1.finals;

/**
 * 动态规划
 * Created by qinshunan on 2019/5/8.
 */

public class DynamicPlanning2 {

    // 0-1背包升级版：n个物体，每个物体还有价值，背包最大承重w，求背包承重内的最大价值

    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int[] value = {5, 7, 2, 4, 9};  // 物品价值
    private int n = 5; // 物品个数
    private int w = 16; // 背包承受的最大重量

    public void knapsack() {
    }

    /**
     * 动态规划-无脑版
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
    }

    /**
     * 动态规划-节省空间版加强版
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack2(int[] weight, int n, int w) {
    }

    public static void main(String[] args) {
        DynamicPlanning2 myDynamicPlanning2 = new DynamicPlanning2();
        myDynamicPlanning2.knapsack();
    }
}
