package com.leetcode.anzai.subject_61_80;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 文本左右对齐
 * https://leetcode-cn.com/problems/text-justification/
 */
public class Subject68 {

    /**
     *
     给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

     你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

     要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

     文本的最后一行应为左对齐，且单词之间不插入额外的空格。

     说明:

     单词是指由非空格字符组成的字符序列。
     每个单词的长度大于 0，小于等于 maxWidth。
     输入单词数组 words 至少包含一个单词。
     示例:

     输入:
     words = ["This", "is", "an", "example", "of", "text", "justification."]
     maxWidth = 16
     输出:
     [
     "This    is    an",
     "example  of text",
     "justification.  "
     ]
     示例 2:

     输入:
     words = ["What","must","be","acknowledgment","shall","be"]
     maxWidth = 16
     输出:
     [
     "What   must   be",
     "acknowledgment  ",
     "shall be        "
     ]
     解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。
     第二行同样为左对齐，这是因为这行只包含一个单词。
     示例 3:

     输入:
     words = ["Science","is","what","we","understand","well","enough","to","explain",
     "to","a","computer.","Art","is","everything","else","we","do"]
     maxWidth = 20
     输出:
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
     * 初步想法：建立一个队列，一次遍历words数组，取出字符串放入队列，并计算队列中的字符串总长度，
     * 当新加入字符串使得长度大于maxWidth时，将队列中的字符串作为一行，填充相应空格，然后清空队列继续遍历，
     * 最后一行要作特殊处理，因为需要左对齐
     * 空格放置的手法：每个单词间放一个，多余的从左往右一个个放，到头了就重来
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
        int strCount = 0; // 队列中字符串个数
        int strLen = 0; // 队列中字符串总长度
        for (int i = 0; i < words.length; i++) {
            String item = words[i];
            // 先判断加入新字符串会不会超长，注意每两个字符串间至少会有一个空格，所以要加上 strCount
            if (strCount + strLen + item.length() > maxWidth) {
                // 超长就先将队列字符串组成一行
                int needSpaceCount = maxWidth - strLen; // 需要的总空格数
                // 计算每两个单词间平均空格个数
                int averageSpace = strCount == 1 ? needSpaceCount : needSpaceCount / (strCount - 1);
                // 如果空格没法平均的话，取余数然后在小于余数坐标的范围内，每个间隔加一个空格
                int moreSpaceIndex = strCount == 1 ? -1 : (needSpaceCount % (strCount - 1)) - 1;
                for (int j = 0; j < strCount; j++) {
                    String addStr = queue.poll();
                    sb.append(addStr);
                    if (maxWidth == sb.length()) { // 最后一个字符串不需要加空格，除非只有一个
                        break;
                    }
                    // 添加空格
                    for (int k = 0; k < averageSpace; k++) {
                        sb.append(" ");
                    }
                    // 空格没法平均时，左边的多加一个
                    if (j <= moreSpaceIndex) {
                        sb.append(" ");
                    }
                }

                list.add(sb.toString());
                // 清空数据
                sb = new StringBuilder();
                strLen = 0;
                strCount = 0;

            }
            queue.add(item);
            strLen += item.length();
            strCount++;
        }

        // 特殊处理最后一行的数据
        for (int j = 0; j < strCount; j++) {
            sb.append(queue.poll());
            if (maxWidth == sb.length()) { // 最后一个字符串不需要加空格，除非只有一个
                break;
            } else { // 每个单词只添加一个空格
                sb.append(" ");
            }
        }
        // 补齐空格
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
