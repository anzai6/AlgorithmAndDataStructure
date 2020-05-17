package com.example.lib.course57_exercise.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ������֮��
 * https://leetcode-cn.com/problems/3sum/
 */
public class SolutionThreeSum {

    /**
     * �������ڵ�����֮��(���в����԰����ظ�����Ԫ��)
     *
     * ����ʹ�õķ����ǣ�������Ȼ����������жϺ�ȥ�أ�Ȼ�����һ�����õ��Ƕ��ֲ���
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> pList = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return pList;

        Arrays.sort(nums);
        int zeroIndex = binarySearchZero(nums); // �ҵ�0��λ��
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {

            // ����������0�����������
            if (nums[i] == 0 && 0 == nums[i + 1] && 0 == nums[i + 2]) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                pList.add(list);
                return pList;
            }

            if (nums[i] >= 0) // û������0�򵱴��ڵ���0ʱ��������������Ϊû�и�����0�Ͳ��������Ϊ0
                return pList;

            // ����������Ⱦ�����һ��
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                continue;
            }

            for (int j = i + 1; j < length - 1; j++) {
                // ����������Ⱦ�����һ��
                if (j < length - 2 && nums[j] == nums[j + 1] && nums[j] == nums[j + 2]) {
                    continue;
                }

                int numTotal = nums[j] + nums[i];
                if (numTotal > 0) // �ʹ���0�Ͳ������±�����
                    break;

                if (-numTotal > nums[length - 1]) // �������һ����Ҳ���ñ�����
                    continue;

                int k = j + 1;
                k = k > zeroIndex ? k : zeroIndex; // ���һ��ֵ���ٴ�0��λ��zeroIndex��ʼ��

                /*
                for (; k < length; k++) {

                    if (nums[i] + nums[j] + nums[k] > 0) // ����0֮��ľͲ��ñ����ˣ���Ϊ���Ǵ��ڵģ�ǰ���Ѿ��ź����ˣ�
                        break;

                    // ��Ϊ�����һ�����֣������ظ���ֻѡ��һ��
                    while (k < length - 1 && nums[k] == nums[k + 1]) {
                        k++;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        pList.add(list);
                    }

                }
                */
                // ���һ�������ñ�������Ϊ���ֲ��ң�
                // ��ʵ���һ���������ﻹ�����ò�¡�������Ż����������ʱ�򹹽��������Ĳ�¡��������Ȼ����ҵ�ʱ�临�ӶȾ���1��
                int totalIndex = binarySearch(nums, k, -numTotal);
                if (totalIndex != -1) { // �ҵ�
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[totalIndex]);
                    pList.add(list);
                }


                // ��������ұ�����һ���������һ��
                if (nums[j] == nums[j + 1]) {
                    j++;
                    continue;
                }
            }

            // ��������ұ�����һ���������һ��
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
        }
        return pList;
    }


    /**
     * ���ֲ���0��λ�ã�û�оͲ���0Ҫ�����λ��(����һ��������λ��)
     *
     * @return
     */
    private int binarySearchZero(int[] list) {
        if (list == null || list.length == 0)
            return 0;

        int low = 0;
        int high = list.length - 1;
        int center = (low + high) / 2;
        int obj = 0;

        if (obj <= list[0]) { // �жϵ�һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return 0;
        }

        if (list[list.length - 1] <= obj) { // �ж����һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return list.length;
        }

        if (list.length == 2) // ����Ϊ2��ʱ��ǰ�������Ѿ��ж��˲���0��2�����������ֻʣ1��
            return 1;

        low = 1;
        high = list.length - 2;

        while (low < high) {
            if (list[center] < obj) { // obj��������
                low = center + 1;
            } else if (list[center] > obj) { // obj��������
                high = center - 1;
            } else { // ���
                return center;
            }
            center = (low + high) / 2;
        }

        // ������low=high=center�����

        // ���￪ʼ����һ�����󣬺�����������ȵ����������77���ж�7<8 ֮��ֱ�Ӳ��룬�ͻᵼ�²�����787����������
        if (list[center] < obj) { // obj��������
            // ȥ����������ȵ�ֵ
            while (center < list.length - 1 && list[center + 1] == list[center]) {
                ++center;
            }
            ++center;
        } else if (list[center] > obj) { // obj��������,�����俪ʼҲ����һ������һ��ʼ����--center;����ʵ�������䲻�ü�һ��
            // ȥ����������ȵ�ֵ
            while (center > 0 && list[center - 1] == list[center]) {
                --center;
            }
//            --center  ����Ҫ����ע�����
        }

        return center < 0 ? 0 : center; // ����λ��
    }


    /**
     * ���ֲ��ң��Ҳ����ͷ���-1
     *
     * @param list
     * @param low  �����λ�ÿ�ʼ���ֲ���
     * @param obj
     * @return
     */
    private int binarySearch(int[] list, int low, int obj) {
        int count = list.length;
        if (count == 0)
            return -1;

        int high = count - 1;
        int center = (low + high) / 2;

        while (low <= high) {
            if (list[center] < obj) { // obj��������
                low = center + 1;
            } else if (list[center] > obj) { // obj��������
                high = center - 1;
            } else { // ���
                return center;
            }
            center = (low + high) / 2;
        }

        return -1;
    }


    public static void main(String[] args) {
        SolutionThreeSum solution = new SolutionThreeSum();
        int[] nums = new int[]{-13, 5, 13, 12, -2, -11, -1, 12, -3, 0, -3, -7, -7, -5, -3, -15, -2, 14, 14, 13, 6, -11, -11, 5, -15, -14, 5, -5, -2, 0, 3, -8, -10, -7, 11, -5, -10, -5, -7, -6, 2, 5, 3, 2, 7, 7, 3, -10, -2, 2, -12, -11, -1, 14, 10, -9, -15, -8, -7, -9, 7, 3, -2, 5, 11, -13, -15, 8, -3, -7, -12, 7, 5, -2, -6, -3, -10, 4, 2, -5, 14, -3, -1, -10, -3, -14, -4, -3, -7, -4, 3, 8, 14, 9, -2, 10, 11, -10, -4, -15, -9, -1, -1, 3, 4, 1, 8, 1};
        List<List<Integer>> pList = solution.threeSum(nums);
        if (pList != null) {
            for (int i = 0; i < pList.size(); i++) {
                List<Integer> list = pList.get(i);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(" " + list.get(j));
                }
                System.out.println();
            }
        }
    }
}
