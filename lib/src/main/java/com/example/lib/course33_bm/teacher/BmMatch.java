package com.example.lib.course33_bm.teacher;


public class BmMatch {

    private static final int SIZE = 256; // ȫ�ֱ������Ա����

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // ��ʼ�� bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // ���� b[i] �� ASCII ֵ
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // ��¼ģʽ����ÿ���ַ������ֵ�λ��
        generateBC(b, m, bc); // �������ַ���ϣ��
        int i = 0; // i ��ʾ������ģʽ������ĵ�һ���ַ�
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // ģʽ���Ӻ���ǰƥ��
                if (a[i+j] != b[j]) break; // ���ַ���Ӧģʽ���е��±��� j
            }
            if (j < 0) {
                return i; // ƥ��ɹ�������������ģʽ����һ��ƥ����ַ���λ��
            }
            // �����ͬ�ڽ�ģʽ�����󻬶� j-bc[(int)a[i+j]] λ
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }


    // b ��ʾģʽ����m ��ʾ���ȣ�suffix��prefix ���������������
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // ��ʼ��
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // ������׺�Ӵ�����
            while (j >= 0 && b[j] == b[m-1-k]) { // �� b[0, m-1] �󹫹���׺�Ӵ�
                --j;
                ++k;
                suffix[k] = j+1; //j+1 ��ʾ������׺�Ӵ��� b[0, i] �е���ʼ�±�
            }
            if (j == -1) prefix[k] = true; // ���������׺�Ӵ�Ҳ��ģʽ����ǰ׺�Ӵ�
        }
    }

    // a,b ��ʾ������ģʽ����n��m ��ʾ������ģʽ���ĳ��ȡ�
    public int bm2(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // ��¼ģʽ����ÿ���ַ������ֵ�λ��
        generateBC(b, m, bc); // �������ַ���ϣ��
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j ��ʾ������ģʽ��ƥ��ĵ�һ���ַ�
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // ģʽ���Ӻ���ǰƥ��
                if (a[i+j] != b[j]) break; // ���ַ���Ӧģʽ���е��±��� j
            }
            if (j < 0) {
                return i; // ƥ��ɹ�������������ģʽ����һ��ƥ����ַ���λ��
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m-1) { // ����кú�׺�Ļ�
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j ��ʾ���ַ���Ӧ��ģʽ���е��ַ��±� ; m ��ʾģʽ������
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // �ú�׺����
        if (suffix[k] != -1) return j - suffix[k] +1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }


}
