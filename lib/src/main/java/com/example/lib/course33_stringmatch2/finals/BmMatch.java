package com.example.lib.course33_stringmatch2.finals;

import java.util.Map;

/**
 * BM字符串查找方法：从模式串后面字符往前匹配，利用坏字符规则和好字符规则提升查找效率
 * （坏字符规则需要额外的hash表内存，如果内存要求严格可以只使用好字符规则）
 * Created by qinshunan on 2019/4/16.
 */

public class BmMatch {


    /**
     * BM查找
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @return 查找到对应字符串的首字符在mainStr的下标, 比如：bcda 中查找 da 返回 2
     */
    public int bmSearch(String mainStr, String matchStr) {

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
        return 0;
    }

    /**
     * 坏字符规则
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @param s        从这个下标开始往前匹配模式串
     * @param sufix    值存储模式串中与后缀子串匹配的子串在模式串中的起始起始字符坐标，下标是这个匹配的后缀子串的长度
     * @param prefix   模式串中有与后缀子串匹配的前缀子串，以其长度为下标，记录值为true
     * @return 返回坏字符规则下移动的长度，返回0证明匹配成功
     */
    private int goodCharRuleMatch(String mainStr, String matchStr, int s, int[] sufix, boolean[] prefix) {

        return 0;
    }


    public static void main(String[] args) {
        BmMatch myBmMatch = new BmMatch();
        String mainStr = "wrekjfsdkfjpouiewrsldkjfxcmlds;fksprioepwsfa";
        String matchStr = "sdfe";
        int i = myBmMatch.bmSearch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
