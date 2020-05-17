package com.leetcode.anzai.subject_81_100;

import java.util.Arrays;

/**
 * �ϲ�������������
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Subject88 {

    /**
     *
     �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣

     ˵��:

     ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
     ����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
     ʾ��:

     ����:
     nums1 = [1,2,3,0,0,0], m = 3
     nums2 = [2,5,6],       n = 3

     ���: [1,2,2,3,5,6]
     *
     */

    /**
     * �ٷ��ⷨ���ܿᣬԭ����ʱ�临�Ӷ���O(m+n),���ҵķ���2���ƣ�ֻ�Ǹ�Ϊ��β����ʼ����
     * ͨ������˼ά�Ǵ�С�����������˼ά�Ӵ�С������Ϳ���ʡ��O(m)�Ŀռ��ˣ�����.....
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m + n || nums2.length < n || n == 0) {
            return;
        }

        // ���� nums1

        int index1 = m - 1; // nums1 ��Ҫ������±�
        int index2 = n - 1; // nums2 ��Ҫ������±�
        int index3 = m + n - 1; // nums1 ����õ��±�
        while (index1 >= 0 && index2 >= 0) {
            int value1 = nums1[index1];
            int value2 = nums2[index2];
            if (value1 >= value2) {
                nums1[index3] = value1;
                index1--;
            } else {
                nums1[index3] = value2;
                index2--;
            }
            index3--;
        }

        while (index1 >= 0) {
            nums1[index3--] = nums1[index1--];
        }

        while (index2 >= 0) {
            nums1[index3--] = nums2[index2--];
        }
    }

    /**
     * 1.ԭ���㷨�Ļ�����nums2���뵽nums1β�������ò�������ԭ���m+1��ʼ��������nums1
     * 2.����һ�������飬��nums1��Ԫ�ظ��Ƴ������㷨�ռ���O(m)
     * <p>
     * �����õ��Ƿ���2
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m + n || nums2.length < n || n == 0) {
            return;
        }

        // ���� nums1
        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        int index1 = 0; // nums1 �±�
        int index2 = 0; // nums2 �±�
        int index3 = 0; // nums3 �±�
        while (index3 < m && index2 < n) {
            int value3 = nums3[index3];
            int value2 = nums2[index2];
            if (value3 <= value2) {
                nums1[index1] = value3;
                index3++;
            } else {
                nums1[index1] = value2;
                index2++;
            }
            index1++;
        }

        while (index3 < m) {
            nums1[index1++] = nums3[index3++];
        }

        while (index2 < n) {
            nums1[index1++] = nums2[index2++];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Subject88 subject = new Subject88();
        subject.merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

}
