package com.example.lib.course60_exercise.string;

/**
 * 实现朴素的字符串匹配算法
 */

public class StringMatchExercise {

    /**
     * BF(Brute Force)暴力匹配算法，也即最朴素的字符串匹配算法
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
                if (mainChars[i + j] != matchChars[j]) { // 不匹配
                    break;
                }
            }
            if (j == matchLen) // 全匹配
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        StringMatchExercise myStringMatch = new StringMatchExercise();
        int i = myStringMatch.BF("水电费您好", "费您");
        System.out.print("" + i);
    }
}
