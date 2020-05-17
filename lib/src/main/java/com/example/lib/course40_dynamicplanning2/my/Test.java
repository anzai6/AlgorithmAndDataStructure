package com.example.lib.course40_dynamicplanning2.my;

/**
 * Created by qinshunan on 2019/5/13.
 */

public class Test {

    // 有不同币种的硬币v1,v2,v3,...,vn，要求支付W元求最少需要多少个硬币，本别是
    int[] currencyValue = {3, 5, 7,}; // 硬币面值
    int totalW = 26;

    public void getMinCurrency() {
        getMinCurrency(currencyValue, totalW);
    }

    // 状态转移表法
    private void getMinCurrency(int[] values, int w) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        // 找出最大值和最小值
        for (int j = 0; j < values.length; j++) {
            if (minValue > values[j])
                minValue = values[j];
            if (maxValue < values[j])
                maxValue = values[j];
        }
        if (w < minValue)
            return;

        int n = w / minValue; // 最多需要的硬币枚数
        boolean[][] statues = new boolean[n][maxValue * n + 1]; // n代表需要多少枚硬币，maxValue * n + 1指硬币最大面值

        int i = 0;
        int newValue = -1;
        for (int j = 0; j < values.length; j++) {
            newValue = values[j];
            statues[0][newValue] = true;
            if (newValue == w) { // 找到
                System.out.println("使用一枚硬币面值为：" + newValue + "元");
                return;
            }
        }


        for (i = 1; i < n; i++) {
            for (int j = w; j >= 0; j--) {
                if (statues[i - 1][j]) {
                    for (int k = 0; k < values.length; k++) {
                        newValue = j + values[k];
                        statues[i][newValue] = true;
                        if (newValue == w) { // 第一个筹齐面额为w即可停止循环
                            break;
                        }
                    }
                }
                if (newValue == w) {
                    break;
                }
            }
            if (newValue == w) {
                break;
            }
        }

        if (newValue != w) {
            return;
        }

        System.out.println("使用硬币面值为：");
        for (int j = i; j >= 0; j--) {

            for (int k = 0; k < values.length; k++) {
                if (j == 0) {
                    if (newValue == values[k]) {
                        System.out.println(values[k] + "元");
                        return;
                    }
                } else if (statues[j - 1][newValue - values[k]]) {
                    newValue = newValue - values[k];
                    System.out.println(values[k] + "元");
                    break;
                }
            }

        }

    }

    // 状态转移方程
    // f(w) = min(f(w),f(w-vn))

    int minCount = Integer.MAX_VALUE;

    public void getMinCurrency2() {
        getMinCurrency2(0, totalW);
        System.out.println("使用硬币枚数为：" + minCount);
    }

    /**
     * getMinCurrency2(0,11)调用,可以通过备忘录或者状态转移方程表翻译成动态规划代码
     *
     * @param n 第几枚硬币
     * @param w 剩余需要支付硬币的面值
     */
    private void getMinCurrency2(int n, int w) {
        if (w == 0) {
            if (minCount > n)
                minCount = n;
            return;
        } else if (w < 0) {
            return;
        }

        for (int i = 0; i < currencyValue.length; i++) {
            getMinCurrency2(n + 1, w - currencyValue[i]);
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.getMinCurrency();
        test.getMinCurrency2();
    }

}
