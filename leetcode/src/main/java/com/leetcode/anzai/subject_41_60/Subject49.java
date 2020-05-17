package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class Subject49 {

    /**
     *
     给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

     示例:

     输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     说明：

     所有输入均为小写字母。
     不考虑答案输出的顺序。
     *
     */

    /**
     * 参考官网：一共26字母，可以统计每个字母出现的字数
     *
     * @param strs
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return list;
        }

        HashMap<String, List> hashMap = new HashMap<>();
        int[] charCount = new int[26];
        String splitStr = "#";
        for (int i = 0; i < strs.length; i++) {

            // 统计次数
            for (int j = 0; j < strs[i].length(); j++) {
                charCount[strs[i].charAt(j) - 'a']++;
            }

            // 按特殊格式组合出现过的字符
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charCount.length; j++) {
                if (charCount[j] != 0) {
                    // 格式：#1#1#
                    sb.append(splitStr).append(j).append(splitStr).append(charCount[j]).append(splitStr);
                    charCount[j] = 0; // 还原
                }
            }

            String key = sb.toString();
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(strs[i]);
            } else {
                List<String> subList = new ArrayList<>();
                subList.add(strs[i]);
                hashMap.put(key, subList);
                list.add(subList);
            }
        }

        return list;
    }

    /**
     * 参考网友：将每一个字符串排序，通过哈希表可以直接匹配了,想法很可以
     *
     * @param strs
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return list;
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charList = strs[i].toCharArray();
            Arrays.sort(charList);
            String str = String.valueOf(charList);
            if (hashMap.containsKey(str)) {
                list.get(hashMap.get(str)).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                list.add(newList);
                newList.add(strs[i]);
                hashMap.put(str, list.size() - 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        Subject49 subject = new Subject49();
        List<List<String>> list = subject.groupAnagrams(strs);

        for (int i = 0; i < list.size(); i++) {
            List<String> subList = list.get(i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.print(subList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
