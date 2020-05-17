package com.leetcode.anzai.subject_41_60;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Subject55 {

    /**
     *
     给定一个非负整数数组，你最初位于数组的第一个位置。

     数组中的每个元素代表你在该位置可以跳跃的最大长度。

     判断你是否能够到达最后一个位置。

     示例?1:

     输入: [2,3,1,1,4]
     输出: true
     解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     示例?2:

     输入: [3,2,1,0,4]
     输出: false
     解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     */

    /**
     * 贪心算法：一遍遍历，保存最远跳跃位置
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int fastPos = 0; // 最远位置
        for (int i = 0; i < nums.length; i++) {
            if (fastPos < i) { // 后面不用遍历了
                return false;
            }
            int pos = i + nums[i];
            if (fastPos < pos) {
                fastPos = pos;
            }
            if (fastPos >= nums.length - 1) { // 到达终点
                return true;
            }
        }
        System.out.println(fastPos);
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{1, 0, 0, 0, 4};
        Subject55 subject = new Subject55();
        System.out.print(subject.canJump(nums));
    }

}
