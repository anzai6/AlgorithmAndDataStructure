package com.example.lib.course41_dynamicplanning3.my;

/**
 * ������Ӵ����ȣ��Ƚ������ַ���֮��ı༭����������Ӵ����ȣ����磺��"matcmu"��"mtacnu"��������Ӵ���"mtcu"���������ӡ�ɾ��,�����滻�ַ�
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ�������Ӵ�������ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */
public class MyLongestCommonSubstring {

    char[] a;
    char[] b;
    int n;
    int m;
    int maxLength = Integer.MIN_VALUE;

    // ��̬�滮��һ�����г������㷨����

    public int getLength(String str1, String str2) {
        a = str1.toCharArray();
        n = str1.length();
        b = str2.toCharArray();
        m = str2.length();
        lengthList = new int[n][m];
//        getLengthByBa(0, 0, 0); // ����
//        return maxLength;
//        getLengthByRe(n - 1, m - 1); // �ݹ�ӱ���¼
//        return lengthList[n - 1][m - 1];
        return getLengthByDp(); // ��̬�滮
    }

    /**
     * �����㷨��getLengthByBa(0,0,0)
     *
     * @param i      �ַ�����a�ƶ����ڼ�λ
     * @param j      �ַ�����b�ƶ����ڼ�λ
     * @param length �Ѽ������������Ӵ�����
     */
    public void getLengthByBa(int i, int j, int length) {
        if (i == n || j == m) {
            if (maxLength < length) // �����ֵ
                maxLength = length;
            return;
        }

        if (a[i] == b[j]) {
            getLengthByBa(i + 1, j + 1, length + 1);
        } else {
            getLengthByBa(i + 1, j, length); // ����a��ǰһλ
            getLengthByBa(i, j + 1, length); // ����b��ǰһλ
            getLengthByBa(i + 1, j + 1, length); // ����a��b�ֱ���ǰһλ
        }
    }

    // ���ݻ����㷨�����ݹ��������Ƿ�����ظ������⣬����������Ƕ�̬�滮�㷨��������������㷨������õĽ���취

    // �ݹ����Լ����������ظ��������ǣ�getLengthByBa(2, 3, 2)getLengthByBa(2, 3, 1)��ȡgetLengthByBa(2, 3, 2)���ɣ���ΪҪ��������Ӵ�����

    // ���ݵݹ������ظ�������˼�������г�״̬ת�Ʒ������£�1.���Ը���״̬ת�Ʒ��̻���һ����ά״̬������ɴ���
    // 2.����ͨ���ݹ�ӱ���¼ʵ�ִ���

    // ״̬ת�Ʒ��̣�
    // if (a[i] == b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1)
    // if (a[i] != b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1))

    // ���̽��ͣ����ȷִ�ǰ����a[i] �� b[j]�ܲ��ܱȽϣ�
    // ������ܱȽϣ�����a[i] �� b[j]�Ȳ��ȣ��������Ǵ���һ�������ģ����ȶ�û�б仯,�� maxLength(i,j) = min(maxLength(i-1,j), maxLength(i,j-1))��
    // ����ܱȽϣ���a[i] == b[j] �� maxLength(i,j) = maxLength(i-1,j-1)+1�� ��a[i] != b[j] �� maxLength(i,j) = maxLength(i-1,j-1)
    // ���Ե�a[i] == b[j]ʱ���Ӳ��ܱȽϵ� max(maxLength(i-1,j), maxLength(i,j-1)) �����ܱȽϵ� maxLength(i-1,j-1)
    // ����: maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1);
    // ͬ������� a[i] ��= b[j]

    // 1.����״̬ת�Ʒ���,ͨ���ݹ�ӱ���¼ʵ�ִ���
    int[][] lengthList; // ����¼

    /**
     * �ݹ�ӱ���¼������getLengthByRe(n-1,m-1);
     *
     * @param i
     * @param j
     * @return
     */
    public int getLengthByRe(int i, int j) {
        if (i == 0 || j == 0) {
            if (j > 0) {
                lengthList[0][j] = 0;
                return 0;
            } else if (i > 0) {
                lengthList[i][0] = 0;
                return 0;
            } else {
                if (a[i] == b[j]) {
                    lengthList[0][0] = 1;
                    return 1;
                } else {
                    lengthList[0][0] = 0;
                    return 0;
                }
            }
        }

        if (lengthList[i][j] > 0) { // ����¼��ֵ
            return lengthList[i][j];
        }

        int lowI = getLengthByRe(i - 1, j);
        int lowJ = getLengthByRe(i, j - 1);
        int last = getLengthByRe(i - 1, j - 1);
        int currentLength;

        if (a[i] == b[j]) {
            currentLength = max(lowI, lowJ, last + 1);
        } else {
            currentLength = max(lowI, lowJ, last);
        }
        lengthList[i][j] = currentLength;
        return currentLength;
    }

    // 2.����״̬ת�Ʒ��̻�����ά����״̬��Ȼ��Ϳ��Է���ɶ�̬�滮������,������Բ�����ʦ���Լ���

    /**
     * ��̬�滮����
     *
     * @return
     */
    public int getLengthByDp() {
        int[][] maxLength = new int[n][m];

        // ��ʼ����һ��
        for (int i = 0; i < m; i++) {
            if (a[0] == b[0]) // ��һ����ȣ�����1
                maxLength[0][i] = 1;
            else maxLength[0][i] = 0; // ���������0
        }

        // ��ʼ����һ��
        for (int i = 0; i < n; i++) {
            if (a[0] == b[0]) // ��һ����ȣ�����1
                maxLength[i][0] = 1;
            else maxLength[i][0] = 0; // ���������0
        }

        // �������з��̣���̬�滮��������ֵ
        // if (a[i] == b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1)+1)
        // if (a[i] != b[j]) maxLength(i,j) = max(maxLength(i-1,j), maxLength(i,j-1), maxLength(i-1,j-1))
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int lowI = maxLength[i - 1][j];
                int lowJ = maxLength[i][j - 1];
                int last = maxLength[i - 1][j - 1];
                if (a[i] == b[j]) {
                    maxLength[i][j] = max(lowI, lowJ, last + 1);
                } else {
                    maxLength[i][j] = max(lowI, lowJ, last);
                }
            }
        }


        return maxLength[n - 1][m - 1];
    }

    public int max(int a, int j, int h) {
        if (a > j)
            return a > h ? a : h;
        else
            return j > h ? j : h;
    }

    public static void main(String[] args) {
        MyLongestCommonSubstring myLongestCommonSubstring = new MyLongestCommonSubstring();
        System.out.println("������Ӵ��ĳ��ȣ�" + myLongestCommonSubstring.getLength("mitcmu", "mtacnu"));
    }
}
