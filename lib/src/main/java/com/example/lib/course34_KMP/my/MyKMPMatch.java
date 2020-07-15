package com.example.lib.course34_KMP.my;

import com.example.lib.course32_stringmatch.my.MyStringMatch;

/**
 * Created by qinshunan on 2019/4/18.
 */
public class MyKMPMatch {


    public int KMPMatch(String mainStr, String matchStr) {

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

        char[] mainChar = mainStr.toCharArray();
        char[] matchChar = matchStr.toCharArray();

        int[] next = getPreMatchData(matchChar, matchLen);

        int j = 0;
        for (int i = 0; i < mainLen; i++) {
            while (j > 0 && mainChar[i] != matchChar[j]) { // һֱ�ҵ� mainChar[i] �� matchChar[j]
                j = next[j - 1] + 1;
            }
            if (mainChar[i] == matchChar[j]) {
                ++j;
            }
            if (j == matchLen) { // �ҵ�ƥ��ģʽ������
                return i - matchLen + 1;
            }
        }
        return -1;
    }


    /**
     * Ԥ�����ҵ�ģʽ���������Ӵ���Ӧ���ƥ��ǰ׺�Ӵ���Ҳ���ƥ���׺�Ӵ�
     */
    private int[] getPreMatchData(char[] b, int matchLen) {

        // int[] next;ģʽ���Ӵ�β�ַ���Ϊ�±ֵ꣬Ϊ���ƥ��ǰ׺�Ӵ���β�ַ��±�
        int[] next = new int[matchLen];
        int k = -1;
        next[0] = k; // ���ַ�û���Ӵ�

        // ����b[0~i-1]���ƥ���׺�Ӵ���k
        // ���b[k+1] == b[i],��b[0~i]���ƥ���׺�Ӵ���k+1
        // ���b[k+1] != b[i],��b[0~i]���ƥ���׺�Ӵ���x
        // ��x-1һ����b[0~i-1]��ĳ����ƥ���׺�Ӵ����ȣ�����һ���������b[x] == b[i]����x-1 <= k ����b[0,x-1]�ض�����b[0,k]--�ú���ᣬ����ǹؼ�
        // ������x-1���ǲ��ϵ�Ѱ��b[0,k]��ĳ�����ƥ���Ӵ�������Ӵ�����Ϊy,����b[y+1] == b[i]���Ӵ�С����Ѱ�ң�����0~k�����ƥ���׺�Ӵ���y = next[k]�������b[y+1] == b[i]��
        // ������������x = y + 1��������y = next[y],����������
        // �����õ����Ƕ�̬�滮��˼·����ͨ��0��1��ֵ��Ȼ����2.3.4.5...i��������
        // ***�ص�*** �ؼ�˼����Ƕ�̬�滮���ҳ�ͨ��next[i-1]��next[i]�Ĺ��ɣ���b[k+1] �� b[i] �ıȽ� ***�ص�***
        // b[k+1] == b[i] ��ֱ��next[i-1]+1�㶨��
        // ��b[k+1] != b[i] ������п�ƥ���Ӵ����ҵ�����b[k+1] == b[i]�Ŀ�ƥ���׺�Ӵ�


        for (int i = 1; i < matchLen; i++) {

            // ��ʱk��b[0~i-1]���ƥ���׺�Ӵ���ͨ��������С��ΧѰ�ҵ�b[k + 1] == b[i]�����ƥ���׺�Ӵ�����k
            // һ��ģʽ��b[0,k]�����п�ƥ���Ӵ�β�ַ������ǣ�next[k]��next[next[k]]��next[next[next[k]]]....ֱ������-1
            // ��������ע�ͺú����
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }

            // �������b[k + 1] ������ b[i]֤��û�����ƥ���׺�Ӵ�����k = -1;
            if (b[k + 1] == b[i]) {
                ++k;
            }

            next[i] = k;
        }

        return next;
    }


    public static void main(String[] args) {
        MyKMPMatch myKMP = new MyKMPMatch();
        String mainStr = "wrekjfsdkfjpouiewrsdkojfxcmlds;fksprioepwsfa";
        String matchStr = "sdkf";
        int i = myKMP.KMPMatch(mainStr, matchStr);
        System.out.print("" + i);
    }
}
