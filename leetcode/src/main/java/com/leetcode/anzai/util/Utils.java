package com.leetcode.anzai.util;

public class Utils {

    /**
     * �����������н��ж��ֲ��ң��������obj�ͷ��ض�Ӧ���±꣬�����ھͷ�����Ҫ������±�λ��
     * ���ֲ�������Ҫ����Ҫע��������ȵ����
     *
     * @param obj
     * @return
     */
    public static int binarySearch(int[] list, int obj) {
        if (list == null)
            return -1;
        int count = list.length;
        if (count == 0)
            return 0;

        int low = 0;
        int high = count - 1;
        int center = (low + high) / 2;

        if (obj <= list[0]) { // �жϵ�һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return 0;
        }

        if (list[count - 1] <= obj) { // �ж����һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return count;
        }

        if (count == 2) // ����Ϊ2��ʱ��ǰ�������Ѿ��ж��˲���0��2�����������ֻʣ1��
            return 1;

        low = 1;
        high = count - 2;

        while (low < high) {
            if (list[center] < obj) { // obj��������
                low = center + 1;
            } else if (list[center] > obj) { // obj��������
                high = center - 1;
            } else { // ���
                return center;
            }
            center = (low + high) / 2;
        }

        // ������low=high=center�����

        // ���￪ʼ����һ�����󣬺�����������ȵ����������77���ж�7<8 ֮��ֱ�Ӳ��룬�ͻᵼ�²�����787����������
        if (list[center] < obj) { // obj��������
            // ȥ����������ȵ�ֵ
            while (center < count - 1 && list[center + 1] == list[center]) {
                ++center;
            }
            ++center;
        } else if (list[center] > obj) { // obj��������,�����俪ʼҲ����һ������һ��ʼ����--center;����ʵ�������䲻�ü�һ��
            // ȥ����������ȵ�ֵ
            while (center > 0 && list[center - 1] == list[center]) {
                --center;
            }
//            --center  ����Ҫ����ע�����
        }

        return center < 0 ? 0 : center; // ����λ��
    }

}
