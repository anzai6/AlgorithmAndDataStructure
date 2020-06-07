package com.example.lib.course39_dynamicplanning1.my;

/**
 * 动态规划
 * Created by qinshunan on 2019/5/8.
 */

public class MyDynamicPlanning1 {

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
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }

        findPackWeight1(i + 1, cw); // 不装背包
        if (cw + weight[i] <= w) {
            findPackWeight1(i + 1, cw + weight[i]); // 装背包
        }

    }

    private boolean[][] findPackWeightStatus = new boolean[n][w]; // 记录以及计算过的状态

    /**
     * 升级版回溯算法实现
     * 使用findPackWeight2(0, 0);
     *
     * @param i  第i个物体
     * @param cw 当前背包装载的重量
     */
    public void findPackWeight2(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }

        if (findPackWeightStatus[i][cw]) // 已经计算过的状态
            return;

        findPackWeightStatus[i][cw] = true;
        findPackWeight1(i + 1, cw); // 不装背包
        if (cw + weight[i] <= w) {
            findPackWeight1(i + 1, cw + weight[i]); // 装背包
        }
    }

    public void knapsack() {
        knapsack2(weight, n, w);
//        knapsack1(weight, n, w);
    }

    /**
     * 动态规划-最无脑版
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
        boolean[][] status = new boolean[n][w + 1]; // 记录某个物体对应的背包重量状态
        // 动态规划首要就是利用哨兵模式
        status[0][0] = true;
        status[0][weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // 第i个物体不装
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j]) status[i][j] = true;
            }

            // 第i个物体装进背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (status[i - 1][j]) status[i][j + weight[i]] = true;
            }
        }

        // 从后往前遍历，遇到第一个就是最大的值
        for (int i = w; i >= 0; i--) {
            if (status[n - 1][i]) {
                System.out.println(i + "");
                return;
            }
        }
    }

    /**
     * 动态规划-节省空间版加强版
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack2(int[] weight, int n, int w) {
        // 这里相比上一个方法使用二维数组节省了空间
        boolean[] status = new boolean[w + 1]; // 记录某个物体对应的背包重量状态
        // 动态规划首要就是利用哨兵模式
        status[0] = true;
        status[weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // 第i个物体不装，这里省掉了不装的循环处理
            /*for (int j = 0; j <= w; j++) {
            }*/

            // 第i个物体装进背包 注意这里只能从大到小循环，不然循环内的判断会对后面的值有干扰
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[j]) status[j + weight[i]] = true;
            }
        }

        // 从后往前遍历，遇到第一个就是最大的值
        for (int i = w; i >= 0; i--) {
            if (status[i]) {
                System.out.println(i + "");
                return;
            }
        }
    }


    public static void main(String[] args) {
        MyDynamicPlanning1 myDynamicPlanning1 = new MyDynamicPlanning1();
//        myDynamicPlanning1.findPackWeight(0, 0);
//        myDynamicPlanning1.findPackWeight2(0, 0);
//        System.out.println(myDynamicPlanning1.maxW);


        myDynamicPlanning1.knapsack();
    }
}
