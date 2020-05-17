package com.leetcode.anzai.subject_41_60;

/**
 * ��k������
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Subject60 {

    /**
     *
     ��������?[1,2,3,��,n]��������Ԫ�ع���?n! �����С�

     ����С˳���г����������������һһ��ǣ���?n = 3 ʱ, �����������£�

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     ����?n ��?k�����ص�?k?�����С�

     ˵����

     ���� n?�ķ�Χ�� [1, 9]��
     ���� k?�ķ�Χ��[1, ?n!]��
     ʾ��?1:

     ����: n = 3, k = 3
     ���: "213"
     ʾ��?2:

     ����: n = 4, k = 9
     ���: "2314"
     *
     */

    /**
     * �����㷨���Ż����ο����Ѽ�֦˼·:
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if (n <= 0 || k == 0) {
            return "";
        }
        // ����ֻ��9���������ȶ���ÿһ���׳ˣ��磺8�� = 40320; 7! = 5040;
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] used = new boolean[n];
        int[] result = new int[n];
        return getPermutationInternal(0, n, k, result, used, factorial);
    }

    /**
     * ����
     *
     * @param i      // ��ǰ���е�λ��
     * @param n
     * @param result
     */
    private String getPermutationInternal(int i, int n, int k, int[] result, boolean[] used, int[] factorial) {
        if (i == n) { // �������
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

            int subItemCount = factorial[n - i - 1]; // �������������ڼ�֦,����ŵ�һλ��ʱ��ÿһ���������� 8! ��,���������ֵ����֦
            if (subItemCount < k) { // ���ڵ�ǰ��ʱ����ȥ��������ֱ��������һ�ʡ���м�����У���֦�ľ���
                k -= subItemCount;
                continue;
            }

            used[j] = true;
            result[i] = j + 1;
            // ��һλ
            return getPermutationInternal(i + 1, n, k, result, used, factorial);
        }
        return "������";
    }

    /**
     * ͨ�������㷨�Լ������ж�(���׳�ʱ������ȫ�������)
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
     * ����
     *
     * @param i      // ��ǰ���е�λ��
     * @param n
     * @param result
     */
    private void getPermutationInternal1(int i, int n, int[] result, boolean[] used) {
        if (count == endCount) { // ֹͣ����
            return;
        }
        if (i == n) { // �������
            count++;
        }
        for (int j = 0; j < n; j++) {
            if (count == endCount) { // ֹͣѭ��
                return;
            }
            if (used[j]) {
                continue;
            }
            used[j] = true;
            result[i] = j + 1;
            // ��һλ
            getPermutationInternal1(i + 1, n, result, used);
            // ����
            used[j] = false;
        }
    }


    public static void main(String[] args) {
        Subject60 subject = new Subject60();
        System.out.print(subject.getPermutation(3, 3));
    }

}
