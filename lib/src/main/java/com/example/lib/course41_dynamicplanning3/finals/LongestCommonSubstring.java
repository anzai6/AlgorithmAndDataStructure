package com.example.lib.course41_dynamicplanning3.finals;

/**
 * ������Ӵ����ȣ��Ƚ������ַ���֮��ı༭����������Ӵ����ȣ����磺��"matcmu"��"mtacnu"��������Ӵ���"mtcu"���������ӡ�ɾ��,�����滻�ַ�
 * ������ƴд���������û�����һ���ַ������ʣ���ȥ���ʿⵥ�ʱȽϣ��ҵ�������Ӵ�������ĵ��ʣ����ھ����û�����Ĵ��󵥴�
 */
public class LongestCommonSubstring {

    char[] a;
    char[] b;
    int n;
    int m;
    int maxLength = Integer.MIN_VALUE;

    // ��̬�滮��һ�����г������㷨����

    public int getLength(String str1, String str2) {
        return 2; // ��̬�滮
    }

    /**
     * �����㷨��getLengthByBa(0,0,0)
     *
     * @param i      �ַ�����a�ƶ����ڼ�λ
     * @param j      �ַ�����b�ƶ����ڼ�λ
     * @param length �Ѽ������������Ӵ�����
     */
    public void getLengthByBa(int i, int j, int length) {
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
        return 2;
    }

    // 2.����״̬ת�Ʒ��̻�����ά����״̬��Ȼ��Ϳ��Է���ɶ�̬�滮������,������Բ�����ʦ���Լ���

    /**
     * ��̬�滮����
     *
     * @return
     */
    public int getLengthByDp() {

        return 2;
    }

    public int max(int a, int j, int h) {
        if (a > j)
            return a > h ? a : h;
        else
            return j > h ? j : h;
    }

    public static void main(String[] args) {
        LongestCommonSubstring myLongestCommonSubstring = new LongestCommonSubstring();
        System.out.println("������Ӵ��ĳ��ȣ�" + myLongestCommonSubstring.getLength("mitcmu", "mtacnu"));
    }
}
