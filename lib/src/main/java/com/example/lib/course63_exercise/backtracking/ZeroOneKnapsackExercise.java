package com.example.lib.course63_exercise.backtracking;

/**
 * 0-1背包：回溯算法
 */

public class ZeroOneKnapsackExercise {

    // 0-1背包：从n个物体中选择物体装入背包，背包最大承重W，物体不可分割，求能装入物体的总重量的最大值
    int maxW = -1; // 存储背包中物品总重量的最大值
    int maxPackW = 150; // 背包最大承重
    int n = 10; // 10个物体
    int[] packW = new int[]{4, 9, 45, 23, 43, 31, 18, 12, 27, 32}; // 下标对应物体，值是物体的重量
    int[] packResult = new int[n]; // 下标对应物体，值是代表物体是否装进去，0不装，1 装
    public int[] maxResult = new int[n]; // 对应最大重量的结果

    /**
     * 求背包装入物品总重量的最大值
     *
     * @return
     */
    public int getZeroOneKnapsackMax() {
        zeroOneKnapsack(0, maxPackW);
        return maxW;
    }

    /**
     * 解决第i个物体是否放入背包
     *
     * @param i
     * @param w 背包剩余承重量
     */
    private void zeroOneKnapsack(int i, int w) {
        if (i >= 10 || w == 0) {
            int totalW = maxPackW - w; // 背包总重量
            if (maxW < totalW) {
                maxW = totalW;
                for (int j = 0; j < n; j++) {
                    maxResult[j] = packResult[j];
                }
            }
            return;
        }
        int thingW = packW[i]; // 第i个物体重量
        if (w >= thingW) {
            packResult[i] = 1;
            zeroOneKnapsack(i + 1, w - thingW); // 放入背包
        }
        packResult[i] = 0;
        zeroOneKnapsack(i + 1, w); // 不放入背包
    }

    private void printPackResult() {
        for (int i = 0; i < maxResult.length; i++) {
            System.out.print(maxResult[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroOneKnapsackExercise exercise = new ZeroOneKnapsackExercise();
        System.out.println("" + exercise.getZeroOneKnapsackMax());
        exercise.printPackResult();
    }
}
