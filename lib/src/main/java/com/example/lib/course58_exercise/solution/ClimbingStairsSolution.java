package com.example.lib.course58_exercise.solution;

/**
 * ��¥��
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairsSolution {

    /**
     *
     ������������¥�ݡ���Ҫ n ������ܵ���¥����

     ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�

     ע�⣺���� n ��һ����������

     ʾ�� 1��

     ���룺 2
     ����� 2
     ���ͣ� �����ַ�����������¥����
     1.  1 �� + 1 ��
     2.  2 ��
     ʾ�� 2��

     ���룺 3
     ����� 3
     ���ͣ� �����ַ�����������¥����
     1.  1 �� + 1 �� + 1 ��
     2.  1 �� + 2 ��
     3.  2 �� + 1 ��


     �������õݹ���⣬��ʽ��
     f(n) = f(n-1) + f(n-2)
     *
     */

    /**
     * ��̬�滮�ⷨ���Ľ��棬ʡ��O(n)�ռ临�Ӷ�
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 2; // ��ǰһλ���൱��f(n-1)
        int second = 1; // ��ǰ��λ���൱��f(n-2)
        int result = 0;
        for (int i = 3; i < n + 1; i++) {
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }

    /**
     * ��̬�滮�ⷨ������f(n) = f(n-1) + f(n-2)���ɽ��
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }

    /**
     * �ݹ�ⷨ���ݹ鹫ʽΪ
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 0)
            return 0;
        int[] isGet = new int[n + 1];
        for (int i = 0; i < n; i++) {
            isGet[i] = 0;
        }
        return climbStairs(isGet, n);
    }

    public int climbStairs(int[] isGet, int n) {
        if (n <= 0)
            return 0;
        if (n == 1) {
            isGet[1] = 1;
            return 1;
        }
        if (n == 2) {
            isGet[2] = 2;
            return 2;
        }

        if (isGet[n] == 0)
            isGet[n] = climbStairs(isGet, n - 1) + climbStairs(isGet, n - 2);

        return isGet[n];
    }

    public static void main(String[] args) {
        ClimbingStairsSolution solution = new ClimbingStairsSolution();
        System.out.print(solution.climbStairs(44) + "");
    }
}
