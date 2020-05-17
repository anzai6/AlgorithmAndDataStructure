package com.example.lib.course58_exercise.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 递归练习
 */
public class RecursionExercise {

    /**
     * 斐波那契数列求值
     *
     * @param n
     * @return
     */
    public int fibonacciSequence(int n) {
        if (n <= 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }

    /**
     * 阶乘 n!
     *
     * @param n
     * @return
     */
    public int factorial(int n) {
        if (n <= 0)
            return 0;

        if (n == 1)
            return 1;

        return factorial(n - 1) * n;
    }

    /**
     * 实现一组数据集合的全排列,即所有排列顺序
     *
     * @param data
     * @param length
     * @return
     */
    public List<List<Integer>> factorial(int[] data, int length) {
        if (data == null)
            return null;
        List<List<Integer>> list = new ArrayList<>();
        if (length == 0)
            return list;
        if (length == 1) {
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(data[0]);
            list.add(subList);
            return list;
        }

        HashMap<Integer, Character> hashMap = new HashMap<>(); // 去重复

        for (int i = length - 1; i >= 0; i--) {
            int value = data[i];
            if (hashMap.containsKey(value)) // 去重复
                continue;
            hashMap.put(value, '1');
            int a = data[length - 1];
            data[length - 1] = value;
            data[i] = a;
            List<List<Integer>> iList = factorial(copyList(data, length - 1), length - 1);
            for (int j = 0; j < iList.size(); j++) {
                List<Integer> subList = iList.get(j);
                subList.add(value);
                list.add(subList);
            }
        }

        return list;
    }

    private int[] copyList(int[] data, int length) {
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[i] = data[i];
        }
        return list;
    }

    /**
     * 网友的简洁办法，关键是交换后又交换回来，而我做的没有，只是copy了新的
     * @param list
     * @param k
     * @param m
     */
    public void perm(int list[], int k, int m) {
        if (k == m) {//没有到最后一个   所以还需要进行排列
            for (int i = 0; i < list.length; i++)
                System.out.print(list[i] + " ");
            System.out.println();
        } else {//进行排列
            for (int i = k; i <= m; i++) {
                int c = list[i];//进行交换  从而完成全排列
                list[i] = list[k];
                list[k] = c;
                perm(list, k + 1, m);
                c = list[i];//需要交换回来 不然就会乱了顺序
                list[i] = list[k];
                list[k] = c;
            }
        }
    }

    public static void main(String[] args) {
        RecursionExercise recursionExercise = new RecursionExercise();

//        for (int i = 0; i < 20; i++) {
//            System.out.println(recursionExercise.fibonacciSequence(i));
//        }

//        for (int i = 0; i < 20; i++) {
//            System.out.println(recursionExercise.factorial(i));
//        }

        int[] data = new int[]{1, 1, 3, 4, 5};

//        List<List<Integer>> list = recursionExercise.factorial(data, 5);
//        for (int j = 0; j < list.size(); j++) {
//            List<Integer> subList = list.get(j);
//            for (int i = 0; i < subList.size(); i++) {
//                System.out.print(" " + subList.get(i));
//            }
//            System.out.println();
//        }

        recursionExercise.perm(data, 0, data.length - 1);
    }
}
