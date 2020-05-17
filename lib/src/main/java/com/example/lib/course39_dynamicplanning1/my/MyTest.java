package com.example.lib.course39_dynamicplanning1.my;

/**
 * 购物车满减活动最大程度褥羊毛
 * Created by qinshunan on 2019/5/8.
 */

public class MyTest {
    // 购物车中，寻找达到满200减50的商品，要求最大限度褥羊毛，即商品总和高于200中最低的价格
    // 在n个商品中找到达到满减200条件的最大价值商品
    // items 商品价格，n 商品个数, w 表示满减条件，比如 200


    private int[] price = {2, 13, 21, 8, 5, 17, 26, 19, 24};  // 物品价格
    private int n = 9; // 商品个数
    private int w = 53; // 满减条件

    public void knapsack() {
        knapsack1(price, n, w);
    }

    /**
     * 动态规划-最无脑版
     *
     * @param price
     * @param n
     * @param w
     */
    public void knapsack1(int[] price, int n, int w) {
        boolean[][] status = new boolean[n][w * 2 + 1]; // 这里固定最多只能超过w两倍倍的价格
        // 动态规划首要就是利用哨兵模式
        status[0][0] = true;
        status[0][price[0]] = true;
        for (int i = 1; i < n; i++) {
            // 不选第i个商品
            for (int j = 0; j <= w * 2; j++) {
                if (status[i - 1][j]) status[i][j] = true;
            }

            // 选择第i个商品
            for (int j = 0; j <= w * 2 - price[i]; j++) {
                if (status[i - 1][j]) status[i][j + price[i]] = true;
            }
        }

        int v = w;
        // 从前往后遍历，遇到第一个就是最小的值，即刚好满减的值
        for (; v < w * 2 + 1; v++) {
            if (status[n - 1][v]) {
                System.out.println("商品总价格：" + v + "元");
                break;
            }
        }

        System.out.println("选择的商品：");
        // 找出选择的商品,这里只是挑选了其中一种
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {// 第一个商品特殊处理
                if (status[0][price[0]] && v == price[0])
                    System.out.println(i + " ");
            } else {
                // 减去当前商品价格后，上一列的值存在，则当前商品被选中了
                if (v >= price[i] && status[i - 1][v - price[i]]) {
                    v -= price[i];
                    System.out.print(i + " - ");
                } else { // 这里还可以挑选其它选择，就不写了

                }
            }
        }
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.knapsack();
    }
}
