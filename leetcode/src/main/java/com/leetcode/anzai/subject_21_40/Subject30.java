package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 */
public class Subject30 {

    /**
     *
     给定一个字符串?s?和一些长度相同的单词?words。找出 s 中恰好可以由?words 中所有单词串联形成的子串的起始位置。

     注意子串要与?words 中的单词完全匹配，中间不能有其他字符，但不需要考虑?words?中单词串联的顺序。

     ?

     示例 1：

     输入：
     s = "barfoothefoobarman",
     words = ["foo","bar"]
     输出：[0,9]
     解释：
     从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     输出的顺序不重要, [9,0] 也是有效答案。
     示例 2：

     输入：
     s = "wordgoodgoodgoodbestword",
     words = ["word","good","best","word"]
     输出：[]
     *
     */

    /**
     * 普通解法：先把主串每一个子串(模式子串的长度)的HashCode求出来（codeList），然后把模式串数组的每一个子串的HashCode求出来（subHashMap）
     * 然后遍历 codeList
     *
     * @param s     主串
     * @param words 模式串数组
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;

        int singleWordLen = words[0].length(); // 单个子串长度
        int allWordLen = words.length * singleWordLen; // 子字符拼起来的长度
        if (allWordLen > s.length()) // 主串长度不够
            return list;
        int[] codeList = new int[s.length() - singleWordLen + 1]; // 存放主串中每一个匹配子串的hashcode，下标是子串在主串起点下标
        for (int i = 0; i < codeList.length; i++) {
            codeList[i] = s.substring(i, i + singleWordLen).hashCode();
        }

        HashMap<Integer, ArrayList<Integer>> subHashMap = new HashMap<>(); // 存放每一个子串的hashcode和下标
        for (int i = 0; i < words.length; i++) {
            int code = words[i].hashCode();
            ArrayList<Integer> indexList = null;
            if (subHashMap.containsKey(code)) {
                indexList = subHashMap.get(code);
            } else {
                indexList = new ArrayList<>();
                subHashMap.put(code, indexList);
            }
            indexList.add(i);
        }

        boolean[] result = new boolean[words.length]; // 存放已经匹配的子串下标
        for (int i = 0; i < s.length() - allWordLen + 1; i++) {
            int j = 0;
            for (; j < result.length; j++) {
                int itemCode = codeList[i + j * singleWordLen]; // 每次间隔单个子串长度
                // 没有存在
                if (subHashMap.containsKey(itemCode)) {
                    ArrayList<Integer> indexList = subHashMap.get(itemCode);
                    int k = 0;
                    for (; k < indexList.size(); k++) {
                        int index = indexList.get(k);
                        if (!result[index]) {
                            result[index] = true;
                            break;
                        }
                    }
                    if(k == indexList.size())
                        break;
                } else
                    break;
            }
            if (j == result.length)
                list.add(i);

            for (int k = 0; k < result.length; k++) {
                result[k] = false;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"word", "good", "best", "good"};
        Subject30 subject = new Subject30();
        List<Integer> list = subject.findSubstring("wordgoodgoodgoodbestword", words);
        for (Integer value : list) {
            System.out.print(value + " ");
        }
    }

}
