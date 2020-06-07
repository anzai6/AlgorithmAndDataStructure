package com.example.lib.course38_backtracking.teacher;

/**
 * �򵥵�������ʽ�����㷨
 */
public class Pattern {
    private boolean matched = false;
    private char[] pattern; // ������ʽ
    private int plen; // ������ʽ����

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) { // �ı���������
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) return; // ����Ѿ�ƥ���ˣ��Ͳ�Ҫ�����ݹ���
        if (pj == plen) { // ������ʽ����β��
            if (ti == tlen) matched = true; // �ı���Ҳ����β��
            return;
        }
        if (pattern[pj] == '*') { // * ƥ��������ַ�
            for (int k = 0; k <= tlen - ti; ++k) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') { // ? ƥ�� 0 ������ 1 ���ַ�
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) { // ���ַ�ƥ�����
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}
