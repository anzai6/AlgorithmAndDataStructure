package com.example.lib.course33_stringmatch2.my;

import com.example.lib.course32_stringmatch.my.MyStringMatch;

import java.util.HashMap;
import java.util.Map;

/**
 * BM字符串查找方法：从模式串后面字符往前匹配，利用坏字符规则和好字符规则提升查找效率
 * （坏字符规则需要额外的hash表内存，如果内存要求严格可以只使用好字符规则）
 * Created by qinshunan on 2019/4/16.
 */

public class MyBmMatch {


    /**
     * BM查找
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @return 查找到对应字符串的首字符在mainStr的下标, 比如：bcda 中查找 da 返回 2
     */
    public int bmSearch(String mainStr, String matchStr) {

        if (mainStr == null || mainStr.length() == 0)
            return -1;

        if (matchStr == null || mainStr.length() == 0)
            return -1;

        if (matchStr.length() > mainStr.length())
            return -1;

        if (matchStr.length() == mainStr.length())
            return mainStr.equals(matchStr) ? 0 : -1;

        if (matchStr.length() <= 2) // 长度2以内用BF暴力搜索算法可能更快（加上坏规则还会更快，这里不考虑了）
            return new MyStringMatch().BF(mainStr, matchStr);

        int mainLen = mainStr.length();
        int matchLen = matchStr.length();

        // -- 数据预处理开始 --
        // 坏字符规则数据预处理
        // 利用散列表存储matchStr中每个字符对应的下标，方便后面查找匹配
        Map<Character, Integer> matchCharMap = new HashMap<>();
        char[] matchChars = matchStr.toCharArray();
        for (int i = 0; i < matchChars.length; i++) {
            matchCharMap.put(matchChars[i], i);
        }

        // 好字符规则数据预处理
        // 值存储模式串中与后缀子串匹配的子串在模式串中的起始字符坐标，下标是这个匹配的后缀子串的长度，例如
        // 模式串：dcdc
        // 则其后缀子串有：  c              dc            cdc
        // 对应   sufix[1] == 1; sufix[2] == 0; sufix[3] == -1
        int[] sufix = new int[matchLen];
        // 初始化
        for (int i = 0; i < matchLen; i++) {
            sufix[i] = -1;
        }

        // 模式串中有与后缀子串匹配的前缀子串，以其长度为下标，记录值为true,根据上面的例子则：prefix[2] == true;
        boolean[] prefix = new boolean[matchLen];

        // 取模式串中0~k的子串与模式串求公共后缀子串，通过公共后缀子串长度赋值sufix和prefix
        // k的取值范围是0~matchLen - 2
        for (int k = 0; k < matchLen - 1; k++) {
            int m = matchLen - 1;
            // 求公共后缀子串
            for (int i = k; i >= 0; --i, --m) {
                char suMatchChar = matchStr.charAt(k);
                char matchChar = matchStr.charAt(m);
                if (suMatchChar == matchChar) {
                    int j = k - i + 1; // 已经匹配的公共后缀子串的长度
                    sufix[j] = i;
                    if (i == 0)
                        prefix[k] = true;
                } else {
                    break;
                }
            }
        }
        // -- 数据预处理结束 --

        // 开始匹配
        int s = matchLen - 1; // 每次开始匹配的下标，由于是从后往前匹配的，所以起始下标就是模式串的长度减一
        // 循环匹配
        while (s < mainLen) {

            // 先使用坏字符规则匹配
            int badMoveLen = badCharRuleMatch(mainStr, matchStr, s, matchCharMap);
            if (badMoveLen == 0) // 匹配成功
                return s - matchLen + 1;
            else if (badMoveLen < 0) { // 坏字符规则匹配失效

            }

            // -- 使用好字符规则匹配 --

            // 上面取得sufix和prefix的值后就可以开始好字符规则匹配了
            int goodMoveLen = goodCharRuleMatch(mainStr, matchStr, s, sufix, prefix);
            if (goodMoveLen == 0) // 匹配成功
                return s - matchLen + 1;

            // 取坏字符规则和好字符规则中移动最大的位数
//            s = s + Math.max(badMoveLen, goodMoveLen);
            s = s + goodMoveLen;
        }

        return -1;
    }

    /**
     * 坏字符规则
     *
     * @param mainStr      主串
     * @param matchStr     模式串
     * @param s            从这个下标开始往前匹配模式串
     * @param matchCharMap 存储模式串每个字符对应的下标的散列表
     * @return 返回坏字符规则下移动的长度，返回0证明匹配成功
     */
    private int badCharRuleMatch(String mainStr, String matchStr, int s, Map<Character, Integer> matchCharMap) {
        int matchLen = matchStr.length();
        // 从后往前匹配
        for (int i = matchLen - 1; i >= 0; --i, --s) {
            char mainChar = mainStr.charAt(s);
            char matchChar = matchStr.charAt(i);
            if (mainChar != matchChar) {
                if (matchCharMap.containsKey(mainChar)) {
                    int j = matchCharMap.get(mainChar);
                    return i - j;
                } else
                    return i + 1;
            }
        }
        return 0;
    }

    /**
     * 好字符规则
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @param s        从这个下标开始往前匹配模式串
     * @param sufix    值存储模式串中与后缀子串匹配的子串在模式串中的起始起始字符坐标，下标是这个匹配的后缀子串的长度
     * @param prefix   模式串中有与后缀子串匹配的前缀子串，以其长度为下标，记录值为true
     * @return 返回坏字符规则下移动的长度，返回0证明匹配成功
     */
    private int goodCharRuleMatch(String mainStr, String matchStr, int s, int[] sufix, boolean[] prefix) {
        int matchLen = matchStr.length();
        // 从后往前匹配
        for (int i = matchLen - 1; i >= 0; --i, --s) {
            char mainChar = mainStr.charAt(s);
            char matchChar = matchStr.charAt(i);
            if (mainChar != matchChar) {
                int j = matchLen - i - 1; // 好字符串长度
                if (j == 0) { // 没有好字符，移动一位
                    return 1;
                } else {
                    int h = sufix[j]; // 好字符串在模式串中的最近子串的下标，例如模式串是：cbcabc,好字符串是bc,则h=1;
                    if (h >= 0) { // 有值
                        return i - h + 1;
                    } else { // 没有值，寻找匹配的前缀子串
                        for (int k = j; k >= 1; --k) {
                            if (prefix[k]) {
                                return matchLen - k;
                            }
                        }
                        // 没有找到匹配的前缀子串,整个模式串后移
                        return matchLen;
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        MyBmMatch myBmMatch = new MyBmMatch();
        String mainStr = "wrekjfsdkfjpouiewrsldkjfxcmlds;fksprioepwsfa";
        String matchStr = "fxcm";
        int i = myBmMatch.bmSearch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
