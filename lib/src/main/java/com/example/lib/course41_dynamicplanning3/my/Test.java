package com.example.lib.course41_dynamicplanning3.my;

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
        getMaxLengthByBa(0, 0, -1);
        System.out.println("最长递增子序列的长度是：" + maxLength);
//        getLengthByRe();
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
        if (i == n) {
            if (maxLength < j)
                maxLength = j;
            return;
        }

        if (numList[i] >= maxNum) { // 大于则长度加一
            getMaxLengthByBa(i + 1, j + 1, numList[i]);
        }
        // 不比较直接到下一个
        getMaxLengthByBa(i + 1, j, maxNum);

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
        int[] a = new int[n]; // 长度作为下标，值是相同长度下，所有长度为n的递增子序列的最大值中的最小值
        // 比如2,3和2,4两个递增子序列，则a[1] = 3;

        // 初始化
        a[0] = numList[0];
        for (int i = 1; i < n; i++) {
            a[i] = -1;
        }


        for (int i = 1; i < n; i++) {
            // 拿numList[i]依次跟每个长度的递增子序列的最大值比较，
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0 && numList[i] < a[0]) {
                    a[0] = numList[i];
                } else if (a[j] != -1) { // 有值
                    // 这里的判断是重点：
                    // 如果a[j] < numList[i] 则a[j+1]可以替换为numList[i](前提是a[j + 1] > numList[i]或者a[j + 1] == -1)
                    if (a[j] < numList[i]
                            && (a[j + 1] == -1 || a[j + 1] > numList[i])) {
                        a[j + 1] = numList[i];
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != -1) { // 有值
                System.out.println("最长递增子序列长度：" + (i + 1) + "   最长递增子序列的最大值：" + a[i]);
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.getMaxLength();
    }
}
