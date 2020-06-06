package com.example.lib.course39_dynamicplanning1.finals;

/**
 * 购物车满减活动最大程度褥羊毛
 * Created by qinshunan on 2019/5/8.
 */

public class Test {
    // 购物车中，寻找达到满200减50的商品，要求最大限度褥羊毛，即商品总和高于200中最低的价格
    // 在n个商品中找到达到满减200条件的最大价值商品
    // items 商品价格，n 商品个数, w 表示满减条件，比如 200


    private int[] price = {2, 13, 21, 8, 5, 17, 26, 19, 24};  // 物品价格
    private int n = 9; // 商品个数
    private int w = 53; // 满减条件

    public void knapsack() {
    }

    /**
     * 动态规划-最无脑版
     *
     * @param price
     * @param n
     * @param w
     */
    public void knapsack1(int[] price, int n, int w) {
    }

    public static void main(String[] args) {
        Test myTest = new Test();
        myTest.knapsack();
    }
}
