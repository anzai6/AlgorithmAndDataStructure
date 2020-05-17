package com.leetcode.anzai.subject_1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ����֮��
 * https://leetcode-cn.com/problems/4sum/
 */
public class Subject18 {

    /**
     *
     ����һ������?n ������������?nums?��һ��Ŀ��ֵ?target���ж�?nums?���Ƿ�����ĸ�Ԫ�� a��b��c?�� d?��ʹ��?a + b + c + d?��ֵ��?target?��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣

     ע�⣺

     ���в����԰����ظ�����Ԫ�顣

     ʾ����

     �������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��

     ����Ҫ�����Ԫ�鼯��Ϊ��
     [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
     ]
     *
     */

    /**
     * ����֮�͵��ټ�һ����������֮���ˣ��ؼ���˫ָ���ҵ���������ֵ����һ�α���
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return list;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1, end = nums.length - 1;
                while (start < end && start > j && end > j) {
                    int sum = nums[start] + nums[end] + nums[i] + nums[j];
                    if (sum > target)
                        end--;
                    else if (sum < target)
                        start++;
                    else { // ���
                        String str = "" + nums[i] + nums[j] + nums[start] + nums[end];
                        if (!hashMap.containsKey(str)) {
                            hashMap.put(str, true);
                            List<Integer> subList = new ArrayList<>();
                            subList.add(nums[i]);
                            subList.add(nums[j]);
                            subList.add(nums[start]);
                            subList.add(nums[end]);
                            list.add(subList);
                        }
                        //������һ�α����������ǹؼ�,ע�������ڼ����ģ���Ϊ��������϶�����������
                        start++;
                        end--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int[] nums = new int[]{0, 0, 0, 0};
        Subject18 subject = new Subject18();
        List<List<Integer>> list = subject.fourSum(nums, 0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
