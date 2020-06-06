package com.example.lib.course41_dynamicplanning3.finals;

/**
 * ����˹̹���룺�Ƚ������ַ���֮��ı༭���룬���磺��"matcmu"��"mtacnu"��Ҫ���ٲ��������������ӡ�ɾ�����滻�ַ���һ����3��
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ��༭������С�ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */

public class LevensteinDistance {

    char[] a;
    char[] b;
    int n;
    int m;
    int minDistance = Integer.MAX_VALUE;

    // ��̬�滮��һ�����г������㷨����

    public int getDistance(String str1, String str2) {
        return 0;
    }

    /**
     * �����㷨��getDistanceByBa(0,0,0)
     *
     * @param i        �ַ�����a�ƶ����ڼ�λ
     * @param j        �ַ�����b�ƶ����ڼ�λ
     * @param distance �Ѽ�����ı༭����
     */
    public void getDistanceByBa(int i, int j, int distance) {
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
        return 0;
    }

    // 2.����״̬ת�Ʒ��̻�����ά����״̬��Ȼ��Ϳ��Է���ɶ�̬�滮������,������Բ�����ʦ���Լ���

    /**
     * ��̬�滮����
     *
     * @return
     */
    public int getDistanceByDp() {


        return 2;
    }

    public int min(int a, int j, int h) {
        if (a > j)
            return h > j ? j : h;
        else
            return a > h ? h : a;
    }


    public static void main(String[] args) {
        LevensteinDistance levensteinDistance = new LevensteinDistance();
        System.out.println("���룺" + levensteinDistance.getDistance("mitcmu", "mtacnu"));
    }
}
