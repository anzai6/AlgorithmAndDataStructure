package com.example.lib.course34_KMP.finals;

import com.example.lib.course33_bm.finals.BmMatch;

import java.util.HashMap;

/**
 * 一个比较高效和简单的字符串匹配算法
 * 原理如下：
 * 从前往后匹配，当遇到不匹配字符时，获取主串正在参与匹配的字符的下一个字符，然后根据这个字符在子串中的位置直接移动子串
 * 关键是理解 -- 主串正在参与匹配的字符的下一个字符 -- 这个意思
 */
public class Sunday {
    /**
     * Sunday查找
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @return 查找到对应字符串的首字符在mainStr的下标, 比如：bcda 中查找 da 返回 2
     */
    public int SundaySearch(String mainStr, String matchStr) {
        if (mainStr == null || mainStr.length() == 0
                || matchStr == null || matchStr.length() == 0
                || mainStr.length() < matchStr.length()) {
            return -1;
        }
        int mainLen = mainStr.length();
        int matchLen = matchStr.length();
        // 子串中每个字符的最后出现的位置
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < matchLen; i++) {
            char c = matchStr.charAt(i);
            hashMap.put(Character.valueOf(c), Integer.valueOf(i));
        }

        // 开始匹配
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = 0;
            for (; j < matchLen; j++) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else if (i == mainLen - matchLen) { // 最后一轮，直接返回
                    return -1;
                } else { // 运用 Sunday 算法
                    int next = i + matchLen; // 主串正在参与匹配的字符的下一个字符下标
                    if (hashMap.containsKey(mainStr.charAt(next))) {
                        // 主串正在参与匹配的字符的下一个字符在模式串中的下标
                        int subNextIndex = hashMap.get(mainStr.charAt(next));
                        // 需要移动的位数
                        int moveIndex = next - subNextIndex;
                        i += moveIndex;
                    } else { // 模式串不存在该字符，直接整个跳过
                        i = next + 1;
                    }
                    break;
                }
            }
            if (j == matchLen) { // 匹配成功
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BmMatch myBmMatch = new BmMatch();
        String mainStr = "wrekjfsdkfjpouiewrsldkjfxcmlds;fksprioepwsfa";
        String matchStr = "fksp";
        int i = myBmMatch.bmSearch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
