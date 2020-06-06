package com.example.lib.course41_dynamicplanning3.finals;

/**
 * Created by qinshunan on 2019/5/15.
 */

public class Test {

    // 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？
    // 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7，
    // 所以最长递增子序列的长度是 4。

    int[] numList = {2, 9, 3, 7, 5, 1, 6};
    int n = numList.length;
    int maxLength = Integer.MIN_VALUE;

    public void getMaxLength() {
    }

    // 惯例先列出回溯算法

    /**
     * 回溯算法：调用getMaxLengthByBa(0,0,-1);
     *
     * @param i      第几位
     * @param j      前面的递增子序列的长度
     * @param maxNum 前面的递增子序列的最大值
     */
    public void getMaxLengthByBa(int i, int j, int maxNum) {

    }

    // 根据回溯算法画出递归树，看是否存在重复子问题，如果存在则考虑动态规划算法，不存在则回溯算法就是最好的解决办法

    // 递归树自己画，这里重复子问题是：getMaxLengthByBa(1, 1, 2),getMaxLengthByBa(1, 1, 9)，取 getMaxLengthByBa(1, 1, 2)即可，
    // 因为要求最长递增子序列，所以相同位置且相同长度下，取递增子序列的最大值的最小值（2<9）

    // 根据递归树和重复子问题思考分析列出状态转移方程如下，1.可以根据状态转移方程画出一个二维状态表并翻译成代码
    // 2.可以通过递归加备忘录实现代码

    // f(i)表示第i个位置的最长递增子序列长度,  状态转移方程如下：
    // f(i) = f(i-1) 前提：numList[i] < f(i-1)长度的所有递增子序列的最大值中的最小值
    // f(i) = f(i-1)+1 前提：numList[i] > f(i-1)长度的所有递增子序列的最大值中的最小值

    /**
     * 动态规划代码
     */
    public void getLengthByRe() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.getMaxLength();
    }
}
