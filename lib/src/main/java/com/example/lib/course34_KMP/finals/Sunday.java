package com.example.lib.course34_KMP.finals;

import com.example.lib.course33_bm.finals.BmMatch;

import java.util.HashMap;

/**
 * һ���Ƚϸ�Ч�ͼ򵥵��ַ���ƥ���㷨
 * ԭ�����£�
 * ��ǰ����ƥ�䣬��������ƥ���ַ�ʱ����ȡ�������ڲ���ƥ����ַ�����һ���ַ���Ȼ���������ַ����Ӵ��е�λ��ֱ���ƶ��Ӵ�
 * �ؼ������ -- �������ڲ���ƥ����ַ�����һ���ַ� -- �����˼
 */
public class Sunday {
    /**
     * Sunday����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return ���ҵ���Ӧ�ַ��������ַ���mainStr���±�, ���磺bcda �в��� da ���� 2
     */
    public int SundaySearch(String mainStr, String matchStr) {
        if (mainStr == null || mainStr.length() == 0
                || matchStr == null || matchStr.length() == 0
                || mainStr.length() < matchStr.length()) {
            return -1;
        }
        int mainLen = mainStr.length();
        int matchLen = matchStr.length();
        // �Ӵ���ÿ���ַ��������ֵ�λ��
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < matchLen; i++) {
            char c = matchStr.charAt(i);
            hashMap.put(Character.valueOf(c), Integer.valueOf(i));
        }

        // ��ʼƥ��
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = 0;
            for (; j < matchLen; j++) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else if (i == mainLen - matchLen) { // ���һ�֣�ֱ�ӷ���
                    return -1;
                } else { // ���� Sunday �㷨
                    int next = i + matchLen; // �������ڲ���ƥ����ַ�����һ���ַ��±�
                    if (hashMap.containsKey(mainStr.charAt(next))) {
                        // �������ڲ���ƥ����ַ�����һ���ַ���ģʽ���е��±�
                        int subNextIndex = hashMap.get(mainStr.charAt(next));
                        // ��Ҫ�ƶ���λ��
                        int moveIndex = next - subNextIndex;
                        i += moveIndex;
                    } else { // ģʽ�������ڸ��ַ���ֱ����������
                        i = next + 1;
                    }
                    break;
                }
            }
            if (j == matchLen) { // ƥ��ɹ�
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
