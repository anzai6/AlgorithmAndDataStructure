package com.example.lib.course40_dynamicplanning2.finals;

/**
 * Created by qinshunan on 2019/5/13.
 */

public class Test {

    // 有不同币种的硬币v1,v2,v3,...,vn，要求支付W元求最少需要多少个硬币，本别是
    int[] currencyValue = {3, 5, 7,}; // 硬币面值
    int totalW = 26;

    public void getMinCurrency() {
    }

    // 状态转移表法
    private void getMinCurrency(int[] values, int w) {
    }

    // 状态转移方程
    // f(w) = min(f(w),f(w-vn))

    int minCount = Integer.MAX_VALUE;

    public void getMinCurrency2() {
    }

    /**
     * getMinCurrency2(0,11)调用,可以通过备忘录或者状态转移方程表翻译成动态规划代码
     *
     * @param n 第几枚硬币
     * @param w 剩余需要支付硬币的面值
     */
    private void getMinCurrency2(int n, int w) {
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.getMinCurrency();
        test.getMinCurrency2();
    }

}
