package com.example.lib.course58_exercise.solution;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairsSolution {

    /**
     *
     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

     注意：给定 n 是一个正整数。

     示例 1：

     输入： 2
     输出： 2
     解释： 有两种方法可以爬到楼顶。
     1.  1 阶 + 1 阶
     2.  2 阶
     示例 2：

     输入： 3
     输出： 3
     解释： 有三种方法可以爬到楼顶。
     1.  1 阶 + 1 阶 + 1 阶
     2.  1 阶 + 2 阶
     3.  2 阶 + 1 阶


     分析可用递归求解，公式：
     f(n) = f(n-1) + f(n-2)
     *
     */

    /**
     * 动态规划解法：改进版，省掉O(n)空间复杂度
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 2; // 往前一位，相当于f(n-1)
        int second = 1; // 往前两位，相当于f(n-2)
        int result = 0;
        for (int i = 3; i < n + 1; i++) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }

    /**
     * 动态规划解法：根据f(n) = f(n-1) + f(n-2)即可解决
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }

    /**
     * 递归解法，递归公式为
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 0)
            return 0;
        int[] isGet = new int[n + 1];
        for (int i = 0; i < n; i++) {
            isGet[i] = 0;
        }
        return climbStairs(isGet, n);
    }

    public int climbStairs(int[] isGet, int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            isGet[1] = 1;
            return 1;
        }
        if (n == 2) {
            isGet[2] = 2;
            return 2;
        }

        if (isGet[n] == 0)
            isGet[n] = climbStairs(isGet, n - 1) + climbStairs(isGet, n - 2);

        return isGet[n];
    }

    public static void main(String[] args) {
        ClimbingStairsSolution solution = new ClimbingStairsSolution();
        System.out.print(solution.climbStairs(44) + "");
    }
}
