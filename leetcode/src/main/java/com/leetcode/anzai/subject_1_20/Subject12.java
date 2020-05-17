package com.leetcode.anzai.subject_1_20;

/**
 * ����ת��������
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class Subject12 {

    /**
     *
     �������ְ������������ַ���?I��?V��?X��?L��C��D?��?M��

     �ַ�          ��ֵ
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     ���磬 �������� 2 д��?II?����Ϊ�������е� 1��12 д��?XII?����Ϊ?X?+?II?�� 27 д��??XXVII, ��Ϊ?XX?+?V?+?II?��

     ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��?IIII������?IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ?IX���������Ĺ���ֻ�������������������

     I?���Է���?V?(5) ��?X?(10) ����ߣ�����ʾ 4 �� 9��
     X?���Է���?L?(50) ��?C?(100) ����ߣ�����ʾ 40 ��?90��?
     C?���Է���?D?(500) ��?M?(1000) ����ߣ�����ʾ?400 ��?900��
     ����һ������������תΪ�������֡�����ȷ���� 1?�� 3999 �ķ�Χ�ڡ�

     ʾ��?1:

     ����:?3
     ���: "III"
     ʾ��?2:

     ����:?4
     ���: "IV"
     ʾ��?3:

     ����:?9
     ���: "IX"
     ʾ��?4:

     ����:?58
     ���: "LVIII"
     ����: L = 50, V = 5, III = 3.
     ʾ��?5:

     ����:?1994
     ���: "MCMXCIV"
     ����: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     */

    /**
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String[] dictionary1 = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] dictionary10 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] dictionary100 = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] dictionary1000 = new String[]{"", "M", "MM", "MMM"};
        return dictionary1000[num / 1000] + dictionary100[num % 1000 / 100] + dictionary10[num % 100 / 10] + dictionary1[num % 10];
    }


    public static void main(String[] args) {
        Subject12 subject = new Subject12();
        System.out.println(subject.intToRoman(1994));
    }
}
