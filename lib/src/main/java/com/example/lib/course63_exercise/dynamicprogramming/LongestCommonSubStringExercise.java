package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * ������Ӵ����ȣ��Ƚ������ַ���֮��ı༭����������Ӵ����ȣ����磺��"matcmu"��"mtacnu"��������Ӵ���"mtcu"���������ӡ�ɾ��,�����滻�ַ�
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ�������Ӵ�������ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */

public class LongestCommonSubStringExercise {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int maxLength = Integer.MIN_VALUE; // ������Ӵ�����

    public int getMaxLength(String str1, String str2) {
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = a.length;
        m = b.length;
//        lcsBT(0, 0, 0);
//        return maxLength;

        return lcsDP();
    }

    /**
     * ����������Ӵ����ȵĻ����㷨
     *
     * @param i    ����a���±�
     * @param j    ����b���±�
     * @param length ��ǰ�Ĺ����Ӵ�����
     */
    private void lcsBT(int i, int j, int length) {
        if (i == n || j == m) {
            if (maxLength < length)
                maxLength = length;
            return;
        }

        if (a[i] == b[j]) {
            lcsBT(i + 1, j + 1, length+1);
        } else {
            lcsBT(i + 1, j, length); // ����a��һλ
            lcsBT(i, j + 1, length); // ����b��һλ
            lcsBT(i + 1, j + 1, length); // ����a��b����һλ
        }
    }

    // ���ݹ�ʽ��f(i,j): ��a[i] == b[j] -> f(i,j) = max( f(i-1,j-1)+1, f(i-1,j), f(i,j-1) )
    // ��a[i] != b[j] -> f(i,j) = max( f(i-1,j-1), f(i-1,j), f(i,j-1) )

    /**
     * ��̬�滮�㷨
     *
     * @return
     */
    private int lcsDP() {
        int[][] maxLength = new int[n][m];
        for (int j = 0; j < m; ++j) { // ��ʼ���� 0 ��:a[0..0] �� b[0..j] �ı༭����
            if (a[0] == b[j]) maxLength[0][j] = 1;
            else if (j != 0) maxLength[0][j] = maxLength[0][j - 1];
            else maxLength[0][j] = 0;
        }
        for (int i = 0; i < n; ++i) { // ��ʼ���� 0 ��:a[0..i] �� b[0..0] �ı༭����
            if (a[i] == b[0]) maxLength[i][0] = 1;
            else if (i != 0) maxLength[i][0] = maxLength[i - 1][0];
            else maxLength[i][0] = 0;
        }
        for (int i = 1; i < n; ++i) { // �������
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) maxLength[i][j] = max(
                        maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1] + 1);
                else maxLength[i][j] = max(
                        maxLength[i - 1][j], maxLength[i][j - 1], maxLength[i - 1][j - 1]);
            }
        }
        return maxLength[n - 1][m - 1];
    }

    /**
     * ����������Сֵ
     *
     * @param i
     * @param j
     * @param f
     * @return
     */
    private int max(int i, int j, int f) {
        if (i > j) {
            return i > f ? i : f;
        } else {
            return j > f ? j : f;
        }
    }

    public static void main(String[] args) {
        LongestCommonSubStringExercise longestCommonSubStringExercise = new LongestCommonSubStringExercise();
        System.out.println("������Ӵ���" + longestCommonSubStringExercise.getMaxLength("mitcmu", "mtacnu"));
    }
}
