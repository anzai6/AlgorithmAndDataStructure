package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * 0-1背包：动态规划算法
 */

public class DynamicProgrammingZeroOneKnapsackExercise {

    // 0-1背包：从n个物体中选择物体装入背包，背包最大承重W，物体不可分割，求能装入物体的总重量的最大值
    int maxPackW = 150; // 背包最大承重
    int n = 10; // 10个物体
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // 下标对应物体，值是物体的重量

    /**
     * 求背包装入物品总重量的最大值:动态规划无脑版
     *
     * @return
     */
    public int dynamicProgramming() {
        boolean[][] packResult = new boolean[n][maxPackW + 1]; // 对应物体重量
        packResult[0][packW[0]] = true; // 第一个物体装进去
        packResult[0][0] = true; // 第一个物体不装进去
        for (int i = 1; i < n; i++) {
            int thingW = packW[i];  // 物体重量
            for (int j = maxPackW; j >= 0; j--) {
                if (packResult[i - 1][j]) { // 装有物体
                    packResult[i][j] = true; // 不装进去
                    if (thingW + j <= maxPackW) // 可以装进去
                        packResult[i][j + thingW] = true;
                }

            }
        }

        int maxW = -1; // 存储背包中物品总重量的最大值

        for (int i = maxPackW; i >= 0; i--) {
            if (packResult[n - 1][i]) { // 最大值
                maxW = i;
                break;
            }
        }

        // 计算出每个背包装或者不装
        int rest = maxW;
        for (int i = n - 1; i >= 1; i--) {
            if (rest >= packW[i] && packResult[i - 1][rest - packW[i]]) { // 装
                rest -= packW[i];
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }

        // 第一个
        if (rest == packW[0] && packResult[0][packW[0]]) { // 装
            System.out.print("1 ");
        } else {
            System.out.print("0 ");
        }
        System.out.println();
        return maxW;
    }

    /**
     * 求背包装入物品总重量的最大值:动态规划节省版
     *
     * @return
     */
    public int dynamicProgramming2() {
        boolean[] packResult = new boolean[maxPackW + 1]; // 对应物体重量
        packResult[packW[0]] = true; // 第一个物体装进去
        packResult[0] = true; // 第一个物体不装进去
        for (int i = 1; i < n; i++) {
            int thingW = packW[i];  // 物体重量
            for (int j = maxPackW; j >= 0; j--) {
                if (packResult[j]) { // 装有物体
                    if (thingW + j <= maxPackW) // 可以装进去
                        packResult[j + thingW] = true;
                }

            }
        }

        int maxW = -1; // 存储背包中物品总重量的最大值

        for (int i = maxPackW; i >= 0; i--) {
            if (packResult[i]) { // 最大值
                maxW = i;
                break;
            }
        }

        return maxW;
    }


    public static void main(String[] args) {
        DynamicProgrammingZeroOneKnapsackExercise exercise = new DynamicProgrammingZeroOneKnapsackExercise();
        System.out.println("" + exercise.dynamicProgramming2());
    }
}
