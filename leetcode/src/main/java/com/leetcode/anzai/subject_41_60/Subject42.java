package com.leetcode.anzai.subject_41_60;

/**
 * ����ˮ
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Subject42 {

    /**
     *
     ����?n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��

     Subject42.png

     ������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ����?��л Marcos ���״�ͼ��

     ʾ��:

     ����: [0,1,0,2,1,0,1,3,2,1,2,1]
     ���: 6
     *
     */

    /**
     * �ȴ������ұ�����Ȼ������������
     * ��Ҫ��Ҫ֪�����ֵ��λ�ã�����Ϊ�м�㣬��ߴ������ұ���,�ұߴ����������,��������������е����
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int totalVolume = 0; // �����
        int maxValueIndex = 0; // ���������ֵ���±�

        // ��ͷ��β����
        for (int i = 0; i < height.length; ) {
            int startEdge = height[i];
            int currentVolume = 0;
            int j = i + 1;
            for (; j < height.length; j++) {
                int endEdge = height[j];
                if (endEdge >= startEdge) { // �������ڵ����Լ��ı�
                    if (j - 1 == i) {
                        startEdge = endEdge;
                        i = j;
                        continue;
                    } else {
                        i = j;
                        totalVolume += currentVolume;
                        break;
                    }
                } else { // ����С���Լ��ı�
                    currentVolume += (startEdge - endEdge);
                }
            }
            maxValueIndex = i;
            if (j == height.length)
                break;
        }

        // ��������β��ͷ����,��Ҫ����Щ��û�м���ģ����� 3,1,2 �����β��ͷ���ܼ���
        for (int i = height.length - 1; i >= maxValueIndex; ) {
            int startEdge = height[i];
            int currentVolume = 0;
            int j = i - 1;
            for (; j >= maxValueIndex; j--) {
                int endEdge = height[j];
                if (endEdge >= startEdge) { // �������ڵ����Լ��ı�
                    if (j - 1 == i) {
                        i = j;
                        continue;
                    } else {
                        i = j;
                        totalVolume += currentVolume;
                        break;
                    }
                } else { // ����С���Լ��ı�
                    currentVolume += (startEdge - endEdge);
                }
            }
            if (j == maxValueIndex - 1)
                break;
        }

        return totalVolume;
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{};
        Subject42 subject = new Subject42();
        System.out.println(subject.trap(candidates));
    }

}
