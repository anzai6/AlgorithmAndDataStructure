package com.example.lib.course41_dynamicplanning3.finals;

/**
 * Created by qinshunan on 2019/5/15.
 */

public class Test {

    // ������һ���������а��� n ����ͬ�����֣���������������е�����������г��ȣ�
    // ���� 2, 9, 3, 6, 5, 1, 7 ����һ���������У���������������о��� 2, 3, 5, 7��
    // ��������������еĳ����� 4��

    int[] numList = {2, 9, 3, 7, 5, 1, 6};
    int n = numList.length;
    int maxLength = Integer.MIN_VALUE;

    public void getMaxLength() {
    }

    // �������г������㷨

    /**
     * �����㷨������getMaxLengthByBa(0,0,-1);
     *
     * @param i      �ڼ�λ
     * @param j      ǰ��ĵ��������еĳ���
     * @param maxNum ǰ��ĵ��������е����ֵ
     */
    public void getMaxLengthByBa(int i, int j, int maxNum) {

    }

    // ���ݻ����㷨�����ݹ��������Ƿ�����ظ������⣬����������Ƕ�̬�滮�㷨��������������㷨������õĽ���취

    // �ݹ����Լ����������ظ��������ǣ�getMaxLengthByBa(1, 1, 2),getMaxLengthByBa(1, 1, 9)��ȡ getMaxLengthByBa(1, 1, 2)���ɣ�
    // ��ΪҪ������������У�������ͬλ������ͬ�����£�ȡ���������е����ֵ����Сֵ��2<9��

    // ���ݵݹ������ظ�������˼�������г�״̬ת�Ʒ������£�1.���Ը���״̬ת�Ʒ��̻���һ����ά״̬������ɴ���
    // 2.����ͨ���ݹ�ӱ���¼ʵ�ִ���

    // f(i)��ʾ��i��λ�õ�����������г���,  ״̬ת�Ʒ������£�
    // f(i) = f(i-1) ǰ�᣺numList[i] < f(i-1)���ȵ����е��������е����ֵ�е���Сֵ
    // f(i) = f(i-1)+1 ǰ�᣺numList[i] > f(i-1)���ȵ����е��������е����ֵ�е���Сֵ

    /**
     * ��̬�滮����
     */
    public void getLengthByRe() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.getMaxLength();
    }
}
