package com.example.lib.course39_dynamicplanning1.my;

/**
 * 动态规划
 * Created by qinshunan on 2019/5/8.
 */

public class MyDynamicPlanning2 {

    // 0-1背包升级版：n个物体，每个物体还有价值，背包最大承重w，求背包承重内的最大价值

    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int[] value = {5, 7, 2, 4, 9};  // 物品价值
    private int n = 5; // 物品个数
    private int w = 16; // 背包承受的最大重量

    public void knapsack() {
        knapsack1(weight, n, w);
        knapsack2(weight, n, w);
    }

    /**
     * 动态规划-无脑版
     *
     * @param weight
     * @param n
     * @param w
     */
    public void knapsack1(int[] weight, int n, int w) {
        int[][] status = new int[n][w + 1]; // 记录某个物体对应的背包重量状态,值对应的是相应的价值
        // 初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                status[i][j] = -1;
            }
        }
        // 动态规划首要就是利用哨兵模式
        status[0][0] = 0;
        status[0][weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            // 第i个物体不装
            for (int j = 0; j <= w; j++) {
                if (status[i - 1][j] >= 0) status[i][j] = status[i - 1][j];
            }

            // 第i个物体装进背包,注意要从大到小遍历，防止对后面的数据干扰
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[i - 1][j] >= 0) {
                    int a = status[i - 1][j] + value[i];
                    if (a > status[i][j + weight[i]]) // 注意重点，只接受更大的值
                        status[i][j + weight[i]] = a;
                }
            }
        }

        int v = 0;
        // 从后往前遍历
        for (int i = w; i >= 0; i--) {
            int a = status[n - 1][i];
            if (a > v) {
                v = a;
            }
        }
        System.out.println(v + "");
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
        int[] status = new int[w + 1]; // 记录某个物体对应的背包重量状态
        for (int i = 0; i < w + 1; i++) {
            status[i] = -1;
        }
        // 动态规划首要就是利用哨兵模式
        status[0] = 0;
        status[weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            // 第i个物体不装，这里省掉了不装的循环处理
            /*for (int j = 0; j <= w; j++) {
            }*/

            // 第i个物体装进背包 注意这里只能从大到小循环，不然循环内的判断会对后面的值有干扰
            for (int j = w - weight[i]; j >= 0; j--) {
                if (status[j] >= 0) {
                    int a = status[j] + value[i];
                    if (a > status[j + weight[i]]) // 注意重点，只接受更大的值
                        status[j + weight[i]] = a;
                }
            }
        }

        int v = 0;
        // 从后往前遍历
        for (int i = w; i >= 0; i--) {
            int a = status[i];
            if (a > v) {
                v = a;
            }
        }
        System.out.println(v + "");
    }

    public static void main(String[] args) {
        MyDynamicPlanning2 myDynamicPlanning2 = new MyDynamicPlanning2();
        myDynamicPlanning2.knapsack();
    }
}
