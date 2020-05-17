package com.leetcode.anzai.subject_1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class Subject18 {

    /**
     *
     给定一个包含?n 个整数的数组?nums?和一个目标值?target，判断?nums?中是否存在四个元素 a，b，c?和 d?，使得?a + b + c + d?的值与?target?相等？找出所有满足条件且不重复的四元组。

     注意：

     答案中不可以包含重复的四元组。

     示例：

     给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

     满足要求的四元组集合为：
     [
     [-1,  0, 0, 1],
     [-2, -1, 1, 2],
     [-2,  0, 0, 2]
     ]
     *
     */

    /**
     * 三数之和的再加一外层就是四数之和了，关键是双指针找到满足条件值后下一次遍历
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
                    else { // 相等
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
                        //进入下一次遍历，这里是关键,注意是往内继续的，因为查找区间肯定是往内缩的
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
