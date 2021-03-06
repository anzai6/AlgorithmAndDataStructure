package com.example.lib.course32_stringmatch.finals;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串匹配算法：BF算法（Brute Force暴力匹配算法）和RK算法
 * Created by qinshunan on 2019/4/12.
 */

public class StringMatch {

    public static Map<Character, Integer> dict = new HashMap<>();

    static {
        dict.put('a', 0);
        dict.put('b', 1);
        dict.put('c', 2);
        dict.put('d', 3);
        dict.put('e', 4);
        dict.put('f', 5);
        dict.put('g', 6);
        dict.put('h', 7);
        dict.put('i', 8);
        dict.put('j', 9);
        dict.put('k', 10);
        dict.put('l', 11);
        dict.put('m', 12);
        dict.put('n', 13);
        dict.put('o', 14);
        dict.put('p', 15);
        dict.put('q', 16);
        dict.put('r', 17);
        dict.put('s', 18);
        dict.put('t', 19);
        dict.put('u', 20);
        dict.put('v', 21);
        dict.put('w', 22);
        dict.put('x', 23);
        dict.put('y', 24);
        dict.put('z', 25);
    }

    /**
     * BF算法（Brute Force暴力匹配算法），朴素的字符串匹配算法
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @return
     */
    public int BF(String mainStr, String matchStr) {
        if (mainStr == null || mainStr.length() == 0 || mainStr == null || matchStr.length() == 0) {
            return -1;
        }
        for (int i = 0; i < mainStr.length(); i++) {
            int k = 0;
            for (; k < matchStr.length(); k++) {
                if (mainStr.charAt(i + k) != matchStr.charAt(k)) {
                    break;
                }
            }
            if (k == matchStr.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Rk算法（加上Hash的BF算法升级版）
     * 这里规定匹配的是a~z的26个字母，hash算法是先给26字母分配26进制数，即dict
     * 然后以类似十进制的计算公式计算一个字符串hash："abc" = 26^2*0+26^1*1+26^0*2
     * 先遍历出主串中所有子串的hash值，然后跟模式串的hash值比较
     * 如果hash算法存在冲突，则在hash相同时比对子串和模式串的字符串来判断
     * 只要hash设置的相对合理，耗时不多且冲突不算多情况下，RK还是优于BF（因为减少了两个字符串之前的比对,而且hash是数字之前的比对，速度较快）
     *
     * @param mainStr  主串
     * @param matchStr 模式串
     * @return
     */
    public int Rk(String mainStr, String matchStr) {
        if (mainStr == null || mainStr.length() == 0 || mainStr == null || matchStr.length() == 0) {
            return -1;
        }
        HashMap<Integer, StringBuilder> hashMap = new HashMap<>();
        int len2 = matchStr.length();
        // 计算主串每一个 len2 长度的hash
        for (int i = 0; i <= mainStr.length() - len2; i++) {
            int hash = getStrHash(mainStr.substring(i, i + len2));
            if (hashMap.containsKey(hash)) {
                hashMap.get(hash).append(',').append(i);
            } else {
                hashMap.put(hash, new StringBuilder().append(i));
            }
            System.out.println("hash = " + hash + ", index = " + i);
        }
        int subHash = getStrHash(matchStr);
        System.out.println("subHash = " + subHash);
        if (hashMap.containsKey(subHash)) {
            StringBuilder sb = hashMap.get(subHash);
            if (sb.length() == 1) {
                return Integer.valueOf(sb.toString());
            }
            String[] array = sb.toString().split(",");
            for (int i = 0; i < array.length; i++) {
                int j = mainStr.charAt(array[i].charAt(0));
                int k = 0;
                for (; k < matchStr.length(); k++) {
                    if (mainStr.charAt(j + k) != matchStr.charAt(k)) {
                        break;
                    }
                }
                if (k == matchStr.length()) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    /**
     * 获取字符串的hash
     * "abc" = 26^2*0+26^1*1+26^0*2
     *
     * @param str
     * @return
     */
    private int getStrHash(String str) {
        int hash = 0;
        int len = str.length() - 1;
        for (int i = 0; i <= len; i++) {
            hash += (Math.pow(26, len - i) * dict.get(str.charAt(i)));
        }
        return hash;
    }


    public static void main(String[] args) {
        StringMatch myStringMatch = new StringMatch();
        int i = myStringMatch.BF("水电费a您好", "您好");
        int j = myStringMatch.Rk("rwqeuiofdskljacxvnersdjkfmfh", "qeui");
        System.out.print("BF: " + i + ",Rk: " + j);
    }
}
