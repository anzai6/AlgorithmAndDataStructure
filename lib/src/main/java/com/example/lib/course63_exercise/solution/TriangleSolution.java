package com.example.lib.course63_exercise.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������С·����
 * https://leetcode-cn.com/problems/triangle/
 */

public class TriangleSolution {

    /**
     *
     ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�

     ���磬���������Σ�

     [
        [2],
       [3,4],
      [6,5,7],
     [4,1,8,3]
     ]
     �Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����


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

     ˵����

     ��������ֻʹ�� O(n) �Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�

     *
     */

    /**
     * ��̬�滮
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int len = triangle.size();
        int[] result = new int[len]; // �洢����ĳһ��ʱÿ����������С·��
        int maxResult = Integer.MAX_VALUE;

        // ��һ����
        result[0] = triangle.get(0).get(0);
        if (len == 1)
            maxResult = result[0];

        for (int i = 1; i < len; i++) {
            List<Integer> list = triangle.get(i);
            int left = 0; // ���Ͻ�
            int right = 0; // ���Ͻ�
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j);
                if (j == 0) { // ��һ�������Ͻ�
                    right = result[0];
                    result[0] = right + value;
                    // ��ǰ����һλ�������Ͻ�,���Ͻǵ�ֵ
                    left = right;
                    right = result[1];
                } else if (j == list.size() - 1) { // ���һ�������Ͻ�
                    result[j] = left + value;
                } else {
                    result[j] = Math.min(right, left) + value; // ȡ���Ͻ�,���Ͻǹ�������Сֵ
                    // ��ǰ����һλ�������Ͻ�,���Ͻ�,���Ϸ���ֵ
                    left = right;
                    if (1 + j < list.size())
                        right = result[j + 1];
                }
                // ������ֵ
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
