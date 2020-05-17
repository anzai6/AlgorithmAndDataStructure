package com.leetcode.anzai.subject_1_20;

/**
 * �����ǰ׺
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Subject14 {

    /**
     *
     ��дһ�������������ַ��������е������ǰ׺��

     ��������ڹ���ǰ׺�����ؿ��ַ���?""��

     ʾ��?1:

     ����: ["flower","flow","flight"]
     ���: "fl"
     ʾ��?2:

     ����: ["dog","racecar","car"]
     ���: ""
     ����: ���벻���ڹ���ǰ׺��
     ˵��:

     ��������ֻ����Сд��ĸ?a-z?��
     *
     */

    /**
     * �����㷨
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefixDC(strs, 0, strs.length - 1);
    }

    /**
     * ����
     *
     * @param strs
     * @param low  �����±߽�
     * @param high �����ϱ߽�
     * @return �������������ǰ׺����
     */
    public String longestCommonPrefixDC(String[] strs, int low, int high) {
        if (low > high)
            return "";
        if (low == high)
            return strs[low];
        if (high - low == 1) {
            return getTwoStrCommonQZ(strs[low], strs[high]);
        }
        int center = high + (low - high) / 2;
        String commonQZ1 = longestCommonPrefixDC(strs, low, center);
        if (center + 1 > high || center + 1 > strs.length - 1)
            return commonQZ1;
        String commonQZ2 = longestCommonPrefixDC(strs, center + 1, high);

        return getTwoStrCommonQZ(commonQZ1, commonQZ2);
    }

    /**
     * �������ַ����Ĺ���ǰ׺
     *
     * @param str1
     * @param str2
     * @return
     */
    private String getTwoStrCommonQZ(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        for (; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                break;
        }
        return str1.substring(0, i);
    }

    /**
     * ˮƽɨ�跨:�õ�һ���ַ������κͺ���ıȶԣ��ҳ������ǰ׺
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String compareStr = ""; // ��̵��ַ���
        int commonLen = Integer.MAX_VALUE; // ������Ӵ��ĳ���

        // ���ҳ���С���ַ�������
        for (int i = 0; i < strs.length; i++) {
            if (commonLen > strs[i].length()) {
                commonLen = strs[i].length();
                compareStr = strs[i];
            }
        }

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            int j = 0;
            for (; j < commonLen; j++) { // ֻ��Ҫ����commonLen���ȼ���
                if (compareStr.charAt(j) != str.charAt(j)) { // ����ȵ��ַ�
                    break;
                }
            }
            if (j == 0) // û�й���ǰ׺
                return "";
            commonLen = j;
        }
        return compareStr.substring(0, commonLen);
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        Subject14 subject = new Subject14();
        System.out.println(subject.longestCommonPrefix(strs));
    }
}
