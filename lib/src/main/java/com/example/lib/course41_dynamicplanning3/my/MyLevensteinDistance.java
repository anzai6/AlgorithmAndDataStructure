package com.example.lib.course41_dynamicplanning3.my;

/**
 * ����˹̹���룺�Ƚ������ַ���֮��ı༭���룬���磺��"matcmu"��"mtacnu"��Ҫ���ٲ��������������ӡ�ɾ�����滻�ַ���һ����3��
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ��༭������С�ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */

public class MyLevensteinDistance {

    char[] a;
    char[] b;
    int n;
    int m;
    int minDistance = Integer.MAX_VALUE;

    // ��̬�滮��һ�����г������㷨����

    public int getDistance(String str1, String str2) {
        a = str1.toCharArray();
        n = str1.length();
        b = str2.toCharArray();
        m = str2.length();
        distanceList = new int[n][m];
//        getDistanceByBa(0, 0, 0); // ����
        getDistanceByRe(n - 1, m - 1); // �ݹ�ӱ���¼
        return distanceList[n - 1][m - 1];
//        return getDistanceByDp(); // ��̬�滮
    }

    /**
     * �����㷨��getDistanceByBa(0,0,0)
     *
     * @param i        �ַ�����a�ƶ����ڼ�λ
     * @param j        �ַ�����b�ƶ����ڼ�λ
     * @param distance �Ѽ�����ı༭����
     */
    public void getDistanceByBa(int i, int j, int distance) {
        if (i == n || j == m) {
            if (i < n) distance = distance + n - i; // ����aû�����������ַ�
            if (j < m) distance = distance + m - j; // ����bû�����������ַ�
            if (minDistance > distance) // ����Сֵ
                minDistance = distance;
            return;
        }

        if (a[i] == b[j]) {
            getDistanceByBa(i + 1, j + 1, distance);
        } else {
            getDistanceByBa(i + 1, j, distance + 1); // ����a��ǰһλ
            getDistanceByBa(i, j + 1, distance + 1); // ����b��ǰһλ
            getDistanceByBa(i + 1, j + 1, distance + 1); // ����a��b�ֱ���ǰһλ
        }
    }


    // ���ݻ����㷨�����ݹ��������Ƿ�����ظ������⣬����������Ƕ�̬�滮�㷨��������������㷨������õĽ���취

    // �ݹ����Լ����������ظ��������ǣ�getDistanceByBa(2, 3, 2)getDistanceByBa(2, 3, 3)��ȡgetDistanceByBa(2, 3, 2)���ɣ���ΪҪ����С����

    // ���ݵݹ������ظ�������˼�������г�״̬ת�Ʒ������£�1.���Ը���״̬ת�Ʒ��̻���һ����ά״̬������ɴ���
    // 2.����ͨ���ݹ�ӱ���¼ʵ�ִ���

    // ״̬ת�Ʒ��̣�
    // if (a[i] == b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1))
    // if (a[i] != b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1)+1)

    // ���̽��ͣ����ȷִ�ǰ����a[i] �� b[j]�ܲ��ܱȽϣ�
    // ������ܱȽϣ�����a[i] �� b[j]�Ȳ��ȣ��������Ǵ���һ�������ģ���Ҫ+1,�� minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1)��
    // ����ܱȽϣ���a[i] == b[j] �� minDistance(i,j) = minDistance(i-1,j-1)�� ��a[i] != b[j] �� minDistance(i,j) = minDistance(i-1,j-1)+1
    // ���Ե�a[i] == b[j]ʱ���Ӳ��ܱȽϵ�min(minDistance(i-1,j)+1, minDistance(i,j-1)+1) �����ܱȽϵ� minDistance(i-1,j-1) j
    // ����: minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1));
    // ͬ������� a[i] ��= b[j]

    // 1.����״̬ת�Ʒ���,ͨ���ݹ�ӱ���¼ʵ�ִ���
    int[][] distanceList; // ����¼

    /**
     * �ݹ�ӱ���¼������getDistanceByRe(n-1,m-1);
     *
     * @param i
     * @param j
     * @return
     */
    public int getDistanceByRe(int i, int j) {
        if (i == 0 || j == 0) {
            if (j > 0) {
                distanceList[0][j] = j;
                return j;
            } else if (i > 0) {
                distanceList[i][0] = i;
                return i;
            } else {
                if (a[i] == b[j]) {
                    distanceList[0][0] = 0;
                    return 0;
                } else {
                    distanceList[0][0] = 1;
                    return 1;
                }
            }
        }

        if (distanceList[i][j] > 0) { // ����¼��ֵ
            return distanceList[i][j];
        }

        int lowI = getDistanceByRe(i - 1, j) + 1;
        int lowJ = getDistanceByRe(i, j - 1) + 1;
        int last = getDistanceByRe(i - 1, j - 1);
        int currentDistance;

        if (a[i] == b[j]) {
            currentDistance = min(lowI, lowJ, last);
        } else {
            currentDistance = min(lowI, lowJ, last + 1);
        }
        distanceList[i][j] = currentDistance;
        return currentDistance;
    }

    // 2.����״̬ת�Ʒ��̻�����ά����״̬��Ȼ��Ϳ��Է���ɶ�̬�滮������,������Բ�����ʦ���Լ���

    /**
     * ��̬�滮����
     *
     * @return
     */
    public int getDistanceByDp() {
        int[][] minDistances = new int[n][m];

        // ��ʼ����һ��
        for (int i = 0; i < m; i++) {
            if (a[0] == b[0]) // ��һ����Ⱦʹ�0��ʼ
                minDistances[0][i] = i;
            else minDistances[0][i] = i + 1; // ��������1��ʼ
        }

        // ��ʼ����һ��
        for (int i = 0; i < n; i++) {
            if (a[0] == b[0]) // ��һ����Ⱦʹ�0��ʼ
                minDistances[i][0] = i;
            else minDistances[i][0] = i + 1;  // ��������1��ʼ
        }

        // �������з��̣���̬�滮��������ֵ
        // if (a[i] == b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1))
        // if (a[i] != b[j]) minDistance(i,j) = min(minDistance(i-1,j)+1, minDistance(i,j-1)+1, minDistance(i-1,j-1)+1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int lowI = minDistances[i - 1][j] + 1;
                int lowJ = minDistances[i][j - 1] + 1;
                int last = minDistances[i - 1][j - 1];
                if (a[i] == b[j]) {
                    minDistances[i][j] = min(lowI, lowJ, last);
                } else {
                    minDistances[i][j] = min(lowI, lowJ, last + 1);
                }
            }
        }


        return minDistances[n - 1][m - 1];
    }

    public int min(int a, int j, int h) {
        if (a > j)
            return h > j ? j : h;
        else
            return a > h ? h : a;
    }


    public static void main(String[] args) {
        MyLevensteinDistance levensteinDistance = new MyLevensteinDistance();
        System.out.println("���룺" + levensteinDistance.getDistance("mitcmu", "mtacnu"));
    }
}
