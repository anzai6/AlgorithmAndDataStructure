package com.leetcode.anzai.subject_21_40;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Subject35 {

    /**
     *
     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

     你可以假设数组中无重复元素。

     示例 1:

     输入: [1,3,5,6], 5
     输出: 2
     示例?2:

     输入: [1,3,5,6], 2
     输出: 1
     示例 3:

     输入: [1,3,5,6], 7
     输出: 4
     示例 4:

     输入: [1,3,5,6], 0
     输出: 0
     *
     */

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }


    /**
     * 在有序数组中进行二分查找，如果存在obj就返回对应的下标，不存在就返回需要插入的下标位置
     * 二分查找最主要的是要注意连续相等的情况
     *
     * @param obj
     * @return
     */
    private int binarySearch(int[] list, int obj) {
        if (list == null)
            return -1;
        int count = list.length;
        if (count == 0)
            return 0;

        int low = 0;
        int high = count - 1;
        int center = (low + high) / 2;

        if (obj <= list[0]) { // 判断第一个，做优化防止极端情况要不停的往下区间移动
            return 0;
        }

        if (list[count - 1] < obj) { // 判断最后一个，做优化防止极端情况要不停的往上区间移动
            return count;
        }

        if (list[count - 1] == obj) { // 判断最后一个，做优化防止极端情况要不停的往上区间移动
            return count - 1;
        }

        if (count == 2) // 长度为2的时候，前面两个已经判断了插入0和2的情况，所有只剩1了
            return 1;

        low = 1;
        high = count - 2;

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
            while (center < count - 1 && list[center + 1] == list[center]) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        Subject35 subject = new Subject35();
        System.out.print(subject.searchInsert(nums, 3));
    }

}
