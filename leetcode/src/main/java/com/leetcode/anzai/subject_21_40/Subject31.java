package com.leetcode.anzai.subject_21_40;

/**
 * ��һ������
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class Subject31 {

    /**
     *
     ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

     �����������һ����������У��������������г���С�����У����������У���

     ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

     ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
     1,2,3 �� 1,3,2
     3,2,1 �� 1,2,3
     1,1,5 �� 1,5,1
     *
     */

    /**
     * ��ͨ�汾
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int len = nums.length;
        int swapIndex = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) { // �ҵ���ǰһλ�������Ȼ�󽻻�λ��
                // ��i��������ҵ�����nums[i - 1]�е���Сֵ
                int minValue = nums[i];
                int minIndex = i;
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < minValue && nums[j] > nums[i - 1]) {
                        minValue = nums[j];
                        minIndex = j;
                    }
                }

                // ���������nums[i - 1]�е���Сֵ��nums[i - 1]����
                nums[minIndex] = nums[i - 1];
                nums[i - 1] = minValue;
                swapIndex = i;
                break;
            }
        }

        // ��swapIndex�±�֮��Ľ��з�ת
        reverse(nums, swapIndex);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j && nums[i] > nums[j]) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{ 2, 3, 1};
        int[] nums = new int[]{2, 3, 1, 3, 3}; // 557432
//        int[] nums = new int[]{1, 100, 8, 7, 6, 5, 4, 3, 2}; // 1,2,4,3,5 -> 1,2,4,5,3
        // 1,2,5,4,3 -> 1,3,2,4,5
        Subject31 subject = new Subject31();
        subject.nextPermutation(nums);
        for (Integer value : nums) {
            System.out.print(value + " ");
        }
    }

}
