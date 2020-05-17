package com.leetcode.anzai.subject_41_60;

/**
 * ��������
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class Subject57 {

    /**
     *
     ����һ�����ص��� ������������ʼ�˵�����������б�

     ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��

     ʾ��?1:

     ����: intervals = [[1,3],[6,9]], newInterval = [2,5]
     ���: [[1,5],[6,9]]
     ʾ��?2:

     ����: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     ���: [[1,2],[3,10],[12,16]]
     ����: ������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10]?�ص���
     *
     */

    /**
     * �½�һ���м�ֵ�����б�Ȼ����������б��ÿһ�����䣬�ж��Ƿ��ܸ�������ϲ���
     * ���ϲ�����ӵ��м�ֵ�б��ϲ������������ֱ���ܲ��������б�
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

        int[][] centerResult = new int[intervals.length + 1][2]; // �м��������
        boolean isAddNew = false; // �ж��Ƿ����������
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {

            if (isAddNew) { // �Ѿ������������
                centerResult[count][0] = intervals[i][0];
                centerResult[count][1] = intervals[i][1];
                count++;
            } else {
                int cuLow = intervals[i][0];
                int cuHigh = intervals[i][1];

                int nextLow = newInterval[0];
                int nextHigh = newInterval[1];

                if (cuLow > nextHigh || nextLow > cuHigh) { // �������䲻�ܺϲ�
                    if (cuLow > nextHigh) { // �Ⱥϲ�������
                        centerResult[count][0] = nextLow;
                        centerResult[count][1] = nextHigh;
                        count++;
                        isAddNew = true;
                    }
                    centerResult[count][0] = cuLow;
                    centerResult[count][1] = cuHigh;
                    count++;
                } else { // ���Ժϲ�����ϲ���ֵ������
                    // �ϲ���������
                    newInterval[0] = Math.min(nextLow, cuLow);
                    newInterval[1] = Math.max(nextHigh, cuHigh);
                }
            }

        }

        if (!isAddNew) { // ��û�����������
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
