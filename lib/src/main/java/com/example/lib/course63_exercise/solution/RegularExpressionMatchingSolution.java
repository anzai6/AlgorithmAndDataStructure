package com.example.lib.course63_exercise.solution;

/**
 * ������ʽƥ��
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatchingSolution {

    /**
     *
     ����һ���ַ���?s?��һ���ַ�����?p��������ʵ��һ��֧�� '.'?��?'*'?��������ʽƥ�䡣

     '.' ƥ�����ⵥ���ַ�
     '*' ƥ���������ǰ�����һ��Ԫ��
     ��νƥ�䣬��Ҫ����?����?�ַ���?s�ģ������ǲ����ַ�����

     ˵��:

     s?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ��
     p?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ���Լ��ַ�?.?��?*��
     ʾ�� 1:

     ����:
     s = "aa"
     p = "a"
     ���: false
     ����: "a" �޷�ƥ�� "aa" �����ַ�����
     ʾ�� 2:

     ����:
     s = "aa"
     p = "a*"
     ���: true
     ����:?��Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
     ʾ��?3:

     ����:
     s = "ab"
     p = ".*"
     ���: true
     ����:?".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
     ʾ�� 4:

     ����:
     s = "aab"
     p = "c*a*b"
     ���: true
     ����:?��Ϊ '*' ��ʾ������������� 'c' Ϊ 0 ��, 'a' ���ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
     ʾ�� 5:

     ����:
     s = "mississippi"
     p = "mis*is*p*."
     ���: false

     *
     */


    /**
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        isMatch = false;
        if (p == null)
            return false;
        if (s == null)
            return false;

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        sLen = s.length();
        pLen = p.length();
        boolean[][] isCheck = new boolean[sLen][pLen];
        isMatchBT(sChars, pChars, 0, 0, isCheck);
        return isMatch;
    }

    private boolean isMatch = false;
    private int sLen;
    private int pLen;

    /**
     * @param sChars
     * @param pChars
     * @param i      sChars��λ��
     * @param j      pChars��λ��
     */
    private void isMatchBT(char[] sChars, char[] pChars, int i, int j, boolean[][] isCheck) {
        if (isMatch) // ��ƥ���ֱ����ֹ����
            return;

        if (i >= sLen || j >= pLen) {
            if (i >= sLen && j >= pLen) { // ������ƥ��ɹ�
                isMatch = true;
            } else if (i == sLen) { // pû��ƥ���꣬��ֻ��ʣ�µĶ���"*"����ƥ��ɹ�
                int k = j;
                for (; k < pLen; k++) {
                    if (pChars[k] == '*') { // ƥ���������ǰ�����һ��Ԫ��
                        continue;
                    } else if (k < pLen - 1 && '*' == pChars[k + 1]) { // ��һ����"*"ʱ����������һ��
                        continue;
                    } else
                        return;
                }
                if (k == pLen)
                    isMatch = true;
            }
            return;
        }

        if (isCheck[i][j])
            return;
        else isCheck[i][j] = true;

        if (pChars[j] == '.') { // ƥ�����ⵥ���ַ�
            if (j < pLen - 1 && '*' == pChars[j + 1]) { // ��һ����"*"ʱ����������һ��
                isMatchBT(sChars, pChars, i, j + 1, isCheck);
            }
            isMatchBT(sChars, pChars, i + 1, j + 1, isCheck);
        } else if (pChars[j] == '*') { // ƥ���������ǰ�����һ��Ԫ��
            if (j > 0) {
                char lastChar = pChars[j - 1];
                for (int k = 0; k <= sLen - i; k++) {
                    if (isMatch) // ��ƥ���ֱ����ֹѭ��
                        return;
                    if (lastChar == '.') { // ƥ��������������ַ�
                        isMatchBT(sChars, pChars, k + i, j + 1, isCheck); // ƥ���������
                    } else {
                        if (k == 0) {
                            isMatchBT(sChars, pChars, i, j + 1, isCheck); // ƥ�����
                        } else if (sChars[k + i - 1] == lastChar) {
                            isMatchBT(sChars, pChars, k + i, j + 1, isCheck); // ƥ����
                        } else
                            break;
                    }
                }
            }
        } else { // ���������ַ�
            if (sChars[i] == pChars[j]) { // ����ƥ��
                isMatchBT(sChars, pChars, i + 1, j + 1, isCheck);
            }

            if (j < pLen - 1 && '*' == pChars[j + 1]) { // ��һ����"*"ʱ����������һ��
                isMatchBT(sChars, pChars, i, j + 1, isCheck);
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatchingSolution solution = new RegularExpressionMatchingSolution();
//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "a*"));
//        System.out.println(solution.isMatch("aa", ".*"));
//        System.out.println(solution.isMatch("aab", "c*a*b"));
//        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("a", "ab*"));
//        System.out.println(solution.isMatch("a", "ab*a"));
//        System.out.println(solution.isMatch("ab", ".*.."));
//        System.out.println(solution.isMatch("", ".*"));
        System.out.println(solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }

}
