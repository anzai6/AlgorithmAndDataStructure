package com.leetcode.anzai.subject_41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ��ĸ��λ�ʷ���
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class Subject49 {

    /**
     *
     ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

     ʾ��:

     ����: ["eat", "tea", "tan", "ate", "nat", "bat"],
     ���:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     ˵����

     ���������ΪСд��ĸ��
     �����Ǵ������˳��
     *
     */

    /**
     * �ο�������һ��26��ĸ������ͳ��ÿ����ĸ���ֵ�����
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

            // ͳ�ƴ���
            for (int j = 0; j < strs[i].length(); j++) {
                charCount[strs[i].charAt(j) - 'a']++;
            }

            // �������ʽ��ϳ��ֹ����ַ�
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charCount.length; j++) {
                if (charCount[j] != 0) {
                    // ��ʽ��#1#1#
                    sb.append(splitStr).append(j).append(splitStr).append(charCount[j]).append(splitStr);
                    charCount[j] = 0; // ��ԭ
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
     * �ο����ѣ���ÿһ���ַ�������ͨ����ϣ�����ֱ��ƥ����,�뷨�ܿ���
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
