package com.leetcode.anzai.subject_41_60;

/**
 * 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Subject56 {

    /**
     *
     给出一个区间的集合，请合并所有重叠的区间。

     示例 1:

     输入: [[1,3],[2,6],[8,10],[15,18]]
     输出: [[1,6],[8,10],[15,18]]
     解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     示例?2:

     输入: [[1,4],[4,5]]
     输出: [[1,5]]
     解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     */

    /**
     * 参考选择排序，每次选择一个和后面所有区间判断是否能合并进去
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }
        if (intervals.length == 0 || intervals[0].length != 2) {
            return intervals;
        }
        int noMergeIndex = 0;// 存放不能合并的区间下标
        for (int i = 0; i < intervals.length; i++) {
            int cuLow = intervals[i][0];
            int cuHigh = intervals[i][1];
            boolean hasMerge = false;
            // 遍历i后面的区间一个个比对，如果有重叠就合并并跳出循环，如果没有可以合并的就存放list中
            for (int j = i + 1; j < intervals.length; j++) {
                int nextLow = intervals[j][0];
                int nextHigh = intervals[j][1];

                if (cuLow > nextHigh || nextLow > cuHigh) { // 两个区间不能合并
                    continue;
                } else { // 可以合并
                    hasMerge = true;
                    intervals[j][0] = Math.min(nextLow, cuLow);
                    intervals[j][1] = Math.max(nextHigh, cuHigh);
                    break;
                }
            }

            if (!hasMerge) { // 当前区间没有跟其它的合并
                intervals[noMergeIndex][0] = intervals[i][0];
                intervals[noMergeIndex][1] = intervals[i][1];
                ++noMergeIndex;
            }

        }

        int[][] result = new int[noMergeIndex][2];
        for (int i = 0; i < noMergeIndex; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {5, 6}};
//        int[][] intervals = new int[][]{{1, 4}, {4, 6}};
//        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}};
        Subject56 subject = new Subject56();
        intervals = subject.merge(intervals);
        if (intervals != null) {
            for (int i = 0; i < intervals.length; i++) {
                System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            }
        }
    }

}
