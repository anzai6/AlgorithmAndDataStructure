package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subject78 {

    /**
     *
     给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

     说明：解集不能包含重复的子集。

     示例:

     输入: nums = [1,2,3]
     输出:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     *
     */

    /**
     * 参考网友大神的二进制解法：
     * 集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 1 << nums.length 相当于 2 的 nums.length 次方，等于枚举了所有情况
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            // 比如 nums.length 等于 4，则会有 4 个二进制位，每个进制位为 1 代表选，0 代表不选
            for (int j = 0; j < nums.length; j++) {
                // ((i >> j) & 1) == 1 这个意思是 求出当前 i 的二进制表示中，等于 1 的所有进制位，然后作为下标选择数组相应下标的值
                // 比如 i = 3 ，则为 0011 ，>> j 即位移所有位数（0,1,2,3），当位移第 0 位和第 1 位时表达式为true
                // 相应的会选择数组的下标为 0 和 1 的值，其它以此类推
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>()); // 空的情况
        if (nums == null || nums.length == 0) {
            return list;
        }

        boolean[] used = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            subsetsIntervalBt(nums, i, 0, list, used);
        }

        return list;
    }

    /**
     * 回溯算法:具体实现
     *
     * @param nums
     * @param k          当前需要加入集合的位数
     * @param startIndex 开始遍历的坐标，这是为了防重复，比如遍历了 nums[1] ，到 nums[2] 后就不用回头遍历 nums[1] 了
     * @param list
     * @param used       记录已经加入的位数，用完记得恢复
     */
    public void subsetsIntervalBt(int[] nums, int k, int startIndex, List<List<Integer>> list, boolean[] used) {
        if (k == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < used.length; i++) {
                if (used[i]) {
                    subList.add(nums[i]);
                }
            }
            list.add(subList);
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            used[i] = true;
            subsetsIntervalBt(nums, k - 1, i + 1, list, used);
            used[i] = false; // 回溯
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Subject78 subject = new Subject78();
        List<List<Integer>> list = subject.subsets(nums);
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
