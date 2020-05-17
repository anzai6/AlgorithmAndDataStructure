package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * 编程实现一个数据序列的最长递增子序列
 */

public class LongestIncrementalSubsequenceExercise {

    // 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？
    // 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7，
    // 所以最长递增子序列的长度是 4。

    int[] list = new int[]{2, 9, 3, 6, 5, 1, 7};
    int n = list.length;
    int maxSequenceLength = Integer.MIN_VALUE; // 最长递增子序列长度

    private int getMaxSequence() {
//        lisBT(0, 0, -1);
//        return maxSequenceLength;
        return lisDP();
    }

    /**
     * 回溯算法：调用 lisDP(0,0,-1);
     *
     * @param i              第几位
     * @param sequenceLength 前面的递增子序列的长度
     * @param maxNum         前面的递增子序列的最大值
     */
    private void lisBT(int i, int sequenceLength, int maxNum) {
        if (i == n) {
            if (maxSequenceLength < sequenceLength)
                maxSequenceLength = sequenceLength;
            return;
        }
        if (list[i] >= maxNum) // 大于则长度加一
            lisBT(i + 1, sequenceLength + 1, list[i]);
        // 不比较直接下一位
        lisBT(i + 1, sequenceLength, maxNum);
    }

    // 回溯公式：f(i) : list[i] >= maxNum(前面的递增子序列的最大值) -> f(i-1)+1
    // list[i] < maxNum(前面的递增子序列的最大值) -> f(i-1)

    /**
     * 动态规划
     * @return
     */
    private int lisDP() {
        int[] result = new int[n]; // 下标index是递增子序列的长度，值存储的是递增子序列的长度为index的最大值
        for (int i = 1; i < n; i++) {
            result[i] = -1;
        }
        result[0] = list[0];

        for (int i = 1; i < n; i++) {
            int item = list[i];
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] < 0)
                    continue;
                int maxNum = result[j];

                if (j == 0 && item < maxNum) { // 第一个特殊处理
                    result[j] = item;
                } else if (item >= maxNum) {
                    int next = result[j + 1];
                    if (next < 0 || next > item)
                        result[j + 1] = item;
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] > -1) {
                maxLength = i + 1;
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncrementalSubsequenceExercise exercise = new LongestIncrementalSubsequenceExercise();
        System.out.println("最长递增子序列长度：" + exercise.getMaxSequence());
    }
}
