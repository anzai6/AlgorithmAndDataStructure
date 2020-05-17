package com.example.lib.course57_exercise.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class SolutionThreeSum {

    /**
     * 求数组内的三数之和(答案中不可以包含重复的三元组)
     *
     * 这里使用的方法是：先排序，然后各种条件判断和去重，然后最后一个数用的是二分查找
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> pList = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return pList;

        Arrays.sort(nums);
        int zeroIndex = binarySearchZero(nums); // 找到0的位置
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {

            // 遍历到三个0，则遍历结束
            if (nums[i] == 0 && 0 == nums[i + 1] && 0 == nums[i + 2]) {
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                pList.add(list);
                return pList;
            }

            if (nums[i] >= 0) // 没有三个0则当大于等于0时，遍历结束，因为没有负数和0就不可能相加为0
                return pList;

            // 连续三个相等就跳过一个
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                continue;
            }

            for (int j = i + 1; j < length - 1; j++) {
                // 连续三个相等就跳过一个
                if (j < length - 2 && nums[j] == nums[j + 1] && nums[j] == nums[j + 2]) {
                    continue;
                }

                int numTotal = nums[j] + nums[i];
                if (numTotal > 0) // 和大于0就不用往下遍历了
                    break;

                if (-numTotal > nums[length - 1]) // 大于最后一个数也不用遍历了
                    continue;

                int k = j + 1;
                k = k > zeroIndex ? k : zeroIndex; // 最后一个值至少从0的位置zeroIndex开始找

                /*
                for (; k < length; k++) {

                    if (nums[i] + nums[j] + nums[k] > 0) // 大于0之后的就不用遍历了，因为都是大于的（前面已经排好序了）
                        break;

                    // 因为是最后一个数字，所以重复的只选择一个
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
                // 最后一个数不用遍历，改为二分查找，
                // 其实最后一步查找这里还可以用布隆过滤器优化，在排序的时候构建好正数的布隆过滤器，然后查找的时间复杂度就是1了
                int totalIndex = binarySearch(nums, k, -numTotal);
                if (totalIndex != -1) { // 找到
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[totalIndex]);
                    pList.add(list);
                }


                // 两个相等且遍历了一个后就跳过一个
                if (nums[j] == nums[j + 1]) {
                    j++;
                    continue;
                }
            }

            // 两个相等且遍历了一个后就跳过一个
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }
        }
        return pList;
    }


    /**
     * 二分查找0的位置，没有就查找0要插入的位置(即第一个正数的位置)
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

        if (obj <= list[0]) { // 判断第一个，做优化防止极端情况要不停的往下区间移动
            return 0;
        }

        if (list[list.length - 1] <= obj) { // 判断最后一个，做优化防止极端情况要不停的往上区间移动
            return list.length;
        }

        if (list.length == 2) // 长度为2的时候，前面两个已经判断了插入0和2的情况，所有只剩1了
            return 1;

        low = 1;
        high = list.length - 2;

        while (low < high) {
            if (list[center] < obj) { // obj在上区间
                low = center + 1;
            } else if (list[center] > obj) { // obj在下区间
                high = center - 1;
            } else { // 相等
                return center;
            }
            center = (low + high) / 2;
        }

        // 下面是low=high=center的情况

        // 这里开始犯了一个错误，忽略了连续相等的情况，比如77，判断7<8 之后直接插入，就会导致插入了787这样的数据
        if (list[center] < obj) { // obj在上区间
            // 去掉相邻且相等的值
            while (center < list.length - 1 && list[center + 1] == list[center]) {
                ++center;
            }
            ++center;
        } else if (list[center] > obj) { // obj在下区间,下区间开始也犯了一个错误，一开始用了--center;，其实在下区间不用减一了
            // 去掉相邻且相等的值
            while (center > 0 && list[center - 1] == list[center]) {
                --center;
            }
//            --center  不需要减，注意理解
        }

        return center < 0 ? 0 : center; // 插入位置
    }


    /**
     * 二分查找，找不到就返回-1
     *
     * @param list
     * @param low  从这个位置开始二分查找
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
            if (list[center] < obj) { // obj在上区间
                low = center + 1;
            } else if (list[center] > obj) { // obj在下区间
                high = center - 1;
            } else { // 相等
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
