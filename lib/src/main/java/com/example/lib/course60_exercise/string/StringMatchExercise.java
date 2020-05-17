package com.example.lib.course60_exercise.string;

/**
 * ʵ�����ص��ַ���ƥ���㷨
 */

public class StringMatchExercise {

    /**
     * BF(Brute Force)����ƥ���㷨��Ҳ�������ص��ַ���ƥ���㷨
     *
     * @param mainStr
     * @param matchStr
     * @return
     */
    public int BF(String mainStr, String matchStr) {
        if (mainStr == null || matchStr == null)
            return -1;
        char[] mainChars = mainStr.toCharArray();
        char[] matchChars = matchStr.toCharArray();
        int mainLen = mainChars.length;
        int matchLen = matchChars.length;

        if (mainLen < matchLen)
            return -1;

        for (int i = 0; i <= mainLen - matchLen; i++) {
            int j = 0;
            for (; j < matchLen; j++) {
                if (mainChars[i + j] != matchChars[j]) { // ��ƥ��
                    break;
                }
            }
            if (j == matchLen) // ȫƥ��
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        StringMatchExercise myStringMatch = new StringMatchExercise();
        int i = myStringMatch.BF("ˮ�������", "����");
        System.out.print("" + i);
    }
}
