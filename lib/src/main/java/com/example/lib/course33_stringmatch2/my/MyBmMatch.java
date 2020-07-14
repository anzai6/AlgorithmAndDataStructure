package com.example.lib.course33_stringmatch2.my;

import com.example.lib.course32_stringmatch.my.MyStringMatch;

import java.util.HashMap;
import java.util.Map;

/**
 * BM�ַ������ҷ�������ģʽ�������ַ���ǰƥ�䣬���û��ַ�����ͺ��ַ�������������Ч��
 * �����ַ�������Ҫ�����hash���ڴ棬����ڴ�Ҫ���ϸ����ֻʹ�ú��ַ�����
 * Created by qinshunan on 2019/4/16.
 */

public class MyBmMatch {


    /**
     * BM����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return ���ҵ���Ӧ�ַ��������ַ���mainStr���±�, ���磺bcda �в��� da ���� 2
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

        if (matchStr.length() <= 2) // ����2������BF���������㷨���ܸ��죨���ϻ����򻹻���죬���ﲻ�����ˣ�
            return new MyStringMatch().BF(mainStr, matchStr);

        int mainLen = mainStr.length();
        int matchLen = matchStr.length();

        // -- ����Ԥ����ʼ --
        // ���ַ���������Ԥ����
        // ����ɢ�б�洢matchStr��ÿ���ַ���Ӧ���±꣬����������ƥ��
        Map<Character, Integer> matchCharMap = new HashMap<>();
        char[] matchChars = matchStr.toCharArray();
        for (int i = 0; i < matchChars.length; i++) {
            matchCharMap.put(matchChars[i], i);
        }

        // ���ַ���������Ԥ����
        // ֵ�洢ģʽ�������׺�Ӵ�ƥ����Ӵ���ģʽ���е���ʼ�ַ����꣬�±������ƥ��ĺ�׺�Ӵ��ĳ��ȣ�����
        // ģʽ����dcdc
        // �����׺�Ӵ��У�  c              dc            cdc
        // ��Ӧ   sufix[1] == 1; sufix[2] == 0; sufix[3] == -1
        int[] sufix = new int[matchLen];
        // ��ʼ��
        for (int i = 0; i < matchLen; i++) {
            sufix[i] = -1;
        }

        // ģʽ���������׺�Ӵ�ƥ���ǰ׺�Ӵ������䳤��Ϊ�±꣬��¼ֵΪtrue,���������������prefix[2] == true;
        boolean[] prefix = new boolean[matchLen];

        // ȡģʽ����0~k���Ӵ���ģʽ���󹫹���׺�Ӵ���ͨ��������׺�Ӵ����ȸ�ֵsufix��prefix
        // k��ȡֵ��Χ��0~matchLen - 2
        for (int k = 0; k < matchLen - 1; k++) {
            int m = matchLen - 1;
            // �󹫹���׺�Ӵ�
            for (int i = k; i >= 0; --i, --m) {
                char suMatchChar = matchStr.charAt(k);
                char matchChar = matchStr.charAt(m);
                if (suMatchChar == matchChar) {
                    int j = k - i + 1; // �Ѿ�ƥ��Ĺ�����׺�Ӵ��ĳ���
                    sufix[j] = i;
                    if (i == 0)
                        prefix[k] = true;
                } else {
                    break;
                }
            }
        }
        // -- ����Ԥ������� --

        // ��ʼƥ��
        int s = matchLen - 1; // ÿ�ο�ʼƥ����±꣬�����ǴӺ���ǰƥ��ģ�������ʼ�±����ģʽ���ĳ��ȼ�һ
        // ѭ��ƥ��
        while (s < mainLen) {

            // ��ʹ�û��ַ�����ƥ��
            int badMoveLen = badCharRuleMatch(mainStr, matchStr, s, matchCharMap);
            if (badMoveLen == 0) // ƥ��ɹ�
                return s - matchLen + 1;
            else if (badMoveLen < 0) { // ���ַ�����ƥ��ʧЧ

            }

            // -- ʹ�ú��ַ�����ƥ�� --

            // ����ȡ��sufix��prefix��ֵ��Ϳ��Կ�ʼ���ַ�����ƥ����
            int goodMoveLen = goodCharRuleMatch(mainStr, matchStr, s, sufix, prefix);
            if (goodMoveLen == 0) // ƥ��ɹ�
                return s - matchLen + 1;

            // ȡ���ַ�����ͺ��ַ��������ƶ�����λ��
//            s = s + Math.max(badMoveLen, goodMoveLen);
            s = s + goodMoveLen;
        }

        return -1;
    }

    /**
     * ���ַ�����
     *
     * @param mainStr      ����
     * @param matchStr     ģʽ��
     * @param s            ������±꿪ʼ��ǰƥ��ģʽ��
     * @param matchCharMap �洢ģʽ��ÿ���ַ���Ӧ���±��ɢ�б�
     * @return ���ػ��ַ��������ƶ��ĳ��ȣ�����0֤��ƥ��ɹ�
     */
    private int badCharRuleMatch(String mainStr, String matchStr, int s, Map<Character, Integer> matchCharMap) {
        int matchLen = matchStr.length();
        // �Ӻ���ǰƥ��
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
     * ���ַ�����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @param s        ������±꿪ʼ��ǰƥ��ģʽ��
     * @param sufix    ֵ�洢ģʽ�������׺�Ӵ�ƥ����Ӵ���ģʽ���е���ʼ��ʼ�ַ����꣬�±������ƥ��ĺ�׺�Ӵ��ĳ���
     * @param prefix   ģʽ���������׺�Ӵ�ƥ���ǰ׺�Ӵ������䳤��Ϊ�±꣬��¼ֵΪtrue
     * @return ���ػ��ַ��������ƶ��ĳ��ȣ�����0֤��ƥ��ɹ�
     */
    private int goodCharRuleMatch(String mainStr, String matchStr, int s, int[] sufix, boolean[] prefix) {
        int matchLen = matchStr.length();
        // �Ӻ���ǰƥ��
        for (int i = matchLen - 1; i >= 0; --i, --s) {
            char mainChar = mainStr.charAt(s);
            char matchChar = matchStr.charAt(i);
            if (mainChar != matchChar) {
                int j = matchLen - i - 1; // ���ַ�������
                if (j == 0) { // û�к��ַ����ƶ�һλ
                    return 1;
                } else {
                    int h = sufix[j]; // ���ַ�����ģʽ���е�����Ӵ����±꣬����ģʽ���ǣ�cbcabc,���ַ�����bc,��h=1;
                    if (h >= 0) { // ��ֵ
                        return i - h + 1;
                    } else { // û��ֵ��Ѱ��ƥ���ǰ׺�Ӵ�
                        for (int k = j; k >= 1; --k) {
                            if (prefix[k]) {
                                return matchLen - k;
                            }
                        }
                        // û���ҵ�ƥ���ǰ׺�Ӵ�,����ģʽ������
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
