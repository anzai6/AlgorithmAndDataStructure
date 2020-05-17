package com.leetcode.anzai.subject_1_20;

/**
 * ʢ���ˮ������
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Subject11 {

    /**
     *
     ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��

     ˵�����㲻����б��������?n?��ֵ����Ϊ 2��

     subject_11.jpg

     ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ?49��

     ?

     ʾ��:

     ����: [1,8,6,2,5,4,8,3,7]
     ���: 49
     *
     */

    /**
     * �ٷ��ⷨ�����Ҿ�ͷ˫ָ�룬С��ָ�����м��ƶ���ֱ���ҵ��������
     * ע�⣺��С��ָ�����м��ƶ�����Ϊ���м��ƶ���Ȼ���٣�������Ҫ�ƶ�����Сָ�룬�����߶Ȳſ��ܱ��
     * ����ƶ����Ǵ�ָ�룬�����߶Ⱦ�ֻ����Сָ���ֵ����������Ч��
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int maxArea = Integer.MIN_VALUE;
        int low = 0; // ��ߵ�ָ��
        int high = height.length - 1; // �ұߵ�ָ��
        while (low < high) {
            int lowValue = height[low];
            int highValue = height[high];
            int minValue = lowValue;
            int interval = high - low;
            if (lowValue >= highValue) {
                minValue = highValue;
                high--;
            } else {
                low++;
            }
            int area = interval * minValue;
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }


    /**
     * ��ͨ�ⷨ��ȫ����
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Subject11 subject = new Subject11();
        System.out.println(subject.maxArea(height));
    }
}
