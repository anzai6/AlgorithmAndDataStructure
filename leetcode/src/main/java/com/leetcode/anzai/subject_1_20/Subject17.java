package com.leetcode.anzai.subject_1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Subject17 {

    /**
     *
     给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。

     给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

     Subject17.png

     示例:

     输入："23"
     输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     说明:
     尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     */

    /**
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return list;
        letterCombinationsInternal(digits, 0, list, new StringBuilder());
        return list;
    }

    /**
     * 递归
     *
     * @param digits
     * @param i
     * @param list
     * @param sb
     */
    private void letterCombinationsInternal(String digits, int i, List<String> list, StringBuilder sb) {
        String charStr = numDicts[digits.charAt(i) - '2'];
        for (int j = 0; j < charStr.length(); j++) {
            char value = charStr.charAt(j);
            sb.append(value);
            if (i == digits.length() - 1) {
                list.add(sb.toString());
            } else {
                letterCombinationsInternal(digits, i + 1, list, sb);
            }
            sb.deleteCharAt(sb.length() - 1); // 删除最后一位，这里是关键
        }
    }

    static String[] numDicts = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Subject17 subject = new Subject17();
        List<String> list = subject.letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
