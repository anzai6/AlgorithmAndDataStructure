package com.example.lib.course59_exercise.solution;

/**
 * x ��ƽ����
 * https://leetcode-cn.com/problems/sqrtx/
 */

public class SqrtSolution {

    /**
     *
     ʵ�� int sqrt(int x) ������

     ���㲢���� x ��ƽ���������� x �ǷǸ�������

     ���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��

     ʾ�� 1:

     ����: 4
     ���: 2
     ʾ�� 2:

     ����: 8
     ���: 2
     ˵��: 8 ��ƽ������ 2.82842...,
     ���ڷ���������������С�����ֽ�����ȥ��
     *
     */


    /**
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int max = 46340;
        int y = 0;
        for (int i = 0; i <= max; i++) {
            if(i*i<=x)
                y = i;
            else
                break;
        }
        return y;
    }

}
