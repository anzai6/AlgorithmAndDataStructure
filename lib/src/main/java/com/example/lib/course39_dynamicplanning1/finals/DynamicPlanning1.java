package com.example.lib.course39_dynamicplanning1.finals;

/**
 * 动态规划
 * Created by qinshunan on 2019/5/8.
 */

public class DynamicPlanning1 {

    // 0-1背包：n个物体，背包最大承重w，求背包装重最大值

    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 16; // 背包承受的最大重量

    // 先用回溯实现

    /**
     * 普通版回溯算法实现
     * 使用findPackWeight1(0, 0);
     *
     * @param i  第i个物体
     * @param cw 当前背包装载的重量
     */
    public void findPackWeight1(int i, int cw) {

    }

    /**
     * 升级版回溯算法实现
     * 使用findPackWeight2(0, 0);
     *
     * @param i  第i个物体
     * @param cw 当前背包装载的重量
     */
    public void findPackWeight2(int i, int cw) {
    }

    public void knapsack() {
    }

    /**
     * 动态规划-最无脑版
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
        DynamicPlanning1 myDynamicPlanning1 = new DynamicPlanning1();
//        myDynamicPlanning1.findPackWeight(0, 0);
//        myDynamicPlanning1.findPackWeight2(0, 0);
//        System.out.println(myDynamicPlanning1.maxW);


        myDynamicPlanning1.knapsack();
    }
}
