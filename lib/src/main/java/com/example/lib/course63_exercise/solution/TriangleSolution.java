package com.example.lib.course63_exercise.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */

public class TriangleSolution {

    /**
     *
     给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

     例如，给定三角形：

     [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
     ]
     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。


       [1]
      [3,2]
     [3,1,1]

        [2],
       [3,4],
      [6,5,9],
     [4,4,8,0]]

       5,6
      11,10,15
     15,14,18,15

     说明：

     如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

     *
     */

    /**
     * 动态规划
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int len = triangle.size();
        int[] result = new int[len]; // 存储到达某一行时每个坐标点的最小路径
        int maxResult = Integer.MAX_VALUE;

        // 第一个行
        result[0] = triangle.get(0).get(0);
        if (len == 1)
            maxResult = result[0];

        for (int i = 1; i < len; i++) {
            List<Integer> list = triangle.get(i);
            int left = 0; // 左上角
            int right = 0; // 右上角
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j);
                if (j == 0) { // 第一个，右上角
                    right = result[0];
                    result[0] = right + value;
                    // 提前给下一位更新左上角,右上角的值
                    left = right;
                    right = result[1];
                } else if (j == list.size() - 1) { // 最后一个，左上角
                    result[j] = left + value;
                } else {
                    result[j] = Math.min(right, left) + value; // 取左上角,右上角过来的最小值
                    // 提前给下一位更新左上角,右上角,正上方的值
                    left = right;
                    if (1 + j < list.size())
                        right = result[j + 1];
                }
                // 求出最大值
                if(i == len -1&& maxResult > result[j]){
                    maxResult = result[j];
                }
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
//        [[-1],[3,2],[-3,1,-1]]
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList1 = new ArrayList<>();
        subList1.add(2);
        list.add(subList1);
        List<Integer> subList2 = new ArrayList<>();
        subList2.add(3);
        subList2.add(4);
        list.add(subList2);
        List<Integer> subList3 = new ArrayList<>();
        subList3.add(6);
        subList3.add(5);
        subList3.add(9);
        list.add(subList3);
        List<Integer> subList4 = new ArrayList<>();
        subList4.add(4);
        subList4.add(4);
        subList4.add(8);
        subList4.add(0);
        list.add(subList4);
        TriangleSolution solution = new TriangleSolution();
        System.out.println(solution.minimumTotal(list));

    }
}
