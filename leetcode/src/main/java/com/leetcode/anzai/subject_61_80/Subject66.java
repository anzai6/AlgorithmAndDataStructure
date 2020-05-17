package com.leetcode.anzai.subject_61_80;

import java.util.Arrays;

/**
 * ��һ
 * https://leetcode-cn.com/problems/plus-one/
 */
public class Subject66 {

    /**
     *
     ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��

     ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�

     ����Լ���������� 0 ֮�⣬��������������㿪ͷ��

     ʾ��?1:

     ����: [1,2,3]
     ���: [1,2,4]
     ����: ���������ʾ���� 123��
     ʾ��?2:

     ����: [4,3,2,1]
     ���: [4,3,2,2]
     ����: ���������ʾ���� 4321��
     *
     */


    /**
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean needNext = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            if (value == 9) {
                digits[i] = 0;
                needNext = true;
            } else {
                digits[i] = value + 1;
                needNext = false;
                break;
            }
        }

        if (!needNext) {
            return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            newDigits[i + 1] = digits[i];
        }

        return newDigits;
    }

    public static void main(String[] args) {
//        int[] digits = new int[]{1,2,3};
//        int[] digits = new int[]{4, 3, 2, 1};
        int[] digits = new int[]{9,1,9,9,9,9};
        Subject66 subject = new Subject66();
        System.out.print(Arrays.toString(subject.plusOne(digits)));
    }

}
