package com.example.lib.course11_sorts.teacher;

/**
 * ����ð���㷨 �������ð�ݸ��׶��������㷨����
 * ϣ������
 * <p>
 * Author: wliu
 */
public class SortsAddOn {

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
        // bubbleDownSort(arr);
        shellSort(arr);
        print(arr);
    }

    /**
     * ����ð�ݡ����ܱ�ð�ݸ��׶���
     * <p>
     * �㷨��Ҫ��
     * ��0��ʼ�������Ԫ��ȥ�����������Ԫ�رȽϣ�����������Ԫ�ش��ں����ĳ��Ԫ�أ��򽻻���
     * 3 2 6 4 5 1
     * ��һ���Ǵ� index=0 Ҳ���� 3�� ��ʼ��index=1�����������ֱȽ�
     * 3 ���� 2����������Ϊ 2 3 6 4 5 1����ʱindex=0��λ�ñ�Ϊ��2
     * ����������2��index=2�Ƚ�
     * 2 ������ 6 ������
     * 2 ������ 4 ������
     * 2 ������ 5 ������
     * 2 ���� 1����������Ϊ 1 3 6 4 5 2����һ��������ɡ�
     * <p>
     * �ڶ����Ǵ� index=1 Ҳ���� 3����ʼ��index=2�����������ֱȽ�
     * 3 ������ 6 ������
     * 3 ������ 4 ������
     * 3 ������ 5 ������
     * 3 ���� 2����������Ϊ 1 2 6 4 5 3���ڶ���������ɡ�
     * <p>
     * �������Ǵ� index=2 Ҳ���� 6����ʼ��index=3�����������ֱȽ�
     * 6 ���� 4����������Ϊ 1 2 4 6 5 3, ��ʱ index = 2 ��λ�ñ�Ϊ��4
     * ����������4��index=4�Ƚ�
     * 4 ������ 5 ������
     * 4 ���� 3����������Ϊ 1 2 3 6 5 4��������������ɡ�
     * <p>
     * �������Ǵ� index=3 Ҳ���� 6����ʼ��index=4�����������ֱȽ�
     * 6 ���� 5����������Ϊ 1 2 3 5 6 4, ��ʱ index = 3 ��λ�ñ�Ϊ��5
     * ����������5��index=5�Ƚ�
     * 5 ���� 4����������Ϊ 1 2 3 4 6 5, ������������ɡ�
     * <p>
     * �������Ǵ� index=4 Ҳ���� 6����ʼ��index=5�����������ֱȽ�
     * 6 ���� 5����������Ϊ 1 2 3 4 5 6, ��ʱ index = 4 ��λ�ñ�Ϊ��5
     * ����������5��index=6�Ƚ�
     * index = 6 �Ѿ������� index < length ������������������ɡ�
     */
    private static void bubbleDownSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    private static void shellSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return;

        int step = len / 2;
        while (step >= 1) {
            for (int i = step; i < len; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < arr[j]) {
                        arr[j + step] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + step] = value;
            }

            step = step / 2;
        }
    }

    private static void print(int[] arr) {
        System.out.println("Print array:");
        for (int x : arr) {
            System.out.print(x + "\t");
        }
        System.out.println("");
    }
}
