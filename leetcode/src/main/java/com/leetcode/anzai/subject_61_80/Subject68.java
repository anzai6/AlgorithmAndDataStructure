package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �ı����Ҷ���
 * https://leetcode-cn.com/problems/text-justification/
 */
public class Subject68 {

    /**
     *
     ����һ�����������һ������ maxWidth�������Ű浥�ʣ�ʹ���Ϊÿ��ǡ���� maxWidth ���ַ������������˶�����ı���

     ��Ӧ��ʹ�á�̰���㷨�������ø����ĵ��ʣ�Ҳ����˵�������ܶ����ÿ���з��õ��ʡ���Ҫʱ���ÿո� ' ' ��䣬ʹ��ÿ��ǡ���� maxWidth ���ַ���

     Ҫ�󾡿��ܾ��ȷ��䵥�ʼ�Ŀո����������ĳһ�е��ʼ�Ŀո��ܾ��ȷ��䣬�������õĿո���Ҫ�����Ҳ�Ŀո�����

     �ı������һ��ӦΪ����룬�ҵ���֮�䲻�������Ŀո�

     ˵��:

     ������ָ�ɷǿո��ַ���ɵ��ַ����С�
     ÿ�����ʵĳ��ȴ��� 0��С�ڵ��� maxWidth��
     ���뵥������ words ���ٰ���һ�����ʡ�
     ʾ��:

     ����:
     words = ["This", "is", "an", "example", "of", "text", "justification."]
     maxWidth = 16
     ���:
     [
     "This    is    an",
     "example  of text",
     "justification.  "
     ]
     ʾ�� 2:

     ����:
     words = ["What","must","be","acknowledgment","shall","be"]
     maxWidth = 16
     ���:
     [
     "What   must   be",
     "acknowledgment  ",
     "shall be        "
     ]
     ����: ע�����һ�еĸ�ʽӦΪ "shall be    " ������ "shall     be",
     ��Ϊ���һ��ӦΪ����룬�������������˶��롣
     �ڶ���ͬ��Ϊ����룬������Ϊ����ֻ����һ�����ʡ�
     ʾ�� 3:

     ����:
     words = ["Science","is","what","we","understand","well","enough","to","explain",
     "to","a","computer.","Art","is","everything","else","we","do"]
     maxWidth = 20
     ���:
     [
     "Science  is  what we",
     "understand      well",
     "enough to explain to",
     "a  computer.  Art is",
     "everything  else  we",
     "do                  "
     ]
     *
     */


    /**
     * �����뷨������һ�����У�һ�α���words���飬ȡ���ַ���������У�����������е��ַ����ܳ��ȣ�
     * ���¼����ַ���ʹ�ó��ȴ���maxWidthʱ���������е��ַ�����Ϊһ�У������Ӧ�ո�Ȼ����ն��м���������
     * ���һ��Ҫ�����⴦����Ϊ��Ҫ�����
     * �ո���õ��ַ���ÿ�����ʼ��һ��������Ĵ�������һ�����ţ���ͷ�˾�����
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int strCount = 0; // �������ַ�������
        int strLen = 0; // �������ַ����ܳ���
        for (int i = 0; i < words.length; i++) {
            String item = words[i];
            // ���жϼ������ַ����᲻�ᳬ����ע��ÿ�����ַ��������ٻ���һ���ո�����Ҫ���� strCount
            if (strCount + strLen + item.length() > maxWidth) {
                // �������Ƚ������ַ������һ��
                int needSpaceCount = maxWidth - strLen; // ��Ҫ���ܿո���
                // ����ÿ�������ʼ�ƽ���ո����
                int averageSpace = strCount == 1 ? needSpaceCount : needSpaceCount / (strCount - 1);
                // ����ո�û��ƽ���Ļ���ȡ����Ȼ����С����������ķ�Χ�ڣ�ÿ�������һ���ո�
                int moreSpaceIndex = strCount == 1 ? -1 : (needSpaceCount % (strCount - 1)) - 1;
                for (int j = 0; j < strCount; j++) {
                    String addStr = queue.poll();
                    sb.append(addStr);
                    if (maxWidth == sb.length()) { // ���һ���ַ�������Ҫ�ӿո񣬳���ֻ��һ��
                        break;
                    }
                    // ��ӿո�
                    for (int k = 0; k < averageSpace; k++) {
                        sb.append(" ");
                    }
                    // �ո�û��ƽ��ʱ����ߵĶ��һ��
                    if (j <= moreSpaceIndex) {
                        sb.append(" ");
                    }
                }

                list.add(sb.toString());
                // �������
                sb = new StringBuilder();
                strLen = 0;
                strCount = 0;

            }
            queue.add(item);
            strLen += item.length();
            strCount++;
        }

        // ���⴦�����һ�е�����
        for (int j = 0; j < strCount; j++) {
            sb.append(queue.poll());
            if (maxWidth == sb.length()) { // ���һ���ַ�������Ҫ�ӿո񣬳���ֻ��һ��
                break;
            } else { // ÿ������ֻ���һ���ո�
                sb.append(" ");
            }
        }
        // ����ո�
        int len = sb.length();
        for (int i = 0; i < maxWidth - len; i++) {
            sb.append(" ");
        }
        list.add(sb.toString());

        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        Subject68 subject = new Subject68();
        List<String> list = subject.fullJustify(words, 20);
        for (String str : list) {
            System.out.println("|"+str+"|");
        }
    }

}
