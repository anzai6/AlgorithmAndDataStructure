package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���
 * https://leetcode-cn.com/problems/combinations/
 */
public class Subject77 {

    /**
     *
     ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�

     ʾ��:

     ����:?n = 4, k = 2
     ���:
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
     * ʹ�û����㷨
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
     * �����㷨
     *
     * @param n
     * @param k
     * @param startIndex ��ʼ�����ĵ㣬����Ϊ�˷��ظ������������ 1 ���� 2 ��Ͳ��û�ͷ���� 1 ��
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

        if (n + 1 < k + startIndex) { // ����������ľ�����
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            used[i] = true;
            combineInternal(n, k - 1, i + 1, list, used);
            used[i] = false; // ����
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
