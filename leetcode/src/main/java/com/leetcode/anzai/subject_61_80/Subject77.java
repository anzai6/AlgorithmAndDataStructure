package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Subject77 {

    /**
     *
     给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

     示例:

     输入:?n = 4, k = 2
     输出:
     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
     *
     */

    /**
     * 使用回溯算法
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        boolean[] used = new boolean[n + 1];
        combineInternal(n, k, 1, list, used);
        return list;
    }

    /**
     * 回溯算法
     *
     * @param n
     * @param k
     * @param startIndex 开始遍历的点，这是为了防重复，比如遍历了 1 ，到 2 后就不用回头遍历 1 了
     * @param list
     * @param used
     */
    public void combineInternal(int n, int k, int startIndex, List<List<Integer>> list, boolean[] used) {
        if (k == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    subList.add(i);
                }
            }
            list.add(subList);
            return;
        }

        if (n + 1 < k + startIndex) { // 个数不满足的就跳过
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            used[i] = true;
            combineInternal(n, k - 1, i + 1, list, used);
            used[i] = false; // 回溯
        }
    }

    public static void main(String[] args) {
        int s = 5;
        int t = 3;
        s = 4;
        t = 2;
        Subject77 subject = new Subject77();
        List<List<Integer>> list = subject.combine(s, t);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = list.get(i);
            if (subList == null) {
                return;
            }
            System.out.print(Arrays.toString(subList.toArray(new Integer[0])));
            System.out.println();
        }

    }

}
