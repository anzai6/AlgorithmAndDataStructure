package com.example.lib.course63_exercise.dynamicprogramming;

/**
 * ����˹̹���룺�Ƚ������ַ���֮��ı༭���룬���磺��"matcmu"��"mtacnu"��Ҫ���ٲ��������������ӡ�ɾ�����滻�ַ���һ����3��
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ��༭������С�ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */
public class LevensteinDistanceExercise {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    private int minDist = Integer.MAX_VALUE; // �洢���

    public int getLevensteinDistance(String str1, String str2) {
        a = str1.toCharArray();
        b = str2.toCharArray();
        n = a.length;
        m = b.length;
//        lwstBT(0, 0, 0);
//        return minDist;

        return lwstDP();
    }

    /**
     * ��������˹̹����Ļ����㷨
     *
     * @param i    ����a���±�
     * @param j    ����b���±�
     * @param dist ��ǰ������˹̹����
     */
    private void lwstBT(int i, int j, int dist) {
        if (i == n || j == m) {
            if (i == n)
                dist += m - j;
            else dist += n - i;
            if (minDist > dist)
                minDist = dist;
            return;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, dist);
        } else {
            lwstBT(i + 1, j, dist + 1); // ����a��һλ
            lwstBT(i, j + 1, dist + 1); // ����b��һλ
            lwstBT(i + 1, j + 1, dist + 1); // ����a��b����һλ
        }
    }

    // ���ݹ�ʽ��f(i,j): ��a[i] == b[j] -> f(i,j) = min( f(i-1,j-1), f(i-1,j)+1, f(i,j-1)+1 )
    // ��a[i] != b[j] -> f(i,j) = min( f(i-1,j-1)+1, f(i-1,j)+1, f(i,j-1)+1 )

    /**
     * ��̬�滮�㷨
     *
     * @return
     */
    private int lwstDP() {
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

    /**
     * ����������Сֵ
     *
     * @param i
     * @param j
     * @param f
     * @return
     */
    private int min(int i, int j, int f) {
        if (i > j) {
            return j > f ? f : j;
        } else {
            return i > f ? f : i;
        }
    }

    public static void main(String[] args) {
        LevensteinDistanceExercise levensteinDistance = new LevensteinDistanceExercise();
        System.out.println("���룺" + levensteinDistance.getLevensteinDistance("mitcmu", "mtacnu"));
    }

}
