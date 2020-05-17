package com.example.lib.course63_exercise.divideandconquer;

/**
 * ���÷����㷨��һ�����ݵ�����Ը���
 */

public class ReverseOrderExercise {

    int count;

    /**
     * ͨ������˼·���鲢����������Ĺ����м�������
     *
     * @param data
     * @return
     */
    public int countReverseOrder(int[] data) {
        countReverseOrderIn(data, 0, data.length - 1);
        return count;
    }

    private void countReverseOrderIn(int[] data, int low, int high) {
        if (low >= high)
            return;
        if (low == high - 1) {
            if (data[low] > data[high]) {
                int item = data[low];
                data[low] = data[high];
                data[high] = item;
                count++;
            }
            return;
        }
        int center = (low + high) / 2;
        countReverseOrderIn(data, low, center);
        countReverseOrderIn(data, center + 1, high);
        mergeList(data, low, center, high);
    }

    private void mergeList(int[] data, int low, int center, int high) {
        int n = high - low + 1;
        int[] cacheList = new int[n];
        int i = 0;
        int j = low; // �����������
        int k = center + 1; // �����������

        while (j <= center && k <= high) {
            if (data[j] <= data[k]) {
                cacheList[i] = data[j];
                count += (k - center - 1); // ���ӵ��������,(k - center - 1)���������Ѿ��ϲ��ĸ���
                j++;
            } else {
                cacheList[i] = data[k];
                k++;
            }
            i++;
        }
        if (j > center) { // ������ϲ��꣬����������
            for (; k <= high; k++, i++) {
                cacheList[i] = data[k];
            }
        } else { // ������ϲ��꣬����������
            for (; j <= center; j++, i++) {
                cacheList[i] = data[j];
                count += (high - center); // ���ӵ����������(high - center)���������Ѿ��ϲ��ĸ���
            }

        }

        // ����
        for (int l = 0; l < n; l++) {
            data[l + low] = cacheList[l];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 5, 6, 4, 1, 2, 3, 4};
        ReverseOrderExercise exercise = new ReverseOrderExercise();
        System.out.println("���������" + exercise.countReverseOrder(data));
        System.out.println("��������飺");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
