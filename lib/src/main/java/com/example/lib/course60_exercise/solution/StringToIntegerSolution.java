package com.example.lib.course60_exercise.solution;

/**
 * �ַ���ת������ (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */

public class StringToIntegerSolution {

    /**
     *
     ������ʵ��һ��?atoi?������ʹ���ܽ��ַ���ת����������

     ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ��

     ������Ѱ�ҵ��ĵ�һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ���������������������Ϊ�������������ţ������һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�������

     ���ַ���������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����Щ�ַ����Ա����ԣ����Ƕ��ں�����Ӧ�����Ӱ�졣

     ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת����

     ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0��

     ˵����

     �������ǵĻ���ֻ�ܴ洢 32 λ��С���з�����������ô����ֵ��ΧΪ?[?2^31,? 2^31?? 1]�������ֵ���������Χ��qing���� ?INT_MAX (231?? 1) ��?INT_MIN (?231) ��

     ʾ��?1:

     ����: "42"
     ���: 42
     ʾ��?2:

     ����: "   -42"
     ���: -42
     ����: ��һ���ǿհ��ַ�Ϊ '-', ����һ�����š�
     ?    ���Ǿ����ܽ���������������������ֵ�����������������õ� -42 ��
     ʾ��?3:

     ����: "4193 with words"
     ���: 4193
     ����: ת����ֹ������ '3' ����Ϊ������һ���ַ���Ϊ���֡�
     ʾ��?4:

     ����: "words and 987"
     ���: 0
     ����: ��һ���ǿ��ַ��� 'w', �����������ֻ��������š�
     ����޷�ִ����Ч��ת����
     ʾ��?5:

     ����: "-91283472332"
     ���: -2147483648
     ����: ���� "-91283472332" ���� 32 λ�з���������Χ��
     ?    ��˷��� INT_MIN (2^31) ��

     *
     */

    /**
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char item = chars[i];
            if (sb.length() == 0 && ' ' == item)
                continue;
            if ((sb.length() == 0 && (item == '-' || '+' == item)) || isNum(item)) {
                sb.append(item);
            } else { // ���ϷǷ��Ż������־ͽ���ѭ��
                break;
            }
        }
        if (sb.length() == 0)
            return 0;

        String result = sb.toString();
        if ("-".equals(result) || "+".equals(result))
            return 0;

        double num = Double.parseDouble(result.replace("+", ""));
        if (num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) num;
    }

    private boolean isNum(char num) {
        int index = num - '0';
        return index >= 0 && index <= 9;
    }

    public static void main(String[] args) {
        StringToIntegerSolution solution = new StringToIntegerSolution();
        System.out.println(solution.myAtoi("+-2"));
    }
}
