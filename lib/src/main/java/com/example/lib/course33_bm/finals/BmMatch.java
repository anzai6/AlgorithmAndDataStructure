package com.example.lib.course33_bm.finals;

import java.util.HashMap;

/**
 * BM�ַ������ҷ�������ģʽ�������ַ���ǰƥ�䣬���û��ַ�����ͺ��ַ�������������Ч��
 * �����ַ�������Ҫ�����hash���ڴ棬����ڴ�Ҫ���ϸ����ֻʹ�ú��ַ�����
 * Created by qinshunan on 2019/4/16.
 */

public class BmMatch {

    /**
     * BM����
     *
     * @param mainStr  ����
     * @param matchStr ģʽ��
     * @return ���ҵ���Ӧ�ַ��������ַ���mainStr���±�, ���磺bcda �в��� da ���� 2
     */
    public int bmSearch(String mainStr, String matchStr) {
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

        // ���ַ���������Ԥ����
        // ֵ�洢ģʽ�������׺�Ӵ�ƥ����Ӵ���ģʽ���е���ʼ�ַ����꣬�±������ƥ��ĺ�׺�Ӵ��ĳ��ȣ�����
        // ģʽ����dcdc
        // �����׺�Ӵ��У�  c              dc            cdc
        // ��Ӧ   sufix[1] == 1; sufix[2] == 0; sufix[3] == -1
        int[] sufix = new int[matchLen];
        // ģʽ���������׺�Ӵ�ƥ���ǰ׺�Ӵ������䳤��Ϊ�±꣬��¼ֵΪtrue,���������������prefix[2] == true;
        boolean[] prefix = new boolean[matchLen];

        // ��ʼ��
        for (int i = 0; i < matchLen; i++) {
            sufix[i] = -1;
            prefix[i] = false;
        }

        // ȡģʽ����0~i���Ӵ���ģʽ���󹫹���׺�Ӵ���ͨ��������׺�Ӵ����ȸ�ֵsufix��prefix
        // i��ȡֵ��Χ��0~matchLen - 2
        for (int i = 0; i < matchLen - 1; i++) {
            int m = matchLen - 1;
            int k = i;
            while (k >= 0) {
                char suMatchChar = matchStr.charAt(k);
                char matchChar = matchStr.charAt(m);
                if (suMatchChar == matchChar) {
                    int j = k - i + 1; // �Ѿ�ƥ��Ĺ�����׺�Ӵ��ĳ���
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

        // ��ʼƥ��
        int i = 0;
        while (i <= mainLen - matchLen) {
            int j = matchLen - 1;
            for (; j >= 0; j--) {
                int mainIndex = i + j;
                char mainC = mainStr.charAt(mainIndex);
                char matchC = matchStr.charAt(j);
                if (mainC == matchC) {
                    continue;
                } else { // ��ƥ��
                    int bMove = badCharRuleMatch(mainC, j, hashMap); // ���û��ַ������ƶ�λ��
                    int gMove = goodCharRuleMatch(j, matchLen, sufix, prefix); // ���ú��ַ������ƶ�λ��

                    // ѡ�������ƶ�λ��
                    i += Math.max(bMove, gMove);
                    break;
                }
            }
            if (j == -1) { // ƥ��ɹ�
                return i;
            }
        }

        return -1;
    }

    /**
     * ���ַ�����
     *
     * @param mainC   ���ַ�
     * @param j       ���ַ����±�
     * @param hashMap �洢ģʽ��ÿ���ַ���Ӧ���±��ɢ�б�
     * @return ���ػ��ַ��������ƶ��ĳ���
     */
    private int badCharRuleMatch(char mainC, int j, HashMap<Character, Integer> hashMap) {
        int bMove = 1; // ���û��ַ������ƶ�λ����Ĭ����1���������ƶ�һλ
        if (hashMap.containsKey(mainC)) {
            int index = hashMap.get(mainC);
            if (index < j) { // С��֤������ߣ��������ұߣ������ƶ�
                bMove = (j - index);
            }
        } else { // �ֵ���û�л��ַ�
            bMove = j + 1;
        }
        return bMove;
    }

    /**
     * ���ַ�����
     *
     * @param j        ���ַ����±�
     * @param matchLen ģʽ������
     * @param sufix    ֵ�洢ģʽ�������׺�Ӵ�ƥ����Ӵ���ģʽ���е���ʼ��ʼ�ַ����꣬�±������ƥ��ĺ�׺�Ӵ��ĳ���
     * @param prefix   ģʽ���������׺�Ӵ�ƥ���ǰ׺�Ӵ������䳤��Ϊ�±꣬��¼ֵΪtrue
     * @return ���ػ��ַ��������ƶ��ĳ���
     */
    private int goodCharRuleMatch(int j, int matchLen, int[] sufix, boolean[] prefix) {
        // ���ú��ַ�����
        int gMove = 1; // ���ú��ַ������ƶ�λ����Ĭ����1���������ƶ�һλ
        int l = matchLen - j - 1; // �Ѿ�ƥ��ĺú�׺����
        int index = sufix[l];
        if (index < 0) { // û�кú�׺
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
