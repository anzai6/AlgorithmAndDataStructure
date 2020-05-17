package com.leetcode.anzai.subject_41_60;

/**
 * ͨ���ƥ��
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Subject44 {

    /**
     *
     ����һ���ַ���?(s) ��һ���ַ�ģʽ?(p) ��ʵ��һ��֧��?'?'?��?'*'?��ͨ���ƥ�䡣

     '?' ����ƥ���κε����ַ���
     '*' ����ƥ�������ַ������������ַ�������
     �����ַ�����ȫƥ�����ƥ��ɹ���

     ˵��:

     s?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ��
     p?����Ϊ�գ���ֻ������?a-z?��Сд��ĸ���Լ��ַ�???��?*��
     ʾ��?1:

     ����:
     s = "aa"
     p = "a"
     ���: false
     ����: "a" �޷�ƥ�� "aa" �����ַ�����
     ʾ��?2:

     ����:
     s = "aa"
     p = "*"
     ���: true
     ����:?'*' ����ƥ�������ַ�����
     ʾ��?3:

     ����:
     s = "cb"
     p = "?a"
     ���: false
     ����:?'?' ����ƥ�� 'c', ���ڶ��� 'a' �޷�ƥ�� 'b'��
     ʾ��?4:

     ����:
     s = "adceb"
     p = "*a*b"
     ���: true
     ����:?��һ�� '*' ����ƥ����ַ���, �ڶ��� '*' ����ƥ���ַ��� "dce".
     ʾ��?5:

     ����:
     s = "acdcb"
     p = "a*c?b"
     ����: false
     *
     */

    /**
     * ���Ѹ�����Ķ�̬�滮
     * <p>
     * ���ƹ�ʽ��f(i,j) = f(i-1,j) -> p[j] = "*",f(i,j-1) -> p[j] = "*",f(i-1,j-1) -> p[j] = "*"��"?"���ַ�; ��������һ�� true ����
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p == null || s == null) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] resultList = new boolean[sLen + 1][pLen + 1]; // ע������ֱ�+1���Ͳ�������д�������жϸ����ٽ�������е����ڱ����ٺܶ��ж�
        resultList[0][0] = true;// ���������յ��ַ�

        // ��ʼ�� s Ϊ�յ���� (ע�� p Ϊ�յ�������� s Ϊ�գ�ʣ�µĶ��� false ���Բ��ó�ʼ����)
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                resultList[0][i] = true;
            } else {
                break; // �˳�ѭ������Ϊʣ�µĶ��� false ��
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    // ������״̬��һ��ƥ�伴��
                    resultList[i][j] = resultList[i - 1][j] || resultList[i][j - 1] || resultList[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    resultList[i][j] = resultList[i - 1][j - 1];
                } else {
                    resultList[i][j] = false;
                }
            }
        }

        return resultList[sLen][pLen];
    }

    /**
     * ��̬�滮
     * <p>
     * ���ƹ�ʽ��f(i,j) = f(i-1,j) -> p[j] = "*",f(i,j-1) -> p[j] = "*",f(i-1,j-1) -> p[j] = "*"��"?"���ַ�; ��������һ�� true ����
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (p == null || s == null) {
            return false;
        }

        // ��Կյ����
        if ("".equals(s) && "".equals(p)) {
            return true;
        } else if ("".equals(s)) {
            int k = 0;
            // ʣ�µĶ���"*"
            for (; k < p.length(); k++) {
                if ('*' == p.charAt(k)) {
                    continue;
                } else {
                    break;
                }
            }
            if (k == p.length()) {
                return true;
            }
            return false;
        } else if ("".equals(p)) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] resultList = new boolean[sLen][pLen];

        // 0-0λ
        if (p.charAt(0) == '*' || p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
            resultList[0][0] = true;
        } else {
            resultList[0][0] = false;
        }

        // ��һ��
        if (p.charAt(0) == '*') { // ֻ�� "*" Ҫ����������һ���� false
            for (int i = 1; i < sLen; i++) {
                resultList[i][0] = true;
            }
        }

        // ��һ��-����Ƚ��ѣ��е���
        if (resultList[0][0]) { // false �Ͳ������±����ˣ������һ���� false
            for (int i = 1; i < pLen; i++) {
                // �����ж����׳���
                if (p.charAt(i) == '*') {
                    resultList[0][i] = true;
                } else if (p.charAt(0) == '*' && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(0))) {
                    // �����ǰ���� i ǰ����ַ����� "*"
                    resultList[0][i] = true;

                    int k = i + 1;
                    // ʣ�µĶ���"*"
                    for (; k < pLen; k++) {
                        if ('*' == p.charAt(k)) {
                            resultList[0][k] = true;
                        } else {
                            break;
                        }
                    }

                    break; // ���治���ж���
                } else {
                    break; // ���治���ж���
                }
            }
        }

        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < pLen; j++) {
                if (p.charAt(j) == '*') {
                    // ������״̬��һ��ƥ�伴��
                    resultList[i][j] = resultList[i - 1][j] || resultList[i][j - 1] || resultList[i - 1][j - 1];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    resultList[i][j] = resultList[i - 1][j - 1];
                } else {
                    resultList[i][j] = false;
                }
            }
        }

        return resultList[sLen - 1][pLen - 1];
    }

    /**
     * �ݹ����+����¼
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        isMatch = false;
        boolean[][] matchList = new boolean[s.length() + 1][p.length() + 1];
        isMatchInternal(s, 0, p, 0, matchList);
        return isMatch;
    }

    private boolean isMatch = false;

    /**
     * �ڲ��ݹ�
     *
     * @param s
     * @param i
     * @param p
     * @param j
     * @param matchList
     */
    public void isMatchInternal(String s, int i, String p, int j, boolean[][] matchList) {
        if (isMatch) {
            return;
        }

        if (matchList[i][j]) {
            return;
        } else {
            matchList[i][j] = true;
        }

        if (i == s.length() && j == p.length()) {
            isMatch = true;
            return;
        } else if (i == s.length()) {
            int k = j;
            // ʣ�µĶ���"*"
            for (; k < p.length(); k++) {
                if ('*' == p.charAt(k)) {
                    continue;
                } else {
                    break;
                }
            }
            if (k == p.length()) {
                isMatch = true;
                return;
            }
            return;
        } else if (j == p.length()) {
            return;
        }

        char pChar = p.charAt(j);

        if ('*' == pChar) {
            isMatchInternal(s, i, p, j + 1, matchList); // ƥ���
            isMatchInternal(s, i + 1, p, j + 1, matchList); // ƥ��һ��
            isMatchInternal(s, i + 1, p, j, matchList); // ƥ��������
        } else if ('?' == pChar) {
            isMatchInternal(s, i + 1, p, j + 1, matchList);
        } else if (s.charAt(i) == pChar) {
            isMatchInternal(s, i + 1, p, j + 1, matchList);
        }
        return;
    }

    public static void main(String[] args) {
        Subject44 subject = new Subject44();
        System.out.println(subject.isMatch("c", "*?*"));
    }
}