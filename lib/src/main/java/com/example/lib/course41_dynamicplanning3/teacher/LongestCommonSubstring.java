package com.example.lib.course41_dynamicplanning3.teacher;

/**
 * ������Ӵ����ȣ��Ƚ������ַ���֮��ı༭����������Ӵ����ȣ����磺��"matcmu"��"mtacnu"��������Ӵ���"mtcu"���������ӡ�ɾ��,�����滻�ַ�
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ�������Ӵ�������ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */

public class LongestCommonSubstring {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // �洢���

    public int getMaxLength(String str1, String str2) {
        if (str1 == null || str1.length() == 0)
            return str2.length();
        if (str2 == null || str2.length() == 0)
            return str1.length();
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = str1.length();
        m = str2.length();
//        minDist = Integer.MAX_VALUE;
//        lwstBT(0, 0, 0);
        return lcs(a, n, b, m);
    }

    // �����㷨�����÷�ʽ lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // �����ַ�ƥ��
            lwstBT(i + 1, j + 1, edist);
        } else { // �����ַ���ƥ��
            lwstBT(i + 1, j, edist + 1); // ɾ�� a[i] ���� b[j] ǰ���һ���ַ�
            lwstBT(i, j + 1, edist + 1); // ɾ�� b[j] ���� a[i] ǰ���һ���ַ�
            lwstBT(i + 1, j + 1, edist + 1); // �� a[i] �� b[j] �滻Ϊ��ͬ�ַ�
        }
    }

    // ���ݻ����㷨�����ݹ��������Ƿ�����ظ������⣬����������Ƕ�̬�滮�㷨��������������㷨������õĽ���취


    // ���ݵݹ������ظ�������˼�������г�״̬ת�Ʒ������£�1.���Ը���״̬ת�Ʒ��̻���һ����ά״̬������ɴ���
    // 2.����ͨ���ݹ�ӱ���¼ʵ�ִ���

    /*
    �����a[i]==b[j]����ô��max_lcs(i, j) �͵��ڣ�
    max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j), max_lcs(i, j-1))��

    �����a[i]!=b[j]����ô��max_lcs(i, j) �͵��ڣ�
    max(max_lcs(i-1,j-1), max_lcs(i-1, j), max_lcs(i, j-1))��

    ���� max ��ʾ�������е����ֵ��
    */


    /**
     * ��̬�滮�Ĵ���
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        for (int j = 0; j < m; ++j) {// ��ʼ���� 0 �У�a[0..0] �� b[0..j] �� maxlcs
            if (a[0] == b[j]) maxlcs[0][j] = 1;
            else if (j != 0) maxlcs[0][j] = maxlcs[0][j - 1];
            else maxlcs[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) {// ��ʼ���� 0 �У�a[0..i] �� b[0..0] �� maxlcs
            if (a[i] == b[0]) maxlcs[i][0] = 1;
            else if (i != 0) maxlcs[i][0] = maxlcs[i - 1][0];
            else maxlcs[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) { // ���
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxlcs[i][j] = max(
                        maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
                else maxlcs[i][j] = max(
                        maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
            }
        }
        return maxlcs[n - 1][m - 1];
    }

    private int max(int x, int y, int z) {
        int maxv = Integer.MIN_VALUE;
        if (x > maxv) maxv = x;
        if (y > maxv) maxv = y;
        if (z > maxv) maxv = z;
        return maxv;
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println("���ȣ�" + longestCommonSubstring.getMaxLength("mitcmu", "mtacnu"));
    }
}
