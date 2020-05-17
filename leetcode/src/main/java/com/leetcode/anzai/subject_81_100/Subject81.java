package com.leetcode.anzai.subject_81_100;

/**
 * ������ת�������� II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Subject81 {

    /**
     *
     ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

     ( ���磬����   [0,0,1,2,2,5,6]   ���ܱ�Ϊ   [2,5,6,0,0,1,2]   )��

     ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ���   true�����򷵻�   false��

     ʾ��   1:

     ����: nums = [2,5,6,0,0,1,2], target = 0
     ���: true
     ʾ��   2:

     ����: nums = [2,5,6,0,0,1,2], target = 3
     ���: false
     ����:

     ���� ������ת�������� ��������Ŀ�������е� nums ���ܰ����ظ�Ԫ�ء�
     ���Ӱ�쵽�����ʱ�临�Ӷ��𣿻���������Ӱ�죬Ϊʲô��
     *
     */

    /**
     * ��ʼ˼·�����ö��������ҵ����ֵ��������ֳ��������䣬Ȼ�����ö���������target
     * <p>
     * ����ʮ����Ĵ��������޸ĵģ������е� nums ���ܰ����ظ�Ԫ�ػᵼ��Ѱ�����ֵ������ʱ����ܻ�����������飬
     * ���Ӷȴ�O(logn)�ᵽ��O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int maxIndex = getMaxIndex(nums); // �ҳ������е����ֵ�±�
        int low;
        int high;
        if (target > nums[0]) { // target �ڴ�����
            low = 1;
            high = maxIndex;
        } else if (target < nums[0]) { // target ��С����
            low = maxIndex + 1;
            high = nums.length - 1;
        } else {
            return true;
        }

        int center;
        while (low <= high) {
            center = (low - high) / 2 + high;
            if (nums[center] > target) {
                high = center - 1;
            } else if (nums[center] < target) {
                low = center + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * �������������ֵ�±�
     *
     * @param nums
     * @return
     */
    private int getMaxIndex(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int maxValue = nums[0];
        int maxIndex = 0;
        int center;

        // �������� while �ǹؼ�����ȥ��ǰ��ͺ��沿�ָ���һ���ظ���ֵ����������������鷳����������ȵ�ֵ�����ж��ƶ��Ǹ��±�
        while (low < nums.length && nums[low] == maxValue) {
            low++;
        }
        while (high >= 0 && nums[high] == maxValue) {
            high--;
        }

        while (low <= high) {
            center = (high - low) / 2 + low;
            if (nums[center] >= maxValue) {
                maxValue = nums[center];
                maxIndex = center;
                low = center + 1;
            } else {
                high = center - 1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        Subject81 subject = new Subject81();
        System.out.println(subject.search(nums, 3));
    }

}
