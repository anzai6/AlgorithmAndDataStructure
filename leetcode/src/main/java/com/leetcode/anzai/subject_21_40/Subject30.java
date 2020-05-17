package com.leetcode.anzai.subject_21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * �������е��ʵ��Ӵ�
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 */
public class Subject30 {

    /**
     *
     ����һ���ַ���?s?��һЩ������ͬ�ĵ���?words���ҳ� s ��ǡ�ÿ�����?words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�

     ע���Ӵ�Ҫ��?words �еĵ�����ȫƥ�䣬�м䲻���������ַ���������Ҫ����?words?�е��ʴ�����˳��

     ?

     ʾ�� 1��

     ���룺
     s = "barfoothefoobarman",
     words = ["foo","bar"]
     �����[0,9]
     ���ͣ�
     ������ 0 �� 9 ��ʼ���Ӵ��ֱ��� "barfoo" �� "foobar" ��
     �����˳����Ҫ, [9,0] Ҳ����Ч�𰸡�
     ʾ�� 2��

     ���룺
     s = "wordgoodgoodgoodbestword",
     words = ["word","good","best","word"]
     �����[]
     *
     */

    /**
     * ��ͨ�ⷨ���Ȱ�����ÿһ���Ӵ�(ģʽ�Ӵ��ĳ���)��HashCode�������codeList����Ȼ���ģʽ�������ÿһ���Ӵ���HashCode�������subHashMap��
     * Ȼ����� codeList
     *
     * @param s     ����
     * @param words ģʽ������
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;

        int singleWordLen = words[0].length(); // �����Ӵ�����
        int allWordLen = words.length * singleWordLen; // ���ַ�ƴ�����ĳ���
        if (allWordLen > s.length()) // �������Ȳ���
            return list;
        int[] codeList = new int[s.length() - singleWordLen + 1]; // ���������ÿһ��ƥ���Ӵ���hashcode���±����Ӵ�����������±�
        for (int i = 0; i < codeList.length; i++) {
            codeList[i] = s.substring(i, i + singleWordLen).hashCode();
        }

        HashMap<Integer, ArrayList<Integer>> subHashMap = new HashMap<>(); // ���ÿһ���Ӵ���hashcode���±�
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

        boolean[] result = new boolean[words.length]; // ����Ѿ�ƥ����Ӵ��±�
        for (int i = 0; i < s.length() - allWordLen + 1; i++) {
            int j = 0;
            for (; j < result.length; j++) {
                int itemCode = codeList[i + j * singleWordLen]; // ÿ�μ�������Ӵ�����
                // û�д���
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
