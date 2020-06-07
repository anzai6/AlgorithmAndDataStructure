package com.example.lib.course34_KMP.teacher;

public class KMPMatch {
    // a, b �ֱ���������ģʽ����n, m �ֱ���������ģʽ���ĳ��ȡ�
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // һֱ�ҵ� a[i] �� b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // �ҵ�ƥ��ģʽ������
                return i - m + 1;
            }
        }
        return -1;
    }

    // b ��ʾģʽ����m ��ʾģʽ���ĳ���
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }


}
