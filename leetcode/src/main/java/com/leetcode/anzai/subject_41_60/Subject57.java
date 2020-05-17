package com.leetcode.anzai.subject_41_60;

/**
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class Subject57 {

    /**
     *
     给出一个无重叠的 ，按照区间起始端点排序的区间列表。

     在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

     示例?1:

     输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     输出: [[1,5],[6,9]]
     示例?2:

     输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     输出: [[1,2],[3,10],[12,16]]
     解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]?重叠。
     *
     */

    /**
     * 新建一个中间值区间列表，然后遍历区间列表的每一个区间，判断是否能跟新区间合并，
     * 不合并和添加到中间值列表，合并则继续遍历，直到能插入区间列表
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length != 2) {
            return intervals;
        }
        if (intervals == null || intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0][0] = newInterval[0];
            intervals[0][1] = newInterval[1];
            return intervals;
        }

        int[][] centerResult = new int[intervals.length + 1][2]; // 中间过渡数组
        boolean isAddNew = false; // 判断是否添加新区间
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {

            if (isAddNew) { // 已经添加了新区间
                centerResult[count][0] = intervals[i][0];
                centerResult[count][1] = intervals[i][1];
                count++;
            } else {
                int cuLow = intervals[i][0];
                int cuHigh = intervals[i][1];

                int nextLow = newInterval[0];
                int nextHigh = newInterval[1];

                if (cuLow > nextHigh || nextLow > cuHigh) { // 两个区间不能合并
                    if (cuLow > nextHigh) { // 先合并新区间
                        centerResult[count][0] = nextLow;
                        centerResult[count][1] = nextHigh;
                        count++;
                        isAddNew = true;
                    }
                    centerResult[count][0] = cuLow;
                    centerResult[count][1] = cuHigh;
                    count++;
                } else { // 可以合并，则合并后赋值新区间
                    // 合并到新区间
                    newInterval[0] = Math.min(nextLow, cuLow);
                    newInterval[1] = Math.max(nextHigh, cuHigh);
                }
            }

        }

        if (!isAddNew) { // 还没有添加新区间
            centerResult[count][0] = newInterval[0];
            centerResult[count][1] = newInterval[1];
            count++;
        }

        int[][] result = new int[count][2];
        for (int i = 0; i < count; i++) {
            result[i][0] = centerResult[i][0];
            result[i][1] = centerResult[i][1];
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] newInterval = new int[]{0, 1};
//        int[][] intervals = new int[][]{{2, 5}, {6, 7}, {8, 9}};
//        int[] newInterval = new int[]{6, 8};
//        int[][] intervals = new int[][]{{1, 5}};
//        int[] newInterval = new int[]{2, 5};
//        int[][] intervals = new int[][]{};
//        int[] newInterval = new int[]{2, 5};
//        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
//        int[] newInterval = new int[]{0, 0};
//        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{4, 8};
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        Subject57 subject = new Subject57();
        intervals = subject.insert(intervals, newInterval);
        if (intervals != null) {
            for (int i = 0; i < intervals.length; i++) {
                System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            }
        }
    }

}
