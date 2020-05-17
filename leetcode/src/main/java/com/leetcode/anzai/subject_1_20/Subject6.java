package com.leetcode.anzai.subject_1_20;

/**
 * Z ���α任
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class Subject6 {

    /**
     *
     ��һ�������ַ������ݸ������������Դ������¡������ҽ���?Z �������С�

     ���������ַ���Ϊ "LEETCODEISHIRING"?����Ϊ 3 ʱ���������£�

     L   C   I   R
     E T O E S I I G
     E   D   H   N
     ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��

     ����ʵ��������ַ�������ָ�������任�ĺ�����

     string convert(string s, int numRows);
     ʾ��?1:

     ����: s = "LEETCODEISHIRING", numRows = 3
     ���: "LCIRETOESIIGEDHN"
     ʾ��?2:

     ����: s = "LEETCODEISHIRING", numRows =?4
     ���:?"LDREOEIIECIHNTSG"
     ����:

     L     D     R
     E   O E   I I
     E C   I H   N
     T     S     G

     L       D       R
     L     O D     R R
     E   O   E   I   I
     E C     I H     N
     T       S       G

     0       8         16
     1     7 9      15 17
     2   6   10   14   18
     3 5     11 13     19
     4       12        20
     *
     */


    /**
     * ���������ַ��±�����ҳ���ÿһ�е��ַ��±�
     * �����±�Ϊ������Ϊi,�����Ϊn,�����ߵ�һ�е��ַ��±����������ұߵ��ַ��±꣬��ʽ��
     * ��һ�������Ϊ�� ,�ڶ��������Ϊ 2i-2
     * ����n=5����i=1,�� 2n-2i = 8,2i-2=0, ���������� 0-->8-->16 ...
     * ��i=2,�� 2n-2i = 6,2i-2=2, ���������� 1-->7-->9  9-->15-->17 ...
     * <p>
     * 0       8         16
     * 1     7 9      15 17
     * 2   6   10   14   18
     * 3 5     11 13     19
     * 4       12        20
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int firstInterval = 2 * numRows - 2 * (i + 1); // ��һ�����
            int secondInterval = 2 * i; // �ڶ������
            int startIndex = i; // ��ߵ�һ���ַ��ĳ�ʼ�±�

            while (startIndex < len) { // ���һ���е�����
                sb.append(s.charAt(startIndex));

                // ֻ��һ�еĵ���������
                if (firstInterval == 0 && secondInterval == 0) {
                    startIndex++;
                    continue;
                }

                if (firstInterval > 0) {
                    startIndex += firstInterval;

                    if (secondInterval == 0) // �ڶ������Ϊ0��ֱ����ѭ��
                        continue;


                    if (startIndex < len) {
                        sb.append(s.charAt(startIndex));
                        startIndex += secondInterval;
                    } else {
                        break;
                    }
                } else { // ��һ�������0��ֱ�ӵ��ڶ������
                    startIndex += secondInterval;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Subject6 subject = new Subject6();
        System.out.println(subject.convert("LEETCODEISHIRING", 1));
    }
}
