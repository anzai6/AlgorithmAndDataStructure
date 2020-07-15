package com.example.lib.course33_bm.finals;

import java.util.HashMap;

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

        // 好字符规则数据预处理
        // 值存储模式串中与后缀子串匹配的子串在模式串中的起始字符坐标，下标是这个匹配的后缀子串的长度，例如
        // 模式串：dcdc
        // 则其后缀子串有：  c              dc            cdc
        // 对应   sufix[1] == 1; sufix[2] == 0; sufix[3] == -1
        int[] sufix = new int[matchLen];
        // 模式串中有与后缀子串匹配的前缀子串，以其长度为下标，记录值为true,根据上面的例子则：prefix[2] == true;
        boolean[] prefix = new boolean[matchLen];

        // 初始化
        for (int i = 0; i < matchLen; i++) {
            sufix[i] = -1;
            prefix[i] = false;
        }

        // 取模式串中0~i的子串与模式串求公共后缀子串，通过公共后缀子串长度赋值sufix和prefix
        // i的取值范围是0~matchLen - 2
        for (int i = 0; i < matchLen - 1; i++) {
            int m = matchLen - 1;
            int k = i;
            while (k >= 0) {
                char suMatchChar = matchStr.charAt(k);
                char matchChar = matchStr.charAt(m);
                if (suMatchChar == matchChar) {
                    int j = k - i + 1; // 已经匹配的公共后缀子串的长度
                    sufix[j] = i;
                    if (i == 0)
                        prefix[k] = true;
                    m--;
                    k--;
                } else {
                    break;
                }
            }
        }

        // 开始匹配
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = matchLen - 1;
            for (; j >= 0; j--) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else { // 不匹配
                    int bMove = badCharRuleMatch(mainC, j, hashMap); // 利用坏字符规则移动位数
                    int gMove = goodCharRuleMatch(j, matchLen, sufix, prefix); // 利用好字符规则移动位数

                    // 选出最大的移动位数
                    i += Math.max(bMove, gMove);
                    break;
                }
            }
            if (j == -1) { // 匹配成功
                return i;
            }
        }

        return -1;
    }

    /**
     * 坏字符规则
     *
     * @param mainC   坏字符
     * @param j       坏字符的下标
     * @param hashMap 存储模式串每个字符对应的下标的散列表
     * @return 返回坏字符规则下移动的长度
     */
    private int badCharRuleMatch(char mainC, int j, HashMap<Character, Integer> hashMap) {
        int bMove = 1; // 利用坏字符规则移动位数，默认是1，即至少移动一位
        if (hashMap.containsKey(mainC)) {
            int index = hashMap.get(mainC);
            if (index < j) { // 小于证明在左边，大于在右边，不能移动
                bMove = (j - index);
            }
        } else { // 字典中没有坏字符
            bMove = j + 1;
        }
        return bMove;
    }

    /**
     * 坏字符规则
     *
     * @param j        坏字符的下标
     * @param matchLen 模式串长度
     * @param sufix    值存储模式串中与后缀子串匹配的子串在模式串中的起始起始字符坐标，下标是这个匹配的后缀子串的长度
     * @param prefix   模式串中有与后缀子串匹配的前缀子串，以其长度为下标，记录值为true
     * @return 返回坏字符规则下移动的长度
     */
    private int goodCharRuleMatch(int j, int matchLen, int[] sufix, boolean[] prefix) {
        // 利用好字符规则
        int gMove = 1; // 利用好字符规则移动位数，默认是1，即至少移动一位
        int l = matchLen - j - 1; // 已经匹配的好后缀长度
        int index = sufix[l];
        if (index < 0) { // 没有好后缀
            for (int k = l; k >= 0; k--) {
                if (prefix[k]) {
                    index = 0;
                    gMove = j - index;
                    break;
                }
            }
        } else {
            gMove = j - index;
        }
        return gMove;
    }


    public static void main(String[] args) {
        BmMatch myBmMatch = new BmMatch();
        String mainStr = "wrekjfsdkfjpouiewrsldkjfxcmlds;fksprioepwsfa";
        String matchStr = "fxcm";
        int i = myBmMatch.bmSearch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
