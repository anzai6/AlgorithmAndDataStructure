package com.example.lib.course60_exercise.solution;

/**
 * Reverse Words in a String����ת�ַ�����ĵ��ʣ�
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

public class ReverseWordsSolution {

    /**
     *
     ����һ���ַ����������ת�ַ����е�ÿ�����ʡ�

     ʾ�� 1��

     ����: "the sky is blue"
     ���:?"blue is sky the"
     ʾ�� 2��

     ����: "  hello world!  "
     ���:?"world! hello"
     ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
     ʾ�� 3��

     ����: "a good   example"
     ���:?"example good a"
     ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
     ?

     ˵����

     �޿ո��ַ�����һ�����ʡ�
     �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
     ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
     ?

     ���ף�

     ��ѡ�� C ���Ե��û�����ʹ��?O(1) ����ռ临�Ӷȵ�ԭ�ؽⷨ��

     *
     */


    /**
     * ��ת���
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] strList = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isFirstWord = false;
        for (int i = strList.length - 1; i >= 0; i--) {
            if (!"".equals(strList[i])) { // ���ǿ��ַ����ǵ���
                if (!isFirstWord)
                    isFirstWord = true;
                else  // �ǵ�һλ�ĵ���ǰ����ӿո�
                    sb.append(" ");
                sb.append(strList[i]);
            } else {
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsSolution solution = new ReverseWordsSolution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
