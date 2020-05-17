package com.leetcode.anzai.subject_41_60;

/**
 * �ϲ�����
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Subject56 {

    /**
     *
     ����һ������ļ��ϣ���ϲ������ص������䡣

     ʾ�� 1:

     ����: [[1,3],[2,6],[8,10],[15,18]]
     ���: [[1,6],[8,10],[15,18]]
     ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
     ʾ��?2:

     ����: [[1,4],[4,5]]
     ���: [[1,5]]
     ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
     *
     */

    /**
     * �ο�ѡ������ÿ��ѡ��һ���ͺ������������ж��Ƿ��ܺϲ���ȥ
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
        int noMergeIndex = 0;// ��Ų��ܺϲ��������±�
        for (int i = 0; i < intervals.length; i++) {
            int cuLow = intervals[i][0];
            int cuHigh = intervals[i][1];
            boolean hasMerge = false;
            // ����i���������һ�����ȶԣ�������ص��ͺϲ�������ѭ�������û�п��Ժϲ��ľʹ��list��
            for (int j = i + 1; j < intervals.length; j++) {
                int nextLow = intervals[j][0];
                int nextHigh = intervals[j][1];

                if (cuLow > nextHigh || nextLow > cuHigh) { // �������䲻�ܺϲ�
                    continue;
                } else { // ���Ժϲ�
                    hasMerge = true;
                    intervals[j][0] = Math.min(nextLow, cuLow);
                    intervals[j][1] = Math.max(nextHigh, cuHigh);
                    break;
                }
            }

            if (!hasMerge) { // ��ǰ����û�и������ĺϲ�
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
