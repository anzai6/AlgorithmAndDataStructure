package com.example.lib.course41_dynamicplanning3.teacher;

/**
 * ����˹̹���룺�Ƚ������ַ���֮��ı༭���룬���磺��"matcmu"��"mtacnu"��Ҫ���ٲ��������������ӡ�ɾ�����滻�ַ���һ����3��
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ��༭������С�ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */

public class LevensteinDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // �洢���

    public int getDistance(String str1, String str2) {
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
        return lwstDP(a, n, b, m);
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
        �����a[i]!=b[j]����ô��min_edist(i, j) �͵��ڣ�
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)

        �����a[i]==b[j]����ô��min_edist(i, j) �͵��ڣ�
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1��min_edist(i-1,j-1))

        ���У�min ��ʾ�������е���Сֵ��
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
    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // ��ʼ���� 0 ��:a[0..0] �� b[0..j] �ı༭����
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // ��ʼ���� 0 ��:a[0..i] �� b[0..0] �ı༭����
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // �������
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else minDist[i][j] = min(
                        minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }


    public static void main(String[] args) {
        LevensteinDistance levensteinDistance = new LevensteinDistance();
        System.out.println("���룺" + levensteinDistance.getDistance("mitcmu", "mtacnu"));
    }
}
