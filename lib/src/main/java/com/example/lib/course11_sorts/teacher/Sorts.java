package com.example.lib.course11_sorts.teacher;

/**
 * ð�����򡢲�������ѡ������
 * <p>
 * Author: Zheng
 */
public class Sorts {

    // ð������a�����飬n��ʾ�����С
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // ��ǰ�˳���־λ
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // ����
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // �˴�ð�������ݽ���
                    flag = true;
                }
            }
            if (!flag) break;  // û�����ݽ�������ǰ�˳�
        }
    }

    // ��������a��ʾ���飬n��ʾ�����С
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // ����Ҫ�����λ�ò��ƶ�����
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // ѡ������a��ʾ���飬n��ʾ�����С
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            // ������Сֵ
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // ����
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}
