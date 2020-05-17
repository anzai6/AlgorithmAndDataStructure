package com.leetcode.anzai.subject_41_60;

/**
 * 第k个排列
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Subject60 {

    /**
     *
     给出集合?[1,2,3,…,n]，其所有元素共有?n! 种排列。

     按大小顺序列出所有排列情况，并一一标记，当?n = 3 时, 所有排列如下：

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     给定?n 和?k，返回第?k?个排列。

     说明：

     给定 n?的范围是 [1, 9]。
     给定 k?的范围是[1, ?n!]。
     示例?1:

     输入: n = 3, k = 3
     输出: "213"
     示例?2:

     输入: n = 4, k = 9
     输出: "2314"
     *
     */

    /**
     * 回溯算法的优化，参考网友剪枝思路:
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if (n <= 0 || k == 0) {
            return "";
        }
        // 由于只有9个数，事先定好每一个阶乘，如：8！ = 40320; 7! = 5040;
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] used = new boolean[n];
        int[] result = new int[n];
        return getPermutationInternal(0, n, k, result, used, factorial);
    }

    /**
     * 回溯
     *
     * @param i      // 当前排列的位数
     * @param n
     * @param result
     */
    private String getPermutationInternal(int i, int n, int k, int[] result, boolean[] used, int[] factorial) {
        if (i == n) { // 排列完成
            StringBuilder sb = new StringBuilder();
            for (int h = 0; h < n; h++) {
                sb.append(result[h]);
            }
            return sb.toString();
        }
        for (int j = 0; j < n; j++) {
            if (used[j]) {
                continue;
            }

            int subItemCount = factorial[n - i - 1]; // 子项数量，用于剪枝,比如放第一位的时候，每一个项的子项都有 8! 个,根据这个数值来剪枝
            if (subItemCount < k) { // 不在当前项时，减去子项数量直接跳到下一项，省略中间的排列，剪枝的精髓
                k -= subItemCount;
                continue;
            }

            used[j] = true;
            result[i] = j + 1;
            // 下一位
            return getPermutationInternal(i + 1, n, k, result, used, factorial);
        }
        return "出错了";
    }

    /**
     * 通过回溯算法以及计数判断(容易超时，容易全情况遍历)
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation1(int n, int k) {
        if (n <= 0 || k == 0) {
            return "";
        }
        endCount = k;
        boolean[] used = new boolean[n];
        int[] result = new int[n];
        getPermutationInternal1(0, n, result, used);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    int count = 0;
    int endCount = 0;

    /**
     * 回溯
     *
     * @param i      // 当前排列的位数
     * @param n
     * @param result
     */
    private void getPermutationInternal1(int i, int n, int[] result, boolean[] used) {
        if (count == endCount) { // 停止回溯
            return;
        }
        if (i == n) { // 排列完成
            count++;
        }
        for (int j = 0; j < n; j++) {
            if (count == endCount) { // 停止循环
                return;
            }
            if (used[j]) {
                continue;
            }
            used[j] = true;
            result[i] = j + 1;
            // 下一位
            getPermutationInternal1(i + 1, n, result, used);
            // 回溯
            used[j] = false;
        }
    }


    public static void main(String[] args) {
        Subject60 subject = new Subject60();
        System.out.print(subject.getPermutation(3, 3));
    }

}
